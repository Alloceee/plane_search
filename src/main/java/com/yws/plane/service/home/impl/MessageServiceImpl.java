package com.yws.plane.service.home.impl;

import com.yws.plane.service.home.MessageService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private Scheduler scheduler;




}
