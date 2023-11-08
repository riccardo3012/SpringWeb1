package service;
import entities.BlogPost;
import exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


@Service
public class BlogPostService {
private List<BlogPost> blogpost = new ArrayList<>();

    public BlogPost save(BlogPost blogpost) {//CREA
        Random rndm = new Random();
        blogpost.setId(rndm.nextInt(1, 100));
        this.blogpost.add(blogpost);
        return blogpost;
    }


    public BlogPost findById(int id) {//GETBYID
        for (BlogPost blogpost : this.blogpost) {
            if (blogpost.getId() == id) {
                return blogpost;
            }
        }
        throw new NotFoundException(id);
    }


    public void findByIdAndDelete(long id) {//DELETEBYID
        Iterator<BlogPost> iterator = this.blogpost.iterator();
        while (iterator.hasNext()){
            BlogPost current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
                return;
            }
        }
    }


    public List<BlogPost> getAllBlog() {//ritora lista blog
        return this.blogpost;
    }


    public BlogPost findAndUpdateById( int id, BlogPost blog) { //findby id e aggiorna
        BlogPost foundBlog = this.findById(id);
        foundBlog.setId(id);
        foundBlog.setCategoria(blog.getCategoria());
        foundBlog.setTitolo(blog.getTitolo());
        foundBlog.setCover(blog.getCover());
        foundBlog.setContenuto(blog.getContenuto());
        foundBlog.setTempoLettura(blog.getTempoLettura());
        return foundBlog;
    }

}