package com.beyond.AuthorProject.dto;

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
