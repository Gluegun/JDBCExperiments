package Entities;

import Entities.CompositeKeys.StudentIdAndCourseIdKey;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
@Data
@IdClass(StudentIdAndCourseIdKey.class)
public class LinkedPurchaseList {


    @Id
    @Column(name = "student_id")
    private int studentId;

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    private Integer price;


    public LinkedPurchaseList() {

    }

    public LinkedPurchaseList(int studentId, int courseId, String studentName, String courseName, Date subscriptionDate, int price) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.subscriptionDate = subscriptionDate;
        this.price = price;
    }

    public LinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}