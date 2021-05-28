package com.research.database.socialnetwork.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "socialnetwork.dbhost")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DBHostConfig {
    private String elasticsearchHost;
    private String neo4jConectionString;
}
