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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;

public class frmKullaniciEkle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel frmKullaniciEkle;
	private JTextField txtKullaniciAdi;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtTlf;
	private JTextField txtEmail;
	private JTextField txtSifre;
	private JTextField txtSifreTekrar;
	private JTextField txtGorevId;
	private JTextField txtAdres;
	private JLabel lblSoyad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKullaniciEkle frame = new frmKullaniciEkle();
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
	public frmKullaniciEkle() {
		setTitle("Kütüphane/Kullanıcı Ekle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 950);
		frmKullaniciEkle = new JPanel();
		frmKullaniciEkle.setBackground(new Color(223, 223, 223));
		frmKullaniciEkle.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(frmKullaniciEkle);
		frmKullaniciEkle.setLayout(null);
		
		JLabel lblKullaniciGorevi = new JLabel("Kullanıcı Görevi:");
		lblKullaniciGorevi.setBounds(109, 105, 158, 27);
		lblKullaniciGorevi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblKullaniciGorevi.setHorizontalAlignment(SwingConstants.RIGHT);
		frmKullaniciEkle.add(lblKullaniciGorevi);
		
		final JComboBox<Object> cbKullaniciGorev = new JComboBox<Object>();
		cbKullaniciGorev.setBounds(296, 102, 263, 35);
		cKullanicilar kullanici= new cKullanicilar();
		kullanici.kullaniciGorevGetir(cbKullaniciGorev);
		frmKullaniciEkle.add(cbKullaniciGorev);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanıcı Adı:");
		lblKullaniciAdi.setBounds(109, 167, 158, 27);
		lblKullaniciAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblKullaniciAdi);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(296, 163, 263, 35);
		frmKullaniciEkle.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		
		JLabel lblAd = new JLabel("Ad:");
		lblAd.setBounds(109, 229, 158, 27);
		lblAd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblAd);
		
		lblSoyad = new JLabel("Soyad:");
		lblSoyad.setBounds(109, 291, 158, 27);
		lblSoyad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblSoyad);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(109, 353, 158, 27);
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblTelefon);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setBounds(109, 415, 158, 27);
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblMail);
		
		JLabel lblSifre = new JLabel("Şifre:");
		lblSifre.setBounds(109, 477, 158, 27);
		lblSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblSifre);
		
		txtAd = new JTextField();
		txtAd.setBounds(296, 226, 263, 35);
		txtAd.setColumns(10);
		frmKullaniciEkle.add(txtAd);
		
		txtSoyad = new JTextField();
		txtSoyad.setBounds(296, 287, 263, 35);
		txtSoyad.setColumns(10);
		frmKullaniciEkle.add(txtSoyad);
		
		txtTlf = new JTextField();
		txtTlf.setBounds(296, 348, 263, 35);
		txtTlf.setColumns(10);
		frmKullaniciEkle.add(txtTlf);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(296, 409, 263, 35);
		txtEmail.setColumns(10);
		frmKullaniciEkle.add(txtEmail);
		
		txtSifre = new JTextField();
		txtSifre.setBounds(296, 470, 263, 35);
		txtSifre.setColumns(10);
		frmKullaniciEkle.add(txtSifre);
		
		JLabel lblSifreTekrar = new JLabel("Şifre Tekrar:");
		lblSifreTekrar.setBounds(109, 540, 158, 27);
		lblSifreTekrar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifreTekrar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblSifreTekrar);
		
		txtSifreTekrar = new JTextField();
		txtSifreTekrar.setBounds(296, 535, 263, 35);
		txtSifreTekrar.setColumns(10);
		frmKullaniciEkle.add(txtSifreTekrar);
		
		JButton btnKullaniciEkle = new JButton("Kullanici Ekle");
		btnKullaniciEkle.setBounds(68, 681, 632, 83);
		
		btnKullaniciEkle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		frmKullaniciEkle.add(btnKullaniciEkle);
		
		txtGorevId = new JTextField();
		txtGorevId.setBounds(569, 102, 20, 35);
		txtGorevId.setText("1");
		txtGorevId.setColumns(10);
		txtGorevId.setVisible(false);
		frmKullaniciEkle.add(txtGorevId);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(109, 595, 158, 27);
		lblAdres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frmKullaniciEkle.add(lblAdres);
		
		txtAdres = new JTextField();
		txtAdres.setBounds(296, 587, 263, 83);
		txtAdres.setColumns(10);
		frmKullaniciEkle.add(txtAdres);
		
		JButton btnCikis = new JButton("Çıkış");
	
		btnCikis.setBounds(10, 767, 89, 90);
		frmKullaniciEkle.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
	
		btnGeriDon.setBounds(104, 767, 89, 90);
		frmKullaniciEkle.add(btnGeriDon);
		cbKullaniciGorev.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedValue = cbKullaniciGorev.getSelectedItem().toString();
		        
		        if (selectedValue.equals("Yönetici")) {
		        	txtGorevId.setText("1");
		        } else {
		        	txtGorevId.setText("2");
		        }
		    }
		});
		btnKullaniciEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mesaj;
				if(txtKullaniciAdi.getText().equals("") || txtAd.getText().equals("") || txtSoyad.getText().equals("") || txtTlf.getText().equals("") ||  txtEmail.getText().equals("") || txtSifre.getText().equals("") || txtAdres.getText().equals("") || txtSifreTekrar.getText().equals("") || cbKullaniciGorev.getSelectedItem() == null) {
		        	 mesaj="Lütfen boş alan bırakmayınız";
				        JOptionPane.showMessageDialog(frmKullaniciEkle, mesaj);
		        }
				else {
					if(txtSifre.getText().equals(txtSifreTekrar.getText())) {
						
						cKullanicilar ck = new cKullanicilar();
						if(ck.DurumGetir(txtKullaniciAdi.getText())) {
							 mesaj="Bu kullanıcı bulunmaktadır.";
						        JOptionPane.showMessageDialog(frmKullaniciEkle, mesaj); 
						}
						else {
							ck.set_GorevId(Integer.valueOf(txtGorevId.getText()));
			            	ck.set_Ad(txtAd.getText());
			            	ck.set_Soyad(txtSoyad.getText());
			            	ck.set_KullaniciAdi(txtKullaniciAdi.getText());
			            	ck.set_KullaniciSifre(txtSifre.getText());
			            	ck.set_Telefon(Integer.valueOf(txtTlf.getText()));
			            	ck.set_Email(txtEmail.getText());
			            	ck.set_Adres(txtAdres.getText());
			            	cSingletonKullanici kullaniciVar=cSingletonKullanici.getInstance(txtKullaniciAdi.getText());
			            	if (kullaniciVar != null) {
			            		  boolean son = kullaniciVar.kullaniciEkle(ck);
			            		  if(son) {
			            				mesaj="Üye eklendi";
								        JOptionPane.showMessageDialog(frmKullaniciEkle, mesaj);
								        txtAd.setText("");
								        txtSoyad.setText("");
								        txtKullaniciAdi.setText("");
								        txtSifre.setText("");
								        txtSifreTekrar.setText("");
								        txtTlf.setText("");
								        txtEmail.setText("");
								        txtAdres.setText("");
			            		  }
			            	
			            	}
			            	else {
			            		mesaj="Üye eklendi";
						        JOptionPane.showMessageDialog(frmKullaniciEkle, mesaj);
						        txtAd.setText("");
						        txtSoyad.setText("");
						        txtKullaniciAdi.setText("");
						        txtSifre.setText("");
						        txtSifreTekrar.setText("");
						        txtTlf.setText("");
						        txtEmail.setText("");
						        txtAdres.setText("");
			            	}
			            		 
						}     
				      }     	
			     }			        
			}		
		});
		btnCikis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        int response = JOptionPane.showConfirmDialog(null, "Uygulamayı kapatmak istediğinize emin misiniz?", "Uyarı",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        
		        if (response == JOptionPane.YES_OPTION) {
		            System.exit(0); // Uygulamayı kapat
		        }
			}
		});
		btnGeriDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  frmKullaniciAnaSayfa frm = new frmKullaniciAnaSayfa();
			        setVisible(false);
			        frm.setVisible(true);
			}
		});
	}
}
