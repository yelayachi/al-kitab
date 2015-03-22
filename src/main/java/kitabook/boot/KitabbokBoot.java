package kitabook.boot;

import kitabook.config.DomainAndPersistenceConfig;
import kitabook.entities.Topic;
import kitabook.metier.IMetier;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


public class KitabbokBoot {
	// le boot
	public static void main(String[] args) {
		// on prépare la configuration
		SpringApplication app = new SpringApplication(DomainAndPersistenceConfig.class);
		app.setLogStartupInfo(false);
		// on la lance
		ConfigurableApplicationContext context = app.run(args);
		// métier
		IMetier metier = context.getBean(IMetier.class);

		// save a couple of topics
		metier.addTopic(new Topic("PHYS"));
		metier.addTopic(new Topic("CHMI"));
		metier.addTopic(new Topic("koka"));
		

		// fetch all topics
		Iterable<Topic> topics = metier.getAllTopics();
		System.out.println("Topics found with findAll():");
		System.out.println("-------------------------------");
		for (Topic topic : topics) {
			System.out.println(topic);
		}
		System.out.println();

		// fetch an individual customer by ID
		Topic topic = metier.getTopicById(1L);
		System.out.println("Topic found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(topic);
		System.out.println();
		
		display("This is the topics we ever waited for ;) : ", topics);
		// fermeture du contexte Spring
		context.close();
	}

	// méthode utilitaire - affiche les éléments d'une collection
	private static <T> void display(String message, Iterable<T> elements) {
		System.out.println(message);
		for (T element : elements) {
			System.out.println(element);
		}
	}

}
