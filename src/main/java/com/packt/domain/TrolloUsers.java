package com.packt.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by WP on 17.04.2016.
 */
@Entity
@Table(name="Trollo_Users")
public class TrolloUsers {// nie mozna utworzyc encji o nazwie User
    @Id
    @GeneratedValue
    @Column(name="ID_USER")
    private long id;

    @Column(name = "CREATING_DATE")
    private java.sql.Date creatingDate;

    @Column(name = "MODIFICATION_DATE")
    private java.sql.Date modificationDate;

    @Column(name = "ID_CREATING_USER")
    private int idCreatingUser;

    @Column(name = "ID_MOD_USER")
    private int idModUser;
    @Column(length = 50 )
    private String name; // varchar2(50)
    @Column(length = 50)
    private String password;
    @Column(length = 150)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trolloUsers", cascade = CascadeType.ALL)
    private Set<TrolloBoard> trolloBoards = new HashSet<TrolloBoard>(0);

    public TrolloUsers(Date creatingDate, Date modificationDate, int idCreatingUser, int idModUser, String name, String password, String email) {
        this.creatingDate = creatingDate;
        this.modificationDate = modificationDate;
        this.idCreatingUser = idCreatingUser;
        this.idModUser = idModUser;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public TrolloUsers() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getIdCreatingUser() {
        return idCreatingUser;
    }

    public void setIdCreatingUser(int idCreatingUser) {
        this.idCreatingUser = idCreatingUser;
    }

    public int getIdModUser() {
        return idModUser;
    }

    public void setIdModUser(int idModUser) {
        this.idModUser = idModUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<TrolloBoard> getTrolloBoards() {
        return trolloBoards;
    }

    public void setTrolloBoards(Set<TrolloBoard> trolloBoards) {
        this.trolloBoards = trolloBoards;
    }

    @Override
    public String toString() {
        return "Trollo_users{" +
                "id=" + id +
                ", creatingDate=" + creatingDate +
                ", modificationDate=" + modificationDate +
                ", idCreatingUser=" + idCreatingUser +
                ", idModUser=" + idModUser +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
