package com.beyond.AuthorProject.author.controller;

import com.beyond.AuthorProject.author.dto.AuthorCreateDto;
import com.beyond.AuthorProject.author.dto.AuthorUpdateRequestDto;
import com.beyond.AuthorProject.author.dto.CommonDto;
import com.beyond.AuthorProject.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody AuthorCreateDto authorCreateDto) {
        authorService.save(authorCreateDto);
        return new ResponseEntity<>(new CommonDto("회원가입 성공",HttpStatus.CREATED.value(),"회원가입에 성공했습니다."),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(new CommonDto(authorService.findById(id), HttpStatus.OK.value(), "성공"),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(new CommonDto(authorService.findAll(), HttpStatus.OK.value(), "회원 전체 조회 성공"),HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody AuthorUpdateRequestDto authorUpdateRequestDto) {
        authorService.update(authorUpdateRequestDto);
        return new ResponseEntity<>(new CommonDto("업데이트 성공", HttpStatus.OK.value(), "업데이트 성공"),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.delete(id);
        return new ResponseEntity<>(new CommonDto("회원 정보가 삭제되었습니다.", HttpStatus.OK.value(), "회원탈퇴 성공"),HttpStatus.OK);
    }
}
