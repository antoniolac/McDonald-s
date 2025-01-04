public abstract class Prodotti{
    //attributi protetti
    protected String codice;
    protected String descrizione;
    protected String categoria;
    protected int quantita;
    protected double prezzo;

    //costruttori
    public Prodotti(String pCodice, String pDescrizione, String pCategoria, int pQuantita, double pPrezzo) {
        this.codice = pCodice;
        this.descrizione = pDescrizione;
        this.categoria = pCategoria;
        this.quantita = pQuantita;
        this.prezzo = pPrezzo;
    }

    @Override
    public String toString() {
        return "Codice: " + codice + ", Descrizione: " + descrizione + ", Categoria: " + categoria
                + ", Quantità: " + quantita + ", Prezzo: " + prezzo;
    }
}