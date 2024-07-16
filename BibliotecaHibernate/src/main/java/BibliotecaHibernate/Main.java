package BibliotecaHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Aponta para o local onde se encontram as configurações feitas no hibernate.cfg.xml
        Configuration cfg = new Configuration().configure();
        // Cria uma factory
        SessionFactory factory = cfg.buildSessionFactory();

        // Cria uma nova session
        Session session = factory.openSession();

        // Inicia uma nova transaction
        session.beginTransaction();

        // Cria ou busca as entidades relacionadas
        Livro livro = session.get(Livro.class, 3L);
        Autor autor = session.get(Autor.class, 3L);

        // Cria um novo livro
        livroAutor LivroAutor = livroAutor.builder()
                .fk_autor(autor)
                .fk_livro(livro)
                .build();


        // Salva o novo livro
        session.persist(livroAutor);

        // Confirma a transação. Caso alguma das ações dadas após beginTransaction() dê errado, todas as outras ações feitas são canceladas.
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
