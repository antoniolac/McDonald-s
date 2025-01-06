import java.util.Scanner; //libreria per l'input
public class McDonalds {
    /* 
        ATTRIBUTI
                    */
    private static final int MAX = 30;
    private Prodotti[] totem = new Prodotti[MAX];  
    

    /* 
        COSTRUTTORI
                    */
    public McDonalds() {
        // Costruttore di default
    }
    public McDonalds(Prodotti[] pDati) {
        for (int i = 0; i < pDati.length; i++) {
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
        String scelta; //input
        do {
            System.out.println("\nC'è un cliente? [S/N]:");
            scelta = sc.nextLine().toLowerCase();
    
            //gestione risposta
            switch (scelta) {
    
                case "s": //se c'è un cliente
                    System.out.println("Benvenuto al McDonald's! Questo è il nostro menù:");
                    stampaTotem(); //stampa del menù
                    cliente();
                    break;
    
                case "n": //uscita programma se non ci sono altri clienti
                    System.out.println("\nGiornata conclusa, chiusura McDonald's");
                    break;
    
                default: //errore inserimento
                    System.out.println("\nErrore, inserisci l'input corretto");
                    break;
            }
        } while (!scelta.equals("n")); //iterazione per la gestione dei clienti
    
        sc.close(); //chiusura scanner
    }
    
    //METODO CHE GESTISCE L'ORDINE DEL CLIENTE
    public void cliente() {
        System.out.println("\nCosa vuoi ordinare? Digita il codice dei prodotti");
        System.out.println("Puoi acquistare massimo 15 prodotti, digita 0 per terminare");
        String[] cProdotto = new String[15]; //carrello acquisti
        int[] quantitàProdotto = new int[15]; //array per le quantità
        boolean flag = false; //flag di uscita
        int i = 0; //contatore

        //ciclo inserimento prodotti nel carrello
        while (!flag && i < cProdotto.length) {
            System.out.print("Inserisci il codice del prodotto: ");
            cProdotto[i] = sc.nextLine().toUpperCase();

            // controllo inserimento
            if (cProdotto[i].equals("0")) {
                flag = true; //uscita ciclo
            } 
            else if (myRicerca(cProdotto[i])) {
                //quantità
                boolean quantitàV = false;
                int quantità = 0;
                while (!quantitàV) {
                    System.out.print("Quante unità vuoi acquistare? ");
                    if (sc.hasNextInt()) {
                        quantità = sc.nextInt();
                        sc.nextLine(); // Consuma il newline lasciato da nextInt()
                        if (quantità > 0) {
                            quantitàV = true; 
                        } else {
                            System.out.println("La quantità deve essere maggiore di 0. Riprova.");
                        }
                    } else {
                        System.out.println("Per favore, inserisci un numero valido.");
                        sc.nextLine(); //Consuma l'input non valido
                    }
                }

                //verifica disponibilità
                for (Prodotti prodotto : totem) {
                    if (prodotto != null && prodotto.getCodice().equals(cProdotto[i])) {
                        if (quantità <= prodotto.getQuantità() && quantità > 0) {
                            prodotto.riduciQuantità(quantità); //aggiorna le rimanenze
                            quantitàProdotto[i] = quantità;
                            System.out.println("Prodotto aggiunto all'ordine.");
                        }
                        else {
                            System.out.println("Quantità non disponibile. riprova.");
                        }
                    }
                }
                i++;
            }
            else {
                System.out.println("Il prodotto non esiste, riprova.");
            }
        }

        acquista(cProdotto, quantitàProdotto); //acquisto dei prodotti scelti        
    }


    //METODO CHE STAMPA IL MENU'
    public void stampaTotem() {
        Prodotti[] array = getTotem();  
        for (Prodotti elemento : array) {
            if (elemento != null) {
                System.out.println(elemento);
            }
        }
    }

    //METODO DI RICERCA
    public boolean myRicerca(String codice) {
        for (Prodotti prodotto : totem) {
            if (prodotto != null && prodotto.getCodice().equals(codice)) {
                return true; 
            }
        }
        return false; 
    }

    //METODO PER L'ACQUISTO DI PRODOTTI
    public void acquista(String[] pCodice, int[] pQuantità) {
        double totale = 0.0; // Totale del costo dei prodotti
    
        // Calcolo del totale
        for (int i = 0; i < pCodice.length; i++) {
            if (pCodice[i] != null && !pCodice[i].equals("0")) {
                for (Prodotti prodotto : totem) {
                    if (prodotto != null && prodotto.getCodice().equals(pCodice[i])) {
                        totale += prodotto.getPrezzo() * pQuantità[i]; 
                    }
                }
            }
        }
    
        System.out.printf("\nIl totale del tuo ordine è: %.2f euro.\n", totale);
    
        //gestione del pagamento
        double importo = 0.0;
        boolean pagamentoV = false;
    
        while (!pagamentoV) {
            System.out.print("Inserisci importo (euro): ");
            if (sc.hasNextDouble()) {
                double pagamento = sc.nextDouble();
    
                if (pagamento > 0) {
                    importo += pagamento;
                    if (importo >= totale) {
                        pagamentoV = true;
                    }
                    else {
                        System.out.printf("Hai inserito %.2f euro. Mancano ancora %.2f euro.\n",
                        importo, totale - importo);
                    }
                }
                else {
                    System.out.println("Devi inserire un importo maggiore di 0. Riprova.");
                }
            } 
            else {
                System.out.println("Errore: inserisci un importo valido.");
                sc.next(); //Consuma l'input errato
            }

            sc.nextLine(); //Consuma il newline lasciato da nextDouble()
        }
    
        //calcolo del resto
        double resto = importo - totale;
        if (resto > 0) {
            System.out.printf("Grazie per l'acquisto! Il tuo resto è: %.2f euro.\n", resto);
        }
        else {
            System.out.println("Grazie per l'acquisto!");
        }
    }
} 