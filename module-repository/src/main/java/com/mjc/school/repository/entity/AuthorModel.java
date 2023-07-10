package com.mjc.school.repository.entity;

import com.mjc.school.repository.dto.AuthorModelRequest;
import com.mjc.school.repository.model.BaseEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "authors")
public class AuthorModel implements BaseEntity<Long> {
    private static Long idGenerator = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 15, unique = true)
    private String name;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime lastUpdateTime;

    @OneToMany(mappedBy = "authorModel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<NewsModel> news;

    public AuthorModel(AuthorModelRequest authorModelRequest) {
        idGenerator++;
        this.setId(AuthorModel.idGenerator);
        this.setName(authorModelRequest.getName());
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }

    public AuthorModel() {
        idGenerator++;
        this.setId(AuthorModel.idGenerator);
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }

    public AuthorModel(String empty) {
        this.setId(AuthorModel.idGenerator);
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }


    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        if (id != null) {
            this.id = id;
        } else
            this.id = AuthorModel.idGenerator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
