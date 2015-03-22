package kitabook.tests;

import java.util.List;

import kitabook.config.DomainAndPersistenceConfig;
import kitabook.entities.Topic;
import kitabook.metier.IMetier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringApplicationConfiguration(classes = DomainAndPersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Metier {

	@Autowired
	private IMetier metier;

	@Test
	public void test1() {
		// affichage clients
		List<Topic> topics = metier.getAllTopics();;
		display("Liste des clients :", topics);

		// affichage créneaux d'un médecin
		Topic topic = topics.get(0);
		display(String.format("Liste des créneaux du médecin %s", topic), topics);
		// liste des Rv d'un médecin, un jour donné
		
		//Assert.assertEquals(rv, rv2);
	}

	// méthode utilitaire - affiche les éléments d'une collection
	private void display(String message, Iterable<?> elements) {
		System.out.println(message);
		for (Object element : elements) {
			System.out.println(element);
		}
	}

}
