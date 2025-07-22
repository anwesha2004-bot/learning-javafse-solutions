package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.model.Skill;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);

		LOGGER.info("Application STARTED.");

		displayDate();
		displayCountry();
		displayCountries();
		displaySkill();

		LOGGER.info("Application ENDED.");
	}

	private static void displayDate() {
		LOGGER.info("START - displayDate()");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Parsed Date: {}", date);
		} catch (Exception e) {
			LOGGER.error("Date parsing error: {}", e.getMessage());
		}
		LOGGER.info("END - displayDate()");
	}

	private static void displayCountry() {
		LOGGER.info("START - displayCountry()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country: {}", country);
		LOGGER.info("END - displayCountry()");
	}

	private static void displayCountries() {
		LOGGER.info("START - displayCountries()");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", List.class);
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("END - displayCountries()");
	}

	private static void displaySkill() {
		LOGGER.info("START - displaySkill()");
		ApplicationContext context = new ClassPathXmlApplicationContext("skill.xml");
		Skill skill = context.getBean("skill", Skill.class);
		LOGGER.debug("Skill: {}", skill);
		LOGGER.info("END - displaySkill()");
	}
}

