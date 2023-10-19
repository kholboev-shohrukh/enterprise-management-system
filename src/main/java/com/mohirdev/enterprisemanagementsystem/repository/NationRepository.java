package com.mohirdev.enterprisemanagementsystem.repository;

import com.mohirdev.enterprisemanagementsystem.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepository extends JpaRepository<Nation, Long> {
}
