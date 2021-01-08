package mk.ukim.finki.bp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class hotel_telefon_id implements Serializable {
    private hotel hotel;
    private String hotel_telefon;

    public hotel_telefon_id(mk.ukim.finki.bp.model.hotel hotel, String hotel_telefon) {
        this.hotel = hotel;
        this.hotel_telefon = hotel_telefon;
    }
}
