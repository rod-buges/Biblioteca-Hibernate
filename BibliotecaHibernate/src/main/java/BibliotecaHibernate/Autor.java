package BibliotecaHibernate;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Autor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "nome", nullable = false)
    private String nome;
    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Livro> livros; // Referencia a propriedade 'autor' na entidade Livro

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", livros=" + livros +
                '}';
    }
}
