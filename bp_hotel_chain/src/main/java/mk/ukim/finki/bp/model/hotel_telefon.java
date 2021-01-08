package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(hotel_telefon_id.class)
public class hotel_telefon implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private hotel hotel;

    @Id
    private String hotel_telefon;

    public hotel_telefon(){}
}
