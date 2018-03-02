/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.common.shiro;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.iff.infra.util.ActionHelper;
import org.iff.infra.util.BaseCryptHelper;
import org.iff.infra.util.FCS;
import org.iff.infra.util.GsonHelper;
import org.iff.infra.util.I18nHelper;
import org.iff.infra.util.Logger;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.StringHelper;
import org.iff.infra.util.ThreadLocalHelper;

import com.foreveross.common.ConstantBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * <pre>
 * JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and 
 * self-contained way for securely transmitting information between parties as a JSON object. 
 * This information can be verified and trusted because it is digitally signed. 
 * JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA
 * </pre>
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 28, 2017
 */
@Deprecated
//还没有实现
public class ShiroJwtAccessControlFilter extends AdviceFilter {

	public static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

	private static final String EXP = "exp";

	private static final String PAYLOAD = "payload";

	protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		ActionHelper helper = ActionHelper.create(request, response);
		//删除context
		String url = StringUtils.removeStart(request.getRequestURI(), request.getContextPath());
		//拿到shiro授权对象
		Subject subject = SecurityUtils.getSubject();
		{
			boolean accessAllowed = false;
			String jwt = request.getHeader("Authorization");
			if (jwt == null || !jwt.startsWith("Bearer ")) {
				return accessAllowed;
			}
			jwt = jwt.substring(jwt.indexOf(" "));
			String username = Jwts.parser().setSigningKey(Base64.encode(SECRET.getBytes())).parseClaimsJws(jwt)
					.getBody().getSubject();
			String subjectName = (String) subject.getPrincipal();
			if (!username.equals(subjectName)) {
				return accessAllowed;
			}
		}
		if (subject.getSession(false) != null) {
			String sessionId = String.valueOf(subject.getSession(false).getId());
			ShiroUser loginUser = (ShiroUser) subject.getSession(false).getAttribute("USER");
			String traceId = Logger.getTraceId();
			String[] split = StringUtils.split(traceId, '/');
			Logger.updateTraceId(StringHelper.concat(split.length > 0 ? split[0] : StringHelper.uuid(), "/", sessionId,
					"/", loginUser == null ? "" : loginUser.getLoginId()));
		}
		Logger.debug(FCS.get("ShiroJwtAccessControlFilter.preHandle, uri: {0}", url));
		{
			try {
				Locale locale = null;
				if (locale == null) {
					if (subject.getPrincipal() != null && subject.isAuthenticated()) {
						locale = (Locale) subject.getSession().getAttribute("locale");
					}
				}
				if (locale == null) {
					Cookie[] cookies = request.getCookies();
					for (Cookie c : cookies) {
						if ("locale".equals(c.getName())) {
							String lang = c.getValue();
							if (StringUtils.isNotBlank(lang)) {
								int indexOf = lang.indexOf('_');
								if (indexOf > -1) {
									locale = new Locale(lang.substring(0, indexOf), lang.substring(indexOf + 1));
								}
							}
						}
					}
				}
				if (locale == null) {
					locale = ThreadLocalHelper.get("locale");
				}
				if (locale != null) {
					ThreadLocalHelper.set("locale", locale);
					ThreadLocalHelper.set("I18N", I18nHelper.get(null, locale));
				}
			} catch (Exception e) {
			}
		}
		{
			if (subject.getPrincipal() == null || !subject.isAuthenticated()) {
				if (url.endsWith(".do") || url.startsWith("/extension/commonws/json/")) {
					response.reset();
					response.setStatus(401);
					response.getWriter().write(GsonHelper
							.toJsonString(MapHelper.toMap("data", "Unauthorized", "result", ConstantBean.ERROR)));
				} else {
					helper.redirect(request.getContextPath() + "/login.html");
				}
				return false;
			}
		}

		ShiroUser user = (ShiroUser) subject.getSession().getAttribute("USER");
		if (user == null) {
			helper.redirect(request.getContextPath() + "/system/auth/account/logout.do");
			return false;
		}
		{
			if (subject.getSession(false) != null) {
				String sessionId = String.valueOf(subject.getSession(false).getId());
				ShiroUser loginUser = (ShiroUser) subject.getSession(false).getAttribute("USER");
				String traceId = Logger.getTraceId();
				String[] split = StringUtils.split(traceId, '/');
				Logger.updateTraceId(StringHelper.concat(split.length > 0 ? split[0] : StringHelper.uuid(), "/",
						sessionId, "/", loginUser == null ? "" : loginUser.getLoginId()));
			}
		}

		// 如果是超级用户
		if (subject.hasRole("ADMIN")) {
			Logger.debug("==ADMIN is Logging==");
			return true;
		}

		//开启shiro鉴权
		{
			if (!subject.isPermitted(url)) {
				helper.redirect(request.getContextPath() + "/common/accessDeny.html");
				return false;
			}
		}

		{//设置当前用户到线程领域
			ThreadLocalHelper.set("accountId", user.getId());
			ThreadLocalHelper.set("LoginEmail", user.getLoginId());
		}
		return true;
	}

	protected void cleanup(ServletRequest request, ServletResponse response, Exception existing)
			throws ServletException, IOException {
		ThreadLocalHelper.remove();
		super.cleanup(request, response, existing);
	}

	/**
	 * 由字符串生成加密key
	 * 
	 * @return
	 */
	public static SecretKey generalKey(String stringKey) {
		byte[] encodedKey = Base64.encode(stringKey.getBytes());
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}

	/**
	 * createJWT: 创建jwt<br/>
	 *
	 * @author guooo
	 * @param id
	 *            唯一id，uuid即可
	 * @param subject
	 *            json形式字符串或字符串，增加用户非敏感信息存储，如user tid，与token解析后进行对比，防止乱用
	 * @param ttlMillis
	 *            有效期
	 * @param stringKey
	 * @return jwt token
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey(SECRET);
		JwtBuilder builder = Jwts.builder().setIssuer("").setId(id).setIssuedAt(now).setSubject(subject)
				.signWith(signatureAlgorithm, key);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * parseJWT: 解密jwt <br/>
	 *
	 * @author guooo
	 * @param jwt
	 * @param stringKey
	 * @return
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 * @since JDK 1.6
	 */
	public static Claims parseJWT(String jwt) throws ExpiredJwtException, UnsupportedJwtException,
			MalformedJwtException, SignatureException, IllegalArgumentException {
		SecretKey key = generalKey(SECRET);
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
		return claims;
	}
	
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.addDays(new Date(), 183)));
	}
}