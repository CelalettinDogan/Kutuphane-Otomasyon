package proje1;

import java.awt.Color;
import java.awt.EventQueue;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proje1.frmGiris;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtKullaniciAdi;
	private JTextField txtKullaniciSifre;
	private JTextField txtUyeAdi;
	private JTextField txtUyeSifre;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGiris frame = new frmGiris();
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
	public frmGiris() {
		setTitle("Kütüphane/Giriş");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 669);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(223, 223, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblKullaniciAdi = new JLabel("Kullanıcı Adı:");
		lblKullaniciAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKullaniciAdi.setBounds(63, 394, 127, 28);
		contentPane.add(lblKullaniciAdi);
		
		final JLabel lblKullaniciSifre = new JLabel("Kullanıcı Şifre:");
		lblKullaniciSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKullaniciSifre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKullaniciSifre.setBounds(63, 455, 127, 28);
		contentPane.add(lblKullaniciSifre);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(200, 394, 390, 28);
		contentPane.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		
		txtKullaniciSifre = new JTextField();
		txtKullaniciSifre.setColumns(10);
		txtKullaniciSifre.setBounds(200, 455, 390, 28);
		contentPane.add(txtKullaniciSifre);
		
		final JButton btnKullaniciGiris = new JButton("Giriş Yap");
		btnKullaniciGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		btnKullaniciGiris.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnKullaniciGiris.setBounds(49, 551, 589, 68);
		contentPane.add(btnKullaniciGiris);
		
		final JLabel lblUyeAdi = new JLabel("Üye Numara:");
		lblUyeAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUyeAdi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUyeAdi.setBounds(63, 394, 127, 28);
		lblUyeAdi.setVisible(false);
		contentPane.add(lblUyeAdi);
		
		final JLabel lblUyeSifre = new JLabel("Üye Şifre:");
		lblUyeSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUyeSifre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUyeSifre.setBounds(95, 455, 95, 28);
		lblUyeSifre.setVisible(false);
		contentPane.add(lblUyeSifre);
		
		txtUyeAdi = new JTextField();
		txtUyeAdi.setColumns(10);
		txtUyeAdi.setBounds(200, 394, 390, 28);
		txtUyeAdi.setVisible(false);
		contentPane.add(txtUyeAdi);
		
		txtUyeSifre = new JTextField();
		txtUyeSifre.setColumns(10);
		txtUyeSifre.setBounds(200, 455, 390, 28);
		txtUyeSifre.setVisible(false);
		contentPane.add(txtUyeSifre);
		
		final JLabel lblUyeGirisi = new JLabel("<html><u>Üye Girişi </u></html>");
	
		
		lblUyeGirisi.setForeground(new Color(0, 128, 192));
		lblUyeGirisi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUyeGirisi.setHorizontalAlignment(SwingConstants.CENTER);
		lblUyeGirisi.setBounds(493, 494, 145, 28);
		contentPane.add(lblUyeGirisi);
		
		final JLabel lblKullaniciGirisi = new JLabel("<html><u>Kullanıcı Girişi</u></html>");
	
		lblKullaniciGirisi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKullaniciGirisi.setForeground(new Color(0, 128, 192));
		lblKullaniciGirisi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKullaniciGirisi.setBounds(493, 494, 145, 28);
		lblKullaniciGirisi.setVisible(false);
		contentPane.add(lblKullaniciGirisi);
		
		final JButton btnUyeGirisi = new JButton("Giriş Yap");
	
		btnUyeGirisi.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnUyeGirisi.setBounds(49, 551, 589, 68);
		btnUyeGirisi.setVisible(false);
		contentPane.add(btnUyeGirisi);
		
		JLabel lblImage = new JLabel("");
		Image icon = new ImageIcon(getClass().getResource("/kullaniciGirisResim.png")).getImage();

		lblImage.setIcon(new ImageIcon(icon));
		lblImage.setBounds(238, 25, 284, 358);
		contentPane.add(lblImage);
		lblUyeGirisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblUyeGirisi.setForeground(new Color(0, 128, 192));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUyeGirisi.setForeground(new Color(0, 128, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUyeSifre.setVisible(true);
				txtUyeAdi.setVisible(true);
				lblUyeSifre.setVisible(true);
				lblUyeAdi.setVisible(true);
				lblUyeGirisi.setVisible(false);
				lblKullaniciAdi.setVisible(false);
				lblKullaniciSifre.setVisible(false);
				txtKullaniciAdi.setVisible(false);
				txtKullaniciSifre.setVisible(false);
				btnKullaniciGiris.setVisible(false);
				btnUyeGirisi.setVisible(true);
				lblKullaniciGirisi.setVisible(true);
			}
		});
		lblKullaniciGirisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUyeSifre.setVisible(false);
				txtUyeAdi.setVisible(false);
				lblUyeSifre.setVisible(false);
				lblUyeAdi.setVisible(false);
				lblUyeGirisi.setVisible(true);
				lblKullaniciAdi.setVisible(true);
				lblKullaniciSifre.setVisible(true);
				txtKullaniciAdi.setVisible(true);
				txtKullaniciSifre.setVisible(true);
				btnKullaniciGiris.setVisible(true);
				btnUyeGirisi.setVisible(false);
				lblKullaniciGirisi.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKullaniciGirisi.setForeground(new Color(0, 128, 255));
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
				lblKullaniciGirisi.setForeground(new Color(0, 128, 192));
			}
		});
		btnKullaniciGiris.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String mesaj;
			    String sifre = txtKullaniciSifre.getText();
			    String kullanciAdi = txtKullaniciAdi.getText();

			    cGiris giris = new cGiris();
			    boolean result = giris.girisKullaniciKontrol(kullanciAdi, sifre);

			    if (result) {
			      
			        cVeritabani._kullaniciId = giris.getPersonelId();
			        cHaraketler ck = new cHaraketler(); 
			        ck.setPersonelId(cVeritabani._kullaniciId);
			        ck.setIslem("Giriş yaptı");
			        ck.setTarih(LocalDateTime.now());
			        ck.personelGirisKontrol(ck);
						

			        frmKullaniciAnaSayfa frm = new frmKullaniciAnaSayfa();
			        setVisible(false);
			        frm.setVisible(true);
			        
			        
			    } else {
			    	 mesaj="Kullanıcı adı veya şifreniz yanlıştır lütfen tekrar deneyiniz.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
			    }
			}
		});
		btnUyeGirisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mesaj;
			    String UyeAdi = txtUyeAdi.getText();
			    String sifre = txtUyeSifre.getText();
			    cGiris giris = new cGiris();
			    boolean result = giris.girisUyeKontrol(UyeAdi, sifre);
			   
			    if (result) {
			    	
			    	
			    	    cVeritabani._uyeId = giris.get_UyeId();
				        cHaraketler ck = new cHaraketler(); 
				        ck.set_UyeId(cVeritabani._uyeId);
				        ck.set_UyeIslem("Giriş yaptı");
				        ck.set_UyeTarih(LocalDateTime.now());
				        ck.uyeGirisKontrol(ck);

				        frmUyeAnaSayfa frm = new frmUyeAnaSayfa();
				        setVisible(false);
				        frm.setVisible(true);
				        
				        
				    } else {
				    	 mesaj="Kullanıcı adı veya şifreniz yanlıştır lütfen tekrar deneyiniz.";
					        JOptionPane.showMessageDialog(contentPane, mesaj);
				    }
			    
				
				
				
			}
		});
	}
	
	
	
}
