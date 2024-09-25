package br.com.carlos.APICurso.repository;

import br.com.carlos.APICurso.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
    Optional<CourseEntity> findByName(String name);

    List<CourseEntity> findAllByCategory(String category);
}
