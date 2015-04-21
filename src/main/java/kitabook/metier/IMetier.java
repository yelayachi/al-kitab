package kitabook.metier;

import java.util.List;

import kitabook.entities.Book;
import kitabook.entities.Contributor;
import kitabook.entities.Participant;
import kitabook.entities.Publisher;
import kitabook.entities.Topic;

public interface IMetier {

	// liste des themes
	public List<Topic> getAllTopics();

	public Topic addTopic(Topic topic);

	public void deleteTopic(long idTopic);

	public Topic getTopicById(long id);

	// liste des BOOKS
	public List<Book> getAllBooks();

	public Book addBook(Book book);

	public void deleteBook(long idBook);

	public Book getBookById(long id);
	
	// liste des PUBLISHERS
	public List<Publisher> getAllPublishers();

	public Publisher addPublisher(Publisher publisher);

	public void deletePublisher(long idPublisher);

	public Publisher getPublisherById(long id);
	
	// liste des PARTICIPANT
	public List<Participant> getAllParticipants();

	public Participant addParticipant(Participant participant);

	public void deleteParticipant(long idParticipant);

	public Participant getParticipantById(long id);
	
	// liste des CONTRIBUTOR
	public List<Contributor> getAllContributors();

	public Contributor addContributor(Contributor contributor);

	public void deleteContributor(long idContributor);

	public Contributor getContributorById(long id);

}