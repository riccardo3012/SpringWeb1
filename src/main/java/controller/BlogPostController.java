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


    @PostMapping("")//CREA
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost postBlogPosts(@RequestBody BlogPost blogpost) {
        return blogpostService.save(blogpost);

    }

    @GetMapping("/{id}")//GETBYID
    @ResponseStatus(HttpStatus.FOUND)
    public BlogPost getBlogPostById(@PathVariable int id) {
        return blogpostService.findById(id);

    }


    @DeleteMapping("/{id}")//DELETEBYID
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void findByIdAndDelete(@PathVariable int id) {
        blogpostService.findByIdAndDelete(id);

    }

    @GetMapping //ritora lista blog
    List<BlogPost> getAllBlog() {
        return blogpostService.getAllBlog();

    }


    @PutMapping("/{id}") //findby id e aggiorna
    BlogPost findAndUpdateById(@PathVariable int id, @RequestBody BlogPost blogPost) {
        return blogpostService.findAndUpdateById(id, blogPost);

    }

}
