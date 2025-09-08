package com.yuvaraj.challenge.library.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor()
@NoArgsConstructor
public class BookDto {

    @NotBlank(message = "Book id can't be blank.")
    int bookId;

    @NotBlank(message = "Book id can't be blank.")
    String title;

    @NotBlank(message = "Book author can't be blank.")
    String author;

    boolean available = true;
}
