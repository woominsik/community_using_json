package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArticleRepository {
    private static List<ArticleDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    public static long write(String title, String body) {
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        datum.add(newArticleDto);

        return id;
    }

    public List<ArticleDto> findAll() {
        return datum;
    }

    public ArticleDto findById(long id) {
        for ( ArticleDto articleDto : datum ) {
            if ( articleDto.getId() == id ) {
                return articleDto;
            }
        }

        return null;
    }

    private static void makeTestData() {
        IntStream.rangeClosed(1, 10).forEach(id -> {
            String title = "24일 흠뻑쇼 동행 구합니다!%d".formatted(id);
            String body = "남녀 무관 24일 흠뻑쇼 같이 갈 인원 4명 구합니다!%d".formatted(id);
            write(title, body);
        });
    }

    public void modify(long id, String title, String body) {
        ArticleDto articleDto = findById(id);

        if (articleDto == null) return;

        articleDto.setTitle(title);
        articleDto.setBody(body);
    }

    public void delete(long id) {
        ArticleDto articleDto = findById(id);
        datum.remove(articleDto);
    }

    public List<ArticleDto> findAllIdGreaterThan(long fromId) {
        return datum
                .stream()
                .filter(articleDto -> articleDto.getId() > fromId)
                .collect(Collectors.toList());
    }
}
