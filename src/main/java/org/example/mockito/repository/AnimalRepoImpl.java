package org.example.mockito.repository;

import org.example.mockito.config.HibernateUtil;
import org.example.mockito.model.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AnimalRepoImpl implements AnimalRepo {
    @Override
    public void save(Animal animal) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(animal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error saving animal", e);
        }
    }

    @Override
    public Animal findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.find(Animal.class, id)).get();
        }
    }

    @Override
    public List<Animal> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Animal", Animal.class).list();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Animal animal = session.find(Animal.class, id);
            if (animal != null) {
                session.remove(animal);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error deleting animal", e);
        }
    }
}
