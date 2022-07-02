package com.app.service;

import com.app.DTO.CreateStudentRequestDto;
import com.app.DTO.StudentAgeResponseDto;
import com.app.DTO.StudentResponseDto;
import com.app.domain.StudentEntity;

import java.util.Collection;
import java.util.Optional;

// поки достатньо
public interface UserService {
    // створення нового студента
    // 1. обовязкові поля name, імя повинно бути не менше 3 і не більше 10 символів
    // 2. dateOfBirth дата не повинна бути з майбутнього, і не більше 88 років
    // 2. якщо емейл є в реквесті це повинен бути валідний емейл. емейл не обовязковий
    // якшо якась з умов не виконується викинути ексепшин з описом помилки і повернути http status code 400 Bad Request і опис помилки
    //Query можна використовувати в репозиторії (треба) ???
    //Ок буду пробувати
    StudentResponseDto createStudent(CreateStudentRequestDto request);

    // знайти студентів за віком, наприклад від 18 до 65
    Collection<StudentAgeResponseDto> findStudentsByAgeRange(int startAge, int endAge);

    // знайти студентів за іменем яке починається на 'name'
    Collection<StudentEntity> findStudentsByNameStartsWith(String name);

    // видалити студентів які мають вказані айдішки, для прикладу (1,3,7)
    // і повернути кількість видалених студентів
    Collection<StudentEntity> deleteAllStudents(Long id);
}
