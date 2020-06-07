package com.khu.bpa.repositories;

import com.khu.bpa.entities.BpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BpInfoRepository extends JpaRepository<BpInfo, Long> {
}
