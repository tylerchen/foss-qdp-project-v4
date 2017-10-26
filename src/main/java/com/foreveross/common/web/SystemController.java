/*******************************************************************************
 * Copyright (c) 七月 14 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.common.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.iff.infra.util.Logger;
import org.iff.infra.util.RSAHelper;
import org.iff.infra.util.SocketHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foreveross.common.ConstantBean;
import com.foreveross.common.ResultBean;
import com.foreveross.common.application.ImageCaptchaApplication;
import com.foreveross.common.application.SystemApplication;
import com.foreveross.common.shiro.ShiroUser;

/**
 * 登录基础功能：登录、登出、验证码。
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Aug 9, 2015
 * auto generate by qdp.
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController {

	@Inject
	ImageCaptchaApplication imageCaptchaApplication;

	@Inject
	SystemApplication systemApplication;

	@ResponseBody
	@RequestMapping("/login.do")
	public ResultBean login(ShiroUser user, HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		// get login info if has login
		if (user == null || user.getLoginId() == null || user.getLoginPasswd() == null) {
			try {
				Subject subject = SecurityUtils.getSubject();
				if (subject == null || subject.getPrincipal() == null || !subject.isAuthenticated()) {
					response.setStatus(401);
					return error("Unauthorized");
				} else {
					return success(subject.getSession().getAttribute("USER"));
				}
			} catch (Exception e) {
				response.setStatus(401);
				return error("Unauthorized");
			}
		}

		try {
			{/*认证码验证*/
				String validCode = (String) request.getParameter("validCode");
				boolean valid = imageCaptchaApplication.validateForID(request.getSession().getId(), validCode);
				if (!valid) {
					return error("请输入正确的验证码！");
				}
			}
			{
				String loginPasswdEnc = user.getLoginPasswd();
				if (StringUtils.isBlank(loginPasswdEnc)) {
					return error("无此帐户或登录密码错误！");
				}
				try {
					String realPassword = RSAHelper.decrypt(loginPasswdEnc,
							RSAHelper.getPrivateKeyFromBase64(ConstantBean.getProperty("rsa.key.private.base64")));
					user.setLoginPasswd(realPassword);
				} catch (Exception e) {
					return error("无此帐户或登录密码错误！");
				}
			}

			user = systemApplication.login(user);

			if (user == null) {
				return error("无此帐户或登录密码错误！");
			}

			///////////////////shiro登陆////////////////////
			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginId(), user.getLoginPasswd());
			token.setRememberMe(true);
			Locale locale = null;
			{
				locale = (Locale) currentUser.getSession().getAttribute("locale");
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
			}
			{
				currentUser.getSession().stop();
			}
			{
				currentUser.login(token);
				Logger.info(user.getLoginId() + " is login.");
			}
			{
				if (locale != null) {
					currentUser.getSession().setAttribute("locale", locale);
					Cookie localeCookie = new Cookie("locale", locale.toString());
					localeCookie.setMaxAge(60 * 60 * 24 * 365);
					response.addCookie(localeCookie);
				}
			}
			{
				currentUser.getSession().setAttribute("USER", user);
			}
			//	} catch (IncorrectCredentialsException e) {
			//		msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	} catch (ExcessiveAttemptsException e) {
			//		msg = "登录失败次数过多";
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	} catch (LockedAccountException e) {
			//		msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	} catch (DisabledAccountException e) {
			//		msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	} catch (ExpiredCredentialsException e) {
			//		msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	} catch (UnknownAccountException e) {
			//		msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	} catch (UnauthorizedException e) {
			//		msg = "您没有得到相应的授权！" + e.getMessage();
			//		model.addAttribute("message", msg);
			//		System.out.println(msg);
			//	}
			///////////////////shiro登陆////////////////////

			//		Cookie[] cookies = request.getCookies();
			//
			//		String css = "default";
			//		String layout = "default";
			//
			//		if (cookies != null) {
			//			for (int i = 0; i < cookies.length; i++) {
			//				Cookie c = cookies[i];
			//				if (c.getName().equalsIgnoreCase("css")) {
			//					css = c.getValue();
			//				} else if (c.getName().equalsIgnoreCase("layout")) {
			//					layout = c.getValue();
			//				}
			//			}
			//		}

			//设置使用哪个样式
			//request.getSession().setAttribute("css", css);
			//设置使用哪套模板
			//request.getSession().setAttribute("layout", layout);

			//return "index";
			return success(user);
		} catch (Exception e) {
			return error(e);
		}

	}

	@ResponseBody
	@RequestMapping("/logout.do")
	public ResultBean logout(ShiroUser user, HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		try {
			request.getSession().removeAttribute("USER");
			request.getSession().invalidate();
			request.getSession(true);
			currentUser.logout();
		} catch (AuthenticationException e) {
			return ResultBean.error().setBody("Unauthorized");
		}
		return ResultBean.success().setBody("Logout success.");
	}

	@RequestMapping("/valid.png")
	public void validateImage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			byte[] image = imageCaptchaApplication.getImageForID(request.getSession().getId());
			/*禁止图像缓存*/
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/png");
			/*将图像输出到Servlet输出流中*/
			OutputStream out = response.getOutputStream();
			out.write(image);
			out.flush();
			SocketHelper.closeWithoutError(out);
		} catch (Exception e) {
			error(e);
		}
	}
}
