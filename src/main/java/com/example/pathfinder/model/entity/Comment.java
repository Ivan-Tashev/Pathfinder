package com.example.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @Column(nullable = false)
    private boolean approved;
    @Column(name = "text_content", columnDefinition = "TEXT", nullable = false)
    private String textContent;
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime created;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

    public boolean isApproved() {
        return approved;
    }

    public Comment setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
