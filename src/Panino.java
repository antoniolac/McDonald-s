public class Panino extends Prodotti{
    public Panino(String codice, String descrizione, int quantita, double prezzo){
        super(codice, descrizione, "Panino", quantita, prezzo);
    }
    @Override
    public String toString() {
        return super.toString();  // Utilizza il toString della classe base, oppure personalizzalo
    }
}