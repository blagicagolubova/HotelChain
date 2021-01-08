package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ocenuvaId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "gostin_embg")
    private gostin gostin;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private hotel hotel;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rezervacija_id")
    private rezervacija rezervacija;

    public ocenuvaId(){}

    public ocenuvaId(mk.ukim.finki.bp.model.gostin gostin, mk.ukim.finki.bp.model.hotel hotel, mk.ukim.finki.bp.model.rezervacija rezervacija) {
        this.gostin = gostin;
        this.hotel = hotel;
        this.rezervacija = rezervacija;
    }
}
