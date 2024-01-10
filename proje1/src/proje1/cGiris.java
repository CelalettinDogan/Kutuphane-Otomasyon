package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cGiris {
	
  
 
    private int _PersonelId;
    private int _UyeId;
  
	public int getPersonelId() {
    	return _PersonelId;
    }
	  public int get_UyeId() {
			return _UyeId;
		}
	public boolean girisUyeKontrol(String uyeAdi, String sifre) {
		 boolean result = false;
	        Connection connect = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {
	        	 Database veri = new DBConnect(new cVeritabani());
	 	        connect = veri.baglanti();
	            String sql = "SELECT * FROM UYELER WHERE UyeKullaniciAdi = ? AND UyeSifre = ? AND DURUM = 1";
	            statement = connect.prepareStatement(sql);
	            statement.setString(1, uyeAdi);
	            statement.setString(2, sifre);
	            resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	            	_UyeId = resultSet.getInt("ID");
	                result = true;
	            } else {
	              
	                result = false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
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

	public boolean girisKullaniciKontrol(String kullanciAdi, String sifre) {
	    boolean result = false;
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        Database veri = new DBConnect(new cVeritabani());
	        connect = veri.baglanti();
	        String sql = "SELECT * FROM KULLANICI WHERE KullaniciAdi = ? AND Parola = ?  and DURUM = 1";
            statement = connect.prepareStatement(sql);
            statement.setString(1, kullanciAdi);
            statement.setString(2, sifre);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	_PersonelId = resultSet.getInt("ID");
                result = true;
            } else {
              
                result = false;
            }
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
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
    
    
}
