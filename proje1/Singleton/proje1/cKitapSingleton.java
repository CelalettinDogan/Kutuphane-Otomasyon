package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cKitapSingleton {
	private static cKitapSingleton instence;



	 public static cKitapSingleton getInstance(String kitapAdi) {
		 cKitapSingleton instance = null;
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "SELECT COUNT(*) AS adet FROM KITAPLAR WHERE KitapAdi= ?";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, kitapAdi);
		        resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            int adet = resultSet.getInt("adet");
		            if (adet > 0) {
		               
		            	kitapGuncelle(kitapAdi); // Kullanıcı adı zaten varsa durumu güncelle
		            } else {
		                instance = new cKitapSingleton();
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

		public static void kitapGuncelle(String kitapAdi) {
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "UPDATE KITAPLAR SET Durum = 1 WHERE KitapAdi = ? ";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, kitapAdi);
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

		 public boolean kitapEkle(cKitap c) {
		 		boolean sonuc = false;

		 	    Connection connect = null;
		 	    PreparedStatement statement = null;

		 	    try {
		 	    	  Database veri = new DBConnect(new cVeritabani());
		 		        connect = veri.baglanti();
		 	        String sql = "insert into KITAPLAR (YayinEviID,RafID,YazarID,KitapAdi,YayınTarihi,SayfaSayisi,Adet,Fiyat) values(?, ?,?, ?, ?, ?, ?, ?)";
		 	        statement = connect.prepareStatement(sql);
		 	        statement.setInt(1, c.get_yazarId());
		 	        statement.setInt(2, c.get_rafId());
		 	        statement.setInt(3, c.get_yazarId());
		 	        statement.setString(4, c.get_kitapAd());
		 	        statement.setInt(5, c.get_yayinTarihi());
		 	        statement.setInt(6, c.get_sayfaSayisi());
		 	        statement.setInt(7, c.get_adet());
		 	        statement.setDouble(8, c.get_fiyat());

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
		 public boolean ciftKategori(cKitap c) {
			    boolean sonuc = false;
			    Connection connect = null;
			    PreparedStatement statement1 = null;
			    PreparedStatement statement2 = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();

			        String sql1 = "INSERT INTO KITAPKATEGORI (KategoriID, KitapID) VALUES ( ?,(SELECT ID FROM KITAPLAR WHERE KitapAdi = ?))";
			        statement1 = connect.prepareStatement(sql1);
			        statement1.setInt(1, c.get_kategoriID());
			        statement1.setString(2, c.get_kitapAd());
			     

			        int affectedRows1 = statement1.executeUpdate();

			        String sql2 = "INSERT INTO KITAPKATEGORI (KategoriID, KitapID) VALUES (?, (SELECT ID FROM KITAPLAR WHERE KitapAdi = ?))";
			        statement2 = connect.prepareStatement(sql2);
			        statement2.setInt(1, c.get_kategoriID2()); // Örnek olarak kategori ID'si 2 alındı.
			        statement2.setString(2, c.get_kitapAd());

			        int affectedRows2 = statement2.executeUpdate();

			        sonuc = (affectedRows1 > 0 && affectedRows2 > 0);
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (statement1 != null) statement1.close();
			            if (statement2 != null) statement2.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }

			    return sonuc;
			}

		 public boolean tekKategori(cKitap c) {
			    boolean sonuc = false;
			    Connection connect = null;
			    PreparedStatement statement1 = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();

			        String sql1 = "INSERT INTO KITAPKATEGORI (KategoriID, KitapID) VALUES (?, (SELECT ID FROM KITAPLAR WHERE KitapAdi = ?))";
			        statement1 = connect.prepareStatement(sql1);
			        statement1.setInt(1, c.get_kategoriID());
			        statement1.setString(2, c.get_kitapAd());

			        int affectedRows1 = statement1.executeUpdate();

			        sonuc = (affectedRows1 > 0);
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        try {
			            if (statement1 != null) statement1.close();
			            if (connect != null) connect.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }

			    return sonuc;
			}
		
}
