package AkilliArabaSistem;
import java.util.Scanner;
public class Ayarlar extends KayitliKullaniciGirisi {
    Scanner input = new Scanner(System.in);
    Menu list = new Menu();
    private String yeniAd, yeniSoyad, yeniSifre1, yenisifre2;
    public Ayarlar() {
        ad=yeniAd;
        soyAd=yeniSoyad;
        sifre1=yeniSifre1;
        sifre2=yenisifre2;
    }
    public void guncelle(String yeniAd) {
        System.out.print("\n•Yeni adınızı giriniz :");
        yeniAd = input.next();                                         //ad = yeniAd;
        System.out.print("•Yeni soyadınızı giriniz: ");
        yeniSoyad = input.next();                                    //soyAd = yeniSoyad;
        System.out.println("\n-->Ad-Soyad Değiştirilmiştir.\n");
        System.out.println("***********************************\n");
        list.menu();
    }
    public void guncelle(String yeniSifre1,String yenisifre2) {
        do {
            System.out.print("\n•Yeni şifre oluşturunuz: ");
            yeniSifre1 = input.next();
            System.out.print("•Yeni şifreyi tekrar giriniz: ");
            yenisifre2 = input.next();
            if (yeniSifre1.equals(yenisifre2)) {                      //yeniSifre1 = yenisifre2; //sifre1 = yeniSifre1;
                System.out.println("\n-->Şifre değiştirilmiştir.");
                System.out.println("***********************************\n");
                list.menu();
            } else {
                System.out.println("!!Şifreler uyuşmamaktadır,tekrar giriniz.");
            }
        } while (yeniSifre1 != yenisifre2);
    }
    public static class Menu {
        public int secim2;
        public Menu() {}
        Scanner input = new Scanner(System.in);
        public void menuSelect(){
            System.out.println("**MENÜ \n 1-Araç Ekle \n 2-Araç Sil\n 3-Araç Kontrolleri \n 4-Ayarlar \n 5-Çıkış Yap");
            System.out.print("\n•Gerçekleştirmek istediğiniz işlemi seçiniz: ");
            secim2 = input.nextInt();
        }
        public void menu() {
            HesapOlusturma person = new HesapOlusturma();
            Araba car = new Araba();
            AracKontrol ctrl = new AracKontrol();
            menuSelect();
            if (secim2 == 1) {
                car.aracEkle();
            } else if (secim2 == 2) {
                if (car.active == true) {
                    car.aracSil();

                } else {
                    System.out.println("\n!!Sistemde silenecek araç mevcut değil.\n");
                    menu();
                }
            } else if (secim2 == 3) {
                if (car.active == true) {
                    ctrl.fonkSecim();
                } else {
                    System.out.println("\n!!Araç kontrolü için araba eklenmelidir.");
                    car.aracEkle();
                }
            } else if (secim2 == 4) {
                guncelleme();
            } else if (secim2 == 5) {
                person.cikisYap();
            } else {
                System.out.println("\n!!Geçersiz işlem talebinde bulundunuz.");
                menu();
            }
        }
        public void guncelleme() {
                Ayarlar ayar = new Ayarlar();
                int secim3;
                System.out.println("\n***********************************");
                System.out.println("\n1-AD-SOYAD GÜNCELLEME\n2-ŞİFRE DEĞİŞTİRME\n ");
                System.out.print("Gerçekleştirmek istediğiniz işlemi seçiniz.");
                secim3 = input.nextInt();
                if (secim3 == 1) {
                    ayar.guncelle(ayar.yeniAd);
                } else {
                    ayar.guncelle(ayar.yeniSifre1, ayar.yenisifre2);
                }
            }
        }
    }