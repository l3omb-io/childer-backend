package dev.childer.childerbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
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

}
