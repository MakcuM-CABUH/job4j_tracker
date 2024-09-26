package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book kolobok = new Book("Kolobok", 5);
        Book cleanCode = new Book("Clean code", 500);
        Book hell = new Book("Hell", 110);
        Book tales = new Book("Tales", 300);

        Book[] books = new Book[4];
        books[0] = kolobok;
        books[1] = cleanCode;
        books[2] = hell;
        books[3] = tales;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println(" ");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println(" ");

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}
