package dev.shoxruhjon.ekorxona.repository;

import dev.shoxruhjon.ekorxona.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Integer> {

    @Query("select a from auth a where a.email = ?1")
    Optional<AuthEntity> findByEmail(String email);
}