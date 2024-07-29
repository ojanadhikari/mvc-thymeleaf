package com.bo.cabmvc.repo;


import com.bo.cabmvc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends
    JpaRepository<Book,Integer> {


}
