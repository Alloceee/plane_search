package com.yws.plane.web.home;

import com.yws.plane.entity.Message;
import com.yws.plane.util.JSONData;
import com.yws.plane.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api")
public class ClockController {

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

    private Integer random(Integer start,Integer end){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(start,end);
    }
}
