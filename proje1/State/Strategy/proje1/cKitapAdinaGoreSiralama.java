package proje1;

import java.util.List;

public class cKitapAdinaGoreSiralama implements KitapSiralamaStrategy {
	public void sort(List<cKitap> kitaplar) {
		kitaplar.sort((b1,b2)-> b1.get_kitapAd().compareTo(b2.get_kitapAd()));
     
	}
}
