package Week1.AlgorithmsDataStructure;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManager {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0)
                return books[mid];
            if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("B001", "Wings of Fire", "A.P.J. Abdul Kalam"),
                new Book("B002", "The Alchemist", "Paulo Coelho"),
                new Book("B003", "The Palace of Illusions", "Chitra Banerjee Divakaruni"),
                new Book("B004", "Sita: Warrior of Mithila", "Amish Tripathi")
        };

        System.out.println(" Linear Search:");
        Book result1 = linearSearch(books, "The Alchemist");
        System.out.println(result1 != null ? "Found: " + result1 : " Not Found");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        System.out.println("\n Binary Search:");
        Book result2 = binarySearch(books, "Sita: Warrior of Mithila");
        System.out.println(result2 != null ? "Found: " + result2 : " Not Found");
    }
}
