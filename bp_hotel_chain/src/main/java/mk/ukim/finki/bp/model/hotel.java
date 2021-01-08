package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class hotel {
    @Id
    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "hotel_ime")
    private String hotelIme;

    private String hotel_adresa;

    private String hotel_url;

    @ManyToOne
    @JoinColumn(name = "postenski_kod")
    private grad g;

//    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
  //  private List<hotel_telefon> telefoni;

    public hotel(){}


}
