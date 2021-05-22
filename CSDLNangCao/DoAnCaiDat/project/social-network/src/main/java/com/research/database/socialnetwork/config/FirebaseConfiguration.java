package com.research.database.socialnetwork.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;

@Service
public class FirebaseConfiguration {

    @PostConstruct
    public void initialize() {
        try {
            File authenConfig = ResourceUtils.getFile("classpath:serviceaccount.json");
            FileInputStream serviceAccount = new FileInputStream(authenConfig);

/*            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://social-network-31b96-default-rtdb.firebaseio.com")
                    .build();*/
			FirebaseOptions options = new FirebaseOptions.Builder()
				    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				    .setDatabaseUrl("https://social-network-realtime-default-rtdb.asia-southeast1.firebasedatabase.app")
				    .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
