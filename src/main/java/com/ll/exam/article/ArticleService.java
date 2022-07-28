package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title,body);
    }

    public List<ArticleDto> findAll(){
        return articleRepository.findAll();
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public void modify(long id, String title, String body) {
        articleRepository.modify(id,title, body);
    }

    public void delete(long id) {
        articleRepository.delete(id);
    }
}
