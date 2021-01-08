package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(gostin_telefon_id.class)
public class gostin_telefon implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "gostin_embg")
    private gostin gostin;

    @Id
    private String gostin_telefon;

    public gostin_telefon(){
    }
}
