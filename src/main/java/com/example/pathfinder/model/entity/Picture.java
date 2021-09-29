package com.example.pathfinder.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Picture setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Picture setRoute(Route route) {
        this.route = route;
        return this;
    }
}
