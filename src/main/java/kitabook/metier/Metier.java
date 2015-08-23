package kitabook.metier;

import java.util.List;

import kitabook.entities.Address;
import kitabook.entities.Book;
import kitabook.entities.Chronic;
import kitabook.entities.CommentBookByParticipant;
import kitabook.entities.Contributor;
import kitabook.entities.DoMap;
import kitabook.entities.InterestedInContributor;
import kitabook.entities.InterestedInParticipant;
import kitabook.entities.InterestedInPublisher;
import kitabook.entities.InterestedInTopic;
import kitabook.entities.MindMap;
import kitabook.entities.Participant;
import kitabook.entities.Publisher;
import kitabook.entities.Read;
import kitabook.entities.Readed;
import kitabook.entities.Summarize;
import kitabook.entities.Thematize;
import kitabook.entities.Topic;
import kitabook.entities.Translate;
import kitabook.entities.WishRead;
import kitabook.entities.Write;
import kitabook.repositories.AdressRepository;
import kitabook.repositories.BookRepository;
import kitabook.repositories.ChronicRepository;
import kitabook.repositories.CommentBookByParticipantRepository;
import kitabook.repositories.ContributorRepository;
import kitabook.repositories.DoMapRepository;
import kitabook.repositories.InterestedInContributorRepository;
import kitabook.repositories.InterestedInParticipantRepository;
import kitabook.repositories.InterestedInPublisherRepository;
import kitabook.repositories.InterestedInTopicRepository;
import kitabook.repositories.MindMapRepository;
import kitabook.repositories.ParticipantRepository;
import kitabook.repositories.PrefaceRepository;
import kitabook.repositories.PublisherRepository;
import kitabook.repositories.ReadRepository;
import kitabook.repositories.ReadedRepository;
import kitabook.repositories.SummarizeRepository;
import kitabook.repositories.ThematizeRepository;
import kitabook.repositories.TopicRepository;
import kitabook.repositories.TranslateRepository;
import kitabook.repositories.WishReadRepository;
import kitabook.repositories.WriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service("metier")
public class Metier implements IMetier {

	// répositories n
	/*La valeur du champ ainsi annoté sera initialisée (injectée) par Spring avec la référence 
	d'un composant Spring du type ou du nom précisés.*/
	@Autowired
	private AdressRepository adressRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ChronicRepository chronicRepository;
	@Autowired
	private CommentBookByParticipantRepository commentBkByPpatRepository; 
	@Autowired
	private ContributorRepository contributorRepository;
	@Autowired
	private DoMapRepository doMapRepository;
	@Autowired
	private InterestedInContributorRepository interestedInContributorRepository;
	@Autowired
	private InterestedInParticipantRepository interestedInParticipantRepository;
	@Autowired
	private InterestedInPublisherRepository interestedInPublisherRepository;
	@Autowired
	private InterestedInTopicRepository interestedInTopicRepository;
	@Autowired
	private MindMapRepository mindMapRepository;
	@Autowired
	private ParticipantRepository participantRepository;
	@Autowired
	private PrefaceRepository prefaceRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private ReadedRepository readedRepository;
	@Autowired
	private ReadRepository readRepository;
	@Autowired
	private SummarizeRepository summarizeRepository;
	@Autowired
	private ThematizeRepository thematizeRepository;
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private TranslateRepository translateRepository;
	@Autowired
	private WishReadRepository wishReadRepository;
	@Autowired
	private WriteRepository writeRepository;
	
	
	// implémentation ADDRESSES
	@Override
	public List<Address> getAllAdresses() {
		return Lists.newArrayList(adressRepository.findAll());
	}

	@Override
	public Address addAdress(Address adresse) {
		return adressRepository.save(adresse);
	}

	@Override
	public void deleteAddress(long id) {
		adressRepository.delete(id);
		
	}

	@Override
	public Address getAddressById(long id) {
		return adressRepository.findOne(id);
	}
	
	// implémentation BOOKS
	@Override
	public List<Book> getAllBooks() {
		return Lists.newArrayList(bookRepository.findAll());
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.delete(id);
		
	}

	@Override
	public Book getBookById(long id) {
		return bookRepository.findOne(id);
	}
	
	// implémentation CHRONICS
	@Override
	public List<Chronic> getAllChronics() {
		return Lists.newArrayList(chronicRepository.findAll());
	}

	@Override
	public Chronic addChronic(Chronic chronic) {
		return chronicRepository.save(chronic);
	}

	@Override
	public void deleteChronic(long id) {
		chronicRepository.delete(id);
	}

