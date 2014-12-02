package com.june.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "fs_bible_book")
public class BibleBook extends IdEntity {

    private String title;
    private String author;
    private String bookTime;
    private Integer bookType;
    private String description;
    private List<BibleChapter> chapters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTime() {
        return bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bibleBook")
    public List<BibleChapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<BibleChapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
