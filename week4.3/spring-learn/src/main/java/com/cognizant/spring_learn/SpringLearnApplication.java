package com.cognizant.spring_learn;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication(
		scanBasePackages = "com.cognizant.spring_learn",
		exclude = { R2dbcAutoConfiguration.class }
)
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		LOGGER.info("Application STARTING...");
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Application STARTED.");

		displayDate();       // Hands-on 2
		displayCountry();    // Hands-on 3
		displayCountries();  // Hands-on 6
	}

	public static void displayDate() throws ParseException {
		LOGGER.info("START - displayDate()");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("31/12/2018");
		LOGGER.debug("Parsed Date: {}", date);
		LOGGER.info("END - displayDate()");
	}

	public static void displayCountry() {
		LOGGER.info("START - displayCountry()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country");
		LOGGER.debug("Country: {}", country.toString());
		LOGGER.info("END - displayCountry()");
	}

	public static void displayCountries() {
		LOGGER.info("START - displayCountries()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("END - displayCountries()");
	}
}


