package Entities;

import Entities.CompositeKeys.StudentNameAndCourseNameIdKey;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
@Data
@IdClass(StudentNameAndCourseNameIdKey.class)
public class PurchaseList {

    @Id
    @Column(name = "student_name")
    private String studentName;

    @Id
    @Column(name = "course_name")
    private String courseName;

    private Integer price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseList(String studentName, String courseName, int price, Date subscriptionDate) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

    public PurchaseList() {

    }
}
