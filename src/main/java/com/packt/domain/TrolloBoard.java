package com.packt.domain;


import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Winiu on 04-05-2016.
 */

@Entity
@Table(name="TROLLO_BOARD")
public class TrolloBoard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="ID_CREATING_USER")
    private Long idCreatingUser;

    @Column(name="ID_MOD_USER")
    private Long idModUser;

    @Column(name="CREATING_DATE")
    private Date creatingDate;

    @Column(name="MODIFICATION_DATE")
    private Date modificationDate;

    @Column(length = 50)
    private String title;

    @Column (length = 4000)
    private String desccription;

    @Column(name="PERMISSION_ID")
    private Long permissionId;

    @ManyToOne
    @JoinColumn(name="TrolloUser_id")
  //  @Column(name="USER_ID")
    private TrolloUsers trolloUsers;

    private Long spot;

    public TrolloBoard(Long permissionId, Long idCreatingUser, Long idModUser, Date creatingDate, Date modificationDate, String title, String desccription, TrolloUsers trolloUsers, Long spot) {
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

    public Long getIdCreatingUser() {
        return idCreatingUser;
    }

    public void setIdCreatingUser(Long idCreatingUser) {
        this.idCreatingUser = idCreatingUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdModUser() {
        return idModUser;
    }

    public void setIdModUser(Long idModUser) {
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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }


    public Long getSpot() {
        return spot;
    }

    public void setSpot(Long spot) {
        this.spot = spot;
    }

    public TrolloUsers getTrolloUsers() {
        return trolloUsers;
    }

    public void setTrolloUsers(TrolloUsers trolloUsers) {
        this.trolloUsers = trolloUsers;
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
