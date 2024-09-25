package br.com.carlos.APICurso.services;

import br.com.carlos.APICurso.dto.CourseDTO;
import br.com.carlos.APICurso.dto.UpdateCourseDTO;
import br.com.carlos.APICurso.entity.CourseEntity;
import br.com.carlos.APICurso.enunms.IsActive;
import br.com.carlos.APICurso.exceptions.CourseAlreadyExistsException;
import br.com.carlos.APICurso.exceptions.CourseDoesNotExistsException;
import br.com.carlos.APICurso.exceptions.CoursesNotFoundException;
import br.com.carlos.APICurso.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity createCourse(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName()).ifPresent(course -> {
            throw new CourseAlreadyExistsException();
        });

        courseEntity.setIsActive(IsActive.ACTIVE);

        return courseRepository.save(courseEntity);
    }

    public List<CourseEntity> getAllCourses() {

        var courses = this.courseRepository.findAll();

        if (courses.isEmpty()) {
            throw new CoursesNotFoundException();
        }

        return courses;
    }

    public CourseDTO getCourseByName(String courseName) {
        return this.courseRepository.findByName(courseName)
                .map(course -> {
                    return new CourseDTO(course.getName(), course.getCategory(), course.getIsActive());
                }).orElseThrow(() -> new CourseDoesNotExistsException());

    }

    public List<CourseDTO> getCoursesByCategory(String courseCategory) {
        var courses = this.courseRepository.findAllByCategory(courseCategory);

        if (courses.isEmpty()) {
            throw new CourseDoesNotExistsException();
        }
        return courses.stream()
                .map(course -> new CourseDTO(course.getName(), course.getCategory(), course.getIsActive()))
                .collect(Collectors.toList());
    }

    public void updateCourse(String courseId, UpdateCourseDTO updateCourseDTO) {
        var id = UUID.fromString(courseId).toString();

        courseRepository.findById(id).ifPresent(course -> {
            course.setName(updateCourseDTO.name());
            course.setCategory(updateCourseDTO.category());
            courseRepository.save(course);
        });

//        if (courseEntity.isPresent()) {
//            var course = courseEntity.get();
//
//            if (updateCourseDTO.name() != null) {
//                course.setName(updateCourseDTO.name());
//            }
//
//            if (updateCourseDTO.category() != null) {
//                course.setCategory(updateCourseDTO.category());
//            }

    }

    public void deleteCourse(String courseId) {
        //TEMOS QUE CONVERTER O ID DE UUID PARA STRING
        var id = UUID.fromString(courseId).toString();

        var courseExists = courseRepository.existsById(id);

        if (!courseExists) {
            throw new CourseDoesNotExistsException();
        }
        courseRepository.deleteById(id);
    }
}




