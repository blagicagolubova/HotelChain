package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.*;



@Data
@Entity
//@IdClass(ocenuva_id.class)
public class ocenuva /*implements Serializable*/ {
    @EmbeddedId
    private ocenuvaId ocenuvaId;
    /* @Id
    @ManyToOne
    @JoinColumn(name = "gostin_embg")
    private gostin gostin;

    @Id
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private hotel hotel;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rezervacija_id")
    private rezervacija rezervacija;*/

    private String komentar;

    private int ocenka;

    public ocenuva(){}


    public ocenuva(ocenuvaId ocenuvaId, int ocenka, String komentar) {
        this.ocenuvaId=ocenuvaId;
        this.ocenka = ocenka;
        this.komentar = komentar;
    }



}
