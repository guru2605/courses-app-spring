package com.example.coursesapp.courses;


import com.example.coursesapp.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable Integer topicId){
        return courseService.getCourses(topicId);
    }

    @RequestMapping("topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable  Integer topicId, @PathVariable  Integer id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable Integer topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable  int id, @RequestBody Course course, @PathVariable Integer topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable  int id) {
        courseService.deleteCourse(id);
    }
}
