package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.CalendarEntity;
import com.iecisa.gtfsprocessor.entity.FareAttributesEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface FareAttributesRepository extends GtfsRepository<FareAttributesEntity>
{

}
