package tn.esprit.rh.achat.tdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Produit;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockTDO {

    private Long idStock;
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;
    private Set<Produit> produits;
    public StockTDO(String libelleStock, Integer qte, Integer qteMin) {
        super();
        this.libelleStock = libelleStock;
        this.qte = qte;
        this.qteMin = qteMin;
    }
}
