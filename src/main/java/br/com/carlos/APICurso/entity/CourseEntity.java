package br.com.carlos.APICurso.entity;

import br.com.carlos.APICurso.enunms.IsActive;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_COURSES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "The field 'name' must not be empty")
    private String name;

    @NotBlank(message = "The field 'category' must not be empty")
    private String category;

    @Enumerated(EnumType.STRING)
    private IsActive isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
