package com.example.library_system;

import com.example.library_system.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // 自定义的查询方法，Spring Data JPA 会根据方法名自动生成对应的SQL查询
    // 根据标题查询单个图书
    Book findByTitle(String title);

    // 根据作者查询图书列表
    List<Book> findByAuthor(String author);

    // 根据标题模糊查询图书列表
    List<Book> findByTitleContaining(String title);

    // 根据出版日期范围查询图书列表
    List<Book> findByPublicationDateBetween(Date startDate, Date endDate);

    // 根据作者和出版日期范围查询图书列表
    List<Book> findByAuthorAndPublicationDateBetween(String author, Date startDate, Date endDate);

    // 根据标题和作者查询单个图书
    Book findByTitleAndAuthor(String title, String author);

    // 根据标题和作者删除图书
    void deleteByTitleAndAuthor(String title, String author);
}
