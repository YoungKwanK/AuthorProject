package com.beyond.AuthorProject.author.service;

import com.beyond.AuthorProject.author.dto.AuthorCreateDto;
import com.beyond.AuthorProject.author.dto.AuthorUpdateRequestDto;
import com.beyond.AuthorProject.author.repository.AuthorRepository;
import com.beyond.AuthorProject.author.domain.Author;
import com.beyond.AuthorProject.author.dto.AuthorListResponseDto;
import com.beyond.AuthorProject.author.dto.AuthorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void save(AuthorCreateDto authorCreateDto){
        if(authorRepository.findByEmail(authorCreateDto.getEmail()).isPresent()){
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        };
        authorRepository.save(authorCreateDto.toAuthor());
    }

    @Transactional(readOnly = true)
    public AuthorResponseDto findById(Long id){
        Author author =  authorRepository.findById(id).orElseThrow();
        return AuthorResponseDto.fromAuthor(author);
    }

    @Transactional(readOnly = true)
    public List<AuthorListResponseDto> findAll(){
        return authorRepository.findAll()
                .stream()
                .map(a->a.toAuthorListResponseDto())
                .toList();
    }

    public void update(AuthorUpdateRequestDto authorUpdateRequestDto){
        Author author = authorRepository.findByEmail(authorUpdateRequestDto.getEmail()).orElseThrow();
        author.update(authorUpdateRequestDto.getPassword());
    }

    public void delete(Long id){
        authorRepository.delete(authorRepository.findById(id).orElseThrow());
    }
}
