package com.packt.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by WP on 17.04.2016.
 */
@Entity

public class Uzytkownik {// nie mozna utworzyc encji o nazwie User
    @Id
    @GeneratedValue
    private long id;

    private java.sql.Date creatingDate;
    private java.sql.Date modificationDate;
    private int idCreatingUser;
    private int idModUser;
    @Column(length = 50 )
    private String name; // varchar2(50)
    @Column(length = 50)
    private String password;
    @Column(length = 150)
    private String email;

    public Uzytkownik(Date creatingDate, Date modificationDate, int idCreatingUser, int idModUser, String name, String password, String email) {
        this.creatingDate = creatingDate;
        this.modificationDate = modificationDate;
        this.idCreatingUser = idCreatingUser;
        this.idModUser = idModUser;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Uzytkownik() {
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
}
