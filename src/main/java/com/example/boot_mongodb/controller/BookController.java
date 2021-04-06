package com.example.boot_mongodb.controller;

import com.example.boot_mongodb.dto.Message;
import com.example.boot_mongodb.dto.RestStatus;
import com.example.boot_mongodb.entity.Book;
import com.example.boot_mongodb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.DataFormatException;


@Slf4j
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * main 테스트
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "main";
    }

    /**
     * 단건 조회 API
     *
     * @param id
     * @return
     * @throws DataFormatException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Message> getBookById(@PathVariable("id") String id) throws DataFormatException {
        log.debug("getBook : {}", id);
        if (id == null) throw new DataFormatException("ID is null");

        Message message = new Message();
        message.setMessage("get book success");
        message.setData(bookService.findBookById(id));
        message.setStatus(RestStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * 전체 조회 API
     *
     * @param
     * @return
     * @throws DataFormatException
     */
    @GetMapping(value = "/all")
    public ResponseEntity<Message> getBookList() throws DataFormatException {

        Message message = new Message();
        message.setMessage("get book list success");
        message.setData(bookService.findBookList(PageRequest.of(1, 50)));
        message.setStatus(RestStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * 생성 API
     *
     * @param book
     * @return
     */
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Message> createBook(@RequestBody Book book) {
        log.debug("create Book : {}", book);

        Message message = new Message();
        message.setMessage("create book success");
        message.setData(bookService.saveBook(book));
        message.setStatus(RestStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * 수정 API
     *
     * @param book
     * @return
     */
    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Message> updateBook(@RequestBody Book book) {
        log.debug("update Book : {}", book);

        Message message = new Message();
        message.setMessage("update book success");
        message.setData(bookService.saveBook(book));
        message.setStatus(RestStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * 삭제 API
     *
     * @param book
     * @return
     */
    @DeleteMapping(value = "/", produces = "application/json")
    public ResponseEntity<Message> deleteBook(@RequestBody Book book) {
        log.debug("delete Book : {}", book);
        Message message = new Message();
        bookService.deleteBook(book);
        message.setMessage("update book success");
        message.setStatus(RestStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
