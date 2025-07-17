package com.beyond.AuthorProject.service;

import com.beyond.AuthorProject.domain.Author;
import com.beyond.AuthorProject.dto.AuthorCreateDto;
import com.beyond.AuthorProject.dto.AuthorListResponseDto;
import com.beyond.AuthorProject.dto.AuthorReponseDto;
import com.beyond.AuthorProject.dto.AuthorUpdateRequestDto;
import com.beyond.AuthorProject.repository.AuthorRepository;
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
    public AuthorReponseDto findById(Long id){
        return authorRepository.findById(id).orElseThrow().toAuthorReponseDto();
    }

    @Transactional(readOnly = true)
    public List<AuthorListResponseDto> findAll(){
        return authorRepository.findAll()
                .stream()
                .map(a->a.toAuthorListReponseDto())
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
