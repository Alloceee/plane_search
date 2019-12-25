package com.yws.plane.web.home;

import com.yws.plane.entity.Message;
import com.yws.plane.service.MessageService;
import com.yws.plane.util.JSONData;
import com.yws.plane.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api")
public class ClockController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    @CrossOrigin
    public String send(@RequestBody Message message){
        System.out.println(message.getEmail());
        Integer type = message.getType();
        if(!StringUtils.isEmpty(message.getPhone())){
            switch (type){
                case 0:
                    String res = MessageUtil.phoneCode("18855109072",123);
                    return JSONData.toJsonString(200,"",res);
                case 1:
                    String res2 = MessageUtil.phoneMessage("18855109072",123);
                    return JSONData.toJsonString(200,"",res2);
                default:
                    return JSONData.toJsonString(500,"没有匹配类型",null);
            }
        }else if(!StringUtils.isEmpty(message.getEmail())){
            switch (type) {
                case 0:
                    String res = MessageUtil.emailCode("18855109072", 123);
                    return JSONData.toJsonString(200, "", res);
                case 1:
                    String res2 = MessageUtil.emailMessage("18855109072", 123);
                    return JSONData.toJsonString(200, "", res2);
                default:
                    return JSONData.toJsonString(500, "没有匹配类型", null);
            }
        }
        return JSONData.toJsonString(500,"没有匹配类型",null);
    }

    @PostMapping("/clock")
    @CrossOrigin
    public String clock(@RequestBody Message message){
        //检查code是否正确
        Integer code = message.getCode();
        if(checkCode(code)){
            boolean res = messageService.insert(message);
            if(res){
                return JSONData.toJsonString(200,"添加成功",null);
            }
        }else {
            return JSONData.toJsonString(500,"验证码错误",null);
        }
        return JSONData.toJsonString(500,"添加失败",null);
    }

    /**
     * 检查验证码是否正确
     * @param code 验证码
     */
    private boolean checkCode(Integer code){
        return true;
    }

    private Integer random(Integer start,Integer end){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(start,end);
    }
}
