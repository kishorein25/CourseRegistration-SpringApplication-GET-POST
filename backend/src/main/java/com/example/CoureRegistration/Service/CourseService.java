package com.example.CoureRegistration.Service;
import com.example.CoureRegistration.Model.Course;
import com.example.CoureRegistration.Model.CourseRegistry;
import com.example.CoureRegistration.Repository.CourseRegistryRepo;
import com.example.CoureRegistration.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {


    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;


    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> getallStudentbyreg() {
        return courseRegistryRepo.findAll();
    }

    public void courseenroll(String name, String emailid, String coursename) {
        CourseRegistry courseRegistry = new CourseRegistry(name,emailid,coursename);
        courseRegistryRepo.save(courseRegistry);
    }
}
