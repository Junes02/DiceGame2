public class Spiller {
    private String navn;
    private Konto konto;

    public Spiller(String navn, int startBalance) {
        this.navn = navn;
        this.konto = new Konto(startBalance);
    }

    public String getNavn() {
        return navn;
    }

    public Konto getKonto() {
        return konto;
    }

    @Override
    public String toString() {
        return "Spiller: " + navn + ", " + konto;
    }
}
