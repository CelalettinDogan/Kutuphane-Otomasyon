package proje1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cAnaSayfa {

	private String _ad;
	public String get_ad() {
		return _ad;
	}
	public void set_ad(String _ad) {
		this._ad = _ad;
	}
	public String get_Soyad() {
		return _Soyad;
	}
	public void set_Soyad(String _Soyad) {
		this._Soyad = _Soyad;
	}
	public String get_gorev() {
		return _gorev;
	}
	public void set_gorev(String _gorev) {
		this._gorev = _gorev;
	}
	private String _Soyad;
	private String  _gorev;
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
	private String _uyeAd;
	private String _uyeSoyad;
	
	public void KullaniciAdiSoyadGetir(int ID) {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	    	 Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "select Ad,Soyad,Gorev from KULLANICI,KULLANICIGOREVLERI where KULLANICI.GorevID = KULLANICIGOREVLERI.ID and KULLANICI.ID= ?";
	        statement = connect.prepareStatement(sql);
	        statement.setInt(1, ID);
	        resultSet = statement.executeQuery();

	     
	        if (resultSet.next()) {
	        	set_ad( resultSet.getString("Ad"));
	        	set_Soyad( resultSet.getString("Soyad"));
	        	set_gorev( resultSet.getString("Gorev"));
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
	
	public void uyeAdiSoyadGetir(int ID) {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	    	 Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "select UyeAd,UyeSoyad,Gorev from UYELER,UYEGOREVLERI where UYELER.GorevID = UYEGOREVLERI.ID AND UYELER.ID =?";
	        statement = connect.prepareStatement(sql);
	        statement.setInt(1, ID);
	        resultSet = statement.executeQuery();

	     
	        if (resultSet.next()) {
	        	set_uyeAd( resultSet.getString("UyeAd"));
	        	set_uyeSoyad( resultSet.getString("UyeSoyad"));
	        	set_gorev( resultSet.getString("Gorev"));
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

}
