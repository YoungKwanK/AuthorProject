package com.beyond.AuthorProject.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorUpdateRequestDto {
    private String email;
    private String password;
}
