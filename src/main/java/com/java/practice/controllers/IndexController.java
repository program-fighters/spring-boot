package com.java.practice.controllers;

import com.java.practice.utils.DateUtils;
import com.java.practice.utils.UrlPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${application.version}")
    private String currentApplicationVersion;

    @GetMapping(UrlPaths.INDEX)
    public String indexCall() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(UrlPaths.API_VERSION)
    public ApiVersion getApiVersion(HttpServletRequest httpServletRequest) {
        String remoteAddress = httpServletRequest.getRemoteAddr();
        String xForwardedForAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        return new ApiVersion(currentApplicationVersion, null, null, null, remoteAddress, xForwardedForAddress, null, null);
    }

    @GetMapping(UrlPaths.TIME)
    public Long getCurrentTime() {
        return DateUtils.currentTimeInMills();
    }

    static public class ApiVersion {
        public final String apiVersion;
        public final Boolean isLocalServer;
        public final String springActiveProfileInUse;
        public final String delta;
        public final String remoteAddress;
        public final String xForwardedForAddress;
        public final Boolean enableAdvertisement;
        public final Boolean isS3Enabled;

        private ApiVersion(String apiVersion, Boolean isLocalServer,
                           String springActiveProfileInUse, String delta, String remoteAddress,
                           String xForwardedForAddress, Boolean enableAdvertisement, Boolean isS3Enabled) {
            this.apiVersion = apiVersion;
            this.isLocalServer = isLocalServer;
            this.springActiveProfileInUse = springActiveProfileInUse;
            this.delta = delta;
            this.remoteAddress = remoteAddress;
            this.xForwardedForAddress = xForwardedForAddress;
            this.enableAdvertisement = enableAdvertisement;
            this.isS3Enabled = isS3Enabled;
        }
    }

    @GetMapping(UrlPaths.LOCALIZATION)
    public String getLocalization(HttpServletRequest httpServletRequest) {
        return "localization";
    }
}
