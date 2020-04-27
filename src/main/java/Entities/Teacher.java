package Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Integer salary;

    private Integer age;
}
