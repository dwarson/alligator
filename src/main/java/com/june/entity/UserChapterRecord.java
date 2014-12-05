package com.june.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "fs_user_chapter_record")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "pk.bibleChapter", joinColumns = @JoinColumn(name = "chapter_id")) })
public class UserChapterRecord {

    private UserChapterRecordPk pk = new UserChapterRecordPk();
    private Integer status;
    private String notes;

    @EmbeddedId
    private UserChapterRecordPk getPk() {
        return pk;
    }

    private void setPk(UserChapterRecordPk pk) {
        this.pk = pk;
    }

    @Transient
    public User getUser() {
        return getPk().getUser();
    }

    public void setUser(User user) {
        getPk().setUser(user);
    }

    @Transient
    public BibleChapter getBibleChapter() {
        return getPk().getBibleChapter();
    }

    public void setBibleChapter(BibleChapter bibleChapter) {
        getPk().setBibleChapter(bibleChapter);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserChapterRecord that = (UserChapterRecord) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
