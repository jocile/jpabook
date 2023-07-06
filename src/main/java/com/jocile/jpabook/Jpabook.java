package com.jocile.jpabook;

import com.jocile.jpabook.model.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        
        entityManager.close();
        factory.close();
    }
}
