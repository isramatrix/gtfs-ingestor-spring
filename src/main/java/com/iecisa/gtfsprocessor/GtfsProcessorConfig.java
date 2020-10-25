package com.iecisa.gtfsprocessor;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableScheduling
@EnableJpaRepositories(
        entityManagerFactoryRef = "gtfsEntityManager",
        transactionManagerRef = "gtfsTransactionManager",
        basePackages = "com.iecisa.gtfsprocessor.repository"
)
public abstract class GtfsProcessorConfig
{
    @Autowired
    private Environment env;

    @Value("${gtfs.schema:#{null}}")
    private String gtfsSchema;

    protected abstract DataSourceProperties dataSource();

    @Bean
    public BasicDataSource dataSourceGtfs()
    {
        return dataSource()
                .initializeDataSourceBuilder()
                .type(BasicDataSource.class)
                .build();
    }

    @Bean(name = "gtfsEntityManager")
    public LocalContainerEntityManagerFactoryBean gtfsEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSourceGtfs())
                .properties(getProperties())
                .packages("com.iecisa.gtfsprocessor.entity")
                .persistenceUnit("gtfs")
                .build();
    }

    @Bean(name = "gtfsTransactionManager")
    public PlatformTransactionManager gtfsTransactionManager(
            @Qualifier("gtfsEntityManager") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map<String, ?> getProperties()
    {
        Map<String, String> properties = new HashMap<>();
        if (gtfsSchema != null) properties.put("hibernate.default_schema", gtfsSchema);
        return properties;
    }
}
