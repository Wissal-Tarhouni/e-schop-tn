package tn.rnu.isi.eschop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

 

@SpringBootApplication
public class EshopApplication extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(EshopApplication.class);

	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EshopApplication.class, args);
	}

}
