package com.nttdata.user_and_category_ms.repository;

import com.nttdata.dockerized.postgresql.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
