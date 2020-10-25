package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.PathwaysEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface PathwaysRepository extends GtfsRepository<PathwaysEntity>
{

}
