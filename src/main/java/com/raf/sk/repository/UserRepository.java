package com.raf.sk.repository;

import com.raf.sk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    void deleteById(int id);

    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findById(Integer id);
}
