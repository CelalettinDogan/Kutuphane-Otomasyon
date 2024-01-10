package proje1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmUyeEkle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUyeAd;
	private JTextField txtUyeSoyad;
	private JTextField txtUyeKullaniciAdi;
	private JTextField txtTelefon;
	private JTextField txtMail;
	private JTextField txtAdres;
	private JTextField txtGorevID;
	private JTextField txtKullaniciSifre;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeEkle frame = new frmUyeEkle();
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
	public frmUyeEkle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 876);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(223, 223, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Üye Ad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(113, 68, 80, 40);
		contentPane.add(lblNewLabel);
		
		txtUyeAd = new JTextField();
		txtUyeAd.setBounds(277, 68, 268, 35);
		contentPane.add(txtUyeAd);
		txtUyeAd.setColumns(10);
		
		JLabel lblyeSoyad = new JLabel("  Üye Soyad:");
		lblyeSoyad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblyeSoyad.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblyeSoyad.setBounds(62, 119, 131, 40);
		contentPane.add(lblyeSoyad);
		
		txtUyeSoyad = new JTextField();
		txtUyeSoyad.setColumns(10);
		txtUyeSoyad.setBounds(277, 119, 268, 35);
		contentPane.add(txtUyeSoyad);
		
		JLabel lblUyeKullaniciAdi = new JLabel("Numara:");
		lblUyeKullaniciAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUyeKullaniciAdi.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUyeKullaniciAdi.setBounds(10, 170, 183, 40);
		contentPane.add(lblUyeKullaniciAdi);
		
		txtUyeKullaniciAdi = new JTextField();
		txtUyeKullaniciAdi.setColumns(10);
		txtUyeKullaniciAdi.setBounds(277, 170, 268, 35);
		contentPane.add(txtUyeKullaniciAdi);
		
		JLabel lblGorev = new JLabel(" Gorev:");
		lblGorev.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGorev.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblGorev.setBounds(113, 272, 80, 40);
		contentPane.add(lblGorev);
		
		JLabel lblTelefono = new JLabel("Telefon:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTelefono.setBounds(100, 323, 93, 40);
		contentPane.add(lblTelefono);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMail.setBounds(131, 374, 62, 40);
		contentPane.add(lblMail);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAdres.setBounds(122, 448, 71, 40);
		contentPane.add(lblAdres);
		
		txtTelefon = new JTextField();
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(277, 323, 268, 35);
		contentPane.add(txtTelefon);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(277, 374, 268, 35);
		contentPane.add(txtMail);
		
		txtAdres = new JTextField();
		txtAdres.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdres.setColumns(1);
		txtAdres.setBounds(277, 420, 268, 173);
		contentPane.add(txtAdres);
		
		JButton btnUyeEkle = new JButton("Üye Ekle");
		
		btnUyeEkle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnUyeEkle.setBounds(78, 633, 578, 86);
		contentPane.add(btnUyeEkle);
		
		final JComboBox<Object> cbGorev = new JComboBox<Object>();
		cbGorev.setBounds(277, 272, 268, 35);
		cUyeler uye= new cUyeler();
		uye.uyeGorevGetir(cbGorev);
		contentPane.add(cbGorev);
		
		txtGorevID = new JTextField("1");
		txtGorevID.setBounds(560, 272, 23, 35);
		contentPane.add(txtGorevID);
		txtGorevID.setVisible(false);
		txtGorevID.setColumns(10);
		
		JLabel lblKullaniciSifre = new JLabel("Parola:");
		lblKullaniciSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKullaniciSifre.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblKullaniciSifre.setBounds(10, 221, 183, 40);
		contentPane.add(lblKullaniciSifre);
		
		txtKullaniciSifre = new JTextField();
		txtKullaniciSifre.setColumns(10);
		txtKullaniciSifre.setBounds(277, 221, 268, 35);
		contentPane.add(txtKullaniciSifre);
		
		JButton btnCikis = new JButton("Çıkış");
	
		btnCikis.setBounds(10, 736, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
	
		btnGeriDon.setBounds(104, 736, 89, 90);
		contentPane.add(btnGeriDon);

		
		
		
		
		cbGorev.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        String selectedValue = cbGorev.getSelectedItem().toString();
		        
		        if (selectedValue.equals("Öğretim Görevlisi")) {
		            txtGorevID.setText("1");
		        } else {
		            txtGorevID.setText("2");
		        }
		    }
		});

		
		
		
		btnUyeEkle.addMouseListener(new MouseAdapter() {
			String mesaj;
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if(txtUyeAd.getText().isEmpty() || txtUyeSoyad.getText().isEmpty() || txtUyeKullaniciAdi.getText().isEmpty() || txtKullaniciSifre.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtMail.getText().isEmpty() || txtAdres.getText().isEmpty() || cbGorev.getSelectedItem() == null) {
		        	 mesaj="Lütfen boş alan bırakmayınız";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		        } else {
		        	 // boolean sonuc = cu.UyeVarMi(txtUyeKullaniciAdi.getText());
		        	//boolean ekle = cu.uyeEkle(cu);
		        	 cUyeler cu = new cUyeler();
		          if(cu.DurumGetir(txtUyeKullaniciAdi.getText())) {
		        	  mesaj="Bu kullanıcı bulunmaktadır.";
				        JOptionPane.showMessageDialog(contentPane, mesaj); 
		          }else {
		          
		        	
		            	cu.set_GorevId(Integer.valueOf(txtGorevID.getText()));
		            	cu.set_UyeAd(txtUyeAd.getText());
		            	cu.set_UyeSoyad(txtUyeSoyad.getText());
		            	cu.set_UyeKullaniciAdi(txtUyeKullaniciAdi.getText());
		            	cu.set_UyeSifre(txtKullaniciSifre.getText());
		            	cu.set_Telefon(txtTelefon.getText());
		            	cu.set_Email(txtMail.getText());
		            	cu.set_Adres(txtAdres.getText());
		            
		            	 cSingleton uyeVar=cSingleton.getInstance(txtUyeKullaniciAdi.getText());
				        
				        if (uyeVar != null) {
				        	  boolean son = uyeVar.uyeEKle(cu);
				        	  if(son) {
				        		   	 mesaj="Üye eklendi";
								        JOptionPane.showMessageDialog(contentPane, mesaj);
								        txtUyeAd.setText("");
								        txtUyeSoyad.setText("");
								        txtUyeKullaniciAdi.setText("");
								        txtKullaniciSifre.setText("");
								        txtTelefon.setText("");
								        txtMail.setText("");
								        txtAdres.setText(""); 
				        	  }
						    
				        } else {
				          
						        mesaj="Üye eklendi";
						        JOptionPane.showMessageDialog(contentPane, mesaj);
						      
						        txtUyeAd.setText("");
						        txtUyeSoyad.setText("");
						        txtUyeKullaniciAdi.setText("");
						        txtKullaniciSifre.setText("");
						        txtTelefon.setText("");
						        txtMail.setText("");
						        txtAdres.setText(""); 
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

