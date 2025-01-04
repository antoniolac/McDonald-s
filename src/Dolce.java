public class Dolce extends Prodotti{
    public Dolce(String codice, String descrizione, int quantita, double prezzo){
        super(codice, descrizione, "Dolce", quantita, prezzo);
    }
    @Override
    public String toString() {
        return super.toString();  // Utilizza il toString della classe base, oppure personalizzalo
    }
}