package com.hierarchical.organization.repository;

import com.hierarchical.organization.domain.entities.Directorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorateRepository extends JpaRepository<Directorate, Long> {

}
