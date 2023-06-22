package com.healteion.HealthionApp.Controller;

import com.healteion.HealthionApp.Dto.LoginDTO;
import com.healteion.HealthionApp.Dto.MemberDTO;
import com.healteion.HealthionApp.Dto.SessionDTO;
import com.healteion.HealthionApp.PayloadResponce.JoinResponse;
import com.healteion.HealthionApp.PayloadResponce.LoginResponse;
import com.healteion.HealthionApp.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/member")
public class LoginPageController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/join")
    public JoinResponse saveMember(@RequestBody MemberDTO memberDTO){
        JoinResponse joinResponse = memberService.addMember(memberDTO);
        return joinResponse;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMember(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = memberService.loginMember(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
