package com.example.coursesapp.topics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll().forEach(topicList::add);
        return topicList;
    }

    public Optional<Topic> getTopic(int id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(int id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(int id) {
        Optional<Topic> topic = this.getTopic(id);
        topic.ifPresent(value -> topicRepository.delete(value));

    }
}
