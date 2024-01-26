package dev.shoxruhjon.ekorxona.repository;

import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, Integer> {
}