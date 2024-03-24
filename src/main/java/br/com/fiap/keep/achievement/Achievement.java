package br.com.fiap.keep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column(name = "NM_ACHIEVEMENT", nullable = false)
    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome;

    @Column(name = "DS_ACHIEVEMENT", nullable = false)
    @NotBlank(message = "O campo descrição não pode estar vazio.")
    private String descricao;

    @Column(name = "DT_ACHIEVEMENT", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "ST_ACHIEVEMENT", nullable = false)
    private boolean completed;

    public Achievement(Long id, String nome, String descricao, boolean completed) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = new Date();
        this.completed = completed;
    }
}
