package proje1;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
public class cHaraketler {
	
	   private int _PersonelId;
	   private String _Islem;
	   private LocalDateTime  _Tarih;
	   
	   public int get_UyeId() {
		return _UyeId;
	}
		public void set_UyeId(int _UyeId) {
			this._UyeId = _UyeId;
		}
		public String get_UyeIslem() {
			return _UyeIslem;
		}
		public void set_UyeIslem(String _UyeIslem) {
			this._UyeIslem = _UyeIslem;
		}
		public LocalDateTime get_UyeTarih() {
			return _UyeTarih;
		}
		public void set_UyeTarih(LocalDateTime _UyeTarih) {
		this._UyeTarih = _UyeTarih;
	}
		private int _UyeId;
	   private String _UyeIslem;
	   private LocalDateTime  _UyeTarih;
	   
	   
	   
	   
	   public void setPersonelId(int id) {
		   this._PersonelId=id;
	   }
	   public int getPersonelId() {
		   return _PersonelId;
	   }
	   public void setIslem(String islem) {
		   this._Islem=islem;
	   }
	   public String getIslem() {
		   return _Islem;
	   }
	   public void setTarih(LocalDateTime  tarih) {
		   this._Tarih=tarih;
	   }  
	   public LocalDateTime  getTarih() {
		   return _Tarih;
	   }
	   
	   public boolean personelGirisKontrol(cHaraketler ch) {
	        boolean result = false;
	        Connection connect = null;
	        PreparedStatement statement = null;

	        try {
	        	  Database veri = new DBConnect(new cVeritabani());
	  	        connect = veri.baglanti();
	            String sql = "INSERT INTO KULLANICIHARAKETLERI (KullaniciID, Islem, Tarih) VALUES (?, ?, ?)";
	            statement = connect.prepareStatement(sql);
	            statement.setInt(1, ch.getPersonelId());
	            statement.setString(2, ch.getIslem());

	         
	            LocalDateTime localDateTime = ch.getTarih();
	            Timestamp timestamp = Timestamp.valueOf(localDateTime);

	            statement.setTimestamp(3, timestamp);

	            int affectedRows = statement.executeUpdate();
	            if (affectedRows > 0) {
	                result = true;
	            } else {
	                result = false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
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
	   public boolean uyeGirisKontrol(cHaraketler ch) {
	        boolean result = false;
	        Connection connect = null;
	        PreparedStatement statement = null;

	        try {
	        	  Database veri = new DBConnect(new cVeritabani());
	  	        connect = veri.baglanti();
	            String sql = "INSERT INTO UYEHAREKETLERI (UyeID, Islem, Tarih) VALUES (?, ?, ?)";
	            statement = connect.prepareStatement(sql);
	            statement.setInt(1, ch.get_UyeId());
	            statement.setString(2, ch.get_UyeIslem());

	         
	            LocalDateTime localDateTime = ch.get_UyeTarih();
	            Timestamp timestamp = Timestamp.valueOf(localDateTime);

	            statement.setTimestamp(3, timestamp);

	            int affectedRows = statement.executeUpdate();
	            if (affectedRows > 0) {
	                result = true;
	            } else {
	                result = false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
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

}
