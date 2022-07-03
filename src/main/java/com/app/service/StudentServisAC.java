package com.app.service;

import com.app.DTO.CreateStudentRequestDto;
import com.app.DTO.StudentAgeResponseDto;
import com.app.DTO.StudentResponseDto;
import com.app.domain.StudentEntity;
import com.app.repository.StudentdRepositoryAC;
import com.app.util.DateUtils;
import com.app.validation.StudentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@Service
class StudentServiceImpl implements UserService {

    private final StudentdRepositoryAC studentdRepositoryAC;



    @Autowired
    public StudentServiceImpl(StudentdRepositoryAC studentdRepositoryAC) {
        this.studentdRepositoryAC = studentdRepositoryAC;
    }

    // давай, я тут ))
    //ok
    // це перше завданняння
// +1. обовязкові поля name, імя повинно бути не менше 3 і не більше 10 символів ce vze napysaly
// +2. dateOfBirth дата не повинна бути з майбутнього, і не більше 88 років
// +2. якщо емейл є в реквесті це повинен бути валідний емейл. емейл не обовязковий
// якшо якась з умов не виконується викинути ексепшин з описом помилки і повернути http status code 400 Bad Request і опис помилки
//Query можна використовувати в репозиторії (треба) ???
//Ок буду пробувати
    @Override
    public StudentResponseDto createStudent(CreateStudentRequestDto request) {
        StudentValidation.validation(request);
        StudentEntity student = new StudentEntity();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(DateUtils.calculateAge(request.getDateOfBirth()));
        student.setDateOfBirth(request.getDateOfBirth());

        studentdRepositoryAC.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(request.getName());
        studentResponseDto.setEmail(request.getEmail());
        //  studentResponseDto.setAge(request.getAge());
        return studentResponseDto;
    }

    //  знайти студентів за віком, наприклад від 18 до 65
    @Override
    public Collection<StudentAgeResponseDto> findStudentsByAgeRange(int startAge, int endAge) {
        Collection<StudentAgeResponseDto> d1 = new LinkedList<>();
        Collection<StudentEntity> qw = studentdRepositoryAC.startAndEndAge(startAge, endAge);
        for (StudentEntity q : qw) {
            StudentAgeResponseDto op = new StudentAgeResponseDto();
            op.setAge(q.getAge());
            op.getName(q.getName());
            op.setEmail(q.getEmail());
            d1.add(op);
        }
        return d1;
    }

    @Override
    // знайти студентів за іменем яке починається на 'name'
    public Collection<StudentEntity> findStudentsByNameStartsWith(String name) {
        return studentdRepositoryAC.studentName(name);
    }

    @Override
    public void deleteAllStudents(Long id) {
             studentdRepositoryAC.delStudent(id);
    }
    @Override
    public void deletePeopleById (Long id){
        studentdRepositoryAC.deleteById(id);

    }


}