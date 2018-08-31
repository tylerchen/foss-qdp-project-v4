/*******************************************************************************
 * Copyright (c) Aug 28, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.dictionary.application.impl;

import com.foreveross.extension.dictionary.application.SystemDictionaryApplication;
import org.apache.commons.lang3.StringUtils;
import org.iff.infra.util.CacheHelper.CacheCallback;
import org.iff.infra.util.MapHelper;
import org.iff.infra.util.mybatis.service.Dao;

import javax.inject.Named;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统字典。
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since Aug 28, 2017
 */
@Named("systemDictionaryApplication")
@SuppressWarnings("rawtypes")
public class SystemDictionaryApplicationImpl implements SystemDictionaryApplication {

    /**
     * 10分钟失效
     */
    private static final int timeToLive = 600;
    /**
     * 不失效
     */
    private static final int timeToIdle = 0;

    public Map<String, String> findType1() {
        return CacheCallback.process("SystemDictionaryApplication-findType1", timeToIdle, timeToLive,
                new CacheCallback<Map<String, String>>() {
                    public Map<String, String> call() {
                        Map<String, String> map = new LinkedHashMap<String, String>(64);
                        List<Map> list = Dao.queryList("SystemDictionary.findDictionaryType1",
                                MapHelper.toMap("vo", null));
                        for (Map m : list) {
                            map.put((String) m.get("code"), (String) m.get("value"));
                        }
                        return map;
                    }
                });
    }

    public Map<String, String> findType2(final String type1) {
        return CacheCallback.process("SystemDictionaryApplication-findType2-" + type1, timeToIdle, timeToLive,
                new CacheCallback<Map<String, String>>() {
                    public Map<String, String> call() {
                        Map<String, String> map = new LinkedHashMap<String, String>(64);
                        if (StringUtils.isBlank(type1)) {
                            return map;
                        }
                        List<Map> list = Dao.queryList("SystemDictionary.findDictionaryType2",
                                MapHelper.toMap("vo", MapHelper.toMap("type1", type1)));
                        for (Map m : list) {
                            map.put((String) m.get("code"), (String) m.get("value"));
                        }
                        return map;
                    }
                });
    }

    public Map<String, String> findDictionary(final String type1, final String type2) {
        return CacheCallback.process("SystemDictionaryApplication-findDictionary-" + type1 + "-" + type2, timeToIdle,
                timeToLive, new CacheCallback<Map<String, String>>() {
                    public Map<String, String> call() {
                        Map<String, String> map = new LinkedHashMap<String, String>(64);
                        if (StringUtils.isBlank(type1) || StringUtils.isBlank(type2)) {
                            return map;
                        }
                        List<Map> list = Dao.queryList("SystemDictionary.findDictionaryCode",
                                MapHelper.toMap("vo", MapHelper.toMap("type1", type1, "type2", type2)));
                        for (Map m : list) {
                            map.put((String) m.get("code"), (String) m.get("value"));
                        }
                        return map;
                    }
                });
    }

}
