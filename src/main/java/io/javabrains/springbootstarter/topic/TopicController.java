package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired	
	private TopicService topicService;
		
		@RequestMapping("/topics")
		public List<Topic> getAllTopics()	{
			return topicService.getAllTopics();
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/topics") 
		public void addTopic(@RequestBody Topic topic)	{
			topicService.addTopic(topic);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{value}") 
		public void updateTopic(@RequestBody Topic topic, @PathVariable("value") String id)	{
			topicService.updateTopic(id, topic);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/topics/{value}") 
		public void deleteTopic(@PathVariable("value") String id)	{
			topicService.deleteTopic(id);
		}
		
		@RequestMapping("/topics/{value}")
		public Optional<Topic> getTopic(@PathVariable("value") String id) {
			return topicService.getTopic(id);
		}
		
		
}
