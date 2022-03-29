package com.solvd.practiceqa.jsontraining.store;

import java.util.ArrayList;
import java.util.List;

public class Buying {

    private Store store;
    private Double expensive;

    public static Buying createStore() {
        Buying buying = new Buying();
        Store store = new Store();
        List<Book> books = new ArrayList<>();
        Book firstBook = new Book();
        firstBook.setAuthor("M.N. Rand");
        firstBook.setPrice(13.2);
        firstBook.setTitle("First Book");
        books.add(firstBook);

        Book secondBook = new Book();
        secondBook.setCategory("Detective");
        secondBook.setIsbn("345678hjs");
        secondBook.setAuthor("K.T. Weis");
        books.add(secondBook);

        Bicycle bicycle = new Bicycle();
        bicycle.setColor("green");
        bicycle.setPrice(12.5);

        store.setBooks(books);
        store.setBicycle(bicycle);
        buying.setStore(store);
        buying.setExpensive(5.);
        return buying;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getExpensive() {
        return expensive;
    }

    public void setExpensive(Double expensive) {
        this.expensive = expensive;
    }
}
