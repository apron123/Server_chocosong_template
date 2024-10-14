package com.ziumks.chocosong.config.database;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Properties;

import static com.ziumks.chocosong.config.database.DatabaseConstants.TargetDatabase.*;

/**
 * TARGET 데이터베이스 엔티티매니저 설정
 *
 * @author  이상민
 * @since   2024.05.21 16:30
 */
@Slf4j
@EnableJpaRepositories(
        basePackages = {package_domain, package_repository},
        entityManagerFactoryRef = entity_manager_factory,
        transactionManagerRef = tx_manager
)
@RequiredArgsConstructor
@Configuration
public class TargetDatabaseConfig {
    
    private final DatabaseProperties dbProps;

    /**
     * DataSource를 생성하여 반환합니다.
     *
     * @return DataSource 객체
     */
    @Bean(name = "targetDataSource")
    public DataSource dataSource() {

        DatabaseProperties.Target targetInfo = dbProps.getTarget();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(targetInfo.getDriver());
        dataSource.setUrl(targetInfo.getUrl());
        dataSource.setUsername(targetInfo.getUsername());
        dataSource.setPassword(targetInfo.getPassword());

        log.info("#################################################");
        log.info("## Database Connection - Target Config Database ");
        log.info("Driver      : {}", targetInfo.getDriver());
        log.info("URL         : {}", targetInfo.getUrl());
        log.info("USERNAME    : {}", targetInfo.getUsername());
        log.info("PASSWORD    : {}", targetInfo.getPassword());
        log.info("MaxPoolSize : {}", targetInfo.getMaxPoolSize());
        log.info("#################################################");

        HikariDataSource hds = new HikariDataSource();
        hds.setDataSource(dataSource);
        hds.setPoolName("TARGET-DB-POOL");
        hds.setMaximumPoolSize(Integer.parseInt(targetInfo.getMaxPoolSize()));

        return hds;

    }

    /**
     * JpaTransactionManager를 생성하여 반환합니다.
     *
     * @param entityManagerFactoryBean LocalContainerEntityManagerFactoryBean 객체
     * @return JpaTransactionManager 객체
     */
    @Bean(name=tx_manager)
    @Autowired
    public JpaTransactionManager jpaTransactionManager(@Qualifier(value = entity_manager_factory) LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());

        return transactionManager;

    }

    /**
     * EntityManagerFactory를 생성하여 반환합니다.
     *
     * @return LocalContainerEntityManagerFactoryBean 객체
     */
    @Bean(name = entity_manager_factory)
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        DatabaseProperties.Target targetInfo = dbProps.getTarget();

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpsAdapter = new HibernateJpaVendorAdapter();
        jpsAdapter.setShowSql(false);
        entityManagerFactoryBean.setJpaVendorAdapter(jpsAdapter);
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(package_domain);

        Properties props = new Properties();

        if(!StringUtils.isEmpty(targetInfo.getSchema())){
            props.setProperty(Environment.DEFAULT_SCHEMA, targetInfo.getSchema());
        }
        props.setProperty(Environment.DIALECT, targetInfo.getDialect());
        props.setProperty(Environment.SHOW_SQL, targetInfo.getShowSql());
        props.setProperty(Environment.FORMAT_SQL, "true");
        props.setProperty(Environment.HBM2DDL_AUTO, targetInfo.getDdlAuto());
        props.setProperty(Environment.USE_SECOND_LEVEL_CACHE, "true");
        props.setProperty(Environment.USE_QUERY_CACHE, "true");
        props.setProperty(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");

        entityManagerFactoryBean.setJpaProperties(props);

        return entityManagerFactoryBean;

    }

}
