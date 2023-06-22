package com.healteion.HealthionApp.Service.Impl;

import com.healteion.HealthionApp.Dto.LoginDTO;
import com.healteion.HealthionApp.Dto.MemberDTO;
import com.healteion.HealthionApp.Dto.SessionDTO;
import com.healteion.HealthionApp.Entity.Member;
import com.healteion.HealthionApp.PayloadResponce.JoinResponse;
import com.healteion.HealthionApp.PayloadResponce.LoginResponse;
import com.healteion.HealthionApp.Repository.MemberRepo;
import com.healteion.HealthionApp.Service.MemberService;
import com.healteion.HealthionApp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public JoinResponse addMember(MemberDTO memberDTO) {
        try {
            Member findMember = memberRepo.findByEmail(memberDTO.getEmail());

            if (findMember == null){
                Member member = new Member(
                        memberDTO.getMemberId(),
                        memberDTO.getName(),
                        memberDTO.getEmail(),
                        this.passwordEncoder.encode(memberDTO.getPassword()),
                        memberDTO.getFoods());

                memberRepo.save(member);

                return new JoinResponse("Success Login", new SessionDTO(member.getId(), member.getName(), member.getEmail()), true);
            }else {
                return  new JoinResponse("Email Already Exist", null, false);
            }
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Member", "id", memberDTO.getMemberId());
        }
    }


    @Override
    public LoginResponse loginMember(LoginDTO loginDTO) {

        Member member = memberRepo.findByEmail(loginDTO.getEmail());

        if (member != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = member.getPassword();

            Boolean checkPassword = passwordEncoder.matches(password, encodedPassword);

            if (checkPassword) {
                Optional<Member> memberCheck = Optional.ofNullable(memberRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword).orElseThrow(() -> new ResourceNotFoundException("Multiple Account Found", " Number of ID", 0)));;
                if (memberCheck.isPresent()) {
                    return new LoginResponse("Login Success", new SessionDTO(member.getId(), member.getName(), member.getEmail()), true);
                } else {
                    return new LoginResponse("Login Failed", new SessionDTO(member.getId(), member.getName(), member.getEmail()), false);
                }
            } else {
                return new LoginResponse("Password Not Match", new SessionDTO(member.getId(), member.getName(), member.getEmail()), false);
            }
        } else {
            return new LoginResponse("Email Not Exists", new SessionDTO(0, "No User", loginDTO.getEmail()), false);
        }
    }
}
