package com.group21.repairmenService.repository;

import com.group21.repairmenService.entity.Ad;
import com.group21.repairmenService.enums.AdStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findAllByUserId(Long userId);

    List<Ad> findAllByServiceNameContaining(String name);

    List<Ad> findByStatus(AdStatus status);
}
