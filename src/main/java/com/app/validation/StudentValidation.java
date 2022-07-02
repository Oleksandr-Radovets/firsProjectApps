package com.app.validation;

import com.app.DTO.CreateStudentRequestDto;

import java.time.LocalDate;
import java.util.regex.Matcher;

import static com.app.controller.StudentControllrerAC.EMAIL_PATTERN;

public  class StudentValidation {
    // створення нового студента
    // 1. обовязкові поля name, імя повинно бути не менше 3 і не більше 10 символів
    // 2. dateOfBirth дата не повинна бути з майбутнього, і не більше 88 років
    // 3. якщо емейл є в реквесті це повинен бути валідний емейл. емейл не обовязковий
    public static void validation(CreateStudentRequestDto request) {
        String name = request.getName();
        if (name == null || (name.length() < 3 || name.length() > 10)) {
            throw new RuntimeException("Name is required, length between [3..10]");
        }
        if(request.getDateOfBirth()==null){
            throw new RuntimeException("Не вказано дату народження");
        }
        LocalDate now = LocalDate.now(); // поточна дата
        int age = now.getYear() - request.getDateOfBirth().getYear(); //
        if (age < 18 || age > 88) {
            throw new RuntimeException("не проходиш по віку");
        }
        if (request.getEmail() != null) {
            Matcher sa = EMAIL_PATTERN.matcher(request.getEmail());

            if (!sa.matches()) {
                throw new RuntimeException("не валідний емейл");
            }
        }

    }

}
