import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Yritysrekisteri {
    ArrayList<Yritys> yritysrekisteri;
    
    public Yritysrekisteri() {
        yritysrekisteri = new ArrayList<>();
    }
    
    public void lisaa(String nimi, String toimitusjohtaja, String osoite, int puhelinnumero, double liikevaihto) {
        this.yritysrekisteri.add(new Yritys(nimi, toimitusjohtaja, osoite, puhelinnumero, liikevaihto));
    }
    
    public void listaa() {
        
        for (Yritys yritys: yritysrekisteri) {
            System.out.println(yritys.getNimi());
        }
    }
    
    public boolean onkoSamaNimi(String nimi) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                return true;
            }
        }
        
        return false;
    }
    
    public String etsi(String nimi) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                return yritys.toString();
            }
        }
        
        return null;
    }
    
    public boolean poista(String nimi) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                this.yritysrekisteri.remove(yritys);
                return true;
            }
        }
        
        return false;
    }
    
    public void uusiNimi(String nimi, String uusiNimi) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                yritys.setNimi(uusiNimi);
            }
        }
    }
    
    public void uusiToimitusjohtaja(String nimi, String uusiToimitusjohtaja) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                yritys.setToimitusjohtaja(uusiToimitusjohtaja);
            }
        }
    }
    
    public void uusiOsoite(String nimi, String uusiOsoite) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                yritys.setOsoite(uusiOsoite);
            }
        }
    }
    
    public void uusiPuhelinnumero(String nimi, int uusiPuhelinnumero) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                yritys.setPuhelinnumero(uusiPuhelinnumero);
            }
        }
    }
    
    public void uusiLiikevaihto(String nimi, double uusiLiikevaihto) {
        
        for (Yritys yritys: yritysrekisteri) {
            
            if (yritys.getNimi().equals(nimi)) {
                yritys.setLiikevaihto(uusiLiikevaihto);
            }
        }
    }
    
    public void tallennaTiedostoon(String tiedostonNimi) {
        try {
            FileOutputStream f = new FileOutputStream(new File(tiedostonNimi));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(this.yritysrekisteri);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
    
    public void lueTiedostosta(String tiedostonNimi) {
        try {
            FileInputStream fi = new FileInputStream(new File(tiedostonNimi));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            this.yritysrekisteri = (ArrayList) oi.readObject();

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
