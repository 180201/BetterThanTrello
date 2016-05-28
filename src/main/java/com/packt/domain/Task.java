package com.packt.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by wp on 22.05.2016.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue
    long id;

    @Column(name = "ID_CREATING_USER")
    private long idCretingUser;

    @Column(name = "ID_MODIFICATION_USER")
    private long idModyficationUser;

    @Column(name = "CREATING_DATE")
    private Date creatingDate;

    @Column(name = "MODIFICATION_DATE")
    private Date modyficationDate;


    private String title;


    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private TrolloBoard trolloBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COL_ID")
    private TrolloColumn trolloColumn;

    @Column(name = "PERMISSION_ID")
    private long permissionId;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", idCretingUser=" + idCretingUser +
                ", idModyficationUser=" + idModyficationUser +
                ", creatingDate=" + creatingDate +
                ", modyficationDate=" + modyficationDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", trolloBoard=" + trolloBoard +
                ", trolloColumn=" + trolloColumn +
                ", permissionId=" + permissionId +
                '}';
    }

    public Task(long idCretingUser, long idModyficationUser, Date creatingDate,
                Date modyficationDate, String title, String description, TrolloBoard trolloBoard, TrolloColumn trolloColumn, long permissionId) {
        this.idCretingUser = idCretingUser;
        this.idModyficationUser = idModyficationUser;
        this.creatingDate = creatingDate;
        this.modyficationDate = modyficationDate;
        this.title = title;
        this.description = description;
        this.trolloBoard = trolloBoard;
        this.trolloColumn = trolloColumn;
        this.permissionId = permissionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCretingUser() {
        return idCretingUser;
    }

    public void setIdCretingUser(long idCretingUser) {
        this.idCretingUser = idCretingUser;
    }

    public long getIdModyficationUser() {
        return idModyficationUser;
    }

    public void setIdModyficationUser(long idModyficationUser) {
        this.idModyficationUser = idModyficationUser;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Date getModyficationDate() {
        return modyficationDate;
    }

    public void setModyficationDate(Date modyficationDate) {
        this.modyficationDate = modyficationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrolloBoard getTrolloBoard() {
        return trolloBoard;
    }

    public void setTrolloBoard(TrolloBoard trolloBoard) {
        this.trolloBoard = trolloBoard;
    }

    public TrolloColumn getTrolloColumn() {
        return trolloColumn;
    }

    public void setTrolloColumn(TrolloColumn trolloColumn) {
        this.trolloColumn = trolloColumn;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }
}