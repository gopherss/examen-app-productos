package com.nttdata.dockerized.postgresql.controller;

import com.nttdata.dockerized.postgresql.model.dto.UserDto;
import com.nttdata.dockerized.postgresql.model.dto.UserSaveRequestDto;
import com.nttdata.dockerized.postgresql.model.dto.UserSaveResponseDto;
import com.nttdata.dockerized.postgresql.model.dto.UserUpdateRequestDto;
import com.nttdata.dockerized.postgresql.model.entity.User;
import com.nttdata.dockerized.postgresql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.nttdata.dockerized.postgresql.mapper.UserMapper.INSTANCE;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return INSTANCE.map(userService.listAll());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.findById(id);

        return INSTANCE.map(user);
    }

    @PostMapping
    public UserSaveResponseDto save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        User userSaved = userService.save(INSTANCE.toEntity(userSaveRequestDto));
        return INSTANCE.toUserSaveResponseDto(userSaved);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        User userUpdated = userService.updateById(id, INSTANCE.toEntity(userUpdateRequestDto));
        return INSTANCE.map(userUpdated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteById(id);
    }
}
