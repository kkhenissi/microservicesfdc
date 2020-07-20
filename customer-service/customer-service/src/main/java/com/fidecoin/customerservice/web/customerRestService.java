package com.fidecoin.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RefreshScope
@RestController
public class customerRestService {
    @Value("${yparam}")
    private String yparam;
    @Value("${me}")
    private String me;
    @GetMapping(value = "/customerConfig")
    public Map<String, Object> customerConfig() {
        Map<String,Object>  params = new HashMap<>();
        params.put("yparam",yparam);
        params.put("me",me);
        params.put("threadName",Thread.currentThread().getName());
        return params;
    }
}
