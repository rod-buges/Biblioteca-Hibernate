package BibliotecaHibernate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livro {
    @Id //chave primária
    @Column(name = "isbn", nullable = false)
    private Long isbn;
    @Column(unique = true, name = "titulo", nullable = false)
    private String titulo;
    @Column(unique = false, name = "anoPublicacao", nullable = false)
    private int anoPublicacao;
    @ManyToOne
    @JoinColumn(name = "fk_editora", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_editora"))
    private Editora editora; //tabela que vai ser referenciada
    @ManyToOne
    @JoinColumn(name = "fk_categoria", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_categoria"))
    private Categoria categoria; //tabela que vai ser referenciada
    @ManyToOne
    @JoinColumn(name = "fk_autor", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_autor"))
    private Autor autor; // Adiciona a referência à entidade Autor

    @Override
    public String toString() {
        return "Livro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", editora=" + editora +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
