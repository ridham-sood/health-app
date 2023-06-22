package com.healteion.HealthionApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SessionDTO {

        private int memberId;
        private String name;
        private String email;

}
