package proje1;

public class cUyeIsimCagirma implements Isim{

	@Override
	public String proccessIsim(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				cAnaSayfa ca = new cAnaSayfa();
				ca.uyeAdiSoyadGetir(id);
				
				return "<html>Hoşgeldiniz Sayın: " + ca.get_uyeAd() + " " + ca.get_uyeSoyad() + "<br>Görevi: " + ca.get_gorev() + "</html>";
	}

}
