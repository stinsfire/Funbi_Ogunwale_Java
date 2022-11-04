package com.company.Project_2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class book implements Serializable {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String isbn;
    private String publish_date;
    private int authorId;
    private String  title;
    private int publisherId;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String  publish_date) {
        this.publish_date = publish_date;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int author_id) {
        this.authorId = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publish_id) {
        this.publisherId = publish_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof book)) return false;
        book book = (book) o;
        return getPublisherId() == book.getPublisherId() && Objects.equals(getId(), book.getId()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getPublish_date(), book.getPublish_date()) && Objects.equals(getAuthorId(), book.getAuthorId()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getPrice(), book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn(), getPublish_date(), getAuthorId(), getTitle(), getPublisherId(), getPrice());
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", publish_date=" + publish_date +
                ", author_id=" + authorId +
                ", title='" + title + '\'' +
                ", publish_id=" + publisherId +
                ", price=" + price +
                '}';
    }
}
