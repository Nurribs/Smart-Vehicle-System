package AkilliArabaSistem;
import java.util.Scanner;
public class KayitliKullaniciGirisi {
    protected String ad;
    protected String soyAd;
    protected String telNo;
    protected String sifre1, sifre2;
    private String girisSifre;
    private int girisSecenek;
    Scanner input=new Scanner(System.in);
    Ayarlar.Menu list=new Ayarlar.Menu();
    public KayitliKullaniciGirisi(){}
    public void setGirisSecenek(int girisSecenek){
        this.girisSecenek = girisSecenek;
    }
    public int getGirisSecenek(){
        return girisSecenek;
    }
    public void setGirisSifre(String girisSifre){
        this.girisSifre =girisSifre;
    }
    public String getGirisSifre(){
        return girisSifre;
    }

    public void giris() {

        System.out.print("1-Kullanıcı adıyla giriş\n" +
                         "2-Telefon numarasıyla giriş: ");
        girisSecenek = input.nextInt();
        do {
            switch (girisSecenek) {
                case 1:
                    giris(ad);
                    break;
                case 2:
                    giris2(telNo);
                    break;
                default:
                    System.out.println("!!Geçersiz seçim yaptınız.\n");
            }
        } while (girisSecenek!=1 || girisSecenek!=2);
    }
    public void giris2(String telNo2){
            do {
                System.out.print("\n•Telefon numaranızı başında sıfır olmadan giriniz : ");
                telNo2 = input.next();
                System.out.print("•Şifrenizi giriniz: ");
                girisSifre = input.next();
                if (telNo.equals(telNo2) && sifre1.equals(girisSifre)) {
                    System.out.println("\n-->Giriş yapılmıştır.\n");
                    list.menu();
                    break;
                }
                else {
                    System.out.println("!!Telefon numarası veya şifre hatalı,tekrar giriniz.");
                }
            }while (!(sifre1.equals(girisSifre)));
        }
    public void giris(String kullaniciAdi){
        do {
            System.out.print("\n•Kullanıcı adınızı giriniz: ");
            kullaniciAdi = input.next();
            System.out.print("•Şifrenizi giriniz: ");
            girisSifre = input.next();
            System.out.println("\n***********************************");
            if (ad.equals(kullaniciAdi) && sifre1.equals(girisSifre)) {
                System.out.println("--> Giriş yapılmıştır.\n");
                list.menu();
                break;
            }
            else {
                System.out.println("!!Kullanıcı adı veya şifre hatalı,tekrar giriniz.");
            }
        }while (ad!=kullaniciAdi || sifre1!=girisSifre);
    }

}
