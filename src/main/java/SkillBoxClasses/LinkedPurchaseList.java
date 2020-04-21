package SkillBoxClasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @Column(name = "student_id")
    private int studentId;

    @Getter
    @Setter
    @Column(name = "course_id")
    private int courseId;

    public LinkedPurchaseList() {

    }


    public LinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}