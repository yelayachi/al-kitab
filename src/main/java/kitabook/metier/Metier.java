package kitabook.metier;

import java.util.List;

import kitabook.entities.Book;
import kitabook.entities.Contributor;
import kitabook.entities.Participant;
import kitabook.entities.Publisher;
import kitabook.entities.Topic;
import kitabook.repositories.BookRepository;
import kitabook.repositories.ContributorRepository;
import kitabook.repositories.ParticipantRepository;
import kitabook.repositories.PublisherRepository;
import kitabook.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service("metier")
public class Metier implements IMetier {

	// répositories
	/*La valeur du champ ainsi annoté sera initialisée (injectée) par Spring avec la référence 
	d'un composant Spring du type ou du nom précisés.*/
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private ParticipantRepository participantRepository;
	@Autowired
	private ContributorRepository contributorRepository;

	// implémentation interface
	@Override
	public List<Topic> getAllTopics() {
		return Lists.newArrayList(topicRepository.findAll());
	}

	@Override
	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public void deleteTopic(long idTopic) {
		topicRepository.delete(idTopic);
		
	}

	@Override
	public Topic getTopicById(long id) {
		return topicRepository.findOne(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return Lists.newArrayList(bookRepository.findAll());
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(long idBook) {
		bookRepository.delete(idBook);
		
	}

	@Override
	public Book getBookById(long id) {
		return bookRepository.findOne(id);
	}

	@Override
	public List<Publisher> getAllPublishers() {
		return Lists.newArrayList(publisherRepository.findAll());
	}

	@Override
	public Publisher addPublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}

	@Override
	public void deletePublisher(long idPublisher) {
		publisherRepository.delete(idPublisher);
		
	}

	@Override
	public Publisher getPublisherById(long id) {
		return publisherRepository.findOne(id);
	}

	@Override
	public List<Participant> getAllParticipants() {
		return Lists.newArrayList(participantRepository.findAll());
	}

	@Override
	public Participant addParticipant(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public void deleteParticipant(long idParticipant) {
		participantRepository.delete(idParticipant);
		
	}

	@Override
	public Participant getParticipantById(long id) {
		return participantRepository.findOne(id);
	}

	@Override
	public List<Contributor> getAllContributors() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(contributorRepository.findAll());
	}

	@Override
	public Contributor addContributor(Contributor contributor) {
		return contributorRepository.save(contributor);
	}

	@Override
	public void deleteContributor(long idContributor) {
		contributorRepository.delete(idContributor);
		
	}

	@Override
	public Contributor getContributorById(long id) {
		return contributorRepository.findOne(id);
	}
}