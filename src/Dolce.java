//classe figlia
public class Dolce extends Prodotti{
    /* 
        COSTRUTTORE
                            */
    public Dolce(String codice, String descrizione, int quantita, double prezzo){
        super(codice, descrizione, "Dolce", quantita, prezzo); //chiamata costruttore classe padre
    }
}