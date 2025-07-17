package com.beyond.AuthorProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonDto {
    private Object result;
    private int statusCode;
    private String statusMessage;
}