	@Override
	public Chronic getChronicById(long id) {
		return chronicRepository.findOne(id);
	}

	// implémentation CommentBookByParticipant
	@Override
	public List<CommentBookByParticipant> getAllCommentBookByParticipants() {
		return Lists.newArrayList(commentBkByPpatRepository.findAll());
	}

	@Override
	public CommentBookByParticipant addCommentBookByParticipant(
			CommentBookByParticipant commentBookByParticipant) {
		return commentBkByPpatRepository.save(commentBookByParticipant);
	}

	@Override
	public void deleteCommentBookByParticipant(long id) {
		commentBkByPpatRepository.delete(id);
		
	}

	@Override
	public CommentBookByParticipant getCommentBookByParticipantById(long id) {
		return commentBkByPpatRepository.findOne(id);
	}
	
	// implémentation CONTRIBUTORS
	@Override
	public List<Contributor> getAllContributors() {
		return Lists.newArrayList(contributorRepository.findAll());
	}

	@Override
	public Contributor addContributor(Contributor contributor) {
		return contributorRepository.save(contributor);
	}

	@Override
	public void deleteContributor(long id) {
		contributorRepository.delete(id);
		
	}

	@Override
	public Contributor getContributorById(long id) {
		return contributorRepository.findOne(id);
	}
	
	//DoMap
	@Override
	public List<DoMap> getAllDoMaps() {
		return Lists.newArrayList(doMapRepository.findAll());
	}

	@Override
	public DoMap addDoMap(DoMap doMap) {
		return doMapRepository.save(doMap);
	}

	@Override
	public void deleteDoMap(long id) {
		doMapRepository.delete(id);
		
	}

	@Override
	public DoMap getDoMapById(long id) {
		return doMapRepository.findOne(id);
	}
	
	//InterestedInContributor
	@Override
	public List<InterestedInContributor> getAllInterestedInContributor() {
		return Lists.newArrayList(interestedInContributorRepository.findAll());
	}

	@Override
	public InterestedInContributor addInterestedInContributor(
			InterestedInContributor itdInContributor) {
		return interestedInContributorRepository.save(itdInContributor);
	}

	@Override
	public void deleteInterestedInContributor(long id) {
		interestedInContributorRepository.delete(id);
		
	}

	@Override
	public InterestedInContributor getInterestedInContributorById(long id) {
		return interestedInContributorRepository.findOne(id);
	}
	
	// implémentation InterestedInParticipant
	@Override
	public List<InterestedInParticipant> getAllInterestedInParticipant() {
		return Lists.newArrayList(interestedInParticipantRepository.findAll());
	}

	@Override
	public InterestedInParticipant addInterestedInParticipant(
			InterestedInParticipant itdInParticipant) {
		return interestedInParticipantRepository.save(itdInParticipant);
	}

	@Override
	public void deleteInterestedInParticipant(long id) {
		interestedInParticipantRepository.delete(id);
		
	}

	@Override
	public InterestedInParticipant getInterestedInParticipantById(long id) {
		return interestedInParticipantRepository.findOne(id);
	}
	
	// implémentation InterestedInPublisher
	@Override
	public List<InterestedInPublisher> getAllInterestedInPublishers() {
		return Lists.newArrayList(interestedInPublisherRepository.findAll());
	}

	@Override
	public InterestedInPublisher addInterestedInPublisher(
			InterestedInPublisher itdInPublisher) {
		return interestedInPublisherRepository.save(itdInPublisher);
	}

	@Override
	public void deleteInterestedInPublisher(long id) {
		interestedInPublisherRepository.delete(id);
		
	}

	@Override
	public InterestedInPublisher getInterestedInPublisherById(long id) {
		return interestedInPublisherRepository.findOne(id);
	}
	
	// implémentation InterestedInTopic
	@Override
	public List<InterestedInTopic> getAllInterestedInTopics() {
		return Lists.newArrayList(interestedInTopicRepository.findAll());
	}

	@Override
	public InterestedInTopic addInterestedInTopic(InterestedInTopic itdInTopic) {
		return interestedInTopicRepository.save(itdInTopic);
	}

	@Override
	public void deleteInterestedInTopic(long id) {
		interestedInTopicRepository.delete(id);
	}

	@Override
	public InterestedInTopic getInterestedInTopicById(long id) {
		return interestedInTopicRepository.findOne(id);
	}
	
	// implémentation PARTICIPANTS
	@Override
	public List<MindMap> getAllMindMaps() {
		return Lists.newArrayList(mindMapRepository.findAll());
	}

	@Override
	public MindMap addMindMap(MindMap mindMap) {
		return mindMapRepository.save(mindMap);
	}

