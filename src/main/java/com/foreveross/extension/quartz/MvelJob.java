/*******************************************************************************
 * Copyright (c) Oct 10, 2017 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.quartz;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.iff.infra.util.Logger;
import org.mvel2.MVEL;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> 
 * @since Oct 10, 2017
 */
public class MvelJob implements Job {

	private static final Logger.Log log = Logger.get("QUARTZ");

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = null;
		JobDataMap map = null;
		try {
			detail = context.getJobDetail();
			map = detail.getJobDataMap();
			if (map == null || map.isEmpty()) {
				return;
			}
			String mvel = map.getString("SCRIPT");
			Map<String, Object> params = new HashMap<String, Object>();
			for (Entry<String, Object> entry : map.entrySet()) {
				params.put(entry.getKey(), entry.getValue());
			}
			MVEL.eval(mvel, params);
			map.put("BODY", "SUCCESS");
			map.put("STATUS", "OK");
		} catch (Exception e) {
			log.error("Failed to execute MvelJob.", e);
			JobExecutionException e2 = null;
			// and rethrow to let quartz handle it
			if (e instanceof JobExecutionException) {
				e2 = (JobExecutionException) e;
			} else {
				e2 = new JobExecutionException(e);
			}
			if (map != null) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e2.printStackTrace(pw);
				map.put("BODY", sw.toString());
				map.put("STATUS", "FAIL");
			}
			throw e2;
		}
	}
}
