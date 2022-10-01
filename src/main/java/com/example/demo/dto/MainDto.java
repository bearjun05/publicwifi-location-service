package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class MainDto {
    private String list_total_count;
    private ResultDto RESULT;
    private List<RowDto> row;
}
