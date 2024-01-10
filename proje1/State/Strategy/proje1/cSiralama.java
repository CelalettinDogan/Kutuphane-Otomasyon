package proje1;


import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cSiralama {
	   private KitapSiralamaStrategy siralamaStrategy;
	   public  void setSortingStrategy(KitapSiralamaStrategy siralamaStrategy){
	        this.siralamaStrategy=siralamaStrategy;
	    }
	   
	   public void kitaplariListele(List<cKitap> kitaplar, JTable tablo){
		    // Sıralama stratejisi uygula
		    siralamaStrategy.sort(kitaplar);

		    // Tablo modelini oluştur
		    DefaultTableModel tableModel = (DefaultTableModel) tablo.getModel();
		    tableModel.setRowCount(0);

		    // Kolon başlıklarını belirle
		    String[] kolon = {"ID", "KİTAP AD", "YAZAR AD","YAZAR SOYAD", "KATEGORİ", "YAYIN TARİHİ", "ADET", "RAF","YAYIN EVİ","FİYAT"};
		    tableModel.setColumnIdentifiers(kolon);

		    // Kitapları tabloya ekle
		    for (cKitap kitap : kitaplar) {
		        Object[] row = {kitap.get_kitapId(), kitap.get_kitapAd(), kitap.get_YazarAd(), kitap.get_YazarSoyad(), kitap.get_Kategoriler(), kitap.get_yayinTarihi(), kitap.get_adet(),
		                kitap.get_RafNo(), kitap.get_YayinEviAdi(), kitap.get_fiyat()};
		        tableModel.addRow(row);
		    }

		    tablo.setModel(tableModel);
		    tablo.getColumnModel().getColumn(0).setMinWidth(0);
	        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
	        tablo.getColumnModel().getColumn(0).setWidth(0);
	        
	        tablo.getColumnModel().getColumn(5).setMinWidth(70);
	        tablo.getColumnModel().getColumn(5).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(5).setWidth(70);

	        tablo.getColumnModel().getColumn(6).setMinWidth(70);
	        tablo.getColumnModel().getColumn(6).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(6).setWidth(70);
	        
	        tablo.getColumnModel().getColumn(7).setMinWidth(70);
	        tablo.getColumnModel().getColumn(7).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(7).setWidth(70);
	        
	        tablo.getColumnModel().getColumn(9).setMinWidth(70);
	        tablo.getColumnModel().getColumn(9).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(9).setWidth(70);
		}
	   
	  
	   
	   
	   
	   
	   
	   private KitapState guncelDurum;
	   
	   public void setState(KitapState state){
	        this.guncelDurum =state;
	    }
	   
	   public void kitaplarinGuncelDurumuListele(List<cKitap> kitaplar,JTable tablo){
	        guncelDurum.durumGoruntule(kitaplar,tablo);
	    }
	   

}
