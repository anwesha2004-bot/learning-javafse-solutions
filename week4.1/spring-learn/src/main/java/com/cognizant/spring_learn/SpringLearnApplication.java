package com.cognizant.spring_learn;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Application STARTING...");
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Application STARTED.");

		displayDate();       // ✅ Hands-on 2
		displayCountry();
		displayCountries(); // ✅ Hands-on 6
// ✅ Hands-on 4
		// displayCountries(); // 🔜 Hands-on 6 (you can uncomment this later)
	}

	// ✅ Hands-on 2: Load SimpleDateFormat from XML

	public static void displayScope() {
		LOGGER.info("START - displayScope()");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country1 = context.getBean("country", Country.class);
		Country country2 = context.getBean("country", Country.class);

		LOGGER.debug("Country1: {}", country1);
		LOGGER.debug("Country2: {}", country2);

		LOGGER.debug("Are both objects same? {}", country1 == country2); // true if singleton, false if prototype

		LOGGER.info("END - displayScope()");
	}

	public static void displayDate() {
		LOGGER.info("START - displayDate()");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat sdf = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			Date date = sdf.parse("31/12/2018");
			LOGGER.debug("Parsed Date: {}", date);
		} catch (ParseException e) {
			LOGGER.error("Error parsing date", e);
		}

		LOGGER.info("END - displayDate()");
	}
	public static void displayCountries() {
		LOGGER.info("START - displayCountries()");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries = context.getBean("countryList", List.class);

		for (Country country : countries) {
			LOGGER.debug("Country: {}", country);
		}

		LOGGER.info("END - displayCountries()");
	}

	// ✅ Hands-on 4: Load Country from XML
	public static void displayCountry() {
		LOGGER.info("START - displayCountry()");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);

		LOGGER.debug("Country: {}", country);

		LOGGER.info("END - displayCountry()");
	}
}


