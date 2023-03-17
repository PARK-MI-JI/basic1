package com.ll.basic1.boundedContext.article.repository;

import com.ll.basic1.boundedContext.article.entitiy.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
