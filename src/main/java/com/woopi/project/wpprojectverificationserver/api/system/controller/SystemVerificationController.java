package com.woopi.project.wpprojectverificationserver.api.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class SystemVerificationController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment env;

    @GetMapping("/java-version")
    public ResponseEntity<Map<String,String>> javaVersion(HttpServletResponse response) {
        String version = System.getProperty("java.version");
        log.debug("JAVA Version : {}", version);

        response.addHeader("Access-Control-Allow-Origin", "*");

        Map<String, String> data = new HashMap<String, String>();
        data.put("java-version", version);
        
        
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/env")
    public void envInfo() {

        log.debug("[env] server.port : {}", env.getProperty("server.port"));

    }
    
}
