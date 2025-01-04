public class Bibita extends Prodotti{
    public Bibita(String codice, String descrizione, int quantita, double prezzo){
        super(codice, descrizione, "Bibita", quantita, prezzo);
    }
    @Override
    public String toString() {
        return super.toString();  // Utilizza il toString della classe base, oppure personalizzalo
    }
}