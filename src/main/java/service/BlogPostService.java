package service;
import entities.BlogPost;
import exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class BlogPostService {
private List<BlogPost> blogpost = new ArrayList<>();

    public BlogPost save(BlogPost blogpost) {
        Random rndm = new Random();
        blogpost.setId(rndm.nextInt(1, 100));
        this.blogpost.add(blogpost);
        return blogpost;
    }

    public static BlogPost findById(int id) {
        for (BlogPost bpost : blogpost) {
            if (bpost.getId() == id) {
                return bpost;
            }


        }
        throw new NotFoundException(id);
    }
}