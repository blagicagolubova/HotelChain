package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
public class rezervacija {
    @Id
    private int rezervacija_id;

    private String status;

    private Date datum_odenje;

    private Date datum_doagjanje;

    private String usluga_ime;

    private int usluga_cena;

    @ManyToOne
    @JoinColumn(name = "soba_id")
    private soba soba;

    @ManyToOne
    @JoinColumn(name = "gostin_embg")
    private gostin gostin;

    public rezervacija(){}

    public rezervacija(Date datum_odenje, Date datum_doagjanje, String usluga_ime, mk.ukim.finki.bp.model.soba soba, mk.ukim.finki.bp.model.gostin gostin) {
        this.rezervacija_id =( int )( Math.random() * 9999 );
        this.status = "aktivna";
        this.datum_odenje = datum_odenje;
        this.datum_doagjanje = datum_doagjanje;
        this.usluga_ime = usluga_ime;
        if(usluga_ime.equals("breakfast included")){
            this.usluga_cena=15;
        }
        else if (usluga_ime.equals("all inclusive"))
        {
            this.usluga_cena=50;
        }
        else {
            this.usluga_cena=0;
        }
        this.soba = soba;
        this.gostin = gostin;
    }

}
