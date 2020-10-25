package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.FareRulesEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface FareRulesRepository extends GtfsRepository<FareRulesEntity>
{

}
