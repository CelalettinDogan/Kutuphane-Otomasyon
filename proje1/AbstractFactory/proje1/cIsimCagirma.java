package proje1;

public class cIsimCagirma implements Isim{

	
	public String proccessIsim(int id) {
		// TODO Auto-generated method stub
		cAnaSayfa ca = new cAnaSayfa();
		ca.KullaniciAdiSoyadGetir(id);
		
		return "<html>Hoşgeldiniz Sayın: " + ca.get_ad() + " " + ca.get_Soyad() + "<br>Görevi: " + ca.get_gorev() + "</html>";
	}

	
	

}
