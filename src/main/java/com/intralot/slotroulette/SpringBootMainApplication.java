package com.intralot.slotroulette;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
* Autowired does not work in main application class because spring can not at this point
* */
@SpringBootApplication
@EnableScheduling
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration
public class SpringBootMainApplication
{
	private static final  Logger log = LoggerFactory.getLogger(SpringBootMainApplication.class);

	public static void main(String[] args)
	{
		log.info("Slot Roulette Server is starting");

//		int total = 12;
//		int[] frequency = new int[] {4,3,2,2,1};
//		double totalPercentage = 0;
//
//		for (int i = 0 ; i < 5 ; i++)
//		{
//			double probability = frequency[i] / (double)total;
//			log.info("I : " + i + " Probability : " + probability);
//			totalPercentage += probability;
//		}
//		log.info("TotalPercentage : " + totalPercentage);



		SpringApplication.run(SpringBootMainApplication.class, args);

		//Integer a = null;
		//Integer b = null;
		// Ensure that the root directory exists
		//giveValues(a,b);
		//long newNumber2 = 132433455477824L;
		//log.info("OUT A : " + a);
		//log.info("OUT B : " + b);

		//JmsTemplate jms = context.getBean(JmsTemplate.class);
		//jms.convertAndSend("javainuse", "test message");
	}

	private static void giveValues(Integer a, Integer b)
	{
		a = new Integer(1);
		b = new Integer(2);

		log.info("IN A : " + a);
		log.info("IN B : " + b);
	}

	public static void test()
	{
		Map<String, Integer> nameMap = new HashMap<>();
		Integer              value   = nameMap.computeIfAbsent("John", String::length);

		//The Function interface has also a default compose method that allows
		// to combine several functions into one and execute them sequentially:


		Function<Integer, String> intToString = Object::toString;
		Function<String, String>  quote       = s -> "'" + s + "'";

		Function<Integer, String> quoteIntToString = quote.compose(intToString);

		Function<String, String>  addParenthesis = s -> "{" + s + "}";
		Function<String, String>  strToUpper = String::toUpperCase;

		Function<String , String> upup       = strToUpper.compose(addParenthesis);

		System.out.println("Value : " + value + " quote : " + quoteIntToString.apply(5).toString());
		System.out.println("Value : " + value + " upup : " + upup.apply("paparakos"));
		//assertEquals("'5'", quoteIntToString.apply(5));
	}
}

/*@Bean
public CommandLineRunner demo(AuthRepository repository)
{
	return (args) -> {
		// save a couple of customers

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Role role : repository.findAll()) {
			log.info("Role : " + role.getRole() + " : Description : " + role.getDescription());
		}
		log.info("");
	};
}*/
