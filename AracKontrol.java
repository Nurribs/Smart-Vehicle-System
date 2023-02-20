package AkilliArabaSistem;
import java.util.Scanner;
public class AracKontrol extends Kontrol {
    Scanner inp = new Scanner(System.in);
    Ayarlar.Menu ayar = new Ayarlar.Menu();
    public int secim;
    public AracKontrol(){}
    public void fonkSecim() {
        kontrolListe();
        System.out.print("\n•Gerçekleştirilecek kontrol: ");
        secim = inp.nextInt();
        aracFonk(secim);
    }
    public void aracFonk(int a) {
        switch (secim) {
            case 1:
                kilitKontrol();
                fonkSecim();
                break;
            case 2:
                farKontrol();
                fonkSecim();
                break;
            case 3:
                aydinlatmaKontrol();
                fonkSecim();
                break;
            case 4:
                klimaKontrol();
                fonkSecim();
                break;
            case 5:
                camKontrol();
                fonkSecim();
                break;
            case 0:
                System.out.println("\n***********************************\n");
                ayar.menu();
                break;
            default:
                System.out.println("\n!!Geçersiz seçim yaptınız,tekrar deneyiniz.");
                fonkSecim();
                break;
        }
    }
    public Boolean kilitKontrol() {
        Boolean kilit = false;
        String durum = "kapalı";
        System.out.print("\n•Kapıları Aç/Kapat: ");
        durum = inp.next();
        durum = durum.toLowerCase();
        if (durum.equals("aç") || durum.equals("ac")) {
            durum = "açık";
            kilit = true;
            System.out.println("-->Kapılar açılmıştır.");
        } else if (durum.equals("kapat")) {
            durum = "kapalı";
            kilit = false;
            System.out.println("-->Kapılar kapanmıştır.");
        }
        return kilit;
    }
    public Boolean farKontrol() {
        Boolean kilit = false;
        int farTur;
        String durum = "kapalı";

        System.out.print("\n•Farları Aç/Kapat: ");
        durum = inp.next();

        durum = durum.toLowerCase();
        if (durum.equals("aç") || durum.equals("ac")) {
            System.out.print("\n•Hangi farları açmak istersiniz?\n"+
                                "1-Uzun Farlar\n"+
                                "2-Kısa Farlar\n"+
                                "3-Sis Lambaları: ");
            farTur=inp.nextInt();
            farKontrol(farTur);
            durum = "açık";
            kilit = true;
        } else if (durum.equals("kapat")) {
            durum = "kapalı";
            kilit = false;
            System.out.println("-->Farlar kapanmıştır.");
        }
        return kilit;
    }
    public void farKontrol(int farTur)
    {
        switch (farTur){
            case 1:
                System.out.println("\n-->Uzun farlar açılmıştır.");
                break;
            case 2:
                System.out.println("\n-->Kısa farlar açılmıştır.");
                break;
            case 3:
                System.out.println("\n-->Sis lambaları açılmıştır.");
                break;
            default:
                System.out.println("\n!!Hatalı tuşlama.");
                fonkSecim();
                break;
        }
    }
    public Boolean aydinlatmaKontrol() {
        Boolean kilit = false;
        String durum = "kapalı";
        System.out.print("\n•Lambalar Aç/Kapat: ");
        durum = inp.next();
        durum = durum.toLowerCase();
        if (durum.equals("aç") || durum.equals("ac")) {
            durum = "açık";
            kilit = true;
            System.out.println("-->Aydınlatma açılmıştır.");
        } else if (durum.equals("kapat")) {
            durum = "kapalı";
            kilit = false;
            System.out.println("-->Aydınlatma kapanmıştır.");
        }
        return kilit;
    }
    public Boolean klimaKontrol() {
        Boolean kilit = false;
        String durum;
        int sicaklik;
        System.out.print("\n•Klima Aç/Kapat: ");
        durum = inp.next();
        durum = durum.toLowerCase();
        if (durum.equals("aç") || durum.equals("ac")) {
            do {
            System.out.print("•Klima sıcaklığını giriniz(min-0/max-30): ");
            sicaklik=inp.nextInt();
            if (sicaklik>=0 && sicaklik<=30){
                durum = "açık";
                kilit = true;
                System.out.println("-->Klima "+sicaklik+" derecede açılmıştır.");
                break;
            }
            else {
                System.out.println("\n!!Uygun sıcaklık değeri giriniz.");
            }
        } while (true);
        } else if (durum.equals("kapat")) {
            durum = "kapalı";
            kilit = false;
            System.out.println("\n-->Klima kapanmıştır.");
        }
        return kilit;
    }
    public void camKontrol() {
        Boolean kilit = false;
        String durum = "kapalı";
        System.out.print("\n•Camlar Aç/Kapat: ");
        durum = inp.next();
        durum = durum.toLowerCase();
        if (durum.equals("aç") || durum.equals("ac")) {
            durum = "açık";
            kilit = true;
            System.out.println("-->Camlar açılmıştır.");
        } else if (durum.equals("kapat")) {
            durum = "kapalı";
            kilit = false;
            System.out.println("-->Camlar kapanmıştır.");
        }
    }

}
