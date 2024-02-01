package dev.shoxruhjon.ekorxona.repository;

import dev.shoxruhjon.ekorxona.entity.SaleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {
    @Query("select s from SaleEntity s where s.id = ?1 and s.createdBy = ?2")
    Optional<SaleEntity> findByIdAndCreatedBy(Integer id, Integer createdBy);

    @Query("select s from SaleEntity s where s.createdBy = ?1")
    List<SaleEntity> findByIdAndCreatedBySales(Integer createdBy, Pageable pageable);

    @Query("select s.advertisement from SaleEntity s order by s.expense desc")
    String findTypeWithHighestAdvertisingCosts();

    @Query("""
            select s.createdBy, SUM(s.expense) as totalExpense
            from SaleEntity s
            group by s.createdBy
            order by totalExpense desc
            """)
    Integer findEmployeeWithMostAdvertisingExpenses();

    @Query("""
           select count(s) from SaleEntity s
           where DATE(s.createdAt) between :startDate and :endDate
           """)
    Integer countAdvertisementsLaunchedLastMonth(LocalDateTime startDate, LocalDateTime endDate);
}