package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        switch (eng) {
            case "hello":
                System.out.println("Привет");
                break;
            case "sister":
                System.out.println("Сестра");
                break;
            default:
                System.out.println("Неизвестное слово");
                break;
        }
        return eng;
    }

    public static void main(String[] args) {
        DummyDic anyWord = new DummyDic();
        anyWord.engToRus("hello");
        anyWord.engToRus("sister");
        anyWord.engToRus("monster");
    }
}
