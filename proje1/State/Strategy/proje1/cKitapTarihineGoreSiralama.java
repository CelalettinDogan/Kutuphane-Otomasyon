package proje1;

import java.util.List;

public class cKitapTarihineGoreSiralama implements KitapSiralamaStrategy{
	public void sort(List<cKitap> kitaplar) {
		kitaplar.sort((b1,b2)-> Integer.compare(b2.get_yayinTarihi(),b1.get_yayinTarihi()));
     
	}
}
