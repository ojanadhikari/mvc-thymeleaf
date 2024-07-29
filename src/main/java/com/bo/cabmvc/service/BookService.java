package com.bo.cabmvc.service;

import com.bo.cabmvc.dto.BookPojo;
import com.bo.cabmvc.entity.Book;
import com.bo.cabmvc.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepo bookRepo;

    public BookPojo save(BookPojo request) {
        return new BookPojo(bookRepo.saveAndFlush(Book.builder()
                        .author(request.getAuthor())
                        .name(request.getName())
                        .price(request.getPrice())
                .build()));
    }

    public BookPojo update( Integer id,BookPojo request) {
        Book book = bookRepo.getById(id);
        book.setAuthor(request.getAuthor());
        book.setName(request.getName());
        book.setPrice(request.getPrice());
        return new BookPojo(bookRepo.save(book));
    }

    public BookPojo getById(Integer id) {
        return new BookPojo(bookRepo.getById(id));
    }

    public List<BookPojo> getAll() {
        List<BookPojo> list = new ArrayList<>();
        for (Book book : bookRepo.findAll()){
            list.add(new BookPojo(book));
        }
        return list;
    }

    public void delete(Integer id) {
        bookRepo.deleteById(id);
        System.out.println("deleted");
    }

}
