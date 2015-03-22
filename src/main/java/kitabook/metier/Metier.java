package kitabook.metier;

import java.util.List;

import kitabook.entities.Topic;
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

}
