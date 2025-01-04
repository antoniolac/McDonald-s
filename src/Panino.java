//classe figlia
public class Panino extends Prodotti{
    /* 
        COSTRUTTORE 
                    */
    public Panino(String codice, String descrizione, int quantita, double prezzo){
        super(codice, descrizione, "Panino", quantita, prezzo); //chiamata costruttore classe padre
    }

    /* 
        METODI OVERLOADING
                            */
    @Override
    public String toString() {
        return super.toString(); 
    }
}