package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cOduncTakip extends cListele {
	

boolean _sureArttırma ;
 
 public boolean is_sureArttırma() {
	return _sureArttırma;
}

public void set_sureArttırma(boolean _sureArttırma) {
	this._sureArttırma = _sureArttırma;
}

 private int _kitapID;
 public int get_kitapID() {
	return _kitapID;
}

public void set_kitapID(int _kitapID) {
	this._kitapID = _kitapID;
}

public int get_emanetID() {
	return _emanetID;
}

public void set_emanetID(int _emanetID) {
	this._emanetID = _emanetID;
}

public String get_numara() {
	return _numara;
}

public void set_numara(String _numara) {
	this._numara = _numara;
}

public String get_uyeAd() {
	return _uyeAd;
}

public void set_uyeAd(String _uyeAd) {
	this._uyeAd = _uyeAd;
}

public String get_uyeSoyad() {
	return _uyeSoyad;
}

public void set_uyeSoyad(String _uyeSoyad) {
	this._uyeSoyad = _uyeSoyad;
}

public String get_kitapAdi() {
	return _kitapAdi;
}

public void set_kitapAdi(String _kitapAdi) {
	this._kitapAdi = _kitapAdi;
}

public int get_adet() {
	return _adet;
}

public void set_adet(int _adet) {
	this._adet = _adet;
}

public LocalDateTime get_emanetTarihi() {
	return _emanetTarihi;
}

public void set_emanetTarihi(LocalDateTime _emanetTarihi) {
	this._emanetTarihi = _emanetTarihi;
}

public String get_teslimTarihi() {
	return _teslimTarihi;
}

public void set_teslimTarihi(String _teslimTarihi) {
	this._teslimTarihi = _teslimTarihi;
}

public boolean is_Durum() {
	return _Durum;
}

public void set_Durum(boolean _Durum) {
	this._Durum = _Durum;
}

private int _emanetID;
 
 private String _numara;
 private String _uyeAd;
 private String _uyeSoyad;
 private String _kitapAdi;
 private int _adet;
 private LocalDateTime _emanetTarihi;
 private String _teslimTarihi;
 private boolean _Durum;

DefaultTableModel table = new DefaultTableModel();
	 String[] kolon = {"ID", "Uye Numara", "Uye Ad","Uye Soyad","Kitap Id","Kitap Adı","Adet" ,"Emanet Tarihi","Teslim Tarihi"};
	 
		
        
		 public void emanetGetirNumara(JTable tablo, String numara) {
		    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
		        table.setRowCount(0);
		        table.setColumnIdentifiers(kolon);
		       

		        Connection connect = null;
		        PreparedStatement statement = null;
		        ResultSet resultSet = null;
		        try {
		        	  Database veri = new DBConnect(new cVeritabani());
		  	        connect = veri.baglanti();
		            String sql = "SELECT \r\n"
			        		+ "    EMANET.ID, UyeKullaniciAdi, UYEAD,UYESOYAD,KITAPLAR.ID AS 'KitapId',KitapAdi,EMANET.Adet,\r\n"
			        		+ "	CONVERT(VARCHAR(12), EMANET.EmanetTarihi, 104) AS EmanetTarihi,\r\n"
			        		+ "    CASE \r\n"
			        		+ "        WHEN EMANET.TeslimTarihi < GETDATE() THEN 'Geçmiş'\r\n"
			        		+ "        WHEN EMANET.TeslimTarihi = GETDATE() THEN 'Bugün'\r\n"
			        		+ "        ELSE CONVERT(VARCHAR, DATEDIFF(day, GETDATE(), EMANET.TeslimTarihi)) + ' gün kaldı'\r\n"
			        		+ "    END AS TeslimDurumu\r\n"
			        		+ "FROM \r\n"
			        		+ "    EMANET, KULLANICI, UYELER, KITAPLAR\r\n"
			        		+ "WHERE \r\n"
			        		+ "    EMANET.KitapID = KITAPLAR.ID AND EMANET.KullaniciID = KULLANICI.ID AND EMANET.UyeID = UYELER.ID and UyeKullaniciAdi LIKE ? and EMANET.Durum=1\r\n"
			        		+ "";
		            statement = connect.prepareStatement(sql);
		            statement.setString(1, numara + "%"); 
		            resultSet = statement.executeQuery();


			        while (resultSet.next()) {
			            Object[] row = {
			            		resultSet.getInt("ID"),	            	
			            		resultSet.getString("UyeKullaniciAdi"),
			            		resultSet.getString("UyeAd"),
			            		resultSet.getString("UyeSoyad"),
			            		resultSet.getInt("KitapId"),
			            		resultSet.getString("KitapAdi"),
			            		resultSet.getInt("ADET"),
			            		resultSet.getString("EmanetTarihi"),
			            		resultSet.getString("TeslimDurumu"),
			            	

			            };
			            table.addRow(row);
			        }

			        tablo.setModel(table); 
			        
			        tablo.getColumnModel().getColumn(0).setMinWidth(0);
			        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
			        tablo.getColumnModel().getColumn(0).setWidth(0);
			        
			        tablo.getColumnModel().getColumn(4).setMinWidth(0);
			        tablo.getColumnModel().getColumn(4).setMaxWidth(0);
			        tablo.getColumnModel().getColumn(4).setWidth(0);
			        
			        tablo.getColumnModel().getColumn(6).setMinWidth(40);
			        tablo.getColumnModel().getColumn(6).setMaxWidth(40);
			        tablo.getColumnModel().getColumn(6).setWidth(40);
			        
			        
			        

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        } finally {
		            try {
		                if (resultSet != null) resultSet.close();
		                if (statement != null) statement.close();
		                if (connect != null) connect.close();
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }

		 public boolean emanetSil(int emanetID) {
			    boolean sonuc = false; // Başlangıç değeri false olarak atandı

			    Connection connect = null;
			    PreparedStatement statement = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();
			        String sql = "UPDATE EMANET SET DURUM = 0 WHERE ID = ?";
			        statement = connect.prepareStatement(sql);

			        statement.setInt(1, emanetID);
			        int affectedRows = statement.executeUpdate();

			        if (affectedRows > 0) {
			          
			            sonuc = true; // Silme işlemi başarılıysa sonuc değerini true olarak güncellendi
			        } else {
			            System.out.println("Silme işlemi başarısız.");
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (statement != null) statement.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return sonuc; // Güncellenmiş sonuc değeri döndürüldü
			}

		 public void adetEkle(int adet, int kitapID) {
			    Connection connect = null;
			    PreparedStatement statement = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();
			        String sql = "UPDATE KITAPLAR SET ADET = ADET + ? WHERE ID = ?";
			        statement = connect.prepareStatement(sql);

			        statement.setInt(1, adet);
			        statement.setInt(2, kitapID); // Kitap ID'sini 2. parametre olarak ayarlayın

			        int affectedRows = statement.executeUpdate();

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (statement != null) statement.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			}
		 public void sureEkle(int emanetID) {
			    Connection connect = null;
			    PreparedStatement statement = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();
			        String sql = "UPDATE EMANET SET TeslimTarihi = DATEADD(DAY, 30, TeslimTarihi), SureArttirma = 1 WHERE ID = ?";
			        statement = connect.prepareStatement(sql);

			        statement.setInt(1, emanetID);

			        int affectedRows = statement.executeUpdate();

			     
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (statement != null) statement.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			}
		 
		 public boolean eklemeKontrol(int emanetId) {
			    boolean sonuc = false;
			    Connection connect = null;
			    PreparedStatement statement = null;
			    ResultSet resultSet = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();
			        String sql = "SELECT SureArttirma FROM EMANET WHERE ID = ?";
			        statement = connect.prepareStatement(sql);
			        statement.setInt(1, emanetId);
			        resultSet = statement.executeQuery();

			        if (resultSet.next()) {
			            sonuc = resultSet.getBoolean("SureArttirma");
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (resultSet != null) resultSet.close();
			            if (statement != null) statement.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }

			    return sonuc;
			}

		
		
		public void listele(JTable tablo) {
		
			 table.setColumnIdentifiers(kolon);

			    Connection connect = null;
			    PreparedStatement statement = null;
			    ResultSet resultSet = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();
			        String sql = "SELECT \r\n"
			        		+ "    EMANET.ID, UyeKullaniciAdi, UYEAD,UYESOYAD,KITAPLAR.ID AS 'KitapId',KitapAdi,EMANET.Adet,\r\n"
			        		+ "	CONVERT(VARCHAR(12), EMANET.EmanetTarihi, 104) AS EmanetTarihi,\r\n"
			        		+ "    CASE \r\n"
			        		+ "        WHEN EMANET.TeslimTarihi < GETDATE() THEN 'Geçmiş'\r\n"
			        		+ "        WHEN EMANET.TeslimTarihi = GETDATE() THEN 'Bugün'\r\n"
			        		+ "        ELSE CONVERT(VARCHAR, DATEDIFF(day, GETDATE(), EMANET.TeslimTarihi)) + ' gün kaldı'\r\n"
			        		+ "    END AS TeslimDurumu\r\n"
			        		+ "FROM \r\n"
			        		+ "    EMANET, KULLANICI, UYELER, KITAPLAR\r\n"
			        		+ "WHERE \r\n"
			        		+ "    EMANET.KitapID = KITAPLAR.ID AND EMANET.KullaniciID = KULLANICI.ID AND EMANET.UyeID = UYELER.ID and EMANET.DURUM=1\r\n"
			        		+ "";
			        statement = connect.prepareStatement(sql);
			        resultSet = statement.executeQuery();

			        while (resultSet.next()) {
			            Object[] row = {
			            		resultSet.getInt("ID"),	            	
			            		resultSet.getString("UyeKullaniciAdi"),
			            		resultSet.getString("UyeAd"),
			            		resultSet.getString("UyeSoyad"),
			            		resultSet.getInt("KitapId"),
			            		resultSet.getString("KitapAdi"),
			            		resultSet.getInt("ADET"),
			            		resultSet.getString("EmanetTarihi"),
			            		resultSet.getString("TeslimDurumu"),
			            	

			            };
			            table.addRow(row);
			        }

			        tablo.setModel(table); 
			        
			        tablo.getColumnModel().getColumn(0).setMinWidth(0);
			        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
			        tablo.getColumnModel().getColumn(0).setWidth(0);
			        
			        tablo.getColumnModel().getColumn(4).setMinWidth(0);
			        tablo.getColumnModel().getColumn(4).setMaxWidth(0);
			        tablo.getColumnModel().getColumn(4).setWidth(0);
			        
			        tablo.getColumnModel().getColumn(6).setMinWidth(40);
			        tablo.getColumnModel().getColumn(6).setMaxWidth(40);
			        tablo.getColumnModel().getColumn(6).setWidth(40);
			        
			        
			        
			     

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (resultSet != null) resultSet.close();
			            if (statement != null) statement.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
		}
	
	

}
