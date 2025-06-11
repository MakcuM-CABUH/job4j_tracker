package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус Toyota: " + toyota);
        System.out.println("Статус Volvo: " + volvo);

        Status[] statuses = Status.values();
        for (Status s : statuses) {
            System.out.println("Название статуса: " + s.name() + " || Порядковый номер статуса: " + s.ordinal());
        }
        String accepted = "ACCEPTED";
        Status status = Status.valueOf(accepted);
        System.out.println(status);

        switch (status) {
            case ACCEPTED:
                System.out.println("Автомобиль принят на СТО");
                break;
            case IN_WORK:
                System.out.println("Автомобиль в работе");
                break;
            case WAITING:
                System.out.println("Автомобиль ожидает запчасти");
                break;
            case FINISHED:
                System.out.println("Работы завершены");
                break;
            default:
        }

        String waiting = "WAITING";
        Status status2 = Status.valueOf(waiting);
        System.out.println(status2);

        switch (status2) {
            case ACCEPTED:
                System.out.println("Автомобиль принят на СТО");
                break;
            case IN_WORK:
                System.out.println("Автомобиль в работе");
                break;
            case WAITING:
                System.out.println("Автомобиль ожидает запчасти");
                break;
            case FINISHED:
                System.out.println("Работы завершены");
                break;
            default:
        }
    }
}
