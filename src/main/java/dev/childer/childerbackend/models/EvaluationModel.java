package dev.childer.childerbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Evaluation")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = EvaluationModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class EvaluationModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Topic",nullable = false)
    private String topic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "IdentityEvaluation",
            joinColumns = @JoinColumn(name = "evaluation_id"),
            inverseJoinColumns = @JoinColumn(name = "indicator_id")
    )
    private IndicatorModel indicator;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "IdentityChildren",
            joinColumns = @JoinColumn(name = "evaluation_id"),
            inverseJoinColumns = @JoinColumn(name = "children_id")
    )
    private ChildrenModel children;
}
