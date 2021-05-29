package com.research.database.socialnetwork.controller;

import com.research.database.socialnetwork.storage.firebase.dto.PostDTO;
import com.research.database.socialnetwork.storage.firebase.entity.Post;
import com.research.database.socialnetwork.storage.firebase.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/post")
public class RestPostController {
    @Autowired
    PostService postService;

    @PostMapping("")
    public String createPatient(@RequestBody PostDTO postDTO) throws InterruptedException, ExecutionException {
        return postService.savePost(postDTO);
    }

    @GetMapping("/myPost/{ownerId}")
    public List<Post> getOwnerPost(@PathVariable("ownerId") Integer ownerId) throws InterruptedException, ExecutionException {
        return postService.getOwnerPost(ownerId);
    }

    @GetMapping("/newFeed/{userId}")
    public List<Post> getNewFeedByUserId(@PathVariable("userId") Integer userId) throws InterruptedException, ExecutionException {
        return postService.getNewFeedByUserId(userId);
    }
}
