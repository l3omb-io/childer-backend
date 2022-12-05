package dev.childer.childerbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Children")
@Data
@NoArgsConstructor
public class ChildrenModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ImagePath",nullable = false)
    private String imagePath;

    @Column(name = "Fname",nullable = false)
    private String fname;

    @Column(name = "Lname",nullable = false)
    private String lname;

    @Column(name = "Nickname",nullable = false)
    private String nickName;

    @Column(name = "IDcard",length = 13,nullable = false)
    private String idCard;

    @Column(name = "BOD",nullable = false)
    private Date bod;

    @Column(name = "Parentname",nullable = false)
    private String parentName;

    @Column(name = "Grade",nullable = false)
    private String grade;

    @Column(name = "Phone",nullable = false)
    private String phone;


}
