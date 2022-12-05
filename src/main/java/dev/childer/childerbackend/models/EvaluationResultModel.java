package dev.childer.childerbackend.models;

import dev.childer.childerbackend.models.enumModels.Term;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "EvaluationResult")
@Data
@NoArgsConstructor
public class EvaluationResultModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Term term;
}
