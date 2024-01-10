package proje1;

public class cOdemeKrediKartFactory implements OdemeFactory{

	@Override
	 public Odeme createOdeme() {
		return new cKrediKartOdeme();
	 }
	

}
