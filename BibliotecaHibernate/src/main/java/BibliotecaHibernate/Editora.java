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
public class Editora {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "nome", nullable = false)
    private String nome;
    @OneToMany(mappedBy = "editora", fetch = FetchType.EAGER)
    private List<Livro> livros; // Corrigido para referenciar a entidade Livro

    @Override
    public String toString() {
        return "Editora{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", livros=" + livros +
                '}';
    }
}
