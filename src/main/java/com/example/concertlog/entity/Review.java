package com.example.concertlog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tekst recenzije je obavezan")
    private String tekst;

    @Min(value = 1, message = "Ocjena mora biti između 1 i 5")
    @Max(value = 5, message = "Ocjena mora biti između 1 i 5")
    private int ocjena;

    private LocalDate datum;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOcjena() {
        return ocjena;
    }
    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }

    public LocalDate getDatum() {
        return datum;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Concert getConcert() {
        return concert;
    }
    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
