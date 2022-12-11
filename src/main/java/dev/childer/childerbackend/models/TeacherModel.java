package dev.childer.childerbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Teacher")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = ChildrenModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TeacherModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "UserName",nullable = false)
    private String userName;

    @Column(name = "Password",nullable = false)
    private String password;
}
