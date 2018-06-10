/*******************************************************************************
 * Copyright (c) 2018-06-08 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation.
 * Auto Generate By foreveross.com Quick Deliver Platform. 
 ******************************************************************************/
package com.foreveross.admin.application.impl;

import com.foreveross.admin.application.AdminApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;

import javax.inject.Inject;
import javax.inject.Named;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * AdminApplicationImpl
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since 2018-06-08
 * auto generate by qdp.
 */
@Named("adminApplication")
public class AdminApplicationImpl implements AdminApplication {
    @Inject
    DiscoveryClient discoveryClient;

    public Map<String, String[]> serverInfos() {
        Map<String, String[]> infos = new LinkedHashMap<String, String[]>();
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            List<String> uris = new ArrayList<String>();
            for (ServiceInstance si : instances) {
                if (si instanceof EurekaDiscoveryClient.EurekaServiceInstance) {
                    EurekaDiscoveryClient.EurekaServiceInstance esi = (EurekaDiscoveryClient.EurekaServiceInstance) si;
                    uris.add(esi.getInstanceInfo().getStatus().name() + "," + esi.getUri().toString());
                } else {
                    URI uri = si.getUri();
                    uris.add("UP," + uri.toString());
                }
            }
            infos.put(service, uris.toArray(new String[uris.size()]));
        }
        return infos;
    }
}
