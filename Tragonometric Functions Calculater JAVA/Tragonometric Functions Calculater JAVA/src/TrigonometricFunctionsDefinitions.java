public class TrigonometricFunctionsDefinitions {
    public static TrigonometricFunctionsDefinitions instance;
    public static TrigonometricFunctionsDefinitions getInstance() {
        if (instance == null) {
            instance = new TrigonometricFunctionsDefinitions();
        }
        return instance;
    }
    public TrigonometricFunctionsDefinitions(){}
    private static double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }
    private static double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }
    public static double sin(double angleInDegrees) {
        return Math.sin(toRadians(angleInDegrees));
    }
    public static double cos(double angleInDegrees) {
        return Math.cos(toRadians(angleInDegrees));
    }
    public static double tan(double angleInDegrees) {
        return Math.tan(toRadians(angleInDegrees));
    }
    public static double cot(double angleInDegrees) {
        double radian = toRadians(angleInDegrees);
        double sinVal = Math.sin(radian);
        if (sinVal == 0) {
            return Math.cos(radian) > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return Math.cos(radian) / sinVal;
    }
    public static double sec(double angleInDegrees) {
        double radian = toRadians(angleInDegrees);
        double cosVal = Math.cos(radian);
        if (cosVal == 0) {
            return cosVal > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return 1 / cosVal;
    }
    public static double csc(double angleInDegrees) {
        double radian = toRadians(angleInDegrees);
        double sinVal = Math.sin(radian);
        if (sinVal == 0) {
            return sinVal > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return 1 / sinVal;
    }
    public static double arcsin(double value) {
        if (value < -1 || value > 1) {
            throw new IllegalArgumentException("Inout must be in range[-1, 1]");
        }
        return toDegrees(Math.asin(value));
    }
    public static double arccos(double value) {
        if(value < -1 || value > 1) {
            throw new IllegalArgumentException("input must be in range [-1, 1]");
        }
        return toDegrees(Math.acos(value));
    }
    public static double arctan(double value) {
        return toDegrees(Math.atan(value));
    }
    public static double arccot(double value) {
        if (value == 0) {
            return 90;
        }
        return toDegrees(Math.atan(1 / value));
    }
    public static double arcsec(double value) {
        if (Math.abs(value) < 1) {
            throw new IllegalArgumentException("input absolute value must be >= 1");
        }
        return toDegrees(Math.acos(1 / value));
    }
    public static double arccsc(double value) {
        if (Math.abs(value) < 1) {
            throw new IllegalArgumentException("input absolute value must be >= 1");
        }
        return toDegrees(Math.asin(1 / value));
    }
    public static double versin(double angleInDegrees) {
        return 1 - cos(angleInDegrees);
    }
    public static double coversin(double angleInDegrees) {
        return 1 - sin(angleInDegrees);
    }
    public static double haversin(double angleInDegrees) {
        return (1 - cos(angleInDegrees)) / 2;
    }
    public static double hacoversin(double angleInDegrees) {
        return (1 - sin(angleInDegrees)) / 2;
    }
    public static double exsec(double angleInDegrees) {
        double secVal = sec(angleInDegrees);
        if (Double.isInfinite(secVal)) {
            return secVal;
        }
        return secVal - 1;
    }
    public static double excsc(double angleInDegrees) {
        double cscVal = csc(angleInDegrees);
        if (Double.isInfinite(cscVal)) {
            return cscVal;
        }
        return cscVal - 1;
    }


}