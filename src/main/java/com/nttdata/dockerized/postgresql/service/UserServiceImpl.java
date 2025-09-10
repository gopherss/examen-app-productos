package com.nttdata.dockerized.postgresql.service;

import com.nttdata.dockerized.postgresql.exception.BadRequestException;
import com.nttdata.dockerized.postgresql.exception.NotFoundException;
import com.nttdata.dockerized.postgresql.model.entity.User;
import com.nttdata.dockerized.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado", "404"));
    }

    @Override
    public User save(User user) {

        if (user.getName() == null || user.getName().isEmpty() ||
                user.getEmail() == null || user.getEmail().isEmpty()){
            throw new BadRequestException("El Email y el nombre son obligatorios");
        }

        user.setActive(Boolean.TRUE);
        return userRepository.save(user);
    }

    @Override
    public User updateById(Long id, User user) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setName(user.getName());
                    existing.setEmail(user.getEmail());
                    existing.setActive(user.getActive());
                    existing.setRegistrationDate(user.getRegistrationDate());
                    return userRepository.save(existing);
                }).orElseThrow(() -> new NotFoundException("Usuario no encontrado para actualizar", "404"));
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)){
            throw new NotFoundException("Usuario no encontrado para eliminar", "404");
        }
        userRepository.deleteById(id);
    }
}
