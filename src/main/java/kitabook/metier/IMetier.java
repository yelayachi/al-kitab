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

public interface IMetier {

	// liste des ADDRESS
	public List<Address> getAllAdresses();

	public Address addAdress(Address adresse);

	public void deleteAddress(long id);

	public Address getAddressById(long id);
	
	// liste des BOOKS
	public List<Book> getAllBooks();

	public Book addBook(Book book);

	public void deleteBook(long id);

	public Book getBookById(long id);
	
	// liste des CommentBookByParticipant
	public List<CommentBookByParticipant> getAllCommentBookByParticipants();

	public CommentBookByParticipant addCommentBookByParticipant(CommentBookByParticipant commentBookByParticipant);

	public void deleteCommentBookByParticipant(long id);

	public CommentBookByParticipant getCommentBookByParticipantById(long id);
	
	// liste des CONTRIBUTOR
	public List<Contributor> getAllContributors();

	public Contributor addContributor(Contributor contributor);

	public void deleteContributor(long id);

	public Contributor getContributorById(long id);
	
	// liste des CHRONICS
	public List<Chronic> getAllChronics();

	public Chronic addChronic(Chronic chronic);

	public void deleteChronic(long id);

	public Chronic getChronicById(long id);
	
	// liste des DoMap
	public List<DoMap> getAllDoMaps();

	public DoMap addDoMap(DoMap doMap);

	public void deleteDoMap(long id);

	public DoMap getDoMapById(long id);
	
	// liste des InterestedInContributor
	public List<InterestedInContributor> getAllInterestedInContributor();

	public InterestedInContributor addInterestedInContributor(InterestedInContributor id);

	public void deleteInterestedInContributor(long id);

	public InterestedInContributor getInterestedInContributorById(long id);
	
	// liste des InterestedInParticipant
	public List<InterestedInParticipant> getAllInterestedInParticipant();

	public InterestedInParticipant addInterestedInParticipant(InterestedInParticipant itdInParticipant);

	public void deleteInterestedInParticipant(long id);

	public InterestedInParticipant getInterestedInParticipantById(long id);
	
	// liste des InterestedInPublisher
	public List<InterestedInPublisher> getAllInterestedInPublishers();

	public InterestedInPublisher addInterestedInPublisher(InterestedInPublisher itdInPublisher);

	public void deleteInterestedInPublisher(long id);

	public InterestedInPublisher getInterestedInPublisherById(long id);
	
	// liste des InterestedInTopic
	public List<InterestedInTopic> getAllInterestedInTopics();

	public InterestedInTopic addInterestedInTopic(InterestedInTopic itdInTopic);

	public void deleteInterestedInTopic(long id);

	public InterestedInTopic getInterestedInTopicById(long id);
	
	// liste des MindMap
	public List<MindMap> getAllMindMaps();

	public MindMap addMindMap(MindMap mindMap);

	public void deleteMindMap(long id);

	public MindMap getMindMapById(long id);

	// liste des PARTICIPANT
	public List<Participant> getAllParticipants();

	public Participant addParticipant(Participant participant);

	public void deleteParticipant(long id);

	public Participant getParticipantById(long id);
	
	// liste des PUBLISHERS
	public List<Publisher> getAllPublishers();

	public Publisher addPublisher(Publisher publisher);

	public void deletePublisher(long id);

	public Publisher getPublisherById(long id);
	
	// liste des Readed
	public List<Readed> getAllReadeds();

	public Readed addReaded(Readed readed);

	public void deleteReaded(long id);

	public Readed getReadedById(long id);
	
	// liste des Read
	public List<Read> getAllReads();

	public Read addRead(Read read);

	public void deleteRead(long id);

	public Read getReadById(long id);
	
	// liste des Summarize
	public List<Summarize> getAllSummarizes();

	public Summarize addSummarize(Summarize summarize);

	public void deleteSummarize(long id);

	public Summarize getSummarizeById(long id);
	
	// liste des Summarize
	public List<Thematize> getAllThematizes();

	public Thematize addThematize(Thematize thematize);

	public void deleteThematize(long id);

	public Thematize getThematizeById(long id);
	
	// liste des topics
	public List<Topic> getAllTopics();

	public Topic addTopic(Topic topic);

	public void deleteTopic(long id);

	public Topic getTopicById(long id);
	
	// liste des translates
	public List<Translate> getAllTranslates();

	public Translate addTranslate(Translate translate);

	public void deleteTranslate(long id);

	public Translate getTranslateById(long id);
	
	// liste des WishRead
	public List<WishRead> getAllWishReads();

	public WishRead addWishRead(WishRead wishRead);

	public void deleteWishRead(long id);

	public WishRead getWishReadById(long id);
	
	// liste des Write
	public List<Write> getAllWrites();

	public Write addWishRead(Write write);

	public void deleteWrite(long id);

	public Write getWriteById(long id);


}