package com.epam.postingservice.controller;

import com.epam.postingservice.dto.SaveDTO;
import com.epam.postingservice.dto.UpdateDTO;
import com.epam.postingservice.entity.Post;
import com.epam.postingservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Post save(@RequestBody SaveDTO saveDTO) {
        Long authorId = saveDTO.getAuthorId();
        String text = saveDTO.getText();
        return postService.save(authorId, text);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post get(@PathVariable Long id) {
        return postService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@PathVariable Long id, @RequestBody UpdateDTO updateDTO) {
        String text = updateDTO.getText();
        return postService.update(id, text);
    }
}
