package com.beyond.AuthorProject.author.dto;

import com.beyond.AuthorProject.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    static public AuthorResponseDto fromAuthor(Author author) {
        return new AuthorResponseDto(author.getId(), author.getName(), author.getEmail(),author.getCreatedAt(),author.getUpdatedAt());
    }
}
