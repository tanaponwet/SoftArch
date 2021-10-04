package com.company;

import java.util.List;

public class BookPublisher {
    public static void main(String[] args) {
        Book book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        FilePrinter file = new FilePrinter();
        file.printToFile(book);
    }
}

