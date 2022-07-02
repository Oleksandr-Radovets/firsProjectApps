package com.app.util;

import java.time.LocalDate;
import java.util.Date;

public class DateUtils {

    public static  int calculateAge(LocalDate date){
        return date.getYear()- LocalDate.now().getYear();
    }

}
