package com.realdolmen.utils;

import java.util.List;

public class RegEx {
    public static boolean isNumberOfPersonsValid(int persons) {
        return persons > 0 && persons < 10;
    }

    public static boolean notEmpty(String s){
        return !(s.equals(""));
    }

}
