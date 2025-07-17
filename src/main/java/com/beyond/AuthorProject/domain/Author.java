package com.beyond.AuthorProject.domain;

import com.beyond.AuthorProject.dto.AuthorListResponseDto;
import com.beyond.AuthorProject.dto.AuthorReponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public AuthorReponseDto toAuthorReponseDto() {
        return new AuthorReponseDto(this.id, this.name, this.email, this.createdAt, this.updatedAt);
    }
    public AuthorListResponseDto toAuthorListReponseDto() {
        return new AuthorListResponseDto(this.id, this.name, this.email);
    }
    public void update(String newPassword) {
        this.password=newPassword;
        this.updatedAt = LocalDateTime.now();
    }
}
