package br.com.fiap.keep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACHIEVEMENT")
    @SequenceGenerator(name = "SQ_ACHIEVEMENT", sequenceName = "SQ_ACHIEVEMENT", allocationSize = 1)
    @Column(name = "ID_ACHIEVEMENT")
    private Long id;

    @NotBlank(message = "{achievement.title.notblank}")
    private String title;

    @Size(min = 10, max = 255, message = "{achievement.description.size}")
    private String description;

    @Positive(message = "{achievement.score.positive}" )
    private int score;

    @Min(0) @Max(100)
    private int status;

}
