package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BookMapper {
    int addBook(Books books);

    int deleteBookById(@Param("bookId") int id);

    int updateBook(Books books);

    Books queryBookById(@Param("bookId") int id);

    List<Books> queryAllBook();

    List<Books> queryBookByName(@Param("bookName") String bookName);

}
