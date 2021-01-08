package mk.ukim.finki.bp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class grad {

    @Id
    private int postenski_kod;

    private String ime_grad;

    public grad(){}

    public grad(int postenski_kod, String ime_grad) {
        this.postenski_kod = postenski_kod;
        this.ime_grad = ime_grad;
    }
}
