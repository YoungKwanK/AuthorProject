package com.beyond.AuthorProject.controller;

import com.beyond.AuthorProject.dto.AuthorCreateDto;
import com.beyond.AuthorProject.dto.AuthorUpdateRequestDto;
import com.beyond.AuthorProject.service.AuthorService;
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
        try {
            authorService.save(authorCreateDto);
            return new ResponseEntity<>("회원가입에 성공했습니다.", HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("존재하지 않는 ID입니다", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody AuthorUpdateRequestDto authorUpdateRequestDto) {
        try{
            authorService.update(authorUpdateRequestDto);
            return new ResponseEntity<>("업데이트 성공", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("업데이트 실패", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            authorService.delete(id);
            return new ResponseEntity<>("회원 정보가 삭제되었습니다.", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("회원 삭제를 실패하였습니다.", HttpStatus.BAD_REQUEST);
        }
    }
}
