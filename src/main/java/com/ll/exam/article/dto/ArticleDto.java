package com.ll.exam.article.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private long id;

    private String title;

    private String body;
}