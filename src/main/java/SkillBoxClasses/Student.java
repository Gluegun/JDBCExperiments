package SkillBoxClasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    @Column(name = "registration_date")
    @Getter
    @Setter
    private Date registrationDate;

    public Student() {
    }

    public Student(String name, int age, Date registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
