package com.realdolmen.utils;

import javax.faces.bean.ApplicationScoped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@ApplicationScoped
public class DateUtils {
    public static Date createDate(String pattern) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(pattern);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date", e);
        }
    }

    public static long yearsFrom(Date date) {
        LocalDate d = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(d, LocalDate.now());
    }

}