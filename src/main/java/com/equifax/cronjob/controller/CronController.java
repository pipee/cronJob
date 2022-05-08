package com.equifax.cronjob.controller;

import com.equifax.cronjob.service.ICronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/cron")
public class CronController {

    private static final Logger log = LoggerFactory.getLogger(CronController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ICronService cronService;

    @GetMapping("/test")
    public ResponseEntity<String> getMesagge(){
        String response = "okay";
        return new ResponseEntity<String>(response,HttpStatus.OK);
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void reportTime(){
        log.info("Time now {}", dateFormat.format(new Date()));
        try {
            log.info("response {}", cronService.getFirstCommand().getResponse());
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }
    }
}
