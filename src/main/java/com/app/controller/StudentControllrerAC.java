package com.app.controller;

import com.app.DTO.CreateStudentRequestDto;
import com.app.DTO.StudentAgeResponseDto;
import com.app.DTO.StudentResponseDto;
import com.app.domain.StudentEntity;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

@RequestMapping(path = "/api/v1/student")
@RestController

public class StudentControllrerAC{

    public static final Pattern EMAIL_PATTERN = Pattern.compile("(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)?");


  //  private final StudentServisAC studentServisAC;
      private UserService userService;


    @Autowired
    public StudentControllrerAC(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public StudentResponseDto addUser(@RequestBody CreateStudentRequestDto request) {
        return userService.createStudent(request);
    }

    @GetMapping(path = "/age")
    public Collection<StudentAgeResponseDto> ageResponseDto(@RequestParam int startAge , @RequestParam int endAge){
        return  userService.findStudentsByAgeRange(startAge,endAge);
    }
    @GetMapping(path = "/name")
    public Collection<StudentEntity> NameResponseDtos( @RequestParam String name){
        return userService.findStudentsByNameStartsWith(name);
    }
    @DeleteMapping  (path="/del")
     public Collection<StudentEntity> studentDelete (@RequestParam Long id) {
         return userService.deleteAllStudents( id);
    }






}
/*
    private final StudentServisAC studentServisAC;
    public StudentControllrerAC(StudentServisAC studentServisAC) {
        this.studentServisAC = studentServisAC; }
    @GetMapping
    public List<StudentResponseDto> getStudent() {
        return studentServisAC.getStudents();   }
    @PostMapping
    public void registerNewStudent(@RequestBody CreateStudentRequestDto requestDto) {
        studentServisAC.addNewStudents(requestDto); }
    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentServisac.deleteStudents(id);}
    @PutMapping("{id}")
    public void updateStudents(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String mail) {
        studentServisac.updateStudent(id, name, mail); }
    */