	@Override
	public void deleteMindMap(long id) {
		mindMapRepository.delete(id);
		
	}

	@Override
	public MindMap getMindMapById(long id) {
		return mindMapRepository.findOne(id);
	}	

	// implémentation PARTICIPANTS
	@Override
	public List<Participant> getAllParticipants() {
		return Lists.newArrayList(participantRepository.findAll());
	}

	@Override
	public Participant addParticipant(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public void deleteParticipant(long id) {
		participantRepository.delete(id);
		
	}

	@Override
	public Participant getParticipantById(long id) {
		return participantRepository.findOne(id);
	}
	
	// implémentation PUBLISHERS
	@Override
	public List<Publisher> getAllPublishers() {
		return Lists.newArrayList(publisherRepository.findAll());
	}

	@Override
	public Publisher addPublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}

	@Override
	public void deletePublisher(long id) {
		publisherRepository.delete(id);
		
	}

	@Override
	public Publisher getPublisherById(long id) {
		return publisherRepository.findOne(id);
	}
	
	// implémentation READED
	@Override
	public List<Readed> getAllReadeds() {
		return Lists.newArrayList(readedRepository.findAll());
	}

	@Override
	public Readed addReaded(Readed readed) {
		return readedRepository.save(readed);
	}

	@Override
	public void deleteReaded(long id) {
		readedRepository.delete(id);
	}

	@Override
	public Readed getReadedById(long id) {
		return readedRepository.findOne(id);
	}

	@Override
	public List<Read> getAllReads() {
		return Lists.newArrayList(readRepository.findAll());
	}

	@Override
	public Read addRead(Read read) {
		return readRepository.save(read);
	}

	@Override
	public void deleteRead(long id) {
		readRepository.delete(id);
		
	}

	@Override
	public Read getReadById(long id) {
		return readRepository.findOne(id);
	}
	
	// implémentation Summarizes
	@Override
	public List<Summarize> getAllSummarizes() {
		return Lists.newArrayList(summarizeRepository.findAll());
	}

	@Override
	public Summarize addSummarize(Summarize summarize) {
		return summarizeRepository.save(summarize);
	}

	@Override
	public void deleteSummarize(long id) {
		summarizeRepository.delete(id);
	}

	@Override
	public Summarize getSummarizeById(long id) {
		return summarizeRepository.findOne(id);
	}
	
	// implémentation Thematizes
	@Override
	public List<Thematize> getAllThematizes() {
		return Lists.newArrayList(thematizeRepository.findAll());
	}

	@Override
	public Thematize addThematize(Thematize thematize) {
		return thematizeRepository.save(thematize);
	}

	@Override
	public void deleteThematize(long id) {
		thematizeRepository.delete(id);
		
	}

	@Override
	public Thematize getThematizeById(long id) {
		return thematizeRepository.findOne(id);
	}
	
	// implémentation TOPICS
	@Override
	public List<Topic> getAllTopics() {
		return Lists.newArrayList(topicRepository.findAll());
	}

	@Override
	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public void deleteTopic(long id) {
		topicRepository.delete(id);
		
	}

	@Override
	public Topic getTopicById(long id) {
		return topicRepository.findOne(id);
	}
	
	// implémentation Translates
	@Override
	public List<Translate> getAllTranslates() {
		return Lists.newArrayList(translateRepository.findAll());
	}

	@Override
	public Translate addTranslate(Translate translate) {
		return translateRepository.save(translate);
	}

	@Override
	public void deleteTranslate(long id) {
		translateRepository.delete(id);
		
	}

	@Override
	public Translate getTranslateById(long id) {
		return translateRepository.findOne(id);
	}

	// implémentation WishReads
	@Override
	public List<WishRead> getAllWishReads() {
		return Lists.newArrayList(wishReadRepository.findAll());
	}

	@Override
	public WishRead addWishRead(WishRead wishRead) {
		return wishReadRepository.save(wishRead);
	}

	@Override
	public void deleteWishRead(long id) {
		wishReadRepository.delete(id);
		
	}

	@Override
	public WishRead getWishReadById(long id) {
		return wishReadRepository.findOne(id);
	}

	// implémentation Writes
	@Override
	public List<Write> getAllWrites() {
		return Lists.newArrayList(writeRepository.findAll());
	}

	@Override
	public Write addWishRead(Write write) {
		return writeRepository.save(write);
	}

	@Override
	public void deleteWrite(long id) {
		writeRepository.delete(id);
	}

	@Override
	public Write getWriteById(long id) {
		return writeRepository.findOne(id);
	}
	
}