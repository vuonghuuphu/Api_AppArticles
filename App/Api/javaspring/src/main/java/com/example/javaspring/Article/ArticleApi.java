package com.example.javaspring.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/V1/articles")
public class ArticleApi {

    @Autowired
    ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getlist() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @PostMapping
    public ResponseEntity<Article> save(@RequestBody Article p) {
        return ResponseEntity.ok(articleService.save(p));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
        Optional<Article> optionalStudent = articleService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }

    @RequestMapping(method = RequestMethod.GET, path = "search")
    public ResponseEntity<List<Article>> search(@RequestParam String Key) {
        return ResponseEntity.ok(articleService.findbytitle(Key));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Article> update(@PathVariable int id, @RequestBody Article p) {
        Optional<Article> optionalStudent = articleService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Article found = optionalStudent.get();
        if (found != null) {
            found.setTitle(p.getTitle());
            found.setDescription(p.getDescription());
            found.setImg(p.getImg());
            found.setContent(p.getContent());
            found.setCategories(p.getCategories());
            found.setCreateAt(p.getCreateAt());
            found.setUpdateAt(p.getUpdateAt());
            found.setStatus(p.getStatus());
        }
        return ResponseEntity.ok(articleService.save(found));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!articleService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        articleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
