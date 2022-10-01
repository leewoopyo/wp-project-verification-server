package com.woopi.project.wpprojectverificationserver.api.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    public String javaVersion() {
        String version = System.getProperty("java.version");
        log.debug("JAVA Version : {}", version);
        
        return "JAVA Version : " + version;
    }

    @GetMapping("/env")
    public void envInfo() {

        log.debug("[env] server.port : {}", env.getProperty("server.port"));

    }
    
}
