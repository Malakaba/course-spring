package com.example.course.service;

import com.example.course.exception.ResourceNotFoundException;
import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Optional<Course> optionalCourse = this.courseRepository.findById(course.getId());

        if (optionalCourse.isPresent()) {
            Course courseUpdated = optionalCourse.get();
            courseUpdated.setId(course.getId());
            courseUpdated.setNome(course.getNome());
            courseUpdated.setDescricao(course.getDescricao());
            courseUpdated.setEmenta(course.getEmenta());
            courseUpdated.setDataInicio(course.getDataInicio());
            courseUpdated.setValor(course.getValor());
            courseRepository.save(courseUpdated);
            return courseUpdated;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + course.getId());
        }
    }

    @Override
    public List<Course> getAllCourse() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long courseId) {

        Optional<Course> optionalCourse = this.courseRepository.findById(courseId);

        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + courseId);
        }
    }

    @Override
    public void deleteCourse(long courseId) {

        Optional<Course> optionalCourse = this.courseRepository.findById(courseId);

        if (optionalCourse.isPresent()) {
            this.courseRepository.delete(optionalCourse.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + courseId);
        }
    }
}
