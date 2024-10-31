import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Spil {

    private Spiller spiller1;
    private Spiller spiller2;
    private boolean spiller1tur = true;
    private boolean ekstraTur = false;
    private Terninger terning = new Terninger();

    // Felter og deres effekter på spillerens balance
    private static final Map<Integer, String> felterBeskeder = new HashMap<>();
    private static final Map<Integer, Integer> felterEffekter = new HashMap<>();

    // Constructor til at initialisere spillerne og felterne
    public Spil() {
        spiller1 = new Spiller("Spiller 1", 1000);
        spiller2 = new Spiller("Spiller 2", 1000);
        opretFelter();
    }

    // Initialisering af felter med beskeder og effekter
    private void opretFelter() {
        felterBeskeder.put(2, "Tower: Du klatrer op i tårnet og finder 250 guldmønter!");
        felterEffekter.put(2, 250);
        
        felterBeskeder.put(3, "Crater: Du falder i et krater og mister 100 guldmønter!");
        felterEffekter.put(3, -100);
        
        felterBeskeder.put(4, "Palace Gates: Du besøger paladsets porte og får 100 guldmønter.");
        felterEffekter.put(4, 100);
        
        felterBeskeder.put(5, "Cold Desert: Det er koldt, og du mister 20 guldmønter.");
        felterEffekter.put(5, -20);
        
        felterBeskeder.put(6, "Walled City: Byen byder dig velkommen med 180 guldmønter.");
        felterEffekter.put(6, 180);
        
        felterBeskeder.put(7, "Monastery: Du besøger et kloster, men der sker intet.");
        felterEffekter.put(7, 0);
        
        felterBeskeder.put(8, "Black Cave: En mørk hule! Du mister 70 guldmønter.");
        felterEffekter.put(8, -70);
        
        felterBeskeder.put(9, "Huts in the Mountain: Du hviler og finder 60 guldmønter.");
        felterEffekter.put(9, 60);
        
        felterBeskeder.put(10, "The Werewall: Du mister 80 guldmønter men får en ekstra tur.");
        felterEffekter.put(10, -80);
        
        felterBeskeder.put(11, "The Pit: Du falder i et hul og mister 50 guldmønter.");
        felterEffekter.put(11, -50);
        
        felterBeskeder.put(12, "Goldmine: Du finder en guldmine og får 650 guldmønter!");
        felterEffekter.put(12, 650);
    }

    public void spillet() {
        var scanner = new Scanner(System.in);

        while (true) {
            Spiller aktivSpiller = spiller1tur ? spiller1 : spiller2;
            System.out.println(aktivSpiller.getNavn() + ", det er din tur.");

            int sum = terning.kast();
            System.out.println(terning);
            System.out.println(felterBeskeder.get(sum));

            int effekt = felterEffekter.getOrDefault(sum, 0);

            // Tjek om spiller lander på Werewall for ekstra tur
            if (sum == 10) {
                ekstraTur = true;
            } else {
                ekstraTur = false;
            }

            // Opdater spillerens balance
            if (effekt > 0) {
                aktivSpiller.getKonto().indsæt(effekt);
            } else {
                aktivSpiller.getKonto().hæv(-effekt);  // Effekt er negativ, så hæv beløbet
            }

            System.out.println("Ny balance for " + aktivSpiller.getNavn() + ": " + aktivSpiller.getKonto().getBalance());

            // Tjek om spiller har vundet
            if (aktivSpiller.getKonto().getBalance() >= 3000) {
                System.out.println(aktivSpiller.getNavn() + " har nået 3000 guldmønter og vinder spillet!");
                break;
            }

            // Skift tur, medmindre spilleren har ekstra tur
            if (!ekstraTur) {
                spiller1tur = !spiller1tur;
            }

            System.out.println("Tryk enter for at kaste terningerne.");
            scanner.nextLine();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Spil().spillet();
    }
}
