package com.research.database.socialnetwork;

import com.research.database.socialnetwork.storage.mysql.entity.User;
import com.research.database.socialnetwork.storage.mysql.service.IUserService;
import com.research.database.socialnetwork.storage.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

/*TODO*/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);
    }

}
