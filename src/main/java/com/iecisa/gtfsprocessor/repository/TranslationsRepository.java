package com.iecisa.gtfsprocessor.repository;

import com.iecisa.gtfsprocessor.entity.TranslationsEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("default")
public interface TranslationsRepository extends GtfsRepository<TranslationsEntity>
{

}
