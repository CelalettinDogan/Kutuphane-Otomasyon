package proje1;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cUyeler extends cDurumGetir {
	
   // Fields 
		    private int _Id;
		    private int _GorevId;
			private String _Telefon;
			private String _UyeKullaniciAdi;
			
			private String _UyeSifre;
			private String _UyeAd;
		    private String _UyeSoyad;
		    private String _Email;
		    private String _Adres;
		    private String _gorev;
		    private double _borc;
		    public double get_borc() {
				return _borc;
			}
			public void set_borc(double _borc) {
				this._borc = _borc;
			}
			public String get_gorev() {
				return _gorev;
			}
			public void set_gorev(String _gorev) {
				this._gorev = _gorev;
			}
			private boolean _UyeDurum;
	//end Fields	    
    //Properties
		    public int get_GorevId() {
				return _GorevId;
			}
			public void set_GorevId(int _GorevId) {
				this._GorevId = _GorevId;
			}
		    public String get_UyeKullaniciAdi() {
						return _UyeKullaniciAdi;
		    }	
		    public void set_UyeKullaniciAdi(String _UyeKullaniciAdi) {
						this._UyeKullaniciAdi = _UyeKullaniciAdi;
					}
			public String get_UyeSifre() {
				return _UyeSifre;
			}
			public void set_UyeSifre(String _UyeSifre) {
				this._UyeSifre = _UyeSifre;
			}
			public String get_UyeAd() {
				return _UyeAd;
			}
			public void set_UyeAd(String _UyeAd) {
				this._UyeAd = _UyeAd;
			}
			public String get_UyeSoyad() {
				return _UyeSoyad;
			}
			public void set_UyeSoyad(String _UyeSoyad) {
				this._UyeSoyad = _UyeSoyad;
			}
			public String get_Telefon() {
				return _Telefon;
			}
			public void set_Telefon(String _Telefon) {
				this._Telefon = _Telefon;
			}
			public String get_Email() {
				return _Email;
			}
			public void set_Email(String _Email) {
				this._Email = _Email;
			}
			public String get_Adres() {
				return _Adres;
			}
			public void set_Adres(String _Adres) {
				this._Adres = _Adres;
			}
		    public int get_Id() {
		 		return _Id;
		 	}
		 	public void set_Id(int _Id) {
		 		this._Id = _Id;
		 	}
		 	public int get_Gorev() {
		 		return _GorevId;
		 	}
		 	public void set_Gorev(int _Gorev) {
 		this._GorevId = _Gorev;
 	}
		 	public boolean is__UyeDurum() {
 		return _UyeDurum;
 	}
		 	public void set__UyeDurum(boolean _UyeDurum) {
 		this._UyeDurum = _UyeDurum;
 	}
	 // end properties	 	
		 	DefaultTableModel table = new DefaultTableModel();
		   	 String[] kolon = {"ID", "Uye Numara", "Uye Ad","Uye Soyad", "Email"};
		   	 String[] kolon2 = {"ID", "Uye Numara", "Uye Ad","Uye Soyad","KitapAdi","Adet", "EmanetTarihi","TeslimTarihi"};
		 
			String[] kolon3 = {"ID","UyeAd", "UyeSoyad", "UyeNumara", "Telefon", "Email", "Borc", "Gorev"};
		   	 
     // Üye Görevlerini getirir
	 public void uyeGorevGetir(JComboBox<Object> cb) {

        cb.removeAllItems();
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT * FROM UYEGOREVLERI";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	
                String gorev = resultSet.getString("Gorev");
             
                cb.addItem(gorev);
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
   
	


 	//uyeyi kullaniciadına göre getirir
 	 public void UyeGetirNumarayaGore(JTable tablo, String UyeNo) {
 		DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
        table.setColumnIdentifiers(kolon);
       

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "select ID,UyeKullaniciAdi,UyeAd,UyeSoyad,Email from UYELER where UyeKullaniciAdi LIKE ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1,  UyeNo + "%"); 
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
 
 	
     public void uyeIslemleriNumara(JTable tablo, String KitapAd) {
     	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
         table.setRowCount(0);
         table.setColumnIdentifiers(kolon3);
        

         Connection connect = null;
         PreparedStatement statement = null;
         ResultSet resultSet = null;
         try {
         	  Database veri = new DBConnect(new cVeritabani());
   	        connect = veri.baglanti();
   	     String sql = "SELECT UYELER.ID,UYELER.UyeAd, UYELER.UyeSoyad, UYELER.UyeKullaniciAdi, UYELER.Telefon, UYELER.Email, UYELER.Borc, UYEGOREVLERI.Gorev " +
                  "FROM UYELER " +
                  "JOIN UYEGOREVLERI ON UYELER.GorevID = UYEGOREVLERI.ID Where UYELER.DURUM=1  and UyeKullaniciAdi LIKE ?";
             statement = connect.prepareStatement(sql);
             statement.setString(1,  KitapAd + "%"); 
             resultSet = statement.executeQuery();

             while (resultSet.next()) {
  	            Object[] row = {
  	            	resultSet.getInt("ID"),
  	                resultSet.getString("UyeAd"),
  	                resultSet.getString("UyeSoyad"),
  	                resultSet.getString("UyeKullaniciAdi"),
  	                resultSet.getString("Telefon"),
  	                resultSet.getString("Email"),
  	                resultSet.getFloat("Borc"),
  	                resultSet.getString("Gorev")
  	            };
  	           table.addRow(row);
  	        }

  	        // Yeni tabloyu JTable'a set et
  	        tablo.setModel(table);

  	        tablo.getColumnModel().getColumn(0).setMinWidth(0);
 	        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
 	        tablo.getColumnModel().getColumn(0).setWidth(0);
 	        
 	        tablo.getColumnModel().getColumn(1).setMinWidth(100);
 	        tablo.getColumnModel().getColumn(1).setMaxWidth(100);
 	        tablo.getColumnModel().getColumn(1).setWidth(100);
 	        
 	        tablo.getColumnModel().getColumn(2).setMinWidth(100);
 	        tablo.getColumnModel().getColumn(2).setMaxWidth(100);
 	        tablo.getColumnModel().getColumn(2).setWidth(100);
 	        
 	        tablo.getColumnModel().getColumn(6).setMinWidth(50);
 	        tablo.getColumnModel().getColumn(6).setMaxWidth(50);
 	        tablo.getColumnModel().getColumn(6).setWidth(50);
 	        

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
 	 
 	 public boolean uyeSifreDegistir(int uyeID, String sifre) {
 	    boolean sonuc = false;
 	    Connection connect = null;
 	    PreparedStatement statement = null;

 	    try {
 	    	  Database veri = new DBConnect(new cVeritabani());
 		        connect = veri.baglanti();
 	        String sql = "UPDATE UYELER SET UyeSifre = ? WHERE ID = ?";
 	        statement = connect.prepareStatement(sql);

 	        // Parametre indeksleri düzeltiliyor
 	        statement.setString(1, sifre);
 	        statement.setInt(2, uyeID); // 2. parametre olarak uyeID atanıyor

 	        int affectedRows = statement.executeUpdate();
 	        sonuc = (affectedRows > 0);
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
 	
 	//üyenin aldığı kitapları lislemek için
 	public void alinanKitapListele(JTable tablo,int UyeID) {
 		  table.setColumnIdentifiers(kolon2);

		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "SELECT\r\n"
		        		+ "    UYELER.ID,UyeKullaniciAdi, UyeAd, UyeSoyad, KitapAdi, EMANET.Adet, EmanetTarihi,\r\n"
		        		+ "    CASE\r\n"
		        		+ "        WHEN TeslimTarihi < GETDATE() THEN 'Geçmiş'\r\n"
		        		+ "        WHEN TeslimTarihi = GETDATE() THEN 'Bugün'\r\n"
		        		+ "        ELSE CONVERT(VARCHAR, DATEDIFF(day, GETDATE(), TeslimTarihi)) + ' kaldı'\r\n"
		        		+ "    END AS TeslimDurumu\r\n"
		        		+ "    \r\n"
		        		+ "FROM UYELER, EMANET, KITAPLAR WHERE EMANET.UyeID = UYELER.ID AND EMANET.KitapID = KITAPLAR.ID AND UYELER.ID=?";
		        statement = connect.prepareStatement(sql);
		        statement.setInt(1, UyeID);
		     
		        resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Object[] row = {
		            		resultSet.getInt("ID"),	            	
		            		resultSet.getString("UyeKullaniciAdi"),
		            		resultSet.getString("UyeAd"),
		            		resultSet.getString("UyeSoyad"),
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
 	
 	
 	//üyenin sahip olduğu borcu getirmek için
 	public double borcGetir(int uyeID) {
 	    double borc = 0.0;
 	    Connection connect = null;
 	    PreparedStatement statement = null;
 	    ResultSet resultSet = null;

 	    try {
 	    	  Database veri = new DBConnect(new cVeritabani());
 		        connect = veri.baglanti();
 	        String sql = "SELECT borc FROM UYELER WHERE ID = ?";
 	        statement = connect.prepareStatement(sql);
 	        statement.setInt(1, uyeID);

 	        resultSet = statement.executeQuery();

 	        if (resultSet.next()) {
 	            borc = resultSet.getDouble("borc");
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
 	    return borc;
 	}
 	
 	// üyenin sahip olduğu borcu silmek için
 	public boolean borcSil(int uyeID, double miktar) {
 	    boolean sonuc = false;
 	    Connection connect = null;
 	    PreparedStatement statement = null;
 	    ResultSet resultSet = null;

 	    try {
 	    	  Database veri = new DBConnect(new cVeritabani());
 		        connect = veri.baglanti();

 	        // Mevcut borcu almak için sorguyu oluşturuyoruz
 	        String borcSorgusu = "SELECT Borc FROM UYELER WHERE ID = ?";
 	        PreparedStatement borcStatement = connect.prepareStatement(borcSorgusu);
 	        borcStatement.setInt(1, uyeID);
 	        resultSet = borcStatement.executeQuery();

 	        if (resultSet.next()) {
 	            double mevcutBorc = resultSet.getDouble("Borc");
 	            // Mevcut borç miktarı, düşürülmek istenen miktarından büyük veya eşitse işlem gerçekleştirilir
 	            if (mevcutBorc >= miktar) {
 	                String sql = "UPDATE UYELER SET Borc = Borc - ? WHERE ID = ?";
 	                statement = connect.prepareStatement(sql);
 	                statement.setDouble(1, miktar);
 	                statement.setInt(2, uyeID);

 	                int affectedRows = statement.executeUpdate();

 	                if (affectedRows > 0) {
 	                    sonuc = true; // Başarılı bir şekilde güncelleme yapıldıysa
 	                }
 	            } else {
 	                // Borç miktarı düşürülmek istenen miktarından küçükse burada bir uyarı verebilirsiniz
 	               
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
 	public void UyeListele(JTable tablo) {
 	    // Yeni tabloyu oluştur
 	  	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
 		  table.setColumnIdentifiers(kolon3);

 	    Connection connect = null;
 	    PreparedStatement statement = null;
 	    ResultSet resultSet = null;

 	    try {
 	    	Database veri = new DBConnect(new cVeritabani());
	        connect = veri.baglanti();
 	        // Uyeler ve UYEGOREVLERI tablolarını birleştiren sorgu
 	        String sql = "SELECT UYELER.ID,UYELER.UyeAd, UYELER.UyeSoyad, UYELER.UyeKullaniciAdi, UYELER.Telefon, UYELER.Email, UYELER.Borc, UYEGOREVLERI.Gorev " +
 	                     "FROM UYELER " +
 	                     "JOIN UYEGOREVLERI ON UYELER.GorevID = UYEGOREVLERI.ID Where UYELER.DURUM=1 ";
 	        statement = connect.prepareStatement(sql);
 	        resultSet = statement.executeQuery();

 	        while (resultSet.next()) {
 	            Object[] row = {
 	            	resultSet.getInt("ID"),
 	                resultSet.getString("UyeAd"),
 	                resultSet.getString("UyeSoyad"),
 	                resultSet.getString("UyeKullaniciAdi"),
 	                resultSet.getString("Telefon"),
 	                resultSet.getString("Email"),
 	                resultSet.getFloat("Borc"),
 	                resultSet.getString("Gorev")
 	            };
 	           table.addRow(row);
 	        }

 	        // Yeni tabloyu JTable'a set et
 	        tablo.setModel(table);

 	        tablo.getColumnModel().getColumn(0).setMinWidth(0);
	        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
	        tablo.getColumnModel().getColumn(0).setWidth(0);
	        
	        tablo.getColumnModel().getColumn(1).setMinWidth(100);
	        tablo.getColumnModel().getColumn(1).setMaxWidth(100);
	        tablo.getColumnModel().getColumn(1).setWidth(100);
	        
	        tablo.getColumnModel().getColumn(2).setMinWidth(100);
	        tablo.getColumnModel().getColumn(2).setMaxWidth(100);
	        tablo.getColumnModel().getColumn(2).setWidth(100);
	        
	        tablo.getColumnModel().getColumn(6).setMinWidth(50);
	        tablo.getColumnModel().getColumn(6).setMaxWidth(50);
	        tablo.getColumnModel().getColumn(6).setWidth(50);
	        
 	        
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

 	
 	public boolean UyeSil(String uyeID) {
 	    boolean result = false;
 	    Connection connect = null;
 	    PreparedStatement statement = null;

 	    try {
 	    	Database veri = new DBConnect(new cVeritabani());
	        connect = veri.baglanti();
 	        String sql = "UPDATE UYELER SET DURUM = 0 WHERE ID = ?";
 	        
 	        statement = connect.prepareStatement(sql);
 	        statement.setString(1, uyeID);

 	        int affectedRows = statement.executeUpdate();
 	        result = (affectedRows > 0);

 	    } catch (SQLException ex) {
 	        ex.printStackTrace(); // Hata detayını konsola yazdır
 	    } finally {
 	        try {
 	            if (statement != null) statement.close();
 	            if (connect != null) connect.close();
 	        } catch (SQLException ex) {
 	            ex.printStackTrace();
 	        }
 	    }

 	    return result;
 	}

 	
 	public boolean BorcGuncelle(String kullaniciAdi, float yeniBorc) {
 	    boolean result = false;
 	    Connection connect = null;
 	    PreparedStatement statement = null;

 	    try {
 	    	Database veri = new DBConnect(new cVeritabani());
	        connect = veri.baglanti();
 	        String sql = "UPDATE UYELER SET Borc = ? WHERE UyeKullaniciAdi = ?";
 	        statement = connect.prepareStatement(sql);
 	        statement.setFloat(1, yeniBorc);
 	        statement.setString(2, kullaniciAdi);

 	        int affectedRows = statement.executeUpdate();
 	        result = (affectedRows > 0);

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

 	    return result;
 	}

	public boolean DurumGetir(String Ad) {
		  boolean durum = false;
	 	    Connection connect = null;
	 	    PreparedStatement statement = null;
	 	    ResultSet resultSet = null;

	 	    try {
	 	    	  Database veri = new DBConnect(new cVeritabani());
	 		        connect = veri.baglanti();
	 	        String sql = "SELECT Durum FROM Uyeler WHERE UyeKullaniciAdi = ?";
	 	        statement = connect.prepareStatement(sql);
	 	        statement.setString(1, Ad);
	 	        
	 	        resultSet = statement.executeQuery(); // Sorguyu çalıştır

	 	        if (resultSet.next()) {
	 	            int durumAl = resultSet.getInt("Durum");
	 	            durum = (durumAl == 1); // Durumu true/false olarak ayarla
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

	 	    return durum;
	 	}
	


}


   
