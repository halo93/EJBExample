package com.dao;

import com.model.Book;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class IBookManagerImplBean implements IBookManager{

    @PersistenceContext
    private EntityManager em;

    public IBookManagerImplBean() {
    }

    @Override public List<Book> getAll() {
        return em.createQuery(
                String.format("select a from %s a", Book.class.getName()))
                .getResultList();
    }

    @Override public Book getOne(String isbn) {
        return em.getReference(Book.class, isbn);
    }

    @Override public void add(Book b) {
        em.persist(b);
    }

    @Override public void update(Book b) {
        em.merge(b);
    }

    @Override public void delete(String isbn) {
        Book b = getOne(isbn);
        if (b != null) em.remove(b);
    }
}
