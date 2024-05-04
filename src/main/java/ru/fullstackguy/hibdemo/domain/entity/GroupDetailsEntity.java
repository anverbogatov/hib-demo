package ru.fullstackguy.hibdemo.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "group_details")
public class GroupDetailsEntity {

    @Id
    private long id;

    private String telegramChannel;

    @MapsId
    @OneToOne
    private GroupEntity group;
}
