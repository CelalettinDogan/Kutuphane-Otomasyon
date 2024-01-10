package proje1;

import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class cKullanicilar extends cDurumGetir {

	 
	 private int _Id;
	 public int get_Id() {
		return _Id;
	}
	public void set_Id(int _Id) {
		this._Id = _Id;
	}
	public int get_GorevId() {
		return _GorevId;
	}
	public void set_GorevId(int _GorevId) {
		this._GorevId = _GorevId;
	}
	public int get_Telefon() {
		return _Telefon;
	}
	public void set_Telefon(int _Telefon) {
		this._Telefon = _Telefon;
	}
	public String get_KullaniciAdi() {
		return _KullaniciAdi;
	}
	public void set_KullaniciAdi(String _KullaniciAdi) {
		this._KullaniciAdi = _KullaniciAdi;
	}
	public String get_KullaniciSifre() {
		return _KullaniciSifre;
	}
	public void set_KullaniciSifre(String _KullaniciSifre) {
		this._KullaniciSifre = _KullaniciSifre;
	}
	public String get_Ad() {
		return _Ad;
	}
	public void set_Ad(String _Ad) {
		this._Ad = _Ad;
	}
	public String get_Soyad() {
		return _Soyad;
	}
	public void set_Soyad(String _Soyad) {
		this._Soyad = _Soyad;
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
	public boolean is_KullaniciDurum() {
		return _KullaniciDurum;
	}
	public void set_KullaniciDurum(boolean _KullaniciDurum) {
		this._KullaniciDurum = _KullaniciDurum;
	}
	private int _GorevId;
	 private int _Telefon;
	 private String _KullaniciAdi;
	 private String _KullaniciSifre;
	 private String _Ad;
	 private String _Soyad;
	 private String _Email;
	 private String _Adres;
	 private boolean _KullaniciDurum;
	 DefaultTableModel table = new DefaultTableModel();
	 String[] kolon = {"ID", "AD", "SOYAD", "TELEFON", "GÖREV", "EMAİL", "ADRES"};

	 
	 
	 
	//Combobox'a yazdırma
    public void kullaniciGorevGetir(JComboBox<Object> cb) {

	        cb.removeAllItems();
	        Connection connect = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {
	        	  Database veri = new DBConnect(new cVeritabani());
	  	        connect = veri.baglanti();
	            String sql = "SELECT * FROM KULLANICIGOREVLERI";
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
	 
	
	 //kullanıcı eklerken onların görevlerini getirmek için
	 public int kullaniciGorevIdGetir(int kullaniciId) {
		    int result = 0;
		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;
		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "SELECT GorevId FROM KULLANICI WHERE ID = ?";
		        statement = connect.prepareStatement(sql);
		        statement.setInt(1, kullaniciId);
		        resultSet = statement.executeQuery();

		        // Eğer resultSet'te bir sonuç varsa, bu sonucu alıp result değişkenine atayabiliriz
		        if (resultSet.next()) {
		            result = resultSet.getInt("GorevId");
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
		    return result;
		}
     
	 //kullanici işlemleri kullanıcı adlarını getirmek için
	 public void kullaniciGetir(JComboBox<Object> cb) {

	        cb.removeAllItems();
	        Connection connect = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {            Database veri = new DBConnect(new cVeritabani());
	        connect = veri.baglanti();
	            String sql = "SELECT * FROM KULLANICI Where DURUM=1";
	            statement = connect.prepareStatement(sql);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	            	cKullanicilar ck = new cKullanicilar();
	            	  ck.set_Id(resultSet.getInt("ID")); // getInt metodunu kullanarak ID değerini al
	            	   ck.set_KullaniciAdi(resultSet.getString("KullaniciAdi")); // getString metodunu kullanarak KullaniciAdi değerini al

	            	    cb.addItem(ck);

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
	 @Override
	    public String toString() {
	        return _KullaniciAdi; // Sadece kullanıcı adını döndür
	    }
	 // Kullanıcı işlemlerinide şifreyi değiştirmek için
	 public boolean kullaniciSifreDegistir(int id, String sifre) {
		    boolean sonuc = false;
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "UPDATE KULLANICI SET Parola = ? WHERE ID = ?";
		        
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, sifre);
		        statement.setInt(2, id);

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
	
	 //tabloda kullanıcıları listeler
	 public void kullaniciListele(JTable tablo) {

		 
		    table.setColumnIdentifiers(kolon);

		    Connection connect = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "Select KULLANICI.ID,Ad,Soyad,Telefon,Gorev,Email,Adres from KULLANICI,KULLANICIGOREVLERI where KULLANICI.GorevID=KULLANICIGOREVLERI.ID and KULLANICI.DURUM=1";
		        statement = connect.prepareStatement(sql);
		        resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Object[] row = {
		                resultSet.getInt("ID"),
		                resultSet.getString("Ad"),
		                resultSet.getString("Soyad"),
		                resultSet.getString("Telefon"),
		                resultSet.getString("Gorev"),
		                resultSet.getString("Email"),
		                resultSet.getString("Adres")
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

	 public boolean kullaniciSil(int kullaniciID) {
		 boolean result =false;
		 Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "UPDATE KULLANICI SET DURUM = 0 WHERE ID = ?";
		        
		        statement = connect.prepareStatement(sql);
		        statement.setInt(1, kullaniciID);

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
	
	@Override
	public boolean DurumGetir(String Ad) {
	
		 boolean durum = false;
	 	    Connection connect = null;
	 	    PreparedStatement statement = null;
	 	    ResultSet resultSet = null;

	 	    try {
	 	    	  Database veri = new DBConnect(new cVeritabani());
	 		        connect = veri.baglanti();
	 	        String sql = "SELECT Durum FROM KULLANICI WHERE KullaniciAdi = ?";
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
