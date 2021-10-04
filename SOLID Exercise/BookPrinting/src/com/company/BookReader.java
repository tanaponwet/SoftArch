package com.company;

import java.util.List;

public class BookReader {
    public static void main(String[] args) {
        Book book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        ScreenPrinter screen = new ScreenPrinter();
        screen.printToScreen(book);
    }
}
