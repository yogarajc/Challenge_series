package com.yuvaraj.challenge.library.service;

import com.yuvaraj.challenge.common.ResponseDTO;
import com.yuvaraj.challenge.library.Dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LibraryService {

    private final HashMap<Integer, BookDto> bookMap = new HashMap<>();

    public ResponseDTO addBook(BookDto bookDto){

        if (bookMap.containsKey(bookDto.getBookId())){

            bookMap.put(bookDto.getBookId(), bookDto);
            return new ResponseDTO(bookDto.getTitle()+" Book successfully added.");
        }else return new ResponseDTO(bookDto.getTitle()+" Book already added.");

    }

    public ResponseDTO getBookList(){

        if (!bookMap.isEmpty())
            return new ResponseDTO("Success", bookMap.values().toArray());
        else return new ResponseDTO("No Data Found");
    }

    public ResponseDTO borrowBook(int bookId){

        if (bookMap.containsKey(bookId)){
            BookDto bookDto;
            bookDto = bookMap.get(bookId);
            if (bookDto.isAvailable()){
                bookDto.setAvailable(false);
                return new ResponseDTO("Success", bookDto);
            }else return new ResponseDTO("Requested book already borrowed from library.");
        }else return new ResponseDTO("Requested book not available in this library");
    }

    public ResponseDTO returnBook(int bookId){

        if (bookMap.containsKey(bookId)){
            BookDto bookDto;
            bookDto = bookMap.get(bookId);
            if (!bookDto.isAvailable()){
                bookDto.setAvailable(true);
                return new ResponseDTO(bookDto.getTitle()+" Book Returned");
            }else return new ResponseDTO(bookDto.getTitle()+" book already available in this library");
        }else return new ResponseDTO("Requested book not available in this library");
    }
}
