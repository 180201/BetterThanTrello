package com.packt.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Winiu on 04-05-2016.
 */

@Entity
@Table(name="TROLLO_BOARD")
public class TrolloBoard {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="ID_CREATING_USER")
    private long idCreatingUser;

    @Column(name="ID_MOD_USER")
    private long idModUser;

    @Column(name="CREATING_DATE")
    private Date creatingDate;

    @Column(name="MODIFICATION_DATE")
    private Date modificationDate;

    @Column(length = 50)
    private String title;

    @Column (length = 4000)
    private String desccription;

    @Column(name="PERMISSION_ID")
    private long permissionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID")
   // @Column(name="USER_ID")
    private TrolloUsers trolloUsers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trolloBoardoInColumn", cascade = CascadeType.ALL)
    private Set<TrolloColumn> trolloColumns= new HashSet<TrolloColumn>(0);

    private long spot;

    public TrolloBoard(long permissionId, long idCreatingUser, long idModUser, Date creatingDate, Date modificationDate, String title, String desccription, TrolloUsers trolloUsers, long spot) {
        this.permissionId = permissionId;
        this.idCreatingUser = idCreatingUser;
        this.idModUser = idModUser;
        this.creatingDate = creatingDate;
        this.modificationDate = modificationDate;
        this.title = title;
        this.desccription = desccription;
        this.trolloUsers = trolloUsers;
        this.spot = spot;
    }

    public TrolloBoard() {
    }

    public long getIdCreatingUser() {
        return idCreatingUser;
    }

    public void setIdCreatingUser(long idCreatingUser) {
        this.idCreatingUser = idCreatingUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdModUser() {
        return idModUser;
    }

    public void setIdModUser(long idModUser) {
        this.idModUser = idModUser;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }


    public long getSpot() {
        return spot;
    }

    public void setSpot(long spot) {
        this.spot = spot;
    }

    public TrolloUsers getTrolloUsers() {
        return trolloUsers;
    }

    public void setTrolloUsers(TrolloUsers trolloUsers) {
        this.trolloUsers = trolloUsers;
    }

    public Set<TrolloColumn> getTrolloColumns() {
        return trolloColumns;
    }

    public void setTrolloColumns(Set<TrolloColumn> trolloColumns) {
        this.trolloColumns = trolloColumns;
    }

    @Override
    public String toString() {
        return "TrolloBoard{" +
                "id=" + id +
                ", idCreatingUser=" + idCreatingUser +
                ", idModUser=" + idModUser +
                ", creatingDate=" + creatingDate +
                ", modificationDate=" + modificationDate +
                ", title='" + title + '\'' +
                ", desccription='" + desccription + '\'' +
                ", permissionId=" + permissionId +
                ", trolloUsers=" + trolloUsers +
                ", spot=" + spot +
                '}';
    }
}
