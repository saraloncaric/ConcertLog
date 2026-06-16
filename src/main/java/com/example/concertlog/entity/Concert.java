package com.example.concertlog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concerts")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Izvođač je obavezan")
    private String izvodac;

    @NotBlank(message = "Grad je obavezan")
    private String grad;

    @NotBlank(message = "Mjesto je obavezno")
    private String mjesto;

    @NotBlank(message = "Žanr je obavezan")
    private String zanr;

    @NotNull(message = "Datum je obavezan")
    private LocalDate date;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public enum Status {
        PLANIRAM, BIO_SAM, PROPUSTIO;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getIzvodac() {
        return izvodac;
    }
    public void setIzvodac(String izvodac) {
        this.izvodac = izvodac;
    }

    public String getGrad() {
        return grad;
    }
    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getMjesto() {
        return mjesto;
    }
    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }

    public String getZanr() {
        return zanr;
    }
    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}
