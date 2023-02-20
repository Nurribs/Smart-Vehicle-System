package AkilliArabaSistem;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class Araba {
    Scanner input = new Scanner(System.in);
   public static boolean active=false;
    Ayarlar.Menu list = new Ayarlar.Menu();
    public Araba() {}
    public void aracEkle() {
        //Boolean isVehicle=false;
        String model, seriNo;
        System.out.print("\n•Aracın model veya ismini giriniz: ");
        model = input.nextLine();
        System.out.print("•Araç seri numarasını giriniz: ");
        seriNo = input.next();
        esleme();
        active=true;
    }

    public int ekranGoruntule() {
        int kod;
        kod = (int) (Math.random() * 8999 + 1000);
        JFrame f1 = new JFrame("");
        f1.setVisible(true);
        f1.setSize(300, 200);
        f1.setLocation(50, 30);
        Container con = f1.getContentPane();
        con.add(new JLabel("KOD: " + kod));
        return kod;
    }
    public void esleme() {

        int onayKod;
        System.out.println("\nLütfen cihazınızı bluetooth ile araca bağlayınız.");
        int ekranKod = ekranGoruntule();
        do {
            System.out.print("\n•Araç ekranında oluşan kodu telefona giriniz: ");
            onayKod = input.nextInt();
            if (onayKod == ekranKod) {
                System.out.println("\n-->Eşleştirme tamamlanmıştır.Aracınız eklendi.\n");
                active = true;
                list.menu();
                break;
            } else {
                System.out.println("\n!!Geçersiz kod girdiniz,tekrar giriniz.");
                ekranKod=ekranGoruntule();
                active = false;
            }
        } while (onayKod!=ekranKod);
    }
    public void aracSil(){
        active = false;
        System.out.println("-->Araç sistemden silinmiştir.");
        list.menu();
    }
}
