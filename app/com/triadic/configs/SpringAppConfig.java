package com.triadic.configs;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages={"com.triadic.nexgeno"})
@EnableMongoRepositories(basePackages= "com.triadic.nexgeno.repository")
@PropertySource("classpath:application.conf")
public class SpringAppConfig extends AbstractMongoConfiguration {

    @Autowired
    private Environment environment;

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("mongodb.db.name");
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(environment.getProperty("mongodb.url"), Integer.parseInt(environment.getProperty("mongodb.port")));
    }

    /*@Override
    public UserCredentials getUserCredentials(){
        return new UserCredentials(environment.getProperty("mongodb.db.username"), environment.getProperty("mongodb.db.password"));
    }*/
}
