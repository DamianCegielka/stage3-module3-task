package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.dto.AuthorModelResponse;
import com.mjc.school.repository.entity.AuthorModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource = new DataSource();

    private List<AuthorModel> listAuthor ;


    public AuthorRepository() {
        //dataSource.loadAuthorsFromDataSource();
    }

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<AuthorModel> readAll() {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            return entityManager.createQuery("SELECT a FROM AuthorModel a", AuthorModel.class)
                    .getResultList();

    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return Optional.ofNullable(entityManager.find(AuthorModel.class, id));
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AuthorModel updatedModel = entityManager.find(AuthorModel.class, entity.getId());
        updatedModel.setName(entity.getName());
        entityManager.getTransaction().commit();
        return updatedModel;
    }

    @Override
    public boolean deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if (readById(id).isPresent()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(AuthorModel.class, id));
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}