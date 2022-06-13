/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package sovellusdiabeetikolle;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import static java.lang.System.console;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.swing.JTextArea;

/**
 * ruokailutapahtuma sekä verensokeritapahtuma luokan kayttoliittyma, jolla
 * voidaan tallentaa ruoka ja verensokeritapahtumia ja myöhemmin tarkastella
 * niitä.
 *
 * @author kapteeni
 * @version 1.0
 */
public class SovellusDiabeetikolle extends Application {

    /**
     * Kellonajan tekstikenttä
     */
    private final TextField tfKellonaika = new TextField();
    /**
     * Tekstikenttä, johon voi kirjoittaa päivämäärän
     */
    private final TextField tfValitsepaiva = new TextField();
    /**
     * Tekstikenttä, johon voi kirjoittaa ensimmäisen verensokeriarvon
     */
    private final TextField tfVerensokeri = new TextField();
    /**
     * Tekstikenttä, johon voi kirjoittaa toisen verensokeriarvon
     */
    private final TextField tfToinenverensokeri = new TextField();
    /**
     * Tekstikenttä, johon voi kirjoittaa syödyn ruuan
     */
    private final TextField tfRuoka = new TextField();
    /**
     * Tekstikenttä, johon voi kirjoittaa juoman jonka on juonut ruokailun
     * yhteydessä
     */
    private final TextField tfJuoma = new TextField();
    /**
     * painike, josta pystytään tallentamaan syöty ruoka tai kirjoitettu
     * verensokeri tiedostoon
     */
    private final Button btTallenna = new Button("Tallenna");
    /**
     * painike, jolla pystytään sulkemaan ikkunat
     */
    private final Button btSulje = new Button("Sulje ikkuna");
    /**
     * painike, jolla pystytään sulkemaan koko ohjelma
     */
    private final Button btSulje1 = new Button("Sulje ohjelma");
    /**
     * painike, jolla pystytään tarkastelemaan aiempia syötyjä ruokia ja
     * verensokereita
     */
    private final Button btOk = new Button("Hae tiedot");
    /**
     * painike, jolla pystytään lisämään syöty ruoka
     */
    private final Button btLisaaruoka = new Button("Lisää ruoka");
    /**
     * painike, jolla pystytään lisäämään verensokeriarvot
     */
    private final Button btLisaaverensokeri = new Button("Lisää verensokeri arvo");
    /**
     * painike, jolla pystytään aukaisemaan tarkastele verensokeri ikkuna
     */
    private final Button btTarkasteleverensokeri = new Button("Tarkastele verensokereita");
    /**
     * painike, jolla pystytään aukaisemaan tarkastele ruokapäiväkirjaa ikkuna
     */
    private final Button btTarkasteleruoka = new Button("Tarkastele ruokapäiväkirjaa");
    /**
     * Teksikenttä, johon tulostuu aiemmat ruokailut
     */
    private final TextArea tfMuistutus = new TextArea();
    /**
     * Teksikenttä, johon tulostuu aiemmat verensokerit
     */
    private final TextArea tfMuistutus1 = new TextArea();
    /**
     * Teksikenttä, johon tulostuu jos ruokailun kirjoittaminen tiedostoon
     * oonnistuu tai epäonnistuu
     */
    private final TextArea tfLisaaruokaa = new TextArea();
    /**
     * Teksikenttä, johon tulostuu jos verensokeri kirjoittaminen tiedostoon
     * oonnistuu tai epäonnistuu
     */
    private final TextArea tfLisaaverensokeri = new TextArea();

    /**
     * ruokailutapahtuman arraylist
     */
    private final ArrayList<Ruokailutapahtuma> ruokailut = new ArrayList<Ruokailutapahtuma>();
    /**
     * verensokeritapahtuman arraylist
     */
    private final ArrayList<Verensokeritapahtuma> verensokerit = new ArrayList<Verensokeritapahtuma>();

