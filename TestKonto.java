public class TestKonto {
    public static void main(String[] args) {

        Konto konto = new Konto(1000);

        konto.indsæt(500);

        konto.hæv(300);

        konto.hæv(1500);

        if (konto.getBalance() > 0) {
            System.out.println("Test bestået: Saldoen er ikke negativ.");
        } else {
            System.out.println("Test fejlet: Saldoen er negativ.");
        }

    konto.indsæt(300);

        konto.hæv(900);

        konto.hæv(1500);

        konto.indsæt(2000);

        konto.hæv(3000);

        if (konto.getBalance() > 0) {
            System.out.println("Test bestået: Saldoen er ikke negativ.");
        } else {
            System.out.println("Test fejlet: Saldoen er negativ.");
        }

    }
}



