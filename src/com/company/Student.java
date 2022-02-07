package com.company;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Student {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    static Scanner sc = new Scanner(System.in);

    public Student(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void showInfo() {
        boolean chyndyk = true;
        do {
            System.out.print("Имя: ");
            name = sc.nextLine();
            if (!name.matches("[а-яА-Яa-zA-Z]*")) {
                System.err.println("Кайра жазыныз");
                System.out.println();
                chyndyk = true;
            } else {
                chyndyk = false;
            }
        } while (chyndyk);
        do {
            System.out.print("Фамилия : ");
            surname = sc.nextLine();
            if (!surname.matches("[а-яА-Яa-zA-Z]*")) {
                System.err.println("Кайра жазыныз\n");
                System.out.println();
                chyndyk = true;
            } else {
                chyndyk = false;
            }
        } while (chyndyk);
        System.out.println("введи дату рождения  MM/DD/YYYY по шаблону: ");
        System.out.print("Дата рождения: ");
        String date = sc.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/u");
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        dateOfBirth = LocalDate.parse(date, dateFormatter);
        while (dateOfBirth.isAfter(today)) {
            System.out.println("Re-enter");
            date = sc.nextLine();
            dateOfBirth = LocalDate.parse(date, dateFormatter);
        }
        int i = LocalDate.now().getYear() - dateOfBirth.getYear();
        i = LocalDate.now().getMonthValue() < dateOfBirth.getMonthValue() ? i - 1 : i;
        System.out.printf("""
                *****************************
                Ваши данные:
                Имя учащегося: %s
                Фамиля учащегося: %s
                Дата рождения учащегося: %s
                Возраст учащегося: %s
                ******************************
                """, getName(), getSurname(), getDateOfBirth(), i);

        System.out.println();
        System.out.println();
    }
}