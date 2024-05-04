package ru.fullstackguy.hibdemo.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String number;

    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private GroupDetailsEntity details;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<StudentEntity> students;

    public void setDetails(GroupDetailsEntity details) {
        this.details = details;
        details.setGroup(this);
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
        students.forEach(el -> el.setGroup(this));
    }
}
