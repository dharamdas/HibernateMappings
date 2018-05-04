package com.hb.mapping.manytomany1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MEETING")
@Setter
@Getter
public class Meeting {

    @Id
    @Column(name = "MEETING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "MEETING_DATE")
    private Date meetingDate;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<Employee>();

    public Meeting(String subject) {
        this.subject = subject;
        this.meetingDate = new Date();
    }

}
