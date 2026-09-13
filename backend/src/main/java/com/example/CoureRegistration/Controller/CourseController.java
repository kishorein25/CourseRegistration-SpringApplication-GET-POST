package com.example.CoureRegistration.Controller;
import com.example.CoureRegistration.Model.Course;
import com.example.CoureRegistration.Model.CourseRegistry;
import com.example.CoureRegistration.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    CourseService courseService;



    @GetMapping("courses")
    public List<Course> getallCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> getStudentbyRegistry(){
        return courseService.getallStudentbyreg();
    }


    @PostMapping("courses/register")
    public String courseEnroll(@RequestParam("name") String name,
                               @RequestParam("emailid") String emailid,
                               @RequestParam("coursename") String coursename){
        courseService.courseenroll(name,emailid,coursename);
        return "Congrats !! "+name+" Enrolled Successfully for this course => "+coursename;
    }


}
