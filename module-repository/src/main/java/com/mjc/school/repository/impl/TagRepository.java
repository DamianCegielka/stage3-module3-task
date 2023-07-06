package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.entity.TagModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class TagRepository implements BaseRepository<TagModel,Long> {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<TagModel> readAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT t FROM TagModel t", TagModel.class)
                .getResultList();
    }

    @Override
    public Optional<TagModel> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public TagModel create(TagModel entity) {
        return null;
    }

    @Override
    public TagModel update(TagModel entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
