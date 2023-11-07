package controller;
import entities.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.BlogPostService;
import java.util.List;


public class BlogPostController {

    @Autowired
    private BlogPostService blogpostService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost postBlogPosts(@RequestBody BlogPost blogpost) {
        return blogpostService.save(blogpost);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BlogPost getBlogPostById(@PathVariable int id) {
        try {
            return BlogPostService.findById(id);
        } catch (Exception e) {
            return null;
        }
    }








}
