package com.solid.book;

public class ScreenPrinter {
	public static void print(Book book) {
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}