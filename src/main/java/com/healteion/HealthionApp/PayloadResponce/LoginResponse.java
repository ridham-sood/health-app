package com.healteion.HealthionApp.PayloadResponce;

import com.healteion.HealthionApp.Dto.SessionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    String message;
    SessionDTO sessionDTO;
    Boolean status;



}
