package com.healteion.HealthionApp.Service;

import com.healteion.HealthionApp.Dto.LoginDTO;
import com.healteion.HealthionApp.Dto.MemberDTO;
import com.healteion.HealthionApp.Dto.SessionDTO;
import com.healteion.HealthionApp.PayloadResponce.JoinResponse;
import com.healteion.HealthionApp.PayloadResponce.LoginResponse;

public interface MemberService {
    JoinResponse addMember(MemberDTO memberDTO);

    LoginResponse loginMember(LoginDTO loginDTO);
}
