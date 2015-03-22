package kitabook.metier;

import java.util.List;

import kitabook.entities.Topic;

public interface IMetier {

	// liste des themes
	public List<Topic> getAllTopics();
	
	public Topic addTopic(Topic topic);
	
	public void deleteTopic(long idTopic);
	
	public Topic getTopicById(long id);
	
}