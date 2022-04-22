package com.example.javaspring.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
    @Query(value = "SELECT * FROM  article a where a.title like %:key% or a.categories like %:key%",nativeQuery = true)
    List<Article> search (@Param("key") String key);
}
