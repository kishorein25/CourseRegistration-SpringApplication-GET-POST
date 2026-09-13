package com.example.CoureRegistration.Repository;
import com.example.CoureRegistration.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CourseRepo extends JpaRepository<Course,String> {

}
