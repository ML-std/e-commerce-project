package com.ecommerce.infoservice.repository;

import com.ecommerce.infoservice.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info,Long> {
}
