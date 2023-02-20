package AkilliArabaSistem;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class HesapOlusturma extends KayitliKullaniciGirisi {
    Scanner input = new Scanner(System.in);
    Araba car = new Araba();

    public HesapOlusturma() {}

    public void anaGiris() {
        System.out.println("\n**********/HESAP OLUŞTURMA/**********");
        System.out.println("");
        hesapOlusturma();
    }

    public void hesapOlusturma() {
        int onaySifre, kod;
        System.out.print("•Adınızı giriniz: ");
        ad = input.next();
        System.out.print("•Soyadınızı giriniz: ");
        soyAd = input.next();
        do {
            System.out.print("•Telefon numaranızı başında sıfır olmadan giriniz: ");
            telNo = input.next();
            if (telNo.length() != 10) {
                System.out.println("!!Hatalı Karakter Sayısı.");
            } else {
                break;
            }
        } while (telNo.length() != 10);
        do {
            kod = kodOlustur();
            System.out.print("•Onay şifrenizi giriniz: ");
            onaySifre = input.nextInt();
            try {
                File nesne = new File("kod.txt");
                Scanner dosyaOku = new Scanner(nesne);
                while (dosyaOku.hasNextInt()) {
                    Integer data = dosyaOku.nextInt();
                }
                dosyaOku.close();
            } catch (FileNotFoundException e) {
                System.out.println("!!Hata oluştu.");
                e.printStackTrace();
            }
            if (onaySifre != kod) {
                System.out.println("!!Onay şifresini yanlış girdiniz,tekrar deneyiniz.");
            }
            System.out.println("\n***********************************\n");
        } while (onaySifre != kod);
        sifreOlustur(onaySifre, kod);
    }

    public void sifreOlustur(int onaySifre, int kod) {
        String cevap = null;
        if (onaySifre == kod) {
            do {
                System.out.print("•Şifre oluşturunuz: ");
                sifre1 = input.next();
                System.out.print("•Şifreyi tekrar giriniz: ");
                sifre2 = input.next();
                if (sifre1.equals(sifre2)) {
                    sifre1 = sifre2;
                    System.out.println("\n***********************************");
                    System.out.println("\n-->Hesabınız oluşturulmuştur.");
                    System.out.print("\nOluşturulan hesaba giriş yapılsın mı?(E/H): ");
                    cevap = input.next();
                    System.out.println("");
                    cevap = cevap.toUpperCase();
                    if (cevap.equals("E")) {
                        giris();
                    } else {
                        cikisYap();
                        System.out.println("-->Çıkış yapılıyor..");
                    }
                    break;
                } else {
                    System.out.println("!!Şifreler uyuşmamaktadır,tekrar giriniz.");
                }
            } while (sifre1 != sifre2);
        }
    }

    public int kodOlustur() {
        int kod;
        kod = (int) (Math.random() * 8999 + 1000);
        JFrame f1 = new JFrame("Onay Kodu");
        f1.setVisible(true);
        f1.setSize(300, 200);
        f1.setLocation(50, 30);
        Container con = f1.getContentPane();
        con.add(new JLabel("Onay şifresi: " + kod));
        try {
            File nesne = new File("kod.txt");
            nesne.createNewFile();
        } catch (IOException e) {
            System.out.println("!!Hata oluştu.");
            e.printStackTrace();
        }
        try {
            FileWriter dosyaYaz = new FileWriter("kod.txt", Charset.forName("UTF-8"));
            dosyaYaz.write(kod);
            dosyaYaz.close();
        } catch (IOException e) {
            System.out.println("!!Hata oluştu.");
            e.printStackTrace();
        }
        return kod;
    }

    public void cikisYap() {
        File nesne = new File("kod.txt");
        nesne.delete();

        System.out.println("\n-->ÇIKIŞ YAPILMIŞTIR.");
        System.exit(0);
    }
}



