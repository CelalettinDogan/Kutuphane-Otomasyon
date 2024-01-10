package proje1;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cKitap extends cDurumGetir {

    public String get_kitapAd() {
		return _kitapAd;
	}
	public void set_kitapAd(String _kitapAd) {
		this._kitapAd = _kitapAd;
	}
	public int get_kitapId() {
		return _kitapId;
	}
	public void set_kitapId(int _kitapId) {
		this._kitapId = _kitapId;
	}
	public int get_sayfaSayisi() {
		return _sayfaSayisi;
	}
	public void set_sayfaSayisi(int _sayfaSayisi) {
		this._sayfaSayisi = _sayfaSayisi;
	}
	public int get_adet() {
		return _adet;
	}
	public void set_adet(int _adet) {
		this._adet = _adet;
	}
	public double get_fiyat() {
		return _fiyat;
	}
	public void set_fiyat(double _fiyat) {
		this._fiyat = _fiyat;
	}
	public int get_rafId() {
		return _rafId;
	}
	public void set_rafId(int _rafId) {
		this._rafId = _rafId;
	}
	public int get_yayinEviId() {
		return _yayinEviId;
	}
	public void set_yayinEviId(int _yayinEviId) {
		this._yayinEviId = _yayinEviId;
	}
	public int get_yazarId() {
		return _yazarId;
	}
	public void set_yazarId(int _yazarId) {
		this._yazarId = _yazarId;
	}
	public int get_yayinTarihi() {
		return _yayinTarihi;
	}
	public void set_yayinTarihi(int _yayinTarihi) {
		this._yayinTarihi = _yayinTarihi;
	}
	private String _kitapAd;
	public String get_YazarAd() {
		return _YazarAd;
	}
	public void set_YazarAd(String _YazarAd) {
		this._YazarAd = _YazarAd;
	}
	public String get_YazarSoyad() {
		return _YazarSoyad;
	}
	public void set_YazarSoyad(String _YazarSoyad) {
		this._YazarSoyad = _YazarSoyad;
	}
	public String get_Kategoriler() {
		return _Kategoriler;
	}
	public void set_Kategoriler(String _Kategoriler) {
		this._Kategoriler = _Kategoriler;
	}
	public String get_RafNo() {
		return _RafNo;
	}
	public void set_RafNo(String _RafNo) {
		this._RafNo = _RafNo;
	}
	public String get_YayinEviAdi() {
		return _YayinEviAdi;
	}
	public void set_YayinEviAdi(String _YayinEviAdi) {
		this._YayinEviAdi = _YayinEviAdi;
	}
	
	
	private String _YazarAd;
	private String _YazarSoyad;
	private String _Kategoriler;
	private String _RafNo;
	private String _YayinEviAdi;
	
    private int _kitapId;
    private int _sayfaSayisi;
    private int _adet;
    private double _fiyat;
    private int _rafId;
    private int _yayinEviId;
    private int _yazarId;
    private int _yayinTarihi;
    public int get_kategoriID() {
		return _kategoriID;
	}
	public void set_kategoriID(int _kategoriID) {
		this._kategoriID = _kategoriID;
	}
	public int get_kategoriID2() {
		return _kategoriID2;
	}
	public void set_kategoriID2(int _kategoriID2) {
		this._kategoriID2 = _kategoriID2;
	}
	private int _kategoriID;
    private int _kategoriID2;
    
    DefaultTableModel table = new DefaultTableModel();
  	 String[] kolon = {"ID", "KİTAP AD", "YAZAR AD","YAZAR SOYAD", "KATEGORİ", "YAYIN TARİHİ", "ADET", "RAF","YAYIN EVİ","FİYAT"};
	 String[] kolon3 = {"ID", "Uye Numara", "Uye Ad","Uye Soyad","KitapAdi","Adet", "EmanetTarihi","TeslimTarihi"};
	 DefaultTableModel table2 = new DefaultTableModel();
   	 String[] kolon2 = {"ID", "Kitap Adı", "Adet","Fiyat"};
   	 
   	 
    
   	 
    //Kitapları listeler
    public void kitapListele(JTable tablo) {
        table.setColumnIdentifiers(kolon);

	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	    	  Database veri = new DBConnect(new cVeritabani());
		        connect = veri.baglanti();
	        String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
	        		+ "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
	        		+ "FROM KITAPLAR \r\n"
	        		+ "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
	        		+ "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
	        		+ "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
	        		+ "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
	        		+ "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID where KITAPLAR.Durum=1 \r\n"
	        		+ "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            Object[] row = {
	            		resultSet.getInt("ID"),
	            		resultSet.getString("KitapAdi"),
	            		resultSet.getString("YazarAd"),
	            		resultSet.getString("YazarSoyad"),
	            		resultSet.getString("Kategoriler"),
	            		resultSet.getString("YayınTarihi"),
	            		resultSet.getString("Adet"),
	            		resultSet.getString("RafNo"),
	            		resultSet.getString("YayinEviAdi"),
	            		resultSet.getInt("Fiyat")

	            };
	            table.addRow(row);
	        }

	        tablo.setModel(table); 
	        
	        tablo.getColumnModel().getColumn(0).setMinWidth(0);
	        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
	        tablo.getColumnModel().getColumn(0).setWidth(0);
	        
	        tablo.getColumnModel().getColumn(5).setMinWidth(70);
	        tablo.getColumnModel().getColumn(5).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(5).setWidth(70);

	        tablo.getColumnModel().getColumn(6).setMinWidth(70);
	        tablo.getColumnModel().getColumn(6).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(6).setWidth(70);
	        
	        tablo.getColumnModel().getColumn(7).setMinWidth(70);
	        tablo.getColumnModel().getColumn(7).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(7).setWidth(70);
	        
	        tablo.getColumnModel().getColumn(9).setMinWidth(70);
	        tablo.getColumnModel().getColumn(9).setMaxWidth(70);
	        tablo.getColumnModel().getColumn(9).setWidth(70);

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
    
    public List<cKitap> DurumKitapGetir() {
        List<cKitap> kitaplar = new ArrayList<>(); // Boş bir kitap listesi oluştur

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql =  "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
	        		+ "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
	        		+ "FROM KITAPLAR \r\n"
	        		+ "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
	        		+ "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
	        		+ "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
	        		+ "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
	        		+ "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID where KITAPLAR.Durum=1 \r\n"
	        		+ "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cKitap kitap = new cKitap(); // Yeni bir cKitap nesnesi oluştur
                kitap.set_kitapId(resultSet.getInt("ID"));
                kitap.set_kitapAd(resultSet.getString("KitapAdi"));
                kitap.set_YazarAd(resultSet.getString("YazarAd"));
                kitap.set_YazarSoyad(resultSet.getString("YazarSoyad"));
                kitap.set_Kategoriler(resultSet.getString("Kategoriler"));
                kitap.set_yayinTarihi(resultSet.getInt("YayınTarihi"));
                kitap.set_adet(resultSet.getInt("Adet"));
                kitap.set_RafNo(resultSet.getString("RafNo"));
                kitap.set_YayinEviAdi(resultSet.getString("YayinEviAdi"));
                kitap.set_fiyat(resultSet.getDouble("Fiyat"));

                kitaplar.add(kitap); // Kitabı listeye ekle
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

        return kitaplar; // Kitap listesini döndür
    }
    //Kitap adına göre getirir
    public void KitapGetirAd(JTable tablo, String KitapAd) {
    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
        table.setColumnIdentifiers(kolon);
       

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
            		+ "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
            		+ "FROM KITAPLAR \r\n"
            		+ "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
            		+ "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
            		+ "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
            		+ "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
            		+ "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID\r\n"
            		+ "where  KITAPLAR.Durum=1 and KITAPLAR.KitapAdi LIKE ? \r\n"
            		+ "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            statement.setString(1,  KitapAd + "%"); 
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
	            Object[] row = {
	            		resultSet.getInt("ID"),
	            		resultSet.getString("KitapAdi"),
	            		resultSet.getString("YazarAd"),
	            		resultSet.getString("YazarSoyad"),
	            		resultSet.getString("Kategoriler"),
	            		resultSet.getString("YayınTarihi"),
	            		resultSet.getString("Adet"),
	            		resultSet.getString("RafNo"),
	            		resultSet.getString("YayinEviAdi"),
	            		resultSet.getInt("Fiyat")

	            };
	            table.addRow(row);
	            tablo.getColumnModel().getColumn(0).setMinWidth(0);
		        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
		        tablo.getColumnModel().getColumn(0).setWidth(0);
		        
		        tablo.getColumnModel().getColumn(5).setMinWidth(70);
		        tablo.getColumnModel().getColumn(5).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(5).setWidth(70);

		        tablo.getColumnModel().getColumn(6).setMinWidth(70);
		        tablo.getColumnModel().getColumn(6).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(6).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(7).setMinWidth(70);
		        tablo.getColumnModel().getColumn(7).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(7).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(9).setMinWidth(70);
		        tablo.getColumnModel().getColumn(9).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(9).setWidth(70);
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
    //Yazar adına göre getiir.
    public void KitapGetirYazar(JTable tablo, String KitapYazar) {
    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
        table.setColumnIdentifiers(kolon);
       

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
            		+ "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
            		+ "FROM KITAPLAR \r\n"
            		+ "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
            		+ "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
            		+ "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
            		+ "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
            		+ "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID\r\n"
            		+ "where  KITAPLAR.Durum=1 and YAZARLAR.YazarAd  LIKE ? \r\n"
            		+ "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            statement.setString(1, "%" + KitapYazar + "%"); 
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
	            Object[] row = {
	            		resultSet.getInt("ID"),
	            		resultSet.getString("KitapAdi"),
	            		resultSet.getString("YazarAd"),
	            		resultSet.getString("YazarSoyad"),
	            		resultSet.getString("Kategoriler"),
	            		resultSet.getString("YayınTarihi"),
	            		resultSet.getString("Adet"),
	            		resultSet.getString("RafNo"),
	            		resultSet.getString("YayinEviAdi"),
	            		resultSet.getInt("Fiyat")

	            };
	            table.addRow(row);
	            tablo.getColumnModel().getColumn(0).setMinWidth(0);
		        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
		        tablo.getColumnModel().getColumn(0).setWidth(0);
		        
		        tablo.getColumnModel().getColumn(5).setMinWidth(70);
		        tablo.getColumnModel().getColumn(5).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(5).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(6).setMinWidth(70);
		        tablo.getColumnModel().getColumn(6).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(6).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(7).setMinWidth(70);
		        tablo.getColumnModel().getColumn(7).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(7).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(9).setMinWidth(70);
		        tablo.getColumnModel().getColumn(9).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(9).setWidth(70);
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
    //kATEGORİ adına göre getiir.
    public void KitapGetirKategori(JTable tablo, String KitapKategori) {
    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
        table.setColumnIdentifiers(kolon);
       

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
            		+ "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
            		+ "FROM KITAPLAR \r\n"
            		+ "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
            		+ "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
            		+ "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
            		+ "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
            		+ "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID\r\n"
            		+ "where KITAPLAR.Durum=1 and KATEGORILER.KategoriAdi  LIKE ? \r\n"
            		+ "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            statement.setString(1, "%" + KitapKategori + "%"); 
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
	            Object[] row = {
	            		resultSet.getInt("ID"),
	            		resultSet.getString("KitapAdi"),
	            		resultSet.getString("YazarAd"),
	            		resultSet.getString("YazarSoyad"),
	            		resultSet.getString("Kategoriler"),
	            		resultSet.getString("YayınTarihi"),
	            		resultSet.getString("Adet"),
	            		resultSet.getString("RafNo"),
	            		resultSet.getString("YayinEviAdi"),
	            		resultSet.getInt("Fiyat")

	            };
	            table.addRow(row);
	            tablo.getColumnModel().getColumn(0).setMinWidth(0);
		        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
		        tablo.getColumnModel().getColumn(0).setWidth(0);
		        
		        tablo.getColumnModel().getColumn(5).setMinWidth(70);
		        tablo.getColumnModel().getColumn(5).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(5).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(6).setMinWidth(70);
		        tablo.getColumnModel().getColumn(6).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(6).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(7).setMinWidth(70);
		        tablo.getColumnModel().getColumn(7).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(7).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(9).setMinWidth(70);
		        tablo.getColumnModel().getColumn(9).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(9).setWidth(70);
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
    //Yayın tarihine  adına göre getiir.
    public void KitapGetirYayinTarihi(JTable tablo, String KitapYayin) {
    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
        table.setColumnIdentifiers(kolon);
       

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
            		+ "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
            		+ "FROM KITAPLAR \r\n"
            		+ "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
            		+ "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
            		+ "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
            		+ "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
            		+ "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID\r\n"
            		+ "where KITAPLAR.Durum=1 and KITAPLAR.YayınTarihi  LIKE ? \r\n"
            		+ "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            statement.setString(1, KitapYayin + "%"); 
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
	            Object[] row = {
	            		resultSet.getInt("ID"),
	            		resultSet.getString("KitapAdi"),
	            		resultSet.getString("YazarAd"),
	            		resultSet.getString("YazarSoyad"),
	            		resultSet.getString("Kategoriler"),
	            		resultSet.getString("YayınTarihi"),
	            		resultSet.getString("Adet"),
	            		resultSet.getString("RafNo"),
	            		resultSet.getString("YayinEviAdi"),
	            		resultSet.getInt("Fiyat")

	            };
	            table.addRow(row);
	            tablo.getColumnModel().getColumn(0).setMinWidth(0);
		        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
		        tablo.getColumnModel().getColumn(0).setWidth(0);
		        
		        tablo.getColumnModel().getColumn(5).setMinWidth(70);
		        tablo.getColumnModel().getColumn(5).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(5).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(6).setMinWidth(70);
		        tablo.getColumnModel().getColumn(6).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(6).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(7).setMinWidth(70);
		        tablo.getColumnModel().getColumn(7).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(7).setWidth(70);
		        
		        tablo.getColumnModel().getColumn(9).setMinWidth(70);
		        tablo.getColumnModel().getColumn(9).setMaxWidth(70);
		        tablo.getColumnModel().getColumn(9).setWidth(70);
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

    //Kitap Sil
    
    public boolean KitapSil(int kitapID) {
		 boolean result =false;
		 Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "UPDATE KITAPLAR SET DURUM = 0 WHERE ID = ?";
		        
		        statement = connect.prepareStatement(sql);
		        statement.setInt(1, kitapID);

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
    //Kitap fiyatını günceller
    public boolean KitapFiyatGüncelle(int kitapID,int Fiyat) {
		 boolean result =false;
		 Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
		  	        connect = veri.baglanti();
		        String sql = "UPDATE KITAPLAR SET Fiyat = ? WHERE ID = ?";
		        
		        statement = connect.prepareStatement(sql);
		        statement.setInt(1, Fiyat);
		        statement.setInt(2, kitapID);

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
   
    //Adet günceller
    public boolean KitapAdetGüncelle(int kitapID,int adet) {
 		 boolean result =false;
 		 Connection connect = null;
 		    PreparedStatement statement = null;

 		    try {
 		    	  Database veri = new DBConnect(new cVeritabani());
 		  	        connect = veri.baglanti();
 		        String sql = "UPDATE KITAPLAR SET Adet = ? WHERE ID = ?";
 		        
 		        statement = connect.prepareStatement(sql);
 		        statement.setInt(1, adet);
 		        statement.setInt(2, kitapID);

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
    
    //Kitapları getirir ve arrayListe ekler 
    public List<cKitap> KitapGetir() {
        List<cKitap> kitaplar = new ArrayList<>(); // Boş bir kitap listesi oluştur

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
                    + "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
                    + "FROM KITAPLAR \r\n"
                    + "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
                    + "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
                    + "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
                    + "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
                    + "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID where KITAPLAR.Durum=1 \r\n"
                    + "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cKitap kitap = new cKitap(); // Yeni bir cKitap nesnesi oluştur
                kitap.set_kitapId(resultSet.getInt("ID"));
                kitap.set_kitapAd(resultSet.getString("KitapAdi"));
                kitap.set_YazarAd(resultSet.getString("YazarAd"));
                kitap.set_YazarSoyad(resultSet.getString("YazarSoyad"));
                kitap.set_Kategoriler(resultSet.getString("Kategoriler"));
                kitap.set_yayinTarihi(resultSet.getInt("YayınTarihi"));
                kitap.set_adet(resultSet.getInt("Adet"));
                kitap.set_RafNo(resultSet.getString("RafNo"));
                kitap.set_YayinEviAdi(resultSet.getString("YayinEviAdi"));
                kitap.set_fiyat(resultSet.getDouble("Fiyat"));

                kitaplar.add(kitap); // Kitabı listeye ekle
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

        return kitaplar; // Kitap listesini döndür
    }

    //Silinmiş kitapları getirmek için
    
    public List<cKitap> silinmisKitapGetir() {
        List<cKitap> kitaplar = new ArrayList<>(); // Boş bir kitap listesi oluştur

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT KITAPLAR.ID, KITAPLAR.KitapAdi,YAZARLAR.YazarAd,Yazarlar.YazarSoyad,\r\n"
                    + "       STRING_AGG(KATEGORILER.KategoriAdi, ', ') AS Kategoriler, KITAPLAR.YayınTarihi, KITAPLAR.Adet,RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat\r\n"
                    + "FROM KITAPLAR \r\n"
                    + "INNER JOIN YAYINEVI  ON KITAPLAR.YayinEviID = YAYINEVI.ID\r\n"
                    + "INNER JOIN RAF  ON KITAPLAR.RafID = RAF.RafID\r\n"
                    + "INNER JOIN YAZARLAR  ON KITAPLAR.YazarID = YAZARLAR.ID\r\n"
                    + "INNER JOIN KITAPKATEGORI  ON KITAPLAR.ID = KITAPKATEGORI.KitapID\r\n"
                    + "INNER JOIN KATEGORILER  ON KITAPKATEGORI.KategoriID = KATEGORILER.ID where KITAPLAR.Durum=0 \r\n"
                    + "GROUP BY KITAPLAR.ID, KITAPLAR.KitapAdi, YAZARLAR.YazarAd,Yazarlar.YazarSoyad, KITAPLAR.YayınTarihi, KITAPLAR.Adet, RAF.RafNo, YAYINEVI.YayinEviAdi, KITAPLAR.Fiyat;";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cKitap kitap = new cKitap(); // Yeni bir cKitap nesnesi oluştur
                kitap.set_kitapId(resultSet.getInt("ID"));
                kitap.set_kitapAd(resultSet.getString("KitapAdi"));
                kitap.set_YazarAd(resultSet.getString("YazarAd"));
                kitap.set_YazarSoyad(resultSet.getString("YazarSoyad"));
                kitap.set_Kategoriler(resultSet.getString("Kategoriler"));
                kitap.set_yayinTarihi(resultSet.getInt("YayınTarihi"));
                kitap.set_adet(resultSet.getInt("Adet"));
                kitap.set_RafNo(resultSet.getString("RafNo"));
                kitap.set_YayinEviAdi(resultSet.getString("YayinEviAdi"));
                kitap.set_fiyat(resultSet.getDouble("Fiyat"));

                kitaplar.add(kitap); // Kitabı listeye ekle
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

        return kitaplar; // Kitap listesini döndür
    }
    
    
    // Ödünç alınan kitapları listelemek için
    
    public void kitapListeleOdunc(JTable tablo, String UyeNo) {
    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table2.setRowCount(0);
        table2.setColumnIdentifiers(kolon2);
       

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "select ID,KitapAdi,Adet,Fiyat from KITAPLAR where KitapAdi LIKE ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1,  UyeNo + "%"); 
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
    //Kitapları adına göre getirir
    public void KitapGetirAdUye(JTable tablo, String KitapAd,int UyeID) {
    	DefaultTableModel table = (DefaultTableModel) tablo.getModel();
        table.setRowCount(0);
        table.setColumnIdentifiers(kolon3);
       

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
	        		+ "FROM UYELER, EMANET, KITAPLAR WHERE EMANET.UyeID = UYELER.ID AND EMANET.KitapID = KITAPLAR.ID AND KitapAdi LIKE ?  AND UYELER.ID=?";
	        statement = connect.prepareStatement(sql);
	      
	     
            statement.setString(1, KitapAd + "%"); 
            statement.setInt(2, UyeID);
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
	            tablo.getColumnModel().getColumn(0).setMinWidth(0);
		        tablo.getColumnModel().getColumn(0).setMaxWidth(0);
		        tablo.getColumnModel().getColumn(0).setWidth(0);
		   
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
// yazara göre getirir
    public void yazarGetir(JComboBox<String> cbYazar) {
        cbYazar.removeAllItems();
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "select ID, YazarAd from YAZARLAR where Durum=1";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String yazarAdi = resultSet.getString("YazarAd");
                cbYazar.addItem(yazarAdi);
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

 

// rafları getirir
    public void rafGetir(JComboBox<String> cb) {
    	cb.removeAllItems();
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "select * from Raf";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String rafNo = resultSet.getString("RafNo");
                cb.addItem(rafNo);
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
    //yayın evi getirir
    public void yayinEviGetir(JComboBox<String> cb) {
    	cb.removeAllItems();
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "select * from YAYINEVI";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String yayinevi = resultSet.getString("YayinEviAdi");
                cb.addItem(yayinevi);
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
//kategorileri getirir
    public void KategoriGetir(JComboBox<String> cb) {
    	cb.removeAllItems();
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "select * from KATEGORILER";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String kategori = resultSet.getString("KategoriAdi");
                cb.addItem(kategori);
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

//yazarId lerini getirir
    public static int getYazarID(String yazarAdi) {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int yazarID = 0;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT ID FROM YAZARLAR WHERE YazarAd = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, yazarAdi);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                yazarID = resultSet.getInt("ID");
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
        return yazarID;
    }
    
    //kategori ıd sini alır
    public static int getKategoriID(String katID) {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int kategoriId = 0;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT ID FROM KATEGORILER WHERE KategoriAdi = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, katID);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	kategoriId = resultSet.getInt("ID");
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
        return kategoriId;
    }
    //raf ıd yi alır
    public static int getRafID(String rafNo) {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int raf = 0;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT RafID FROM Raf WHERE RafNo = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, rafNo);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                raf = resultSet.getInt("RafID");
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
        return raf;
    }
    
    //yayin evi getirir
    public static int getYayinEviID(String yayinEviAdi) {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int yayinEvi = 0;

        try {
        	  Database veri = new DBConnect(new cVeritabani());
  	        connect = veri.baglanti();
            String sql = "SELECT ID FROM YAYINEVI WHERE YayinEviAdi = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, yayinEviAdi);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	yayinEvi = resultSet.getInt("ID");
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
        return yayinEvi;
    }
 

// kitapların durumunu  kontrol edilir

		public boolean YayinEviVarMi(String yayinEviAdi) {
		    boolean sonuc = false;
		    Connection connect = null;
		    CallableStatement statement = null;
		    
		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        
		        String storedProcedureCall = "{ call yayinEviVarmi(?, ?) }";
		        statement = connect.prepareCall(storedProcedureCall);
		        
		        statement.setString(1, yayinEviAdi);
		        statement.registerOutParameter(2, Types.INTEGER);
		        
		        statement.execute();
		        
		        int output = statement.getInt(2);
		        
		      
		        if (output == 1) {
		            sonuc = true;
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
		    
		    return sonuc;
		}

		public void yayinEviEkle(String yayinEviAdi) {
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "INSERT INTO YAYINEVI (yayineviAdi) VALUES (?)";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, yayinEviAdi);
		        
	
		        
		      
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
		public boolean rafVarMi(String rafAdi) {
		    boolean sonuc = false;
		    Connection connect = null;
		    CallableStatement statement = null;
		    
		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        
		        String storedProcedureCall = "{ call rafVarMi (?, ?) }";
		        statement = connect.prepareCall(storedProcedureCall);
		        
		        statement.setString(1, rafAdi);
		        statement.registerOutParameter(2, Types.INTEGER);
		        
		        statement.execute();
		        
		        int output = statement.getInt(2);
		        
		      
		        if (output == 1) {
		            sonuc = true;
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
		    
		    return sonuc;
		}

		public void rafEkle(String rafAdi) {
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "INSERT INTO RAF (RafNo) VALUES (?)";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, rafAdi);
		     
		        
		      
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
		public boolean yazarVarMi(String yazarAdi) {
		    boolean sonuc = false;
		    Connection connect = null;
		    CallableStatement statement = null;
		    
		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        
		        String storedProcedureCall = "{ call YazarVarMi (?, ?) }";
		        statement = connect.prepareCall(storedProcedureCall);
		        
		        statement.setString(1, yazarAdi);
		        statement.registerOutParameter(2, Types.INTEGER);
		        
		        statement.execute();
		        
		        int output = statement.getInt(2);
		        
		      
		        if (output == 1) {
		            sonuc = true;
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
		    
		    return sonuc;
		}

		public void yazarEkle(String yazarAdi) {
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		    	  Database veri = new DBConnect(new cVeritabani());
			        connect = veri.baglanti();
		        String sql = "INSERT INTO YAZARLAR (YazarAd) VALUES (?)";
		        statement = connect.prepareStatement(sql);
		        statement.setString(1, yazarAdi);
		        

		        
		      
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
	
		public boolean DurumGetir (String Ad) {
			  boolean durum = false;
			    Connection connect = null;
			    PreparedStatement statement = null;
			    ResultSet resultSet = null;

			    try {
			    	  Database veri = new DBConnect(new cVeritabani());
				        connect = veri.baglanti();
			        String sql = "select Durum from KITAPLAR where KitapAdi= ? ";
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
