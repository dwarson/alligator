package com.june.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "fs_bible_chapter")
public class BibleChapter extends IdEntity {
    private BibleBook bibleBook;
    private String title;
    private String status;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    public BibleBook getBibleBook() {
        return bibleBook;
    }

    public void setBibleBook(BibleBook bibleBook) {
        this.bibleBook = bibleBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
