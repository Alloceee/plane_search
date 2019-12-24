package com.baomidou.springboot.service2.impl;

import com.baomidou.springboot.model.Message;
import com.baomidou.springboot.mapper.MessageMapper;
import com.baomidou.springboot.service2.MessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-24
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
