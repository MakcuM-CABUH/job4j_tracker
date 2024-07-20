package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        System.out.println();

        Error error2 = new Error(true, 404, "страница не найдена");
        error2.printInfo();
        System.out.println();

        Error error3 = new Error(true, 405, "запрос не может быть выполнен");
        error3.printInfo();
        System.out.println();

        Error error4 = new Error(false, 0, "ошибок не обнаружено");
        error4.printInfo();
        System.out.println();
    }

    public void printInfo() {
        System.out.println("Обнаружена ошибка: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Сообщение об ошибке: " + message);
    }
}
