package AkilliArabaSistem;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public abstract class Kontrol {
    public Kontrol(){}
    public void kontrolListe() {
        System.out.println("\n*******/Araç Kontrolleri/*******");
        System.out.println("\n1-Araç kapı kilit kontrol\n" +
                "2-Far kontrol\n" +
                "3-Araç içi lamba kontrol\n" +
                "4-Klima kontrol\n" +
                "5-Cam kontrol\n"+
                "0-Çıkış");
    }

    public abstract Boolean kilitKontrol();
    public abstract Boolean farKontrol();
    public abstract Boolean klimaKontrol();
    public abstract Boolean aydinlatmaKontrol();
    public abstract void camKontrol();

}
