//classe padre
public abstract class Prodotti{
    /* 
        ATTRIBUTI PROTETTI
                            */
    protected String codice;
    protected String descrizione;
    protected String categoria;
    protected int quantita;
    protected double prezzo;

    /* 
        COSTRUTTORI
                    */
    public Prodotti(String pCodice, String pDescrizione, String pCategoria, int pQuantita, double pPrezzo) {
        this.codice = pCodice;
        this.descrizione = pDescrizione;
        this.categoria = pCategoria;
        this.quantita = pQuantita;
        this.prezzo = pPrezzo;
    }

    /* 
        GETTERS AND SETTERS 
                            */
    public String getCodice() {
        return codice;
    }

    /* 
        METODI ASTRATTI
                        */
    @Override
    public String toString() {
        return "Codice: " + codice + ", Descrizione: " + descrizione + ", Categoria: " + categoria
                + ", Quantità: " + quantita + ", Prezzo: " + prezzo;
    }
}