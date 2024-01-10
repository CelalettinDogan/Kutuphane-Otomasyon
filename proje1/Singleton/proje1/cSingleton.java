package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cSingleton {
	 private static cSingleton instence;
		


	 public static cSingleton getInstance(String uyeNumara) {
		    cSingleton instance = null;
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "SELECT COUNT(*) AS adet FROM UYELER WHERE UyeKullaniciAdi = ?";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, uyeNumara);
		        resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            int adet = resultSet.getInt("adet");
		            if (adet > 0) {
		               
		                uyeGuncelle(uyeNumara); // Kullanıcı adı zaten varsa durumu güncelle
		            } else {
		                instance = new cSingleton();
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
		    return instance;
		}

		public static void uyeGuncelle(String uyeNumara) {
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "UPDATE Uyeler SET Durum = 1 WHERE UyeKullaniciAdi = ?";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, uyeNumara);
		        int affectedRows = statement.executeUpdate(); // UPDATE sorgusu olduğu için executeUpdate kullanılmalı
		        if (affectedRows > 0) {
		      
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
		}

	    public boolean uyeEKle(cUyeler c) {	
	    	
	    	boolean sonuc = false;

	    	 Connection connect = null;
	  	    PreparedStatement statement = null;

	  	    try {
	  	      Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	  	        String sql = "INSERT INTO UYELER (GorevID,UyeAd, UyeSoyad,UyeKullaniciAdi,UyeSifre, Telefon, Email, Adres) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
	  	        statement = connect.prepareStatement(sql);
	  	        statement.setInt(1, c.get_GorevId());
	  	        statement.setString(2, c.get_UyeAd());
	  	        statement.setString(3, c.get_UyeSoyad());
	  	        statement.setString(4, c.get_UyeKullaniciAdi());
	  	        statement.setString(5, c.get_UyeSifre());
	   	        statement.setString(6, c.get_Telefon());
	  	        statement.setString(7, c.get_Email());
	  	        statement.setString(8, c.get_Adres());

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
}
