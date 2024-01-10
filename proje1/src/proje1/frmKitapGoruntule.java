package proje1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class frmKitapGoruntule extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel consol;
	private JTextField txtKitapAdi;
	private JTextField txtYazar;
	private JTextField txtKategori;
	private JTextField txtYayinTarihi;
	private JLabel lblNewLabel_1_2;
	private JTable table;
	private JScrollPane tblKitapTablo;
	private JButton btnCikis;
	private JButton btnGeriDon;
	private JButton btnKitapEkle;
	private JButton btnOdunc;
	private JButton btnKitapSil;
	private JButton btnFiyatGncelle;
	private JTextField txtSilKitap;
	private JTextField txtFiyat;
	private JTextField txtKitapId;
	private JTextField txtAdetGuncelle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKitapGoruntule frame = new frmKitapGoruntule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmKitapGoruntule() {
		setTitle("Kütüphane/Kitapları Görüntüle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 816);
		consol = new JPanel();
		consol.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(consol);
		consol.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kitap Adı:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(45, 32, 103, 24);
		consol.add(lblNewLabel);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setBounds(45, 67, 208, 32);
		consol.add(txtKitapAdi);
		txtKitapAdi.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Yazar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(283, 32, 103, 24);
		consol.add(lblNewLabel_1);
		
		txtYazar = new JTextField();
		txtYazar.setColumns(10);
		txtYazar.setBounds(283, 67, 208, 32);
		consol.add(txtYazar);
		
		txtKategori = new JTextField();
		txtKategori.setColumns(10);
		txtKategori.setBounds(512, 67, 208, 32);
		consol.add(txtKategori);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kategori:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(512, 32, 103, 24);
		consol.add(lblNewLabel_1_1);
		
		txtYayinTarihi = new JTextField();
		txtYayinTarihi.setColumns(10);
		txtYayinTarihi.setBounds(738, 67, 208, 32);
		consol.add(txtYayinTarihi);
		
		lblNewLabel_1_2 = new JLabel("Yayın Tarihi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(738, 32, 103, 24);
		consol.add(lblNewLabel_1_2);
		
		tblKitapTablo = new JScrollPane();
		tblKitapTablo.setBounds(45, 110, 900, 375);
		consol.add(tblKitapTablo);
		
		table = new JTable();
		cKitap ck = new cKitap();
		ck.kitapListele(table);
		tblKitapTablo.setViewportView(table);
		
		btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int response = JOptionPane.showConfirmDialog(null, "Uygulamayı kapatmak istediğinize emin misiniz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			            System.exit(0); // Uygulamayı kapat
			        }
			}
		});
		btnCikis.setBounds(10, 676, 89, 90);
		consol.add(btnCikis);
		
		btnGeriDon = new JButton("Geri Dön");
		btnGeriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKullaniciAnaSayfa frm = new frmKullaniciAnaSayfa();
		        setVisible(false);
		        frm.setVisible(true);
			}
		});
		btnGeriDon.setBounds(109, 676, 89, 90);
		consol.add(btnGeriDon);
		
		btnKitapEkle = new JButton("Kitap Ekle");
		btnKitapEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmKitapEkle ke = new frmKitapEkle();
				setVisible(false);
				ke.setVisible(true);
			}
		});
		
		btnKitapEkle.setBounds(45, 492, 175, 147);
		consol.add(btnKitapEkle);
		
		btnOdunc = new JButton("Ödünç");
		btnOdunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOduncVer ov = new frmOduncVer();
				setVisible(false);
				ov.setVisible(true);
				
			}
		});
		btnOdunc.setBounds(226, 492, 175, 147);
		consol.add(btnOdunc);
		
		btnKitapSil = new JButton("Kitap Sil");
	
	
		btnKitapSil.setBounds(407, 492, 175, 147);
		consol.add(btnKitapSil);
		
		btnFiyatGncelle = new JButton("Fiyat Güncelle");
	
		btnFiyatGncelle.setBounds(592, 492, 175, 147);
		consol.add(btnFiyatGncelle);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Kitap Adı: ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2_1.setBounds(967, 240, 130, 24);
		consol.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Fiyat:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2_1_1.setBounds(967, 302, 130, 24);
		consol.add(lblNewLabel_1_2_1_1);
		
		txtSilKitap = new JTextField();
		txtSilKitap.setColumns(10);
		txtSilKitap.setBounds(1111, 238, 208, 32);
		txtSilKitap.setEditable(false);
		consol.add(txtSilKitap);
		
		txtFiyat = new JTextField();
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(1111, 300, 208, 32);
		consol.add(txtFiyat);
		
		txtKitapId = new JTextField();
		txtKitapId.setColumns(10);
		txtKitapId.setBounds(1329, 240, 15, 32);
		txtKitapId.setVisible(false);
		consol.add(txtKitapId);
		
		JComboBox<Object> cbSirala = new JComboBox<Object>();
	
		cbSirala.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbSirala.setBounds(956, 110, 252, 32);
		cbSirala.addItem("Sırala");
		cbSirala.addItem("Kitaba Adına Göre Sırala"); 
		cbSirala.addItem("Yayın Tarihine Göre ");
		cbSirala.addItem("Fiyata Göre Sırala");
		cbSirala.addItem("Silinmiş Kitaplar");
		consol.add(cbSirala);
		
		JButton btnAdetGuncelle = new JButton("Adet Güncelle");
	
		btnAdetGuncelle.setBounds(777, 492, 175, 147);
		consol.add(btnAdetGuncelle);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Adet:");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2_1_1_1.setBounds(967, 349, 130, 24);
		consol.add(lblNewLabel_1_2_1_1_1);
		
		txtAdetGuncelle = new JTextField();
		txtAdetGuncelle.setColumns(10);
		txtAdetGuncelle.setBounds(1111, 343, 208, 32);
		consol.add(txtAdetGuncelle);
		
		for (int i = 0; i < table.getColumnCount(); i++) {
		    Class<?> col_class = table.getColumnClass(i);
		    table.setDefaultEditor(col_class, null);
		}
		
		txtKitapAdi.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirAd(table, txtKitapAdi.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirAd(table, txtKitapAdi.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirAd(table, txtKitapAdi.getText());
			}

		 
		});
		
		txtYazar.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirYazar(table, txtYazar.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYazar(table, txtYazar.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYazar(table, txtYazar.getText());
			}

		 
		});
		
		txtKategori.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirKategori(table, txtKategori.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirKategori(table, txtKategori.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirKategori(table, txtKategori.getText());
			}

		 
		});
		
		txtYayinTarihi.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirYayinTarihi(table, txtYayinTarihi.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYayinTarihi(table, txtYayinTarihi.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYayinTarihi(table, txtYayinTarihi.getText());
			}

		 
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = table.getSelectedRow();

			       
			        if (selectedRow != -1) {
			          
			        	txtKitapId.setText(table.getValueAt(selectedRow, 0).toString()); 
			        	txtSilKitap.setText(table.getValueAt(selectedRow, 1).toString()); 
			        	txtFiyat.setText(table.getValueAt(selectedRow, 9).toString()); 
			        	txtAdetGuncelle.setText(table.getValueAt(selectedRow, 6).toString()); 
			        }
			}
		});
		
		btnKitapSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mesaj;
				if(	txtSilKitap.getText().isEmpty() ) {
					mesaj="Lütfen bir kitap seçiniz.";
			        JOptionPane.showMessageDialog(consol, mesaj);
				}
				else {
					
				
				 int response = JOptionPane.showConfirmDialog(null, "Bu kitabı silmek istediğinize emin misiniz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			        	cKitap ck = new cKitap();
						
						String kitapSilId = txtKitapId.getText();
						int kitapID = Integer.parseInt(kitapSilId);
			            boolean sonuc = ck.KitapSil(kitapID);
			            if(sonuc) {
			            	mesaj="Kitap silinmiştir.";
					        JOptionPane.showMessageDialog(consol, mesaj);
					        DefaultTableModel model = (DefaultTableModel) table.getModel();
					        model.setRowCount(0); 

					    
					    	ck.kitapListele(table);
					    
					     
			            }
			            else {
			            	mesaj="Kitap silinememiştir";
					        JOptionPane.showMessageDialog(consol, mesaj);
			            }
			     }
			}
			}
		});
		
		btnFiyatGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mesaj;
				if(	txtSilKitap.getText().isEmpty() ) {
					mesaj="Lütfen bir kitap seçiniz.";
			        JOptionPane.showMessageDialog(consol, mesaj);
				}
				else {
				 int response = JOptionPane.showConfirmDialog(null, "Fiyat güncellemek istiyor musunuz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			        	cKitap ck = new cKitap();
			        	String kitapSilId = txtKitapId.getText();
						int kitapID = Integer.parseInt(kitapSilId);
						String fiyat = txtFiyat.getText();
						int fiyatDegistir = Integer.parseInt(fiyat);
			            boolean sonuc = ck.KitapFiyatGüncelle(kitapID,fiyatDegistir);
			            if(sonuc) {
			            	mesaj="Kitap fiyat güncellenmiştir.";
					        JOptionPane.showMessageDialog(consol, mesaj);
					        DefaultTableModel model = (DefaultTableModel) table.getModel();
					        model.setRowCount(0); 

					    
					    	ck.kitapListele(table);
					     
			            }
			            else {
			            	mesaj="Kitap fiyatı güncellenememiştir";
					        JOptionPane.showMessageDialog(consol, mesaj);
			            }
			        }
				}
			}
		});
		btnAdetGuncelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mesaj;
				if(	txtSilKitap.getText().isEmpty() ) {
					mesaj="Lütfen bir kitap seçiniz.";
			        JOptionPane.showMessageDialog(consol, mesaj);
				}
				else {
				 int response = JOptionPane.showConfirmDialog(null, "Adeti guncellemek istiyor musunuz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			        	cKitap ck = new cKitap();
			        	String kitapSilId = txtKitapId.getText();
						int kitapID = Integer.parseInt(kitapSilId);
						String adet = txtAdetGuncelle.getText();
						int adetGuncelle = Integer.parseInt(adet);
			            boolean sonuc = ck.KitapAdetGüncelle(kitapID,adetGuncelle);
			            if(sonuc) {
			            	mesaj="Kitap adet güncellenmiştir.";
					        JOptionPane.showMessageDialog(consol, mesaj);
					        DefaultTableModel model = (DefaultTableModel) table.getModel();
					        model.setRowCount(0); 

					    
					    	ck.kitapListele(table);
					     
			            }
			            else {
			            	mesaj="Kitap adeti güncellenememiştir";
					        JOptionPane.showMessageDialog(consol, mesaj);
			            }
			        }
				}
			}
		});
		cbSirala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String selectedValue = cbSirala.getSelectedItem().toString();
			        
				 if (selectedValue.equals("Kitaba Adına Göre Sırala")) {
					    cKitap ck = new cKitap();
					    List<cKitap> kitapListesi = ck.KitapGetir();

					    cSiralama cs = new cSiralama();
					    KitapSiralamaStrategy kitapAdinaGoreSirala = new cKitapAdinaGoreSiralama();
					    cs.setSortingStrategy(kitapAdinaGoreSirala);

					    // Kitapları sırala
					    cs.kitaplariListele(kitapListesi,table);

					    // Tablo modelini oluştur
					 
					
					   
					} else if(selectedValue.equals("Yayın Tarihine Göre ")){
						cKitap ck = new cKitap();
					    List<cKitap> kitapListesi = ck.KitapGetir();

					    cSiralama cs = new cSiralama();
					    KitapSiralamaStrategy kitapTarihineGore = new cKitapTarihineGoreSiralama();
					    cs.setSortingStrategy(kitapTarihineGore);

					    // Kitapları sırala
					    cs.kitaplariListele(kitapListesi,table);

			        }
					else if((selectedValue.equals("Fiyata Göre Sırala"))) {
						cKitap ck = new cKitap();
					    List<cKitap> kitapListesi = ck.KitapGetir();

					    cSiralama cs = new cSiralama();
					    KitapSiralamaStrategy fiyatS = new cFiyatSiralama();
					    cs.setSortingStrategy(fiyatS);

					    // Kitapları sırala
					    cs.kitaplariListele(kitapListesi,table);
					}
					else if((selectedValue.equals("Sırala"))) {
						cKitap ck = new cKitap();
						KitapState durumGetir = new cDurumKitapState();
						 cSiralama cs = new cSiralama();
						 List<cKitap> kitapListesi= ck.DurumKitapGetir();
						 cs.setState(durumGetir);
						 cs.kitaplarinGuncelDurumuListele(kitapListesi, table);
					
					  
					}
				 
					else {
						cKitap ck = new cKitap();
						KitapState durumGetir = new cDurumKitapState();
						 List<cKitap> kitapListesi = ck.silinmisKitapGetir();
						 cSiralama cs = new cSiralama();
						 cs.setState(durumGetir);
						 cs.kitaplarinGuncelDurumuListele(kitapListesi, table);
						 
					}
			}
		});

	}
}
