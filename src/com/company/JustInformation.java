package com.company;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class JustInformation {



    public class test {
        // Constants
        public static final DecimalFormat phoneFormatD = new DecimalFormat("0000000000");
        public static final MessageFormat phoneFormatM = new MessageFormat("({0}) {1}-{2}");

        // Example Method on a Main Class
        public static void main(String... args) {
            try {
                System.out.println(formatPhoneNumber("8091231234"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber("18091231234"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber("451231234"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber("11231234"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber("1231234"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber("231234"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber(""));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println(formatPhoneNumber(8091231234f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Magic
        public static String formatPhoneNumber(Object phone) throws Exception {

            double p = 0;

            if (phone instanceof String)
                p = Double.valueOf((String) phone);

            if (phone instanceof Integer)
                p = (Integer) phone;

            if (phone instanceof Float)
                p = (Float) phone;

            if (phone instanceof Double)
                p = (Double) phone;

            if (p == 0 || String.valueOf(p) == "" || String.valueOf(p).length() < 7)
                throw new Exception("Paramenter is no valid");

            String fot = phoneFormatD.format(p);

            String extra = fot.length() > 10 ? fot.substring(0, fot.length() - 10) : "";
            fot = fot.length() > 10 ? fot.substring(fot.length() - 10, fot.length()) : fot;

            String[] arr = {
                    (fot.charAt(0) != '0') ? fot.substring(0, 3) : (fot.charAt(1) != '0') ? fot.substring(1, 3) : fot.substring(2, 3),
                    fot.substring(3, 6),
                    fot.substring(6)
            };
            String r = phoneFormatM.format(arr);
            r = (r.contains("(0)")) ? r.replace("(0) ", "") : r;
            r = (extra != "") ? ("+" + extra + " " + r) : r;
            return (r);
        }
    }}
    /*Result will be

            (809) 123-1234
            +1 (809) 123-1234
            (45) 123-1234
            (1) 123-1234
            123-1234
            023-1234
    java.lang.NumberFormatException: empty String
    at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1842)
    at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
    at java.lang.Double.parseDouble(Double.java:538)
    at java.lang.Double.valueOf(Double.java:502)
    at test.formatPhoneNumber(test.java:66)
    at test.main(test.java:45)
    java.lang.Exception: Paramenter is no valid
    at test.formatPhoneNumber(test.java:78)
    at test.main(test.java:50)
(809) 123-1232
}*/
