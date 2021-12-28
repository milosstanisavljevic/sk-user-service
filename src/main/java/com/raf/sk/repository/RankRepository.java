package com.raf.sk.repository;

import com.raf.sk.domain.UserRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RankRepository extends JpaRepository<UserRank,Long> {

    Optional<UserRank> findByType(String name);
}
