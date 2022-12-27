package com.example.coursesapp.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(Integer topicId) {
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }

    public Optional<Course> getCourse(int id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(int id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(int id) {
        Optional<Course> course = this.getCourse(id);
        course.ifPresent(value -> courseRepository.delete(value));

    }
}
