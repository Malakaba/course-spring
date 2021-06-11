package com.example.course.service;

import com.example.course.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    Course updateCourse(Course course);

    List<Course> getAllCourse();

    Course getCourseById(long courseId);

    void deleteCourse(long courseId);
}
