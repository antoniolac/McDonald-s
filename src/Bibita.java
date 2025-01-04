//classe figlia
public class Bibita extends Prodotti{
    /* 
        COSTRUTTORE
                            */
    public Bibita(String codice, String descrizione, int quantita, double prezzo){
        super(codice, descrizione, "Bibita", quantita, prezzo); //chiamata costruttore classe padre
    }

    /* 
        METODI OVERLOADING
                            */
    @Override
    public String toString() {
        return super.toString();
    }
}