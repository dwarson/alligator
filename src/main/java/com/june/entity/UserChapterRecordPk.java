package com.june.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserChapterRecordPk implements Serializable {

    private static final long serialVersionUID = -533099659866137246L;
    private User user;
    private BibleChapter bibleChapter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    public BibleChapter getBibleChapter() {
        return bibleChapter;
    }

    public void setBibleChapter(BibleChapter bibleChapter) {
        this.bibleChapter = bibleChapter;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserChapterRecordPk that = (UserChapterRecordPk) o;

        if (user != null ? !user.equals(that.user) : that.user != null)
            return false;
        if (bibleChapter != null ? !bibleChapter.equals(that.bibleChapter)
                : that.bibleChapter != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result
                + (bibleChapter != null ? bibleChapter.hashCode() : 0);
        return result;
    }
}
