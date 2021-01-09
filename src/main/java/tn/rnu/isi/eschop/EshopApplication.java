package tn.rnu.isi.eschop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
 
import java.util.Locale;
 


//for jsr310 java 8 java.time.*
@EntityScan(
      basePackageClasses = {EshopApplication.class, Jsr310JpaConverters.class}
)

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class EshopApplication extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(EshopApplication.class);

	
//	@Bean
//	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
//	    TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
//	    tomcatFactory.addContextCustomizers((context) -> {
//	        StandardRoot standardRoot = new StandardRoot(context);
//	        standardRoot.setCacheMaxSize(40 * 1024);
//	    });
//	    return tomcatFactory;
//	}
	
	public EshopApplication()
	   {
	       super();
	       setRegisterErrorPageFilter(false);
	   }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EshopApplication.class);
	}
	
	
	
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }
 
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
 
     public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EshopApplication.class, args);
	}

}
