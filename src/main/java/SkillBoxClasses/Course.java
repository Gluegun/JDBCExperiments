package SkillBoxClasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {

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
    private int duration;

    @Getter
    @Setter
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Teacher teacher;

    @Column(name = "students_count")
    @Getter
    @Setter
    private int studentsCount;

    @Getter
    @Setter
    private int price;

    @Column(name = "price_per_hour")
    @Getter
    @Setter
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "subscriptions",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @Getter
    @Setter
    private List<Student> students;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Getter
    @Setter
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
