import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private Yritysrekisteri yritysrekisteri;
    
    public Kayttoliittyma(Scanner lukija, Yritysrekisteri rekisteri) {
        this.lukija = lukija;
        this.yritysrekisteri = rekisteri;
    }
    
    public void kaynnista() {
        System.out.println("Komennot:\n"
                + "Lopeta - lopettaa ohjelman\n"
                + "Lisaa - lisää rekisteriin yrityksen\n"
                + "Listaa - listaa rekisterin yritysten nimet\n"
                + "Etsi - etsii yrityksen tiedot nimen perusteella\n"
                + "Poista - poistaa yrityksen rekisteristä \n"
                + "Muokkaa - muokkaa yrityksen tietoja \n"
                + "Tallenna - tallentaa yritysrekisterin tiedostoon \n"
                + "Lue - lukee yritysrekisterin tiedostosta");
        
        while (true) {
            System.out.println("");
            System.out.print("Anna komento: ");
            String komento = lukija.nextLine();
            
            if (komento.equals("Lopeta")) {
                break;
            }
            
            if (komento.equals("Lisaa")) {
              lisaa();  
            }
            
            if (komento.equals("Listaa")) {
                listaa();
            }
            
            if (komento.equals("Etsi")) {
                etsi();
            }
            
            if (komento.equals("Poista")) {
                poista();
            }
            
            if (komento.equals("Muokkaa")) {
                muokkaa();
            }
            
            if (komento.equals("Tallenna")) {
                tallennaTiedostoon();
            }
            
            if (komento.equals("Lue")) {
                lueTiedostosta();
            }
            
        }
    }
    
    public void lisaa() {
        System.out.print("Anna yrityksen nimi: ");
        String nimi = lukija.nextLine();
        
        if (this.yritysrekisteri.onkoSamaNimi(nimi)) {
            System.out.println("Tämän niminen yritys on jo rekisterissä");
        } else {
            System.out.print("Anna toimitusjohtajan nimi: ");
            String toimitusjohtaja = lukija.nextLine();
            System.out.print("Anna pääkonttorin osoite: ");
            String osoite = lukija.nextLine();
            System.out.print("Anna puhelinnumero: ");
            int puhelinnumero = Integer.valueOf(lukija.nextLine());
            System.out.print("Anna viimeisimmän tilivuoden liikevaihto: ");
            double liikevaihto = Double.valueOf(lukija.nextLine());
            this.yritysrekisteri.lisaa(nimi, toimitusjohtaja, osoite, puhelinnumero, liikevaihto);
        }
    }
    
    public void listaa() {
        this.yritysrekisteri.listaa();
    }
    
    public void etsi() {
        System.out.print("Mikä yritys etsitään: ");
        String nimi = lukija.nextLine();
        
        if (this.yritysrekisteri.etsi(nimi) == null) {
            System.out.println("Kyseistä yritystä ei ole rekisterissä");
        } else {
            System.out.println(this.yritysrekisteri.etsi(nimi));
        }
    }
    
    public void poista() {
        System.out.print("Mikä yritys poistetaan: ");
        String nimi = lukija.nextLine();
        
        if (!(this.yritysrekisteri.poista(nimi))) {
            System.out.println("Kyseistä yritystä ei ole rekisterissä");
        } else {
            System.out.println("Kyseinen yritys poistettu rekisteristä");
        }
    }
    
    public void muokkaa() {
        System.out.print("Mitä yritystä muokataan: ");
        String nimi = lukija.nextLine();
        
        if (this.yritysrekisteri.etsi(nimi) == null) {
            System.out.println("Kyseistä yritystä ei ole rekisterissä");
        } else {
            System.out.println("Mitä tietoa haluat muuttaa: nimi, toimitusjohtaja, osoite, puhelinnumero, liikevaihto");
            String komento = lukija.nextLine();
            
            if (komento.equals("nimi")) {
                System.out.print("Anna uusi nimi: ");
                String uusiNimi = lukija.nextLine();
                
                if (this.yritysrekisteri.onkoSamaNimi(uusiNimi)) {
                    System.out.println("Tämän niminen yritys on jo rekisterissä (tai syötit saman nimen)");
                } else {
                    this.yritysrekisteri.uusiNimi(nimi, uusiNimi);
                }
            }
            
            if (komento.equals("toimitusjohtaja")) {
                System.out.print("Anna uusi toimitusjohtaja: ");
                String uusiToimitusjohtaja = lukija.nextLine();
                this.yritysrekisteri.uusiToimitusjohtaja(nimi, uusiToimitusjohtaja);
            }
            
            if (komento.equals("osoite")) {
                System.out.println("Anna uusi osoite: ");
                String uusiOsoite = lukija.nextLine();
                this.yritysrekisteri.uusiOsoite(nimi, uusiOsoite);
            }
            
            if (komento.equals("puhelinnumero")) {
                System.out.print("Anna uusi numero: ");
                int uusiPuhelinnumero = Integer.valueOf(lukija.nextLine());
                this.yritysrekisteri.uusiPuhelinnumero(nimi, uusiPuhelinnumero);
            }
            
            if (komento.equals("liikevaihto")) {
                System.out.println("Anna uusi liikevaihto: ");
                double uusiLiikevaihto = Double.valueOf(lukija.nextLine());
                this.yritysrekisteri.uusiLiikevaihto(nimi, uusiLiikevaihto);
            }
        }
    }
    
    public void tallennaTiedostoon() {
        System.out.print("Mihin tiedostoon tallennetaan: ");
        String tiedostonNimi = lukija.nextLine();
        this.yritysrekisteri.tallennaTiedostoon(tiedostonNimi);
    }
    
    public void lueTiedostosta() {
        System.out.print("Mitä tiedostosta luetaan: ");
        String tiedostonNimi = lukija.nextLine();
        
        this.yritysrekisteri.lueTiedostosta(tiedostonNimi);
    }
}
