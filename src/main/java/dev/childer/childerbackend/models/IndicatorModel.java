package dev.childer.childerbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Indicator")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = IndicatorModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class IndicatorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Title",nullable = false)
    private String title;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "IdentityEvaluationResult",
            joinColumns = @JoinColumn(name = "indicator_id"),
            inverseJoinColumns = @JoinColumn(name = "evaluationResult_id")
    )
    private EvaluationResultModel evaluationResult;



    @OneToOne(mappedBy = "indicator",cascade = CascadeType.ALL)
    private EvaluationModel evaluation;
}
