package com.jocile.jpabook;

import com.jocile.jpabook.model.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Jpabook {

    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = factory.createEntityManager();
        
        // todo: codigo
        
        // Encontrar um registro
        //Book b = entityManager.find(Book.class, 1);
        
        /* Salvar um registro
        entityManager.getTransaction().begin();
        Book livro = new Book("Como programar", "Deitel");
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
        */
        
        /*Atualizar um registro
        Book livro = entityManager.find(Book.class, 1);
        livro.setAuthor("Deitel H.");
        entityManager.getTransaction().begin();
        entityManager.merge(livro);
        entityManager.getTransaction().commit();
        */
        
         /*Remover um registro 
        Book livro = entityManager.find(Book.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
        */        
        
        // Encontar um registro por um critério específico
        Book livroAuthor = findByAuthor(entityManager, "Deitel");
        System.out.println(livroAuthor.toString());

        entityManager.close();        
        factory.close();
    }
    
    public static Book findByAuthor(EntityManager entityManager, String author){
        /*
        String jpql = " SELECT b.id, b.title, b.author "+
                      " FROM Book b "+
                      " WHERE b.author = :author";
        */
        String jpql = " SELECT b FROM Book b "+
                      " WHERE b.author = :author";
        //Query query = entityManager.createQuery(jpql);
        //query.setParameter("author", author);
        //TypedQuery typedQuery = entityManager.createQuery(jpql, Book.class);
        TypedQuery<Book> typedQuery = entityManager.createQuery(jpql, Book.class);
        typedQuery.setParameter("author", author);
        
        //List<Book> lst = (Book) query.getResultList();
        //List<Book> lst = typeQuery.getResultList();
        Book livro = (Book) typedQuery.getSingleResult();

        entityManager.close();
        //return lst.get(0);
        return livro;
    }
}
