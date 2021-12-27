package com.raf.sk.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 50, unique = true, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String ime;
    @Column(length = 20, nullable = false)
    private String prezime;
    @Column(nullable = false)
    private int kontakt;
    @Column(nullable = false)
    private Date dateOfBirth;
    @ManyToOne(optional = false)
    private Role role;
    @ManyToOne(optional = true)
    private Rank rank1;
    @Column(length = 10)
    private int numberOfReservations;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getKontakt() {
        return kontakt;
    }

    public void setKontakt(int kontakt) {
        this.kontakt = kontakt;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Rank getRank1() {
        return rank1;
    }

    public void setRank1(Rank rank) {
        this.rank1 = rank;
    }
}
