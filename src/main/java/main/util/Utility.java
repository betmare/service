package main.util;

public class Utility {
    public static boolean checkBooleanNullTrue( Boolean booleanToCheck ) {
        return booleanToCheck == null ? Boolean.TRUE : booleanToCheck;
    }
    public static boolean checkBooleanNullFalse( Boolean booleanToCheck ) {
        return booleanToCheck == null ? Boolean.FALSE : booleanToCheck;
    }
}
