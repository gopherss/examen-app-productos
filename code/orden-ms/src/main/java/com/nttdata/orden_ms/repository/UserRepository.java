package com.nttdata.orden_ms.repository;

import com.nttdata.orden_ms.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
