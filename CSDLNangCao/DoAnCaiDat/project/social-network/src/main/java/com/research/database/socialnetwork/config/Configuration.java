package com.research.database.socialnetwork.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@org.springframework.context.annotation.Configuration
@EnableElasticsearchRepositories(basePackages = "com.research.database.socialnetwork")
@EnableConfigurationProperties
@ConfigurationProperties("application.yml")
public class Configuration {
    //    TO-DO
    //public static String elastichSeachHost= "http://localhost:9200";
    public static String elastichSeachHost= "18.141.200.97:9200";
    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo(elastichSeachHost)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}