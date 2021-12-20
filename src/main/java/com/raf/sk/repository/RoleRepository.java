package com.raf.sk.repository;

import com.raf.sk.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Rank, Long> {
    Optional<Rank> findByType(String name);
}