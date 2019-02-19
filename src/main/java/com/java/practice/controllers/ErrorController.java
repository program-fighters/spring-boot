package com.java.practice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@ControllerAdvice
public class ErrorController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler
    public void allExceptions(Exception e, HttpServletRequest request,
                              HttpServletResponse res) throws IOException {
        if (e != null) {
            logger.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }


}
