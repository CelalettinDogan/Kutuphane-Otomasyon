package proje1;

public class cOdemeNakitFactory  implements OdemeFactory{

	@Override
	public Odeme createOdeme() {
		// TODO Auto-generated method stub
		return new cNakitOdeme();
	}

}
