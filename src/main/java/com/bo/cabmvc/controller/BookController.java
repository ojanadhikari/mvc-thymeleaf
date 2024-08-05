package com.bo.cabmvc.controller;

import com.bo.cabmvc.dto.BookPojo;
import com.bo.cabmvc.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private static final String RETURN_URL = "redirect:/";

    @Value("${server.url}")
    private String serverUrl;

    @GetMapping("/")
    public String loadBookPage(Model model){
        log.info(serverUrl);
        model.addAttribute("books",bookService.getAll());
        return "book";
    }

    @GetMapping("/add-book")
    public String showCreationForm(Model model) {
        model.addAttribute("book",new BookPojo());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Model model ,
                           @ModelAttribute("book")BookPojo book,
                           BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add-book";
        }
        bookService.save(book);
        return RETURN_URL;
    }


    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("book",bookService.getById(id));
        return "update-book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Integer id,@ModelAttribute("book") BookPojo book,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            book.setId(id);
            return "update-book";
        }

        bookService.update(id,book);
        return RETURN_URL;
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable Integer id,Model model){
        bookService.delete(id);
        return RETURN_URL;
    }
//
    @GetMapping("/403")
    public String getAccessDeniedPage(){
        return "403";
    }


}
