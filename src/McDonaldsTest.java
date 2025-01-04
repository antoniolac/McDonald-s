import java.util.Scanner;

public class McDonaldsTest {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        //creazione McDonald's
        Prodotti[] dati = caricaDati();
        McDonalds mc = new McDonalds(dati);
        String scelta;
        do {
            System.out.println("C'è un cliente? [S/N]:");
            scelta = sc.nextLine().toLowerCase();
            switch(scelta){
                case "s":
                    mc.stampaTotem();
                    break;
                case "n":
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("errore");
                    break;
            }
        } while (!scelta.equals("n"));
        sc.close();

    }

    // Metodo caricaDati diventa statico
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
