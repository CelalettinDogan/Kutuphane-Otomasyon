package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cOdunc extends cListele {
	
	
     public int get_uyeID() {
		return _uyeID;
	}
	public void set_uyeID(int _uyeID) {
		this._uyeID = _uyeID;
	}
	public int get_kitapID() {
		return _kitapID;
	}
	public void set_kitapID(int _kitapID) {
		this._kitapID = _kitapID;
	}
	public int get_personelID() {
		return _personelID;
	}
	public void set_personelID(int _personelID) {
		this._personelID = _personelID;
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
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
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
	public double get_Fiyat() {
		return _Fiyat;
	}
	public void set_Fiyat(double _Fiyat) {
		this._Fiyat = _Fiyat;
	}
	private int _uyeID;
     private int _kitapID;
     private int _personelID;
     private String _uyeAd;
     private String _uyeSoyad;
     private String _email;
     private String _kitapAdi;
     private int _adet;
     private double _Fiyat;
	 private int _kullaniciID;
	
     public int get_kullaniciID() {
		return _kullaniciID;
	}
	public void set_kullaniciID(int _kullaniciID) {
		this._kullaniciID = _kullaniciID;
	}
	
	 DefaultTableModel table = new DefaultTableModel();
   	 String[] kolon = {"ID", "Uye Numara", "Uye Ad","Uye Soyad", "Email"};
   	 
   	 DefaultTableModel table2 = new DefaultTableModel();
   	 String[] kolon2 = {"ID", "Kitap Adı", "Adet","Fiyat"};
	
	public boolean emanetEkle(cOdunc c) {
		boolean sonuc = false;

 	    Connection connect = null;
 	    PreparedStatement statement = null;

 	    try {
 	    	  Database veri = new DBConnect(new cVeritabani());
 		        connect = veri.baglanti();
 	        String sql = "INSERT INTO EMANET (UyeID, KitapID,KullaniciID,EmanetTarihi, TeslimTarihi,Adet) VALUES (?,?, ?,GETDATE(), DATEADD(DAY, 30, GETDATE()),?);";
 	        statement = connect.prepareStatement(sql);
 	        statement.setInt(1, c.get_uyeID());
 	        statement.setInt(2, c.get_kitapID());
 	        statement.setInt(3, c.get_kullaniciID());
 	        statement.setInt(4, c.get_adet());


 	       int affectedRows = statement.executeUpdate(); // executeUpdate() methodu kullanılmalı
 	        sonuc = (affectedRows > 0); // executeUpdate() methodu kullanılmalı
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

 	   return sonuc;
     }
     


    
	
	public void kitapListele(JTable tablo) {
		table2.setColumnIdentifiers(kolon2);

		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "select ID,KitapAdi,Adet,Fiyat from KITAPLAR";
		        statement = connect.prepareStatement(sql);
		        resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Object[] row = {
		            		resultSet.getInt("ID"),	            	
		            		resultSet.getString("KitapAdi"),
		            		resultSet.getString("Adet"),
		            		resultSet.getString("Fiyat"),
		            		
		            	

		            };
		            table2.addRow(row);
		        }

		        tablo.setModel(table2); 
		        
		        tablo.getColumnModel().getColumn(0).setMinWidth(0);
		        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
		        tablo.getColumnModel().getColumn(0).setWidth(0);
		        
		      
		     

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
	public int adetKontrol(int adet, int kitapId) {
	    int sonuc = 0;
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	    	  Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "SELECT Adet FROM KITAPLAR WHERE ID = ?";
	        statement = connect.prepareStatement(sql);
	        statement.setInt(1, kitapId);

	        resultSet = statement.executeQuery();
	        
	      
	        if (resultSet.next()) {
	            int kitapAdet = resultSet.getInt("Adet");
	            if (adet <= kitapAdet) {
	                sonuc = 1; // Adet, kitap adedinden küçük veya eşitse 1 olarak işaretleyelim
	            }
	           
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
	public void borcEkleme(double fiyat, int uyeId) {
	    Connection connect = null;
	    PreparedStatement statement = null;

	    try {
	    	  Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "UPDATE Uyeler SET Borc = Borc + ? WHERE ID = ?";
	        statement = connect.prepareStatement(sql);
	        statement.setDouble(1, fiyat);
	        statement.setInt(2, uyeId);

	        int affectedRows = statement.executeUpdate();
	        
	        // Eğer gerekirse, etkilenen satır sayısını kontrol etmek için bu kısmı kullanabilirsiniz
	    
	      
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
	public void adetSil(int adet, int kitapId) {
	    Connection connect = null;
	    PreparedStatement statement = null;

	    try {
	    	  Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "UPDATE KITAPLAR SET Adet = Adet-? WHERE ID = ?";
	        statement = connect.prepareStatement(sql);
	        statement.setInt(1, adet);
	        statement.setInt(2, kitapId);

	        int affectedRows = statement.executeUpdate();
	        
	        // Eğer gerekirse, etkilenen satır sayısını kontrol etmek için bu kısmı kullanabilirsiniz
	      
	      
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
	@Override
	public void listele(JTable tablo) {
		table.setColumnIdentifiers(kolon);

	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	    	  Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "select ID,UyeKullaniciAdi,UyeAd,UyeSoyad,Email from UYELER";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            Object[] row = {
	            		resultSet.getInt("ID"),	            	
	            		resultSet.getString("UyeKullaniciAdi"),
	            		resultSet.getString("UyeAd"),
	            		resultSet.getString("UyeSoyad"),
	            		resultSet.getString("Email"),
	            	

	            };
	            table.addRow(row);
	        }

	        tablo.setModel(table); 
	        
	        tablo.getColumnModel().getColumn(0).setMinWidth(0);
	        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
	        tablo.getColumnModel().getColumn(0).setWidth(0);
	        
	        tablo.getColumnModel().getColumn(1).setMinWidth(100);
	        tablo.getColumnModel().getColumn(1).setMaxWidth(100);
	        tablo.getColumnModel().getColumn(1).setWidth(100);
	        
	        tablo.getColumnModel().getColumn(3).setMinWidth(90);
	        tablo.getColumnModel().getColumn(3).setMaxWidth(90);
	        tablo.getColumnModel().getColumn(3).setWidth(90);
	        
	        tablo.getColumnModel().getColumn(2).setMinWidth(90);
	        tablo.getColumnModel().getColumn(2).setMaxWidth(90);
	        tablo.getColumnModel().getColumn(2).setWidth(90);
	     

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
