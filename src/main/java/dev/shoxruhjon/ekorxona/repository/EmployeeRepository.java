package dev.shoxruhjon.ekorxona.repository;

import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import dev.shoxruhjon.ekorxona.entity.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    @Query("select count(u) from users u where u.department = ?1")
    Integer countByDepartment(Department department);

    @Query("select SUM(u.salary) from users u")
    BigDecimal sumSalary();

//    @Query("select COUNT(c) from customer c where DATE(c.createdAt) = CURRENT_DATE")
//    Long countDailyRegisteredCustomers();

    @Query("select u from users u JOIN FETCH customer c group by u.id order by COUNT(c) desc")
    EmployeeEntity findEmployeeWithMostCustomers();

    @Query("select COUNT(c) from customer c where c.createdBy = ?1")
    Integer findEmployeeWithMostCustomersTotal(Integer id);

    @Query("select c.createdBy, COUNT(c) as count from customer c GROUP BY c.createdBy ORDER BY count desc")
    List<EmployeeEntity> findTop3Employees();
}