package com.yws.plane.web.home;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yws.plane.entity.User;
import com.yws.plane.service.TokenService;
import com.yws.plane.service.UserService;
import com.yws.plane.util.EncryptUtil;
import com.yws.plane.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    @CrossOrigin
    public String register(@RequestBody User user){
        String password = user.getPassword();
        String username = EncryptUtil.base64Decode(user.getUsername());
        if(user.getEmail()!=null){
            user.setEmail(EncryptUtil.base64Decode(user.getEmail()));
        }
        if(user.getPhone()!=null){
            user.setPhone(EncryptUtil.base64Decode(user.getPhone()));
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        user.setPassword(null);
        user.setUsername(null);
        wrapper.setEntity(user);
        User user1 = userService.getOne(wrapper);
        if(user1!=null){
            return JSONData.toJsonString(500,"该账户已经注册，请直接登录",null);
        }
        user.setPassword(password);
        user.setUsername(username);
        if(userService.save(user)){
            String token = tokenService.getUserToken(user);
            return JSONData.toJsonString(200,"注册成功",JSONData.tokenObject(token,user.getUsername()));
        }
        return JSONData.toJsonString(500,"注册失败",null);
    }

    @PostMapping("/login")
    @CrossOrigin
    public String login(@RequestBody String data){
        String email = EncryptUtil.base64Decode(data.substring(0, data.length() - 64));
        String password = data.substring(data.length()-64);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        User user1 = userService.getOne(wrapper);
        if(user1!=null){
            String token = tokenService.getUserToken(user1);
            return JSONData.toJsonString(200,"登录成功",JSONData.tokenObject(token,user1.getUsername()));
        }else{
            user.setPhone(email);
            user.setEmail(null);
            QueryWrapper<User> wrapper2 = new QueryWrapper<>();
            wrapper2.setEntity(user);
            User user2 = userService.getOne(wrapper2);
            if(user2!=null){
                String token = tokenService.getUserToken(user2);
                return JSONData.toJsonString(200,"登录成功",JSONData.tokenObject(token,user2.getUsername()));
            }
        }
        return JSONData.toJsonString(500,"用户名或密码不正确",null);
    }
}
