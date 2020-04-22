package Entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class StudentIdAndCourseIdKey implements Serializable {

    private int courseId;

    private int studentId;

    public StudentIdAndCourseIdKey() {
    }
}
