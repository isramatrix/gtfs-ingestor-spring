package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.GtfsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GtfsRepository<E extends GtfsEntity> extends JpaRepository<E, Long>
{

}
