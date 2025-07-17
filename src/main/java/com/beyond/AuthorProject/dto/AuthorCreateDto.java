package com.beyond.AuthorProject.dto;

import com.beyond.AuthorProject.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorCreateDto {
    private String name;
    private String email;
    private String password;

    public Author toAuthor(){
        return new Author(this.name, this.email, this.password);
    }
}
