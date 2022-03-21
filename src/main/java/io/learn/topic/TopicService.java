package io.learn.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {		
		List<Topic> topicsList = new ArrayList<>();
		topicRepository.findAll()
			.forEach(topicsList::add);
		return topicsList;
	}
	
	public Topic getTopic(String id) {	
		Optional<Topic> topicOptional = topicRepository.findById(id);
		if (topicOptional.isPresent()) {
		    Topic topic = topicOptional.get();
		    return topic;
		} else {
		    return null;
		}
	}

	public void addTopic(Topic topic) {		
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {		
		topicRepository.save(topic);	
	}

	public void deleteTopic(String id) {	
		topicRepository.deleteById(id);
	}
}