    /**
     * Ohjelmaikkunan käynnistykseen ja toiminnallisuuden määrittely
     */
    @Override
    public void start(Stage primaryStage) {

        //Tehdään HBox, johon lisätään buttonit. Nämä näkyvät etusivulla.
        HBox hbox = new HBox(15);
        hbox.setPadding(new Insets(0, 0, 0, 0));

        hbox.getChildren().add(btLisaaruoka);
        hbox.getChildren().add(btLisaaverensokeri);
        hbox.getChildren().add(btTarkasteleverensokeri);
        hbox.getChildren().add(btTarkasteleruoka);
        hbox.getChildren().add(btSulje1);

        //sijoitetaan hbox eli tässä tapauksessa buttonit vasemmalle alhaalle
        hbox.setAlignment(Pos.BOTTOM_LEFT);

        //tehdään toinen HBox johon sijoitetaan tervetulo teksti
        HBox toinenhbox = new HBox(15);
        Label uusi = new Label("Hei! Tervetuloa käyttämään ruokapäiväkirjaa." + "\n"
                + "Voit lisätä alhaalta ruokailun sekä verensokeriarvot." + "\n"
                + "Voit myös tarkastella aiemmin syöttämiä arvoja tarkastele kohdasta.");
        uusi.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        toinenhbox.getChildren().add(uusi);

        toinenhbox.setAlignment(Pos.CENTER);

        //tehdään stackpane, johon lisätään molemmat hboxit
        StackPane root = new StackPane();
        root.getChildren().addAll(toinenhbox, hbox);

        //tehdään scene
        Scene scene = new Scene(root, 700, 500);

        primaryStage.setTitle("Ruokapäiväkirja");
        primaryStage.setScene(scene);
        primaryStage.show();

        //tehdään sulje1 buttonille ominaisuus, että se sulkee pääohjelman
        btSulje1.setOnAction(e -> {
            primaryStage.close();
        });

        //lisätään toiminnallisuus lisaaverensokeri buttonille
        btLisaaverensokeri.setOnAction((ActionEvent event) -> {
            GridPane verensokeripaneeli = new GridPane();
            verensokeripaneeli.setHgap(5);
            verensokeripaneeli.setVgap(5);

            // lisätään solmut
            verensokeripaneeli.add(new Label("Päivämäärä: "), 0, 0);
            verensokeripaneeli.add(tfValitsepaiva, 1, 0);
            verensokeripaneeli.add(new Label("Kellonaika: "), 0, 2);
            verensokeripaneeli.add(tfKellonaika, 1, 2);
            verensokeripaneeli.add(new Label("Verensokeri ennen ruokaa: "), 0, 3);
            verensokeripaneeli.add(tfVerensokeri, 1, 3);
            verensokeripaneeli.add(new Label("Verensokeri 1 tunti ruokailun jälkeen: "), 0, 4);
            verensokeripaneeli.add(tfToinenverensokeri, 1, 4);
            verensokeripaneeli.add(btTallenna, 1, 5);
            verensokeripaneeli.add(btSulje, 0, 5);
            verensokeripaneeli.add(tfLisaaverensokeri, 1, 6);

            tfLisaaverensokeri.setPrefHeight(25);
            tfLisaaverensokeri.setPrefWidth(200);

            verensokeripaneeli.setAlignment(Pos.CENTER);

            StackPane kolmasikkuna = new StackPane();

            kolmasikkuna.getChildren().addAll(verensokeripaneeli);

            Scene uusiScene = new Scene(kolmasikkuna, 500, 300);

            // uusi ikkuna
            Stage verensokeriIkkuna = new Stage();
            verensokeriIkkuna.setTitle("Lisää verensokeri");
            verensokeriIkkuna.setScene(uusiScene);

            verensokeriIkkuna.show();

            btTallenna.setOnAction(e -> {
                talletaVerensokeri();
            });

            btSulje.setOnAction(e -> {
                verensokeriIkkuna.close();
            });
        });

        //lisätään toiminnallisuus tarkasteleVerensokeri buttonille
        btTarkasteleverensokeri.setOnAction((ActionEvent event) -> {
            GridPane paneeli = new GridPane();
            paneeli.setHgap(5);
            paneeli.setVgap(5);
            paneeli.add(tfMuistutus1, 1, 3);
            paneeli.add(btSulje, 0, 4);
            paneeli.add(btOk, 1, 4);

            //Tähän tulostuu käyttäjän syöttämä verensokeriarvo, johon ei pystytä tekemään muokkauksia. 
            tfMuistutus1.setEditable(false);

            paneeli.setAlignment(Pos.TOP_CENTER);

            StackPane neljasikkuna = new StackPane();

            neljasikkuna.getChildren().addAll(paneeli);

            Scene secondScene = new Scene(neljasikkuna, 600, 400);

            // uusi ikkuna
            Stage uusiIkkuna = new Stage();
            uusiIkkuna.setTitle("Täältä voit tarkastella aiemmipia verensokereita");
            uusiIkkuna.setScene(secondScene);

            uusiIkkuna.show();

            btOk.setOnAction(e -> {
                haeVerensokeri();
            });

            btSulje.setOnAction(e -> {
                uusiIkkuna.close();
            });
        });
        //lisätään toiminnallisuus tarkasteleRuoka buttonille
        btTarkasteleruoka.setOnAction((ActionEvent event) -> {
            GridPane paneeli = new GridPane();
            paneeli.setHgap(5);
            paneeli.setVgap(5);
            paneeli.add(tfMuistutus, 1, 3);
            paneeli.add(btSulje, 0, 4);
            paneeli.add(btOk, 1, 4);

            tfMuistutus.setEditable(false);
            paneeli.setAlignment(Pos.TOP_CENTER);

            StackPane neljasikkuna = new StackPane();

            neljasikkuna.getChildren().addAll(paneeli);

            Scene secondScene = new Scene(neljasikkuna, 600, 400);

            // uusi ikkuna
            Stage uusiIkkuna = new Stage();
            uusiIkkuna.setTitle("Tarkastele ruokapäiväkirjaa");
            uusiIkkuna.setScene(secondScene);

            uusiIkkuna.show();

            btSulje.setOnAction(e -> {
                uusiIkkuna.close();
            });

            btOk.setOnAction(e -> {
                haeRuoka();

            });
        });

        //lisätään toiminnallisuus lisaaruoka buttonille
        btLisaaruoka.setOnAction(
                (ActionEvent event) -> {
                    GridPane paneeli = new GridPane();
                    // asetetaan tilaa solujen välille
                    paneeli.setHgap(5);
                    paneeli.setVgap(5);
                    // lisätään solmut
                    paneeli.add(new Label("Päivämäärä: "), 0, 0);
                    paneeli.add(tfValitsepaiva, 1, 0);
                    paneeli.add(new Label("Kellonaika: "), 0, 2);
                    paneeli.add(tfKellonaika, 1, 2);
                    paneeli.add(new Label("Ruoka: "), 0, 3);
                    paneeli.add(tfRuoka, 1, 3);
                    paneeli.add(new Label("Juoma: "), 0, 4);
                    paneeli.add(tfJuoma, 1, 4);
                    paneeli.add(btTallenna, 1, 5);
                    paneeli.add(btSulje, 0, 5);
                    paneeli.add(tfLisaaruokaa, 1, 6);

                    //Asetetaan koko tekstikentälle
                    tfLisaaruokaa.setPrefHeight(25);
                    tfLisaaruokaa.setPrefWidth(200);

                    paneeli.setAlignment(Pos.CENTER);

                    StackPane toinenikkuna = new StackPane();

                    toinenikkuna.getChildren().addAll(paneeli);

                    Scene secondScene = new Scene(toinenikkuna, 400, 300);

                    // uusi ikkuna
                    Stage uusiIkkuna = new Stage();
                    uusiIkkuna.setTitle("Lisää ruoka");
                    uusiIkkuna.setScene(secondScene);

                    uusiIkkuna.show();

                    btTallenna.setOnAction(e -> {
                        talletaRuoka();
                    });

                    btSulje.setOnAction(e -> {
                        uusiIkkuna.close();
                    });
                }
        );
    }

