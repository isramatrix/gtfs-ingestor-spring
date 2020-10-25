package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.StopTimesEntity;
import com.iecisa.gtfsprocessor.entity.StopsEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface StopTimesRepository extends GtfsRepository<StopTimesEntity>
{

}
