package com.equifax.cronjob.service;

import com.equifax.cronjob.dto.ResponseDto;

public interface ICronService {

    public ResponseDto getFirstCommand() throws Exception;
}
