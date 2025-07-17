package com.beyond.AuthorProject.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorListResponseDto {
    private Long id;
    private String name;
    private String email;
}
