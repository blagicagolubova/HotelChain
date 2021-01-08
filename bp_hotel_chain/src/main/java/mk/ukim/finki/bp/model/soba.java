package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class soba {
    @Id
    private int soba_id;

    private boolean dali_e_slobodna;

    private String soba_tip;

    @Column(name = "soba_broj")
    private int sobaBroj;

    private String soba_url;

    private int soba_cena;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private hotel h;

    public soba(){}
}
