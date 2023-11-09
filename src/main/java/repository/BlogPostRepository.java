package repository;
import entities.BlogPost;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
