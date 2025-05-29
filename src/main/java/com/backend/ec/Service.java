package com.backend.ec;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

  @Autowired
    private Repository repository; // Article 엔티티용 JpaRepository

    // 전체 게시글 조회
    public List<Article> findAll() {
        return repository.findAll();
    }

    // 특정 게시글 조회
    public Article findById(Long id) {
        Optional<Article> article = repository.findById(id);
        return article.orElse(null);
    }

    // 게시글 생성
    public Article save(Request dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return repository.save(article);
    }

    // 게시글 수정
    public Article update(Long id, Request dto) {
        Article article = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return repository.save(article);
    }

    // 게시글 삭제
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
