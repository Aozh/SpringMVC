package com.gaussic.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by zhaoli8 on 2016/8/15.
 */
@Entity
@Table(name = "blog", schema = "springdemo", catalog = "")
public class BlogEntity {
    private int id;
    private String title;
    private String content;
    private UserEntity userByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}