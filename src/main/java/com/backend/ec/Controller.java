package com.backend.ec;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping
    public List<Article> getAllBoards() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Article getBoard(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Article createBoard(@RequestBody Request req) {
        return service.save(req);
    }

    @PutMapping("/{id}")
    public Article updateBoard(@PathVariable Long id, @RequestBody Request req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        service.delete(id);
    }
}
