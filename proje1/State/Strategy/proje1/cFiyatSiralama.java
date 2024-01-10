package proje1;

import java.util.List;

public class cFiyatSiralama implements KitapSiralamaStrategy {
	public void sort(List<cKitap> kitaplar) {
		kitaplar.sort((b1,b2)-> Double.compare(b2.get_fiyat(),b1.get_fiyat()));
     
	}
}


