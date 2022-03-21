package io.learn.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {		
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
			.forEach(courseList::add);
		return courseList;
	}
	
	public Course getCourse(String id) {		
		Optional<Course> courseOptional = courseRepository.findById(id);
		if (courseOptional.isPresent()) {
		    Course course = courseOptional.get();
		    return course;
		} else {
		    return null;
		}
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {		
		courseRepository.save(course);	
	}

	public void deleteCourse(String id) {	
		courseRepository.deleteById(id);
	}
}
