package com.packt.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Winiu on 23-06-2016.
 */
@Entity
public class Label {
    @Id
    @GeneratedValue
    private long id;

    private String nameLabel;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private TrolloBoard trolloBoardInLabel;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "labelInTask")
    private Set<Task> taskSet = new HashSet<Task>(0);

    public long getId() {
        return id;
    }


    public String getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(String nameLabel) {
        this.nameLabel = nameLabel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TrolloBoard getTrolloBoardInLabel() {
        return trolloBoardInLabel;
    }

    public void setTrolloBoardInLabel(TrolloBoard trolloBoardInLabel) {
        this.trolloBoardInLabel = trolloBoardInLabel;
    }

    public Set<Task> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }

    public Label(){}
    public Label(String color, String nameLabel, TrolloBoard trolloBoardInLabel) {
        this.color = color;
        this.nameLabel = nameLabel;
        this.trolloBoardInLabel = trolloBoardInLabel;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", nameLabel='" + nameLabel + '\'' +
                ", color='" + color + '\'' +
                ", trolloBoardInLabel=" + trolloBoardInLabel +
                ", taskSet=" + taskSet +
                '}';
    }
}
