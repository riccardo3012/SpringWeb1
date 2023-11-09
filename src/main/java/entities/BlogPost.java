package entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    @Column(name = "tempo_lettura")
    private int tempoLettura;


    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoLettura=" + tempoLettura +
                '}';

  }

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

}