    /**
     * metodi, joka tallentaa käyttäjän ruokailitiedot .dat tiedostoon.
     */
    public void talletaRuoka() {

        Ruokailutapahtuma uusi = new Ruokailutapahtuma(tfValitsepaiva.getText(), tfKellonaika.getText(), tfRuoka.getText(), tfJuoma.getText());
        ruokailut.add(uusi);
        Ruokailutapahtuma[] uusi2 = ruokailut.toArray(new Ruokailutapahtuma[0]);
        String tiedostonNimi = "ruokailut.dat";
        {

            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(tiedostonNimi));
                os.writeObject(uusi2);
                os.close();
                tfLisaaruokaa.setText("Tallentaminen onnistui!");
            } catch (FileNotFoundException a) {
                tfLisaaruokaa.setText("Tiedostoa ei löytynyt?!");
            } catch (IOException a) {
                tfLisaaruokaa.setText("Tiedosto taisi löytyä, mutta jotain meni pieneen.");
            };
        }
    }

    /**
     * metodi, joka hakee käyttäjän ruokailitiedot .dat tiedostosta.
     */
    public void haeRuoka() {
        Ruokailutapahtuma[] testi = null;
        try {
            String teksti = "";
            FileInputStream tiedosto2 = new FileInputStream("ruokailut.dat");
            ObjectInputStream oliotiedosto2 = new ObjectInputStream(tiedosto2);
            testi = (Ruokailutapahtuma[]) oliotiedosto2.readObject();
            tiedosto2.close();
            oliotiedosto2.close();
            ruokailut.clear();
            Collections.addAll(ruokailut, testi);
            for (Ruokailutapahtuma r : testi) {
                teksti += ("\n" + "päivämäärä: " + r.getPaivamaara() + "\nkello: " + r.getKello() + "\nruoka: " + r.getRuoka() + "\nJuoma: " + r.getJuoma() + "\n");
            }
            tfMuistutus.setText(teksti);
            tfMuistutus.setEditable(false);
        } catch (Exception a) {
            System.out.println("tiedostoa luettaessa vikaan meni");
        }

    }

    /**
     * metodi, tallentaa käyttäjän syöttämät verensokeri arvot .dat tiedostoon.
     */
    public void talletaVerensokeri() {

        Verensokeritapahtuma uusi = new Verensokeritapahtuma(tfValitsepaiva.getText(), tfKellonaika.getText(), Double.parseDouble(tfVerensokeri.getText()), Double.parseDouble(tfToinenverensokeri.getText()));
        verensokerit.add(uusi);
        Verensokeritapahtuma[] uusi2 = verensokerit.toArray(new Verensokeritapahtuma[0]);
        String tiedostonNimi = "verensokerit.dat";

        {

            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(tiedostonNimi));
                os.writeObject(uusi2);
                os.close();
                tfLisaaverensokeri.setText("Tallentaminen onnistui!");
            } catch (FileNotFoundException a) {
                tfLisaaverensokeri.setText("Tiedostoa ei löytynyt?!");
            } catch (IOException a) {
                tfLisaaverensokeri.setText("Tiedosto taisi löytyä, mutta jotain meni pieleen.");
            };
        }
    }

    /**
     * metodi, joka hakee käyttäjän syöttämät arvot .dat tiedostosta.
     */
    public void haeVerensokeri() {
        Verensokeritapahtuma[] luetaan = null;
        try {
            String teksti = "";
            FileInputStream tiedosto2 = new FileInputStream("verensokerit.dat");
            ObjectInputStream oliotiedosto2 = new ObjectInputStream(tiedosto2);
            luetaan = (Verensokeritapahtuma[]) oliotiedosto2.readObject();
            tiedosto2.close();
            oliotiedosto2.close();
            verensokerit.clear();
            Collections.addAll(verensokerit, luetaan);
            for (Verensokeritapahtuma v : luetaan) {
                teksti += ("\n" + "päivämäärä: " + v.getPaivamaara1() + "\nkello: " + v.getKello1() + "\nEnsimmäinen verensokeri: " + v.getEkaverensokeri() + "\nToinen verensokeri: " + v.getTokaverensokeri() + "\n");
            }
            tfMuistutus1.setText(teksti);
            tfMuistutus1.setEditable(false);
        } catch (Exception a) {
            tfMuistutus1.setText("Eipä tainnut onnistua!");
        }

    }

    /**
     * Ohjelman käynnistävä metodi
     *
     * @param args kutsuparametreja ei käytetä.
     */
    public static void main(String[] args) {
        launch(args);

    }
}
