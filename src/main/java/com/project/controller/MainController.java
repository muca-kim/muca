package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {

    @RequestMapping("/")
    public String viewMain() {
        if (log.isDebugEnabled()) {
            log.debug("Start viewMain");
        }
        if (log.isDebugEnabled()) {
            log.debug("End viewMain");
        }
        return "mainPage";
    }

}