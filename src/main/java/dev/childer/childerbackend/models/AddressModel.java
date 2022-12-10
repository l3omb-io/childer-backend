package dev.childer.childerbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = AddressModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AddressModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "HouseNumber",nullable = false)
    private String houseNumber;

    @Column(name = "Moo",nullable = false)
    private String moo;

    @Column(name = "Tambon",nullable = false)
    private String tambon;

    @Column(name = "District",nullable = false)
    private String district;

    @Column(name = "Province",nullable = false)
    private String province;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    ChildrenModel children;
}
