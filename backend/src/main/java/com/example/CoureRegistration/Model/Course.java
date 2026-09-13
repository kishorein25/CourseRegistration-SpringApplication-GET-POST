package com.example.CoureRegistration.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private String CourseId;
    private String CourseName;
    private String Trainer;
    private int DurationinWeeks;

}
