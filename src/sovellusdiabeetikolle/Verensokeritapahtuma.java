//verensokeritapahtumaluokka. Kolmas osa harjoitustyöstä. 

package sovellusdiabeetikolle;

import java.io.Serializable;

/**
 * Luokka toteuttaa verensokeritapahtuman, jolla on paivamaara, kello,
 * ekaverensokeri sekä toinenverensokeri parametrit.
 *
 * @author kapteeni
 * @version 1.0 2022/03/14
 */
public class Verensokeritapahtuma implements Serializable {

    /**
     * paivamaara merkkijonona
     */
    private String paivamaara1;
    /**
     * kello merkkijonona
     */
    private String kello1;
    /**
     * ekaverensokeri desimaaliluku
     */
    private double ekaverensokeri;
    /**
     * tokaverensokeri desimaaliluku
     */
    private double tokaverensokeri;

    /**
     * .
     * @param paivamaara1 String paivamaara1
     * @param kello1 String kello1
     * @param ekaverensokeri double ekaverensokeri
     * @param tokaverensokeri double tokaverensokeri
     */
    public Verensokeritapahtuma(String paivamaara1, String kello1, double ekaverensokeri, double tokaverensokeri) {
        this.paivamaara1 = paivamaara1;
        this.kello1 = kello1;
        this.ekaverensokeri = ekaverensokeri;
        this.tokaverensokeri = tokaverensokeri;

    }

    /**
     * palauttaa paivamaaran
     *
     * @return the paivamaara1
     */
    public String getPaivamaara1() {
        return paivamaara1;
    }

    /**
     * Asettaa päivämäärän
     *
     * @param paivamaara1
     */
    public void setPaivamaara1(String paivamaara1) {
        this.paivamaara1 = paivamaara1;
    }

    /**
     * Palauttaa kellonajan
     *
     * @return the kello1
     */
    public String getKello1() {
        return kello1;
    }

    /**
     * Asettaa kellonajan
     *
     * @param kello1
     */
    public void setKello1(String kello1) {
        this.kello1 = kello1;
    }

    /**
     * palauttaa ensimmäisen verensokeriarvon
     *
     * @return the ekaverensokeri
     */
    public double getEkaverensokeri() {
        return ekaverensokeri;
    }

    /**
     * Asettaa ensimmäisen verensokeriarvon
     *
     * @param ekaverensokeri
     */
    public void setEkaverensokeri(double ekaverensokeri) {
        this.ekaverensokeri = ekaverensokeri;
    }

    /**
     * Palauttaa toisen verensokeriarvon
     *
     * @return the tokaverensokeri
     */
    public double getTokaverensokeri() {
        return tokaverensokeri;
    }

    /**
     * Asettaa toisen verensokeriarvon
     *
     * @param tokaverensokeri
     */
    public void setTokaverensokeri(double tokaverensokeri) {
        this.tokaverensokeri = tokaverensokeri;
    }

}
