package payload;
import lombok.Getter;


@Getter
public class BlogPostPayload {
    private int id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoLettura;

}
