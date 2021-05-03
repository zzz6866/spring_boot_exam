package com.example.boot_mongodb.controller;

import com.example.boot_mongodb.dto.Message;
import com.example.boot_mongodb.dto.RestStatus;
import com.example.boot_mongodb.entity.Book;
import com.example.boot_mongodb.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "BookController V1")
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
    @ApiOperation(value = "예제", notes = "main 예제 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
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
    @ApiOperation(value = "단건 조회 API", notes = "id 값으로 단건을 조회합니다.")
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
    @ApiOperation(value = "전체 조회 API", notes = "전체 데이터를 조회합니다.")
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
    @ApiOperation(value = "생성 조회 API", notes = "데이터를 생성합니다.")
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
    @ApiOperation(value = "수정 API", notes = "body -> id 값으로 수정합니다.")
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
    @ApiOperation(value = "수정 API", notes = "body -> id 값으로 삭제합니다.")
    public ResponseEntity<Message> deleteBook(@RequestBody Book book) {
        log.debug("delete Book : {}", book);
        Message message = new Message();
        bookService.deleteBook(book);
        message.setMessage("update book success");
        message.setStatus(RestStatus.OK);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
