import java.io.Serializable;

public class Yritys implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String nimi;
    private String toimitusjohtaja;
    private String osoite;
    private int puhelinnumero;
    private double liikevaihto;
    
    Yritys() {
    };
    
    Yritys(String nimi, String toimitusjohtaja, String osoite, int puhelinnumero, double liikevaihto) {
        this.nimi = nimi;
        this.toimitusjohtaja = toimitusjohtaja;
        this.osoite = osoite;
        this.puhelinnumero = puhelinnumero;
        this.liikevaihto = liikevaihto;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public void setNimi(String uusiNimi) {
      this.nimi = uusiNimi;  
    } 
    
    public void setToimitusjohtaja(String uusiToimitusjohtaja) {
        this.toimitusjohtaja = uusiToimitusjohtaja;
    }
    
    public void setOsoite(String uusiOsoite) {
        this.osoite = uusiOsoite;
    }
    
    public void setPuhelinnumero(int uusiPuhelinnumero) {
        this.puhelinnumero = uusiPuhelinnumero;
    }
    
    public void setLiikevaihto(double uusiLiikevaihto) {
        this.liikevaihto = uusiLiikevaihto;
    }
    
    public String toString() {
        return "Yrityksen nimi: " + this.nimi + "\n"
                + "Toimitusjohtaja: " + this.toimitusjohtaja + "\n"
                + "Pääkonttorin osoite: " + this.osoite + "\n"
                + "Puhelinnumero: " + this.puhelinnumero + "\n"
                + "Viimeisimmän tilivuoden liikevaihto: " + this.liikevaihto;
    }
}
