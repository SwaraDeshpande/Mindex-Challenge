package com.mindex.challenge.config;

import com.mindex.challenge.dao.EmployeeRepository;
//import com.mongodb.client.MongoClient;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class MongoConfig {


    @Bean
    public MongoDbFactory mongoDbFactory() {

        MongoClient mongoClient = new MongoClient("127.0.0.1:27017");

        return new SimpleMongoDbFactory(mongoClient, "test" );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}


