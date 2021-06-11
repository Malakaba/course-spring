package com.example.course.controller;

import com.example.course.model.Course;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/curso")
    public ResponseEntity<List<Course>> getAllCourse() {
        return ResponseEntity.ok().body(this.courseService.getAllCourse());
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.courseService.getCourseById(id));
    }

    @PostMapping("/curso")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok().body(this.courseService.createCourse(course));
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course course) {
        course.setId(id);
        return ResponseEntity.ok().body(this.courseService.updateCourse(course));
    }

    @DeleteMapping("curso/{id}")
    public HttpStatus deleteCourse(@PathVariable long id) {
        this.courseService.deleteCourse(id);
        return HttpStatus.OK;
    }

}
