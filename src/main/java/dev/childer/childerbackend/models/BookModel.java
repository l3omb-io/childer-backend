package dev.childer.childerbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class BookModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Schoolname")
    private String schoolName;

    @Column(name = "SchoolLocation")
    private String schoolLocation;

    @Column(name = "Affiliation")
    private String affiliation;

    @Column(name = "SchoolYear")
    private int schoolYear;

    @OneToOne(mappedBy = "book")
    private ChildrenModel children;
}
