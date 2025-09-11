package com.nttdata.user_and_category_ms.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdateRequestDto {

    private String name;
    private String email;
    private Boolean active;
    private Date registrationDate;
}
