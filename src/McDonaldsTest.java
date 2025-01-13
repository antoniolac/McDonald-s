public class McDonaldsTest {
    /*
         PROGRAMMA PRINCIPALE
                                */
    public static void main(String[] args) {
        //caricamento dati test
        Prodotti[] dati = caricaDati();
        //creazione oggetto McDonald's
        McDonalds mc = new McDonalds(dati);
        //chiamata al metodo
        mc.gestioneClienti();
    }
    //metodo caricaDati
    public static Prodotti[] caricaDati() {
        Prodotti[] prodotto = new Prodotti[11];
        prodotto[0] = new Panino("P001", "McChicken", 10, 5.00);
        prodotto[1] = new Panino("P002", "Hamburger", 15, 3.50);
        prodotto[2] = new Panino("P003", "Cheeseburger", 12, 4.00);
        prodotto[3] = new Panino("P004", "Gustoso", 8, 5.50);
        prodotto[4] = new Bibita("B001", "CocaCola", 20, 1.50);
        prodotto[5] = new Bibita("B002", "Acqua", 30, 1.00);
        prodotto[6] = new Bibita("B003", "Aranciata", 15, 2.00);
        prodotto[7] = new Dolce("D001", "Milkshake", 5, 3.00);
        prodotto[8] = new Dolce("D002", "Crostata", 10, 2.50);
        prodotto[9] = new Dolce("D003", "Gelato", 20, 2.00);
        prodotto[10] = new Dolce("D004", "Pancake", 15, 2.00);
        return prodotto;
    }

}

