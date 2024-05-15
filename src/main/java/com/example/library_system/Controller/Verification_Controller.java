package com.example.library_system.Controller;

import com.example.library_system.Service.Verification_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification")
public class Verification_Controller {
    @Autowired
    private Verification_Service verificationService;

    @PostMapping("/sendCode")
    public String sendVerificationCode(@RequestParam String id) {
        String code = verificationService.generateAndSaveCode(id);
        System.out.println("验证码: " + code);
        return "验证码已发送";
    }

    @PostMapping("/verifyCode")
    public String verifyCode(@RequestParam String code, @RequestParam String id) {
        String correctCode = verificationService.getCode(id);
        if (correctCode != null && correctCode.equals(code)) {
            return "验证码验证成功";
        } else {
            return "验证码验证失败";
        }
    }
}