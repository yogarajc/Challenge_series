package com.yuvaraj.challenge.library.controller;

import com.yuvaraj.challenge.common.ResponseDTO;
import com.yuvaraj.challenge.library.Dto.BookDto;
import com.yuvaraj.challenge.library.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping("/books")
    private ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody BookDto bookDto){
        return ResponseEntity.ok(libraryService.addBook(bookDto));
    }

    @GetMapping("/books")
    private ResponseEntity<ResponseDTO> getBookList(){
        return ResponseEntity.ok(libraryService.getBookList());
    }

    @PostMapping("books/{bookId}/borrow")
    private ResponseEntity<ResponseDTO> borrowBook(@PathVariable int bookId){
        return ResponseEntity.ok(libraryService.borrowBook(bookId));
    }

    @PostMapping("books/{bookId}/return")
    private ResponseEntity<ResponseDTO> returnBook(@PathVariable int bookId){
        return ResponseEntity.ok(libraryService.returnBook(bookId));
    }
}
