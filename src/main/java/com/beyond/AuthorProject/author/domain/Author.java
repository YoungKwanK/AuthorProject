package com.beyond.AuthorProject.author.domain;

import com.beyond.AuthorProject.author.dto.AuthorListResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Author(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public AuthorListResponseDto toAuthorListResponseDto() {
        return new AuthorListResponseDto(this.id, this.name, this.email);
    }
    public void update(String newPassword) {
        this.password=newPassword;
        this.updatedAt = LocalDateTime.now();
    }
}
