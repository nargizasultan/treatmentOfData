package com.company;


import java.time.LocalDate;
import java.util.Scanner;

public class Course {
    private String name;
    private String surname;
    private long phone;
    private LocalDate theDateTheCourseBegan;
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner1 = new Scanner(System.in);


    public Course(String name, String surname, long phone) {

        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Course() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {


        this.name = name;

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phoneNum) {
        this.phone = phone;
    }

    public LocalDate getTheDateTheCourseBegan() {
        return theDateTheCourseBegan;
    }

    public void setTheDateTheCourseBegan(LocalDate theDateTheCourseBegan) {
        this.theDateTheCourseBegan = theDateTheCourseBegan;
    }

    public void showInfo() {
        boolean chyndyk = true;
        do {
            System.out.print("Имя учителя: ");
            name = scanner.nextLine();
            if (!name.matches("[а-яА-Яa-zA-Z]*")) {
                System.err.println("Кайра жазыныз");
                System.out.println();
                chyndyk = true;
            } else {
                chyndyk = false;
            }
        } while (chyndyk);
        do {
            System.out.print("Фамилия учителя: ");
            surname = scanner.nextLine();
            if (!surname.matches("[а-яА-Яa-zA-Z]*")) {
                System.err.println("Кайра жазыныз\n");
                System.out.println();
                chyndyk = true;
            } else {
                chyndyk = false;
            }
        } while (chyndyk);

        System.out.print("Введи номер телефона без  + , example:996777234234: ");
        long phone = scanner.nextLong();


        long kodStrany = phone / 1000000000;
        long kodStranyAndOperatora = phone / 1000000;
        int kodoperatora = 0;
        if ((int) kodStrany == 996) {
            if (kodStranyAndOperatora < 997000 && kodStranyAndOperatora > 996000) {
                kodoperatora = (int) kodStranyAndOperatora - 996000;
                if (kodoperatora == 500 || kodoperatora == 706 || kodoperatora == 777) {
                    System.out.printf("""
                            *********************************
                            Данные учителя:
                            Имя учителя: %s
                            Фамилия учителя : %s
                            """, getName(), getSurname());
                    System.out.println("Номер учителя: " + String.valueOf(phone).replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d+)", "$1-($2)-$3-$4"));
                    System.out.println("*********************************");
                } else {
                    System.out.println("Нет такого оператора:" + kodStrany);
                }
            }
        } else {
            System.err.println("Код нашей страны +996 а не +" + kodStrany);

        }


    }
}