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

    Scanner sc = new Scanner(System.in);//scanner per gli input
    
    //metodo che gestisce i clienti del Mc
    public void gestioneClienti() {
        String scelta; // input
        do {
            System.out.println("C'è un cliente? [S/N]:");
            scelta = sc.nextLine().toLowerCase();
    
            // gestione risposta
            switch (scelta) {
    
                case "s": // se c'è un cliente
                    System.out.println("Benvenuto al McDonald's! Questo è il nostro menù:");
                    stampaTotem(); // stampa del menù
                    System.out.println("\nCosa vuoi ordinare? Digita il codice dei prodotti");
                    System.out.println("Digita 0 per terminare, puoi acquistare massimo 15 prodotti");
                    String[] cProdotto = new String[15]; // carrello acquisti
                    int[] quantitàProdotto = new int[15]; // array per le quantità
                    boolean flag = false; // flag di uscita
                    int i = 0; // contatore
    
                    // ciclo inserimento prodotti nel carrello
                    while (!flag && i < cProdotto.length) {
                        System.out.print("Inserisci il codice del prodotto: ");
                        cProdotto[i] = sc.nextLine().toUpperCase();
    
                        // controllo inserimento
                        if (cProdotto[i].equals("0")) {
                            flag = true; // uscita ciclo
                        } else if (myRicerca(cProdotto[i])) {
                            // Chiedere la quantità
                            System.out.print("Quanti pezzi desideri? ");
                            int quantità = sc.nextInt();
                            sc.nextLine(); // Consumi il newline lasciato da nextInt()
    
                            // Verifica disponibilità
                            boolean prodottoDisponibile = false;
                            for (Prodotti prodotto : totem) {
                                if (prodotto != null && prodotto.getCodice().equals(cProdotto[i])) {
                                    if (quantità <= prodotto.getQuantità()) {
                                        prodotto.riduciQuantità(quantità); // aggiorna le rimanenze
                                        prodottoDisponibile = true;
                                        quantitàProdotto[i] = quantità; // salviamo la quantità
                                        System.out.println("Prodotto aggiunto all'ordine.");
                                    } else {
                                        System.out.println("Quantità non disponibile. Riprova.");
                                    }
                                }
                            }
                            if (!prodottoDisponibile) {
                                System.out.println("Il prodotto non è disponibile o il codice è errato.");
                            }
                            i++;
                        } else {
                            System.out.println("Il prodotto non esiste, riprova.");
                        }
                    }
    
                    acquista(cProdotto, quantitàProdotto); // acquisto dei prodotti scelti
                    break;
    
                case "n": // uscita programma se non ci sono altri clienti
                    System.out.println("Exit");
                    break;
    
                default: // errore inserimento
                    System.out.println("Errore");
                    break;
            }
        } while (!scelta.equals("n")); // iterazione per la gestione dei clienti
    
        sc.close(); // chiusura scanner
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
    public void acquista(String[] pCodice, int[] pQuantità) {
        double totale = 0.0; // Totale del costo dei prodotti
    
        // Calcolo del totale
        for (int i = 0; i < pCodice.length; i++) {
            if (pCodice[i] != null && !pCodice[i].equals("0")) {
                for (Prodotti prodotto : totem) {
                    if (prodotto != null && prodotto.getCodice().equals(pCodice[i])) {
                        totale += prodotto.getPrezzo() * pQuantità[i]; // Prezzo * quantità
                    }
                }
            }
        }
    
        System.out.printf("Il totale del tuo ordine è: %.2f euro.\n", totale);
    
        // Gestione del pagamento
        double importoInserito = 0.0;
        boolean pagamentoCompletato = false;
    
        while (!pagamentoCompletato) {
            System.out.print("Inserisci il denaro (euro): ");
            if (sc.hasNextDouble()) {
                double input = sc.nextDouble();
    
                if (input > 0) {
                    importoInserito += input;
                    if (importoInserito >= totale) {
                        pagamentoCompletato = true;
                    } else {
                        System.out.printf("Hai inserito %.2f euro. Mancano ancora %.2f euro.\n",
                                importoInserito, totale - importoInserito);
                    }
                } else {
                    System.out.println("Devi inserire un importo maggiore di 0. Riprova.");
                }
            } else {
                System.out.println("Errore: inserisci un importo valido.");
                sc.next(); // Consuma l'input errato
            }
    
            // Consuma il newline lasciato da nextDouble()
            sc.nextLine(); // Importante!
        }
    
        // Calcolo del resto
        double resto = importoInserito - totale;
        if (resto > 0) {
            System.out.printf("Grazie per l'acquisto! Il tuo resto è: %.2f euro.\n", resto);
        } else {
            System.out.println("Grazie per l'acquisto!");
        }
    }
}    