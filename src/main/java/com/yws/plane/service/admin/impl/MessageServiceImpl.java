package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.Message;
import com.yws.plane.repository.MessageRepository;
import com.yws.plane.service.admin.MessageService;
import com.yws.plane.util.JSONData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yws.plane.util.BeanUtils.getNullPropertyNames;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 15:22
 * @Project: plane_search
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public String add(Message message) {
        Message message1 = messageRepository.save(message);
        if (message1 != null) {
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String show() {
        List<Message> messages = messageRepository.findAll();
        return JSONData.toJsonString(0, "", messages.size(), messages);
    }

    @Override
    public String one(Long id) {
        Message message = messageRepository.getOne(id);
        return JSONData.toJsonString(0, "", message);
    }

    @Override
    public String del(String messages) {
        JSONArray array = JSONArray.parseArray(messages);
        List<Message> messages1 = array.toJavaList(Message.class);
        //批量删除
        messageRepository.deleteInBatch(messages1);
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(Message message) {
        Message message1 = messageRepository.getOne(message.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(message, message1, getNullPropertyNames(message));
        //执行更新操作
        Message c = messageRepository.save(message1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }
}
