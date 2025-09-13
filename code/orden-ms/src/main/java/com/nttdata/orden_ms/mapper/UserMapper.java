package com.nttdata.orden_ms.mapper;


import com.nttdata.orden_ms.model.dto.UserDto;
import com.nttdata.orden_ms.model.dto.UserSaveRequestDto;
import com.nttdata.orden_ms.model.dto.UserSaveResponseDto;
import com.nttdata.orden_ms.model.dto.UserUpdateRequestDto;
import com.nttdata.orden_ms.model.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public UserDto map(User user);

    public List<UserDto> map(List<User> users);

    public User toEntity(UserSaveRequestDto userSaveRequestDto);

    public User toEntity(UserUpdateRequestDto userUpdateRequestDto);

    public UserSaveResponseDto toUserSaveResponseDto(User user);

    @AfterMapping
    default void setRemainingValues(User user, @MappingTarget UserDto userDto) {
        userDto.setStatus(Boolean.TRUE.equals(user.getActive()) ? "Active" : "Inactive");
    }
}
