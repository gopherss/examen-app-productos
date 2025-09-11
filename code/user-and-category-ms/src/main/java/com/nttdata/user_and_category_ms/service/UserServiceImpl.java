package com.nttdata.user_and_category_ms.service;

import com.nttdata.dockerized.postgresql.exception.BadRequestException;
import com.nttdata.dockerized.postgresql.exception.InternalServerErrorException;
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
        try {
            if (user.getName() == null || user.getName().isBlank() ||
                    user.getEmail() == null || user.getEmail().isBlank()){
                throw new BadRequestException("El Email y el nombre son obligatorios");
            }

            user.setActive(Boolean.TRUE);
            return userRepository.save(user);

        } catch (BadRequestException e) {
            throw e;
        }catch (Exception e){
            throw new InternalServerErrorException("Error interno al guardar el usuario: " + e.getMessage());
        }
    }

    @Override
    public User updateById(Long id, User user) {
        return userRepository.findById(id)
                .map(userExisting -> {
                    userExisting.setName(user.getName());
                    userExisting.setEmail(user.getEmail());
                    userExisting.setActive(user.getActive());
                    userExisting.setRegistrationDate(user.getRegistrationDate());
                    return userRepository.save(userExisting);
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
