import java.util.Random;
public class Terninger{
    private Random rand = new Random();
    private int terning1, terning2;

    public int kast(){
        terning1 = rand.nextInt(6)+1;
        terning2 = rand.nextInt(6)+1;
return getSum();

    }
public int getSum(){
    return terning1 + terning2;
}
public String toString(){
    return "Terningerne viser " + terning1 + " og " + terning2; 
}
}