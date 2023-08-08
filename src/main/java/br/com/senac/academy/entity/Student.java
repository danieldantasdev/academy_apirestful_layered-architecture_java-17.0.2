package br.com.senac.academy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer _id;
    @Column(name = "name")
    private String _name;
    @Column(name = "surname")
    private String _surName;
    @Column(name = "email")
    private String _email;
}
