package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {

        Student student = new Student();

        student.setFullName("MakcuM CABUH");
        student.setGroup("Intern");
        student.setDateOfReceipt("24 sept 2023");

        System.out.println(" student: " + student.getFullName()
                + " \n training group: " + student.getGroup()
                + " \n date of receipt: " + student.getDateOfReceipt());
    }
}
