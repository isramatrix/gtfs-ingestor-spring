package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.RoutesEntity;
import com.iecisa.gtfsprocessor.entity.ShapesEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface RoutesRepository extends GtfsRepository<RoutesEntity>
{

}
