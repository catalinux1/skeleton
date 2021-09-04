package com.skeleton.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skeleton.util.LoggedUser;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractAuditable {

    @Column(name = "CREATED_BY", nullable = false)
    protected String createdBy;

    @Column(name = "CREATED", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime createdDate;

    @Column(name = "LAST_UPDATE_BY", nullable = false)
    protected String lastUpdateBy;

    @Column(name = "LAST_UPDATE", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime lastUpdateDate;

    @PrePersist
    public void addCreatedBy() {
        this.createdBy = LoggedUser.getLoggedUserName();
        this.createdDate = LocalDateTime.now();
        this.lastUpdateBy = LoggedUser.getLoggedUserName();
        this.lastUpdateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void addLastUpdateBy() {
        if (LoggedUser.getLoggedUserName() != null) {
            this.lastUpdateBy = LoggedUser.getLoggedUserName();
            this.lastUpdateDate = LocalDateTime.now();
        }
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(final String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(final LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
