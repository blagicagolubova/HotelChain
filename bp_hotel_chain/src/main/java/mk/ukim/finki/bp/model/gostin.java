package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class gostin {
    @Id
    private String gostin_embg;

    private String gostin_ime;

    private String gostin_prezime;

    private String gostin_email;

    public gostin(){}

    public gostin(String gostin_embg, String gostin_ime, String gostin_prezime, String gostin_email) {
        this.gostin_embg = gostin_embg;
        this.gostin_ime = gostin_ime;
        this.gostin_prezime = gostin_prezime;
        this.gostin_email = gostin_email;
    }
}
