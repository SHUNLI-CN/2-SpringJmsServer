package fr.aoufi.springsample.runtime;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.aoufi.springsample.model.Personne;
import fr.aoufi.springsample.service.PersonneService;
import fr.aoufi.springsamplejava.conf.ApplicationConfiguration;

public class Runtime {

	public static void main(String[] args) throws JsonProcessingException {

		System.setProperty("spring.profiles.active", "jpa");

		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		for (String string : applicationContext.getBeanDefinitionNames()) {
			System.out.println(string);
		}
		
		PersonneService personneService = (PersonneService) applicationContext.getBean("personneService");

		personneService = applicationContext.getBean(PersonneService.class);

		personneService = applicationContext.getBean("personneService", PersonneService.class);

		Personne personne = new Personne();
		personne.setNom("Dupont");
		personne.setPrenom("Pierre");
		
		// envoi de la personne sur la file jms
		personneService.save(personne);

		applicationContext.close();
	}

}
