package com.equifax.cronjob.service.impl;

import com.equifax.cronjob.controller.CronController;
import com.equifax.cronjob.dto.ResponseDto;
import com.equifax.cronjob.service.ICronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CronServiceImpl implements ICronService {
    private static final Logger log = LoggerFactory.getLogger(CronController.class);


    @Autowired
    RestTemplate restClient;

    @Value("#{${listOfStrings}}")
    private List<String> listOfStrings;

    @Override
    public ResponseDto getFirstCommand() throws Exception{
        ResponseDto responseDto;
        try {
            responseDto = restClient.getForObject("http://demo1646372.mockable.io/internal", ResponseDto.class);

        }catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc){
            log.info(httpClientOrServerExc.getLocalizedMessage());
            responseDto = new ResponseDto(String.valueOf(httpClientOrServerExc.getStatusCode()));
        }
        return responseDto;
    }

}
