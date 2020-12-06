package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.form.BookForm;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping("/search")
    public String index(BookForm bookForm, String showList, Model model){
        model.addAttribute("title","本屋さん");

        if (bookForm.getId() !=null){
            Book book=bookService.findById(bookForm.getId());
            model.addAttribute("book",book);
        }

        if (showList != null){
            List<Book> bookList=bookService.getBookList();
            model.addAttribute("bookList",bookList);

        }
        return "index";
    }

}
