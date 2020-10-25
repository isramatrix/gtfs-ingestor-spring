package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.FeedInfoEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface FeedInfoRepository extends GtfsRepository<FeedInfoEntity>
{

}
