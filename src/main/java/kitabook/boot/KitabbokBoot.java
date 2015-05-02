package kitabook.boot;

import kitabook.config.DomainAndPersistenceConfig;
import kitabook.entities.Book;
import kitabook.entities.Contributor;
import kitabook.entities.Participant;
import kitabook.entities.Publisher;
import kitabook.entities.Topic;
import kitabook.metier.IMetier;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class KitabbokBoot {
	// le boot
	public static void main(String[] args) {
		// on prépare la configuration
		SpringApplication app = new SpringApplication(
				DomainAndPersistenceConfig.class);
		app.setLogStartupInfo(false);
		// on la lance
		ConfigurableApplicationContext context = app.run(args);
		// métier
		IMetier metier = context.getBean(IMetier.class);

		// save a couple of topics
		//Topic topicB = (Topic) new Topic("PHYS").build(1L, 1L);
		//metier.addTopic(new Topic("HIST"));
		//metier.addTopic(new Topic("DINE"));
		//metier.addTopic(new Topic("koka"));

		metier.addPublisher(new Publisher("Kitabook 5", "KITABOOK 5", "28/11/2015","iliass.dagha@test.com"));
		metier.addContributor((Contributor)new Contributor("Iliass", "Dagha", "Contrib1","lemommo@test.com").build(1L, 1L));
		metier.addParticipant((Participant)new Participant("iliyo", "dido", "idag", "dagi", "contrib1", "28/11/1986").build(1L, 1L));
		//Publisher publ3 = new Publisher("Kitabook 4", "KITABOOK 4", new Date(2015,10,02));
		//metier.addPublisher(publ3);
		//metier.addBook(new Book(publ3, "livre 1", new Date(2015,01,02), 200,"123456789", 2));

		// fetch all topics
		Iterable<Topic> topics = metier.getAllTopics();
		display("Topics found with findAll():", topics);
		

		// fetch all books
		Iterable<Publisher> publishers = metier.getAllPublishers();
		display("Publishers found with findAll():", publishers);
		
		Iterable<Book> books = metier.getAllBooks();
		display("Books found with findAll():", books);
		
		Iterable<Participant> participants = metier.getAllParticipants();
		display("Participants found with findAll():", participants);
		
		Iterable<Contributor> contributors = metier.getAllContributors();
		display("Contributors found with findAll():", contributors);

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
