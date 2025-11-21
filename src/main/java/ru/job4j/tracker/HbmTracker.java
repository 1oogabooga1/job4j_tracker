package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

    private final SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = true;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery("UPDATE Item SET name = :name, created = :created WHERE id = :id")
                    .setParameter("id", id)
                    .setParameter("created", item.getCreated())
                    .executeUpdate() != 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Item", Item.class).list();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Item WHERE name = :name", Item.class).setParameter("name", key).list();
        }
    }

    @Override
    public Item findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Item WHERE id = :id", Item.class).setParameter("id", id).uniqueResult();
        }
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
