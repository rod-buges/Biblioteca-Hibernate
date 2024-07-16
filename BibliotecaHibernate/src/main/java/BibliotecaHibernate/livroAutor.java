package BibliotecaHibernate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class livroAutor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_livro", referencedColumnName = "isbn", foreignKey = @ForeignKey(name = "fk_livro"))
    private Livro livro; //tabela que vai ser referenciada
    @ManyToOne
    @JoinColumn(name = "fk_autor", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_autor"))
    private Autor autor; //tabela que vai ser referenciada


}
