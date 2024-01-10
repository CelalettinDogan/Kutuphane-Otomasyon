package proje1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class frmKitapEkle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtKitapAdi;
	private JTextField txtYayinTarihi;
	private JTextField txtSayfaSayisi;
	private JTextField txtAdet;
	private JTextField txtYayinEvi;
	private JTextField txtRafID;
	private JTextField txtFiyat;
	private JTextField txtKategoriID2;
	private JTextField txtKategoriID1;
	private JTextField txtYazarID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKitapEkle frame = new frmKitapEkle();
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
	public frmKitapEkle() {
		setTitle("Kütüphane/Kitap Ekle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 773);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(223, 223, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKitapAdi = new JLabel("Kitap Adı:");
		lblKitapAdi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKitapAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKitapAdi.setBounds(103, 185, 131, 36);
		contentPane.add(lblKitapAdi);
		
		JLabel lblSayfaSayısı = new JLabel("Sayfa Sayısı:");
		lblSayfaSayısı.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSayfaSayısı.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSayfaSayısı.setBounds(103, 284, 131, 36);
		contentPane.add(lblSayfaSayısı);
		
		JLabel lblAdet = new JLabel("Adet:");
		lblAdet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdet.setBounds(103, 331, 131, 36);
		contentPane.add(lblAdet);
		
		JLabel lblYaynEvi = new JLabel("Yayın Evi:");
		lblYaynEvi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYaynEvi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYaynEvi.setBounds(103, 44, 131, 36);
		contentPane.add(lblYaynEvi);
		
		JLabel lblRaf = new JLabel("Raf:");
		lblRaf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaf.setBounds(103, 91, 131, 36);
		contentPane.add(lblRaf);
		
		JLabel lblYayinTarihi = new JLabel("Yayın Tarihi:");
		lblYayinTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYayinTarihi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYayinTarihi.setBounds(103, 237, 131, 36);
		contentPane.add(lblYayinTarihi);
		
		JLabel lblNewLabel_1 = new JLabel("KİTAP KAYIT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(146, 0, 359, 56);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> cbYayinEvi = new JComboBox<String>();
	
		cKitap ck = new cKitap();
		ck.yayinEviGetir(cbYayinEvi);
		cbYayinEvi.setBounds(244, 45, 290, 38);
		contentPane.add(cbYayinEvi);
		
		JComboBox<String> cbRaf = new JComboBox<String>();
	
		ck.rafGetir(cbRaf);
		
		cbRaf.setBounds(244, 92, 290, 38);
		contentPane.add(cbRaf);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setBounds(244, 186, 290, 38);
		contentPane.add(txtKitapAdi);
		txtKitapAdi.setColumns(10);
		
		txtYayinTarihi = new JTextField();
		txtYayinTarihi.setColumns(10);
		txtYayinTarihi.setBounds(244, 235, 290, 38);
		contentPane.add(txtYayinTarihi);
		
		txtSayfaSayisi = new JTextField();
		txtSayfaSayisi.setColumns(10);
		txtSayfaSayisi.setBounds(244, 284, 290, 38);
		contentPane.add(txtSayfaSayisi);
		
		txtAdet = new JTextField();
		txtAdet.setColumns(10);
		txtAdet.setBounds(244, 332, 290, 38);
		contentPane.add(txtAdet);
		
		JButton btnKayitEkle = new JButton("Kayıt Ekle");
		
		btnKayitEkle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnKayitEkle.setBounds(88, 535, 524, 71);
		contentPane.add(btnKayitEkle);
		
		txtYayinEvi = new JTextField();
		txtYayinEvi.setText("1");
		txtYayinEvi.setColumns(10);
		txtYayinEvi.setBounds(544, 45, 16, 38);
		txtYayinEvi.setVisible(false);
		contentPane.add(txtYayinEvi);
		
		txtRafID = new JTextField();
		txtRafID.setText("1");
		txtRafID.setColumns(10);
		txtRafID.setBounds(544, 89, 16, 38);
		txtRafID.setVisible(false);
		contentPane.add(txtRafID);
		
		JComboBox<String> cbYazar = new JComboBox<String>();
		
		ck.yazarGetir(cbYazar);
	
		cbYazar.setBounds(244, 141, 290, 38);
		contentPane.add(cbYazar);
		
		JLabel lblYazarAd = new JLabel("Yazar Adı:");
		lblYazarAd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYazarAd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYazarAd.setBounds(103, 138, 131, 36);
		contentPane.add(lblYazarAd);
		
		JLabel lblFiyat = new JLabel("Fiyat:");
		lblFiyat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiyat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFiyat.setBounds(103, 378, 131, 36);
		contentPane.add(lblFiyat);
		
		txtFiyat = new JTextField();
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(244, 381, 290, 38);
		contentPane.add(txtFiyat);
		
		JLabel lblKategori = new JLabel("Kategori:");
		lblKategori.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKategori.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKategori.setBounds(103, 425, 131, 36);
		contentPane.add(lblKategori);
		
		JComboBox<String> cbKategori1 = new JComboBox<String>();
		
		cbKategori1.setBounds(244, 425, 290, 38);
		ck.KategoriGetir(cbKategori1);
		contentPane.add(cbKategori1);
		
		JComboBox<String> cbKategori2 = new JComboBox<String>();
		ck.KategoriGetir(cbKategori2);
		cbKategori2.setBounds(244, 474, 290, 38);
		cbKategori2.setVisible(false);
		contentPane.add(cbKategori2);
		
		JLabel lblKategori_1 = new JLabel("2. Kategori:");
		lblKategori_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKategori_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKategori_1.setBounds(103, 472, 131, 36);
		lblKategori_1.setVisible(false);
		contentPane.add(lblKategori_1);
		
		txtKategoriID2 = new JTextField();
		txtKategoriID2.setText("1");
		txtKategoriID2.setBounds(544, 483, 16, 20);
		txtKategoriID2.setVisible(false);
		contentPane.add(txtKategoriID2);
		
		txtKategoriID2.setColumns(10);
		
		txtKategoriID1 = new JTextField();
		txtKategoriID1.setText("1");
		txtKategoriID1.setColumns(10);
		txtKategoriID1.setBounds(544, 425, 16, 20);
		txtKategoriID1.setVisible(false);
		contentPane.add(txtKategoriID1);
		
		
		txtYazarID = new JTextField();
		txtYazarID.setText("1");
		txtYazarID.setColumns(10);
		txtYazarID.setVisible(false);
		txtYazarID.setBounds(544, 138, 16, 41);
		
		contentPane.add(txtYazarID);

		JCheckBox chbKategori = new JCheckBox("2.Kategori için tıklayın");
		chbKategori.setBounds(6, 21, 152, 23);
		contentPane.add(chbKategori);
		
		JButton btnCikis = new JButton("Çıkış");
	
		btnCikis.setBounds(6, 633, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
		
		btnGeriDon.setBounds(103, 633, 89, 90);
		contentPane.add(btnGeriDon);
		
		JButton btnYazar = new JButton("Yazar");
	
		btnYazar.setBounds(592, 633, 89, 90);
		contentPane.add(btnYazar);
		
		JButton btnRaf = new JButton("Raf");
	
		btnRaf.setBounds(493, 633, 89, 90);
		contentPane.add(btnRaf);
		
		JButton btnYayinEvi = new JButton("Yayın Evi");
	
		btnYayinEvi.setBounds(394, 633, 89, 90);
		contentPane.add(btnYayinEvi);
		
		chbKategori.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            cbKategori2.setVisible(true);
		            lblKategori_1.setVisible(true);
		        } else {
		            cbKategori2.setVisible(false);
		            lblKategori_1.setVisible(false);
		        }
		    }
		});
		
		cbYazar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				    String selectedYazarAdi = (String) cbYazar.getSelectedItem();
				    int yazarID = cKitap.getYazarID(selectedYazarAdi); // Yazar ID'sini al
				    txtYazarID.setText(String.valueOf(yazarID)); // ID'yi JTextField'e yazdır
				}
				
			        
			}
		});
		
		cbRaf.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				    String selectedRafNo = (String) cbRaf.getSelectedItem();
				    int rafID = cKitap.getRafID(selectedRafNo); // Yazar ID'sini al
				    txtRafID.setText(String.valueOf(rafID)); // ID'yi JTextField'e yazdır
				}

			}

			
		});
		cbYayinEvi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				    String selectedRafNo = (String) cbYayinEvi.getSelectedItem();
				    int yayinEviID = cKitap.getYayinEviID(selectedRafNo); // Yazar ID'sini al
				    txtYayinEvi.setText(String.valueOf(yayinEviID)); // ID'yi JTextField'e yazdır
				}
			}
		});
		cbKategori1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				    String selectedRafNo = (String) cbKategori1.getSelectedItem();
				    int katID = cKitap.getKategoriID(selectedRafNo); // Yazar ID'sini al
				    txtKategoriID1.setText(String.valueOf(katID)); // ID'yi JTextField'e yazdır
				}
			}
		});
		cbKategori2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				    String selectedRafNo = (String) cbKategori2.getSelectedItem();
				    int katID = cKitap.getKategoriID(selectedRafNo); // Yazar ID'sini al
				    txtKategoriID2.setText(String.valueOf(katID)); // ID'yi JTextField'e yazdır
				}
			}
		});
		btnKayitEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
				 if(txtKitapAdi.getText().isEmpty() || txtYayinTarihi.getText().isEmpty() || txtSayfaSayisi.getText().isEmpty() || txtAdet.getText().isEmpty() || txtFiyat.getText().isEmpty() || cbYazar.getSelectedItem() == null || cbRaf.getSelectedItem() == null || cbYayinEvi.getSelectedItem() == null 
						 || cbKategori1.getSelectedItem() == null) {
		        	 mesaj="Lütfen boş alan bırakmayınız";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		        }
				 else {
					 cKitap ck = new cKitap();
					 if(ck.DurumGetir(txtKitapAdi.getText())) {
			        	  mesaj="Bu kullanıcı bulunmaktadır.";
					        JOptionPane.showMessageDialog(contentPane, mesaj); 
			          }
					 else {
						 
						 if(chbKategori.isSelected()) {
							 ck.set_kitapAd(txtKitapAdi.getText());
							 ck.set_yayinTarihi(Integer.valueOf(txtYayinTarihi.getText()));
							 ck.set_sayfaSayisi(Integer.valueOf(txtSayfaSayisi.getText()));
							 ck.set_adet(Integer.valueOf(txtAdet.getText()));
							 ck.set_fiyat(Double.valueOf(txtFiyat.getText()));
							 ck.set_rafId(Integer.valueOf(txtRafID.getText()));
							 ck.set_yazarId(Integer.valueOf(txtYazarID.getText()));
							 ck.set_yayinEviId(Integer.valueOf(txtYayinEvi.getText()));
							 ck.set_kategoriID(Integer.valueOf(txtKategoriID1.getText()));
							 ck.set_kategoriID2(Integer.valueOf(txtKategoriID2.getText()));
							 
							 cKitapSingleton kitapVar=cKitapSingleton.getInstance(txtKitapAdi.getText());
							 if (kitapVar != null) {
					        	  boolean son = kitapVar.kitapEkle(ck);
					        	  boolean sonK = kitapVar.ciftKategori(ck);
					        	  if(son&&sonK) {
					        		   	 mesaj="Kitap eklendi";
									        JOptionPane.showMessageDialog(contentPane, mesaj);
									      
					        	  }
							 }
						 }
						 else {
							 ck.set_kitapAd(txtKitapAdi.getText());
							 ck.set_yayinTarihi(Integer.valueOf(txtYayinTarihi.getText()));
							 ck.set_sayfaSayisi(Integer.valueOf(txtSayfaSayisi.getText()));
							 ck.set_adet(Integer.valueOf(txtAdet.getText()));
							 ck.set_fiyat(Double.valueOf(txtFiyat.getText()));
							 ck.set_rafId(Integer.valueOf(txtRafID.getText()));
							 ck.set_yazarId(Integer.valueOf(txtYazarID.getText()));
							 ck.set_yayinEviId(Integer.valueOf(txtYayinEvi.getText()));
							 ck.set_kategoriID(Integer.valueOf(txtKategoriID1.getText()));
							 cKitapSingleton kitapVar=cKitapSingleton.getInstance(txtKitapAdi.getText());
							 if (kitapVar != null) {
					        	  boolean son = kitapVar.kitapEkle(ck);
					        	  boolean sonK = kitapVar.tekKategori(ck);
					        	  if(son&&sonK) {
					        		   	 mesaj="Kitap eklendi";
									        JOptionPane.showMessageDialog(contentPane, mesaj);
									      
					        	  }
							 }
						 }
					 }
					 }
			}
		});
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int response = JOptionPane.showConfirmDialog(null, "Uygulamayı kapatmak istediğinize emin misiniz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			            System.exit(0); // Uygulamayı kapat
			        }
			}
		});
		
		btnGeriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKullaniciAnaSayfa frm = new frmKullaniciAnaSayfa();
		        setVisible(false);
		        frm.setVisible(true);
			}
		});
		btnYayinEvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
		        JTextField textField = new JTextField();
		        Object[] message = {"Yayın evi ekleyin:", textField};
		        int option = JOptionPane.showConfirmDialog(null, message, "Yayınevi Ekle", JOptionPane.OK_CANCEL_OPTION);
		        cKitap ck = new cKitap();
		        if (option == JOptionPane.OK_OPTION) {{
		        	
		       
		        boolean sonuc = ck.YayinEviVarMi(textField.getText());
		        if(sonuc) {
		        	 mesaj="Bu Yayın Evi bulunmaktadır.";
				        JOptionPane.showMessageDialog(contentPane, mesaj); 
		        }
		        else {
		        	ck.yayinEviEkle(textField.getText());
		        	 mesaj="Yayın evi eklenmiştir.";
				        JOptionPane.showMessageDialog(contentPane, mesaj); 
		        }
			
		        }
		        }
		        }
			
		});
		btnRaf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
		        JTextField textField = new JTextField();
		        Object[] message = {"Raf Ekle", textField};
		        int option = JOptionPane.showConfirmDialog(null, message, "Raf ekle", JOptionPane.OK_CANCEL_OPTION);
		        cKitap ck = new cKitap();
		        if (option == JOptionPane.OK_OPTION) {{
		        	 boolean sonuc = ck.rafVarMi(textField.getText());
				        if(sonuc) {
				        	 mesaj="Bu raf zaten bulunmaktadır.";
						        JOptionPane.showMessageDialog(contentPane, mesaj); 
				        }
				        else {
				        	ck.rafEkle(textField.getText());
				        	 mesaj="Raf eklenmiştir.";
						        JOptionPane.showMessageDialog(contentPane, mesaj); 
		        }
		       
		        }
		        }
		        }
			
		});
		btnYazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
		        JTextField textField = new JTextField();
		        Object[] message = {"Yazar Ekle", textField};
		        int option = JOptionPane.showConfirmDialog(null, message, "Yazar Ekle", JOptionPane.OK_CANCEL_OPTION);
		        cKitap ck = new cKitap();
		        if (option == JOptionPane.OK_OPTION) {{
		        	   boolean sonuc = ck.yazarVarMi(textField.getText());
				        if(sonuc) {
				        	 mesaj="Bu yazar bulunmaktadır.";
						        JOptionPane.showMessageDialog(contentPane, mesaj); 
				        }
				        else {
				        	ck.yazarEkle(textField.getText());
				        	 mesaj="Yazar eklenmiştir.";
						        JOptionPane.showMessageDialog(contentPane, mesaj); 
				        }
		        	}
		        }
		     
			}
		});
	}
}
