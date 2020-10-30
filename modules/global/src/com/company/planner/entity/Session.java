package com.company.planner.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamePattern("%s|description")
@Table(name = "PLANNER_SESSION")
@Entity(name = "planner_Session")
public class Session extends StandardEntity {
    private static final long serialVersionUID = 3271255497931152196L;

//    topic	String (255)	Yes
//    startDate	LocalDateTime	Yes
//    endDate	LocalDateTime
//    speaker	Association to “Speaker” entity, many-to-one cardinality	Yes
//    duration	Integer	Yes
//    description	String (2000)

    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPEAKER")
    private Speaker speaker;

    @Column(name = "DURATION", nullable = false)
    private Integer duration;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Transient
    @MetaProperty(related = {"startDate","duration"})
    public LocalDateTime getEndDate() {
//        return endDate;
        return (startDate != null && duration != null) ? startDate.plusHours(duration) : null;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}