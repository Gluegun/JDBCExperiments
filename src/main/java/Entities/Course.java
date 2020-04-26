package Entities;

import lombok.Data;
import Enum.CourseType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    public Course() {

    }

    public Course(String name, int duration, String description,
                  Teacher teacher, int studentsCount,
                  int price, float pricePerHour,
                  List<Student> students, CourseType type) {
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.teacher = teacher;
        this.studentsCount = studentsCount;
        this.price = price;
        this.pricePerHour = pricePerHour;
        this.students = students;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", studentsCount=" + studentsCount +
                ", price=" + price +
                ", pricePerHour=" + pricePerHour +
                ", students=" + students +
                ", type=" + type +
                '}';
    }
}
