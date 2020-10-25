package com.iecisa.gtfsprocessor;

import com.iecisa.gtfsprocessor.entity.StopsEntity;
import com.iecisa.gtfsprocessor.model.DatabaseEnvironment;
import com.iecisa.gtfsprocessor.repository.StopsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

class GtfsProcessorApplicationTests {

    DatabaseEnvironment environment = new DatabaseEnvironment() { };

    @Test
    void contextLoads() throws Exception
    {
        /*
        GtfsInsertionService insertionService = new GtfsInsertionService();

        FtpSource ftpSource = new FtpSource("185.22.92.152", "usriecisa", "FWxaIpD0pHjV");
        ftpSource.setGtfsFileName("GTFS.zip");

        insertionService
                .setSource(ftpSource)
                .insert();
         */
    }

}
