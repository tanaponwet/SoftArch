package com.company;

public class ScreenPrinter implements Book.IScreen {

    @Override
    public void printToScreen(Book book) {
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}
