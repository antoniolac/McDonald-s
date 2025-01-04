import java.util.Scanner; //libreria per l'input
public class McDonalds {
    /* 
        ATTRIBUTI
                    */
    private static final int MAX = 30;
    private Prodotti[] totem = new Prodotti[MAX];  // Inizializzazione dell'array


    /* 
        COSTRUTTORI
                    */
    public McDonalds() {
        // Costruttore di default
    }
    public McDonalds(Prodotti[] pDati) {
        for (int i = 0; i < pDati.length; i++) {  // Corretto il ciclo for
            this.totem[i] = pDati[i];
        }
    }

    /* 
        GETTERS AND SETTERS
                            */
    public Prodotti[] getTotem() {
        return totem;
    }

    /* 
        METODI
                    */

    //metodo che gestisce i clienti del Mc
    public void gestioneClienti(){
        //creazione oggetto per l'input
        Scanner sc = new Scanner(System.in); 
        String scelta;//input
        do {
            System.out.println("C'è un cliente? [S/N]:");
            scelta = sc.nextLine().toLowerCase();
            //gestione risposta
            switch(scelta){
                
                case "s"://se c'è un cliente
                    System.out.println("Benvenuto al McDonald's! questo è il nostro menù:");
                    stampaTotem(); //stampa del menù
                    System.out.println("\nCosa vuoi ordinare? digita il codice dei prodotti");
                    System.out.println("Digita 0 per terminare, puoi acquistare massimo 15 prodotti");
                    String[] cProdotto = new String[15];//carello acquisti
                    boolean flag = false;//flag di uscita
                    int i = 0;//contatore
                    //ciclo inserimento prodotti nel carrello
                    while(!flag && i<cProdotto.length){
                        cProdotto[i] = sc.nextLine().toUpperCase();
                        //controllo inserimento
                        if (cProdotto[i].equals("0")) {
                            flag = true;//uscita ciclo
                        } else if (myRicerca(cProdotto[i])) {
                            System.out.println("Prodotto aggiunto all'ordine.");
                            i++;
                        } else {
                            System.out.println("Il prodotto non esiste, riprova.");
                        }
                    }
                    acquista(cProdotto);//acquisto dei prodotti scelti
                    break;

                case "n"://uscita programma se non ci sono altri clienti
                    System.out.println("exit");
                    break;

                default://errore inserimento
                    System.out.println("errore");
                    break;
            }
        } while (!scelta.equals("n")); //iterazione per la gestione dei clienti
        
        sc.close(); //chiusura scanner

    }

    //metodo che stampa il menù
    public void stampaTotem() {
        Prodotti[] array = getTotem();  // Non serve dichiararlo private
        for (Prodotti elemento : array) {
            if (elemento != null) {
                System.out.println(elemento);
            }
        }
    }
    //metodo di myRicerca 
    public boolean myRicerca(String codicemyRicerca) {
        for (Prodotti prodotto : totem) {
            if (prodotto != null && prodotto.getCodice().equals(codicemyRicerca)) {
                return true; 
            }
        }
        return false; 
    }

    //metodo che gestisce l'acquisto dei prodotti
    public void acquista(String[] pCodice) {
        // Implementazione del metodo acquista
    }
}


