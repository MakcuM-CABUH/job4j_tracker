package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {

        Student student = new Student();

        student.setFullName("MakcuM CABUH");
        student.setGroup("Intern");
        student.setDateOfReceipt("24 sept 2023");

        System.out.println(" student: " + student.getFullName()
                + System.lineSeparator() + " training group: " + student.getGroup()
                + System.lineSeparator() + " date of receipt: " + student.getDateOfReceipt());
    }
}
