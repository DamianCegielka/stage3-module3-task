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

    private List<AuthorModel> listAuthor = dataSource.getListAuthor();

    public AuthorRepository() {
        dataSource.loadAuthorsFromDataSource();
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
        AuthorModelResponse authorModelResponse = new AuthorModelResponse();
        listAuthor.forEach(x -> {
            boolean b = x.getId().equals(id);
            if (b) authorModelResponse.map(x);
            if (b) authorModelResponse.print();
        });
        return Optional.ofNullable(authorModelResponse.mapToAuthorModel());
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
        AuthorModelResponse authorModelResponse = new AuthorModelResponse();
        listAuthor.forEach(x -> {
            boolean b = x.getId().equals(entity.getId());
            if (b) x.setName(entity.getName());
            if (b) x.setLastUpdateTime(LocalDateTime.now());
            if (b) authorModelResponse.map(x);
            if (b) authorModelResponse.print();

        });
        return authorModelResponse.mapToAuthorModel();
    }

    @Override
    public boolean deleteById(Long id) {
        if (listAuthor.removeIf(x -> x.getId().equals(id))) {
            System.out.println(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existById(Long id) {
        for (AuthorModel author : listAuthor) {
            if (author.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}