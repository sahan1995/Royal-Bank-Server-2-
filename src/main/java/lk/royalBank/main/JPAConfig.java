package lk.royalBank.main;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@Configuration
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
public class JPAConfig {

//    @Autowired
//    private Environment env;
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jva){
//
//        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
//        lcemfb.setPackagesToScan("lk.royalBank.entity");
//        lcemfb.setDataSource(ds);
//        lcemfb.setJpaVendorAdapter(jva);
//        return lcemfb;
//    }
//
//    @Bean
//    public DataSource dataSource(){
//
//        BasicDataSource bds = new BasicDataSource();
//        bds.setDriverClassName(env.getRequiredProperty("hibernate.connection.driver_class"));
//        bds.setUrl(env.getRequiredProperty("hibernate.connection.url"));
//        bds.setUsername(env.getRequiredProperty("hibernate.connection.username"));
//        bds.setPassword(env.getRequiredProperty("hibernate.connection.password"));
//        bds.setInitialSize(env.getRequiredProperty("bds.initial_size",Integer.class));
//        bds.setMaxTotal(env.getRequiredProperty("bds.max_total",Integer.class));
//        bds.setMaxIdle((env.getRequiredProperty("bds.max_idel",Integer.class)));
//        return bds;
//
//    }
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter(){
//        HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
//        jpa.setDatabase(Database.MYSQL);
//        jpa.setGenerateDdl(true);
//        jpa.setShowSql(true);
//        jpa.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
//        return jpa;
//    }
//
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        return new JpaTransactionManager(emf);
//    }
}
