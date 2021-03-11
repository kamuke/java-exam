import java.util.Scanner;

public class Paaohjelma {
    
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Yritysrekisteri yritysrekisteri = new Yritysrekisteri();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija, yritysrekisteri);
        
        kayttoliittyma.kaynnista();
    }
    
}
