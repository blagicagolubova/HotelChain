package mk.ukim.finki.bp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class gostin_telefon_id implements Serializable {
    private gostin gostin;
    private String gostin_telefon;

    public gostin_telefon_id(mk.ukim.finki.bp.model.gostin gostin, String gostin_telefon) {
        this.gostin = gostin;
        this.gostin_telefon = gostin_telefon;
    }
}
