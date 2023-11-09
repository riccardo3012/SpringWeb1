package entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<BlogPost> blogpostList;

}
