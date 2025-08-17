package com.learning.jobappservice.RegisterApi.Repository;

import com.learning.jobappservice.RegisterApi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByMobile(String mobile);
    Optional<User> findByCnic(String cnic);
}
