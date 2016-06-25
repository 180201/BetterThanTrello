package com.packt.domain;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Winiu on 20-05-2016.
 */
@Entity
@Table(name = "TROLLO_COLUMN")
public class TrolloColumn {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ID_CREATING_USER")
    private long idCretingUser;

    @Column(name = "ID_MODIFICATION_USER")
    private long idModyficationUser;

    @Column(name="CREATING_DATE")
    private Date creatingDate;

    @Column(name="MODIFICATION_DATE")
    private Date modyficationDate;


    private String title;

    private String description;

    private long orderColumn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BOARD_ID")
    private TrolloBoard trolloBoardoInColumn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private TrolloUsers trolloUsersInColumn;

    @Column(name="PERMISSION_ID")
    private long permissionId;

    public TrolloColumn() {
    }

    public TrolloColumn(long idCretingUser, long idModyficationUser, Date creatingDate, Date modyficationDate, String title, String description,
                        TrolloBoard trolloBoardoInColumn, TrolloUsers trolloUsersInColumn, long permissionId) {
        this.idCretingUser = idCretingUser;
        this.idModyficationUser = idModyficationUser;
        this.creatingDate = creatingDate;
        this.modyficationDate = modyficationDate;
        this.title = title;
        this.description = description;
        this.trolloBoardoInColumn = trolloBoardoInColumn;
        this.trolloUsersInColumn = trolloUsersInColumn;
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


    public TrolloUsers getTrolloUsersInColumn() {
        return trolloUsersInColumn;
    }

    public void setTrolloUsersInColumn(TrolloUsers trolloUsersInColumn) {
        this.trolloUsersInColumn = trolloUsersInColumn;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public TrolloBoard getTrolloBoardoInColumn() {
        return trolloBoardoInColumn;
    }

    public void setTrolloBoardoInColumn(TrolloBoard trolloBoardoInColumn) {
        this.trolloBoardoInColumn = trolloBoardoInColumn;
    }

    public long getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(long orderColumn) {
        this.orderColumn = orderColumn;
    }

    @Override
    public String toString() {
        return "TrolloColumn{" +
                "id=" + id +
                ", idCretingUser=" + idCretingUser +
                ", idModyficationUser=" + idModyficationUser +
                ", creatingDate=" + creatingDate +
                ", modyficationDate=" + modyficationDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", trolloBoardoInColumn=" + trolloBoardoInColumn +
                ", trolloUsersInColumn=" + trolloUsersInColumn +
                ", permissionId=" + permissionId +
                '}';
    }
}


