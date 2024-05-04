package ru.fullstackguy.hibdemo.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private GroupEntity group;

    @OneToOne(cascade = CascadeType.ALL)
    private PassportEntity passport;

    public void setPassport(PassportEntity passport) {
        this.passport = passport;
        passport.setStudent(this);
    }
}
