package com.realdolmen.utils;

import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.TimeZone;
//not needed
@FacesConverter("epoch")
public class EpochToHoursConverter extends DateTimeConverter {
    public EpochToHoursConverter() {
        setType("both");
        setTimeZone(TimeZone.getTimeZone("GMT-3"));
    }
}