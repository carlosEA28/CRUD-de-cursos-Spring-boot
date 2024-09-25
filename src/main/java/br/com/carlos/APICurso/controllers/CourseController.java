package br.com.carlos.APICurso.controllers;

import br.com.carlos.APICurso.dto.UpdateCourseDTO;
import br.com.carlos.APICurso.entity.CourseEntity;
import br.com.carlos.APICurso.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        var result = this.userService.createCourse(courseEntity);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        var users = userService.getAllCourses();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{courseName}")
    public ResponseEntity<Object> getCourseByName(@Valid @PathVariable("courseName") String courseName) {
        var course = userService.getCourseByName(courseName);

        return ResponseEntity.ok(course);
    }

    @GetMapping("/category/{courseCategory}")
    public ResponseEntity<Object> getCourseByCategory(@Valid @PathVariable(value = "courseCategory") String courseCategory) {
        var courses = userService.getCoursesByCategory(courseCategory);

        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourse(@PathVariable("courseId") String courseId, @Valid @RequestBody UpdateCourseDTO updateCourseDTO) {
        userService.updateCourse(courseId, updateCourseDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("courseId") String courseId) {
        userService.deleteCourse(courseId);

        return ResponseEntity.noContent().build();
    }
}
