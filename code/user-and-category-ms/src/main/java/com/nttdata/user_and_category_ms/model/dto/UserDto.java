package com.nttdata.user_and_category_ms.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String status;

    private Date registrationDate;
}
