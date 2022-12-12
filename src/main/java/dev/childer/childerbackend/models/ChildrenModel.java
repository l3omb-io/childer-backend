package dev.childer.childerbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Children")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = ChildrenModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ChildrenModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Fname", nullable = false)
    private String fname;

    @Column(name = "Lname", nullable = false)
    private String lname;

    @Column(name = "Nickname", nullable = false)
    private String nickName;

    @Column(name = "IDcard", length = 13, nullable = false)
    private String idCard;

    @Column(name = "BOD", nullable = false)
    private Date bod;

    @Column(name = "Parentname", nullable = false)
    private String parentName;

    @Column(name = "Grade", nullable = false)
    private String grade;

    @Column(name = "Tel", nullable = false, length = 10)
    private String tel;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "IdentityBook",
            joinColumns = @JoinColumn(name = "children_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private BookModel book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "IdentityAddress",
            joinColumns = @JoinColumn(name = "children_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private AddressModel address;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "children")
    private Set<EvaluationModel> evaluation;

    private String imagePath;


}
