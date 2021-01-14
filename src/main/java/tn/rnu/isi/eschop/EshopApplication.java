package tn.rnu.isi.eschop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


 

@SpringBootApplication
public class EshopApplication extends SpringBootServletInitializer {

	private final static Logger logger = LoggerFactory.getLogger(EshopApplication.class);

	public static void main(String[] args) throws Exception {
		logger.debug(":::Demarrage  Eshop Application :::");

		SpringApplication.run(EshopApplication.class, args);
		
	}

}
