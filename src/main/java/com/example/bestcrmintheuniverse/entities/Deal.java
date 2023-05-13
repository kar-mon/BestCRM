package com.example.bestcrmintheuniverse.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double budget;
    private String state;
    private String name;
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "contact_point_id")
    private Person contactPoint;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Person getContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(Person contactPoint) {
        this.contactPoint = contactPoint;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
