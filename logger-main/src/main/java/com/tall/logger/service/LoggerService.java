package com.tall.logger.service;

import com.tall.logger.facade.LoggerFacade;
import org.apache.dubbo.config.annotation.Service;

@Service
public class LoggerService implements LoggerFacade {
    @Override
    public void saveParam(String params) {
        System.out.println("saveParam:" + params);
    }
}
