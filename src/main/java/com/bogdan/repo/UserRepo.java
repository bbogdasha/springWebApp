package com.bogdan.repo;

import com.bogdan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User getUserById(Long id);

    List<User> findAllByOrderByIdAsc();
}