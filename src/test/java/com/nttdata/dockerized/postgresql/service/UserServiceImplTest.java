package com.nttdata.dockerized.postgresql.service;

import com.nttdata.dockerized.postgresql.exception.BadRequestException;
import com.nttdata.dockerized.postgresql.exception.NotFoundException;
import com.nttdata.dockerized.postgresql.model.entity.User;
import com.nttdata.dockerized.postgresql.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private final User user = new User(1L, "Sandro", "sandro@mail.com", true, new Date());

    @Test
    void testFindById_Success() {

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.findById(1L);

        assertEquals("Sandro", result.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testFindById_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.findById(1L));
        assertEquals("Usuario no encontrado", exception.getMessage());
    }

    @Test
    void testListAll_Success() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new User(1L, "Sandro", "sandro@mail.com", true, new Date()),
                new User(2L, "Ana", "ana@mail.com", true, new Date())));

        List<User> result = userService.listAll();
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testSave_Success() {

        when(userRepository.save(any(User.class))).thenReturn(new User(1L, "Sandro", "sandro@mail.com", true, new Date()));

        User result = userService.save(user);

        assertNotNull(result.getId());
        assertEquals("Sandro", result.getName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testSave_BadRequest() {
        User user = new User(null, "", "", true, new Date());

        assertThrows(BadRequestException.class, () -> userService.save(user));
    }

    @Test
    void testUpdateById_Success() {
        User existing = new User(1L, "Sandro", "sandro@mail.com", true, new Date());
        User updateData = new User(null, "Sandro Castro", "sandroc@mail.com", true, new Date());
        when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(userRepository.save(any(User.class))).thenReturn(existing);

        User result = userService.updateById(1L, updateData);

        assertEquals("Sandro Castro", result.getName());
    }

    @Test
    void testUpdateById_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userService.updateById(1L, new User()));
    }

    @Test
    void testDeleteById_Success() {
        when(userRepository.existsById(1L)).thenReturn(true);

        userService.deleteById(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteById_NotFound() {
        when(userRepository.existsById(1L)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> userService.deleteById(1L));
    }

}
