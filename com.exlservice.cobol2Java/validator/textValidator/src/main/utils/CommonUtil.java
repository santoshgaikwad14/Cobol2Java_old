package main.utils;

public class CommonUtil {
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        // Check if a string is numeric
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isVehicleYearValid(String year) {
        // Check if a vehicle year is valid
//        System.out.println(year);
        int yearInt = Integer.parseInt(year);
        if (yearInt >=1900 && yearInt<=2019){
            return true;
        }
        else{
            return false;
        }
//        return yearInt >= 1900 && yearInt <= 2019;
    }

    public static boolean isWeeksLeadTimeValid(String weeks) {
        // Check if weeks lead time is valid
        int weeksInt = Integer.parseInt(weeks);
        return weeksInt >= 1 && weeksInt <= 4;
    }

}
