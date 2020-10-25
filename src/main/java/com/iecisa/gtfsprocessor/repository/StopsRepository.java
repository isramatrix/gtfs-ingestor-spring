package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.StopsEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface StopsRepository extends GtfsRepository<StopsEntity>
{

}
