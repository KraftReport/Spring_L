package com.home.boot.controller;

import com.home.boot.model.Student;
import com.home.boot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping
    public List<Student> returnStudentList(){
        return  studentService.returnStudentList();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
    }

    @DeleteMapping("{studentId}")
    public void delete(@PathVariable("studentId") Long id){
        studentService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id")Long id,@RequestParam(required = false)String name,@RequestParam(required = false)String email){
        studentService.update(id,name,email);
    }
}
