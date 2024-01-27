package dev.shoxruhjon.ekorxona.repository;

import dev.shoxruhjon.ekorxona.entity.SaleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {
    @Query("select s from sale s where s.id = ?1 and s.createdBy = ?2")
    Optional<SaleEntity> findByIdAndCreatedBy(Integer id, Integer createdBy);

    @Query("select s from sale s where s.createdBy = ?1")
    List<SaleEntity> findByIdAndCreatedBySales(Integer createdBy, Pageable pageable);
}