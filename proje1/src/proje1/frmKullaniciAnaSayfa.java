package proje1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class frmKullaniciAnaSayfa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKullaniciAnaSayfa frame = new frmKullaniciAnaSayfa();
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
	public frmKullaniciAnaSayfa() {
		setTitle("Kütüphane/Ana Sayfa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 837);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(223, 223, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("Ana Sayfa");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(344, 24, 478, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnUyeEkle = new JButton("");
		btnUyeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 Image icon = new ImageIcon(getClass().getResource("/uyeEkle.png")).getImage();
		 btnUyeEkle.setIcon(new ImageIcon(icon));
		btnUyeEkle.setBounds(57, 126, 205, 190);
		contentPane.add(btnUyeEkle);
		
		JButton btnKitapEkle = new JButton("");
		Image kitap = new ImageIcon(getClass().getResource("/kitapEkleButon.png")).getImage();
		btnKitapEkle.setIcon(new ImageIcon(kitap));
		btnKitapEkle.setBounds(344, 126, 205, 190);
		contentPane.add(btnKitapEkle);
		
		
		JButton btnOduncVer = new JButton("");
	
		Image odunc = new ImageIcon(getClass().getResource("/oduncVer.png")).getImage();
		btnOduncVer.setIcon(new ImageIcon(odunc));
		btnOduncVer.setBounds(617, 126, 205, 190);
		contentPane.add(btnOduncVer);
		
		final JButton btnKullaniciEkle = new JButton("");
		Image kullanici = new ImageIcon(getClass().getResource("/kullaniciEkle.png")).getImage();
		btnKullaniciEkle.setIcon(new ImageIcon(kullanici));
		btnKullaniciEkle.setBounds(877, 126, 205, 190);
		contentPane.add(btnKullaniciEkle);
		
		JButton btnUyeIslemleri = new JButton("");
		
		Image img = new ImageIcon(getClass().getResource("/uyeIslemleri.png")).getImage();
		btnUyeIslemleri.setIcon(new ImageIcon(img));
		btnUyeIslemleri.setBounds(57, 445, 205, 190);
		contentPane.add(btnUyeIslemleri);
		
		JButton btnKitaplariGoruntule = new JButton("");
		
		Image kGoruntu = new ImageIcon(getClass().getResource("/kitaplarıGoruntule.png")).getImage();
		btnKitaplariGoruntule.setIcon(new ImageIcon(kGoruntu));
		btnKitaplariGoruntule.setBounds(344, 445, 205, 190);
		contentPane.add(btnKitaplariGoruntule);
		
		JButton btnOduncTakip = new JButton("");
	
		Image oTakip = new ImageIcon(getClass().getResource("/oduncTakip.png")).getImage();
		btnOduncTakip.setIcon(new ImageIcon(oTakip));
		btnOduncTakip.setBounds(617, 445, 205, 190);
		contentPane.add(btnOduncTakip);
		
		JButton btnKullaniciIslemleri = new JButton("");
	
		Image kIslemleri = new ImageIcon(getClass().getResource("/kullaniciIslemleri.png")).getImage();
		btnKullaniciIslemleri.setIcon(new ImageIcon(kIslemleri));
		btnKullaniciIslemleri.setBounds(877, 445, 205, 190);
		contentPane.add(btnKullaniciIslemleri);
		
		JLabel lblNewLabel_1 = new JLabel("ÜYE EKLE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(57, 337, 205, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("KİTAP EKLE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(344, 337, 205, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ÖDÜNÇ VER");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(617, 337, 205, 40);
		contentPane.add(lblNewLabel_1_2);
		
		final JLabel lblNewLabel_1_3 = new JLabel("KULLANICI EKLE");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(877, 337, 205, 40);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ÜYE İŞLEMLERİ");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(57, 648, 205, 40);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("KİTAPLARI GÖRÜNTÜLE");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(330, 648, 233, 40);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("ÖDÜNÇ TAKİP");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(617, 648, 205, 40);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("KULLANICI İŞLEMLERİ");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_7.setBounds(877, 648, 205, 40);
		contentPane.add(lblNewLabel_1_7);
		
		
		JLabel lblKullaniciID = new JLabel("");
		lblKullaniciID.setBounds(40, 24, 46, 14);
		lblKullaniciID.setText(String.valueOf(cVeritabani._kullaniciId));
		lblKullaniciID.setVisible(false);
		contentPane.add(lblKullaniciID);
		
		JButton btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int response = JOptionPane.showConfirmDialog(null, "Uygulamayı kapatmak istediğinize emin misiniz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			            System.exit(0); // Uygulamayı kapat
			        }
			}
		});
		btnCikis.setBounds(10, 699, 89, 90);
		contentPane.add(btnCikis);
		
		JLabel lblKullaniciGorev = new JLabel("");
		lblKullaniciGorev.setHorizontalAlignment(SwingConstants.LEFT);
		lblKullaniciGorev.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullaniciGorev.setBounds(40, 24, 309, 50);
		contentPane.add(lblKullaniciGorev);
	    
		cAnaSayfa ca = new cAnaSayfa();
		
		cKullanicilar ck = new cKullanicilar();
		String lblKullaniciIDText = lblKullaniciID.getText();
		int kullaniciID = Integer.parseInt(lblKullaniciIDText);
		int kullaniciGorevID = ck.kullaniciGorevIdGetir(kullaniciID);
		
		
		
		IsimFactory gorevFactory = new cIsimCagirmaFactory();
		Isim pIsim = gorevFactory.createIsim();
		lblKullaniciGorev.setText(pIsim.proccessIsim(kullaniciID));
	
		
		if(kullaniciGorevID ==2) {
			lblNewLabel_1_3.setVisible(false);
			btnKullaniciEkle.setVisible(false);
		
		} 
		
		btnUyeEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUyeEkle uEkle = new frmUyeEkle();
	    	 	setVisible(false);
	    	 	uEkle.setVisible(true);
			}
		});
		btnKullaniciEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmKullaniciEkle kEkle = new frmKullaniciEkle();
	    	 	setVisible(false);
	    	 	kEkle.setVisible(true);
			}
		});
		btnKitapEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmKitapEkle kEkle = new frmKitapEkle();
				setVisible(false);
	    	 	kEkle.setVisible(true);
			}
		});
		btnKullaniciIslemleri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmKullaniciIslemleri kIslem = new frmKullaniciIslemleri();
				setVisible(false);
				kIslem.setVisible(true);
			}
		});
		btnKitaplariGoruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmKitapGoruntule kg = new frmKitapGoruntule();
				setVisible(false);
				kg.setVisible(true);
				
			}
		});
		
		btnOduncVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOduncVer ov = new frmOduncVer();
				setVisible(false);
				ov.setVisible(true);
			}
		});
		
		btnOduncTakip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOduncTakip ot = new frmOduncTakip();
				setVisible(false);
				ot.setVisible(true);
			}
		});
		btnUyeIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUyeIslemleri uı = new frmUyeIslemleri();
				setVisible(false);
				uı.setVisible(true);
			}
		});
		


	}
}
