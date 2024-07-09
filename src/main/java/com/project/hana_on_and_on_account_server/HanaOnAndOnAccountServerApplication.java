package com.project.hana_on_and_on_account_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class HanaOnAndOnAccountServerApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HanaOnAndOnAccountServerApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);
	}

}
