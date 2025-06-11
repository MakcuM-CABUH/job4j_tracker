package ru.job4j.oop;

public class Jukebox {

//   ЭТОТ вариант отправил на проверку

//    public void music(int position) {
//        if (position == 1) {
//            System.out.println("Пусть бегут неуклюже пешеходы по лужам...");
//        } else if (position == 2) {
//            System.out.println("Глазки закрывай, баю-бай...");
//        } else {
//            System.out.println("Песня не найдена");
//        }
//    }

    //  ЭТОТ вариант - запасной. Если попросят сделать через СВИТЧ-КЕЙС
    public void music(int position) {
        String mark;
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже пешеходы по лужам...");
                break;
            case 2:
                System.out.println("Глазки закрывай, баю-бай...");
                break;
            default:
                System.out.println("Песня не найдена");
                break;
        }
    }

    public static void main(String[] args) {
        Jukebox box = new Jukebox();
        box.music(1);
        box.music(2);
        box.music(12);
    }
}