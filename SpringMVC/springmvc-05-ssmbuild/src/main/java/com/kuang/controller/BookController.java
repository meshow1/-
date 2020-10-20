package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.kuang.service.BookServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部书籍并返回书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPapper(){
        return "addBook";
    }

    //添加书籍请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toupdateBook(int id, Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String toUpdatePaper(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        List<Books> books = bookService.queryBookByName(queryBookName);
        model.addAttribute("list", books);
        return "allBook";
    }

}
