package com.mjc.school.repository.entity;

import com.mjc.school.repository.dto.NewsModelRequest;
import com.mjc.school.repository.model.BaseEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "news")
public class NewsModel implements BaseEntity<Long> {

    private static Long idGenerator = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime lastUpdateTime;
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorModel authorModel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "news_tag",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagModel> tagModels;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public NewsModel(NewsModelRequest newsDTOCreation) {
        idGenerator++;
        this.setId(NewsModel.idGenerator);
        this.setTitle(newsDTOCreation.getTitle());
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
        this.setContent(newsDTOCreation.getContent());
        this.setAuthorId(newsDTOCreation.getAuthorId());
    }

    public NewsModel() {
        idGenerator++;
        setId(NewsModel.idGenerator);
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }

    public NewsModel(String empty) {
        setId(NewsModel.idGenerator);
        this.setCreateDate(LocalDateTime.now());
        this.setLastUpdateTime(LocalDateTime.now());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorModel(AuthorModel authorModel) {
        this.authorModel = authorModel;
    }

    public AuthorModel getAuthorModel() {
        return authorModel;
    }

    public List<TagModel> getTagModels() {
        return tagModels;
    }

    public void setTagModels(List<TagModel> tags) {
        this.tagModels = tags;
    }
}
