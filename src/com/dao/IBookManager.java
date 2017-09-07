package com.dao;

import com.model.Book;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IBookManager {
    List<Book> getAll();
    Book getOne(String isbn);
    void add(Book b);
    void update(Book b);
    void delete(String isbn);
}
