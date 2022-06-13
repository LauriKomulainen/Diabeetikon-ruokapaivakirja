//ruokailutapahtumaluokka. Toinen osa harjoitustyöstä. 

package sovellusdiabeetikolle;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.swing.JTextArea;

/**
 * Luokka toteuttaa ruokailutapahtuman, jolla on paivamaara, kello, ruoka sekä
 * juoma parametrit.
 *
 * @author kapteeni
 * @version 1.0 2022/03/14
 */
public class Ruokailutapahtuma implements Serializable {

    /**
     * paivamaara merkkijonona.
     */
    private String paivamaara;
    /**
     * kello merkkijonona.
     */
    private String kello;
    /**
     * ruoka merkkijonona.
     */
    private String ruoka;
    /**
     * juoma merkkijonona.
     */
    private String juoma;

    
    /**
     * .
     * @param paivamaara String paivamaara
     * @param kello String kello
     * @param ruoka Sting ruoka
     * @param juoma String juoma
     */
    public Ruokailutapahtuma (String paivamaara, String kello, String ruoka, String juoma) {
        this.paivamaara = paivamaara;
        this.kello = kello;
        this.ruoka = ruoka;
        this.juoma = juoma;
    }

    /**
     * palauttaa paivamaaran
     * @return the paivamaara
     */
    public String getPaivamaara() {
        return paivamaara;
    }

    /**
     * Asettaa paivamaaran
     * @param paivamaara
     */
    public void setPaivamaara(String paivamaara) {
        this.paivamaara = paivamaara;
    }

    /**
     * palauttaa kellonajan
     * @return the kello
     */
    public String getKello() {
        return kello;
    }

    /**
     * Asettaa kellon
     * @param kello
     */
    public void setKello(String kello) {
        this.kello = kello;
    }

    /**
     * palauttaa ruuan
     * @return the ruoka
     */
    public String getRuoka() {
        return ruoka;
    }

    /**
     * Asettaa ruuan
     * @param ruoka
     */
    public void setRuoka(String ruoka) {
        this.ruoka = ruoka;
    }

    /**
     * Palauttaa juoman
     * @return the juoma
     */
    public String getJuoma() {
        return juoma;
    }

    /**
     * Asettaa juoman
     * @param juoma
     */
    public void setJuoma(String juoma) {
        this.juoma = juoma;
    }

}
