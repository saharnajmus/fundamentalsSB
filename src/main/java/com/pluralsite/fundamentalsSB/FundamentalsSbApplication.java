package com.pluralsite.fundamentalsSB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FundamentalsSbApplication {
    //private static final Logger log = LoggerFactory.logger(com.pluralsite.fundamentalsSB.FundamentalsSbApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(FundamentalsSbApplication.class, args);
    }

}

	/*@Bean
	public CommandLineRunner demo(PersonRepository repository){
		return (args)->{
			repository.save(new Person("sophia"));
			repository.save(new Person("sara"));
			for(Person person: repository.findAll()){
				log.info("The person details are " + person.toString());

			}
		};
	}

	@Bean
	public CommandLineRunner demoMethod(PassportRepository repository){
		return (args)->{
			repository.save(new Passport(12345,"Pakistani"));
			repository.save(new Passport(678910,"Belgian"));
			for(Passport passport: repository.findAll()){
				log.info("The passport details are " + passport.toString());

			}
		};
	}*/


//this class is used to bootstrap and launch a spring application from java main method