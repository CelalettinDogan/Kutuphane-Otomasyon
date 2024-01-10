package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cSingletonKullanici {
	 private static cSingletonKullanici instence;
	


	 public static cSingletonKullanici getInstance(String KullaniciNumara) {
		 cSingletonKullanici instance = null;
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "SELECT COUNT(*) AS adet FROM KULLANICI WHERE KullaniciAdi= ?";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, KullaniciNumara);
		        resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            int adet = resultSet.getInt("adet");
		            if (adet > 0) {
		               
		            	kullaniciGuncelle(KullaniciNumara); // Kullanıcı adı zaten varsa durumu güncelle
		            } else {
		                instance = new cSingletonKullanici();
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

		public static void kullaniciGuncelle(String KullaniciNumara) {
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "UPDATE KULLANICI SET Durum = 1 WHERE KullaniciAdi = ? ";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, KullaniciNumara);
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

		 public boolean kullaniciEkle(cKullanicilar c) {
		 		boolean sonuc = false;

		 	    Connection connect = null;
		 	    PreparedStatement statement = null;

		 	    try {
		 	    	  Database veri = new DBConnect(new cVeritabani());
		 		        connect = veri.baglanti();
		 	        String sql = "INSERT INTO KULLANICI (GorevID,KullaniciAdi, Ad,Soyad,Telefon, Email, Parola, Adres) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
		 	        statement = connect.prepareStatement(sql);
		 	        statement.setInt(1, c.get_GorevId());
		 	        statement.setString(2, c.get_KullaniciAdi());
		 	        statement.setString(3, c.get_Ad());
		 	        statement.setString(4, c.get_Soyad());
		 	        statement.setInt(5, c.get_Telefon());
		 	        statement.setString(6, c.get_Email());
		 	        statement.setString(7, c.get_KullaniciSifre());
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
