package ru.job4j.enumeration;

public enum Status {
    ACCEPTED(1, "Принят") {
        private String message = "Автомобиль принят на СТО";

        @Override
        public String getMessage() {
            return message;
        }

    },
    IN_WORK(2, "В работе") {
        private String message = "Автомобиль в работе";

        @Override
        public String getMessage() {
            return message;
        }
    },
    WAITING(3, "Ожидает запчасти") {
        private String message = "Автомобиль ожидает запчасти";

        @Override
        public String getMessage() {
            return message;
        }
    },
    FINISHED(4, "Работы завершены") {
        private String message = "Все работы завершены";

        @Override
        public String getMessage() {
            return message;
        }
    };

    private final String text;

    private final int code;

    Status(int code, String text) {
        this.text = text;
        this.code = code;
    }

    public String info() {
        return text;
    }

    public int code() {
        return code;
    }

    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Код Toyota: " + toyota.code());
        System.out.println("Статус Toyota: " + toyota.info());
        System.out.println("Код Volvo: " + volvo.code());
        System.out.println("Статус Volvo: " + volvo.info());
    }

    public abstract String getMessage();
}
