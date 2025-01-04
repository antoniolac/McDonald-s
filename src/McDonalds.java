public class McDonalds {
    // Attributi
    private static final int MAX = 30;
    private Prodotti[] totem = new Prodotti[MAX];  // Inizializzazione dell'array

    // Costruttori
    public McDonalds() {
        // Costruttore di default
    }

    public McDonalds(Prodotti[] pDati) {
        for (int i = 0; i < pDati.length; i++) {  // Corretto il ciclo for
            this.totem[i] = pDati[i];
        }
    }

    // Getter e setter
    public Prodotti[] getTotem() {
        return totem;
    }

    // Metodi
    public void stampaTotem() {
        Prodotti[] array = getTotem();  // Non serve dichiararlo private
        for (Prodotti elemento : array) {
            if (elemento != null) {
                System.out.println(elemento);
            }
        }
    }

    public boolean ricerca(String codiceRicerca) {
        for (Prodotti prodotto : totem) {
            if (prodotto != null && prodotto.getCodice().equals(codiceRicerca)) {
                return true; 
            }
        }
        return false; 
    }


    public void acquista(String[] pCodice) {
        // Implementazione del metodo acquista
    }
}

