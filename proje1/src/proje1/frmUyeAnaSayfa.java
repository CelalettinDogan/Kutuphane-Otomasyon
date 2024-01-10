package proje1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmUyeAnaSayfa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeAnaSayfa frame = new frmUyeAnaSayfa();
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
	public frmUyeAnaSayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlinanKitaplar = new JButton("");
		
		Image aKitap = new ImageIcon(getClass().getResource("/oduncTakip.png")).getImage();
		btnAlinanKitaplar.setIcon(new ImageIcon(aKitap));
		btnAlinanKitaplar.setBounds(37, 122, 205, 190);
		contentPane.add(btnAlinanKitaplar);
		
		JLabel lblNewLabel_1 = new JLabel("ALINAN KİTAPLAR");
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 344, 205, 40);
		contentPane.add(lblNewLabel_1);
		
		JButton btnKitaplar = new JButton("");
	
		
		Image kGoruntu = new ImageIcon(getClass().getResource("/kitaplarıGoruntule.png")).getImage();
		btnKitaplar.setIcon(new ImageIcon(kGoruntu));
		btnKitaplar.setBounds(349, 122, 205, 190);
		contentPane.add(btnKitaplar);
		
		JButton btnUyeIslemleri = new JButton("");
		Image uIslemleri = new ImageIcon(getClass().getResource("/kullaniciIslemleri.png")).getImage();
		btnUyeIslemleri.setIcon(new ImageIcon(uIslemleri));
		btnUyeIslemleri.setBounds(664, 122, 205, 190);
		contentPane.add(btnUyeIslemleri);
		
		JLabel lblNewLabel_1_1 = new JLabel("KİTAPLAR");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(349, 344, 205, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ÜYE İŞLEMLERİ");
		
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(664, 344, 205, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblUyeId = new JLabel("");
		lblUyeId.setBounds(52, 35, 46, 14);
		lblUyeId.setVisible(false);
		contentPane.add(lblUyeId);
		int uyeId = cVeritabani._uyeId;
		lblUyeId.setText(String.valueOf(uyeId));
		
		JLabel lblUyeGorev = new JLabel("");
		lblUyeGorev.setBounds(37, 51, 205, 60);
		contentPane.add(lblUyeGorev);
		 // Sayısal değeri etiketin metin içeriği olarak ayarlayın
		cAnaSayfa ca = new cAnaSayfa();
		
	
		
		
		
		ca.uyeAdiSoyadGetir(uyeId);
		IsimFactory uyeGorevFactory = new cUyeIsimCagirmaFactory();
		Isim uyeIsim = uyeGorevFactory.createIsim();
		lblUyeGorev.setText(uyeIsim.proccessIsim(uyeId));
		
		JButton btnCikis = new JButton("Çıkış");
	
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCikis.setBounds(10, 609, 89, 90);
		contentPane.add(btnCikis);
		
		btnUyeIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmUyeHesapIslemleri ui = new frmUyeHesapIslemleri();
				setVisible(false);
				ui.setVisible(true);
			}
		});
		
		btnKitaplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUyeKitaplar uk = new frmUyeKitaplar();
				setVisible(false);
				uk.setVisible(true);
			}
		});
		
		btnAlinanKitaplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlinanKitaplar  ak = new frmAlinanKitaplar();
				setVisible(false);
				ak.setVisible(true);
			}
		});
		
		btnCikis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCikis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  int response = JOptionPane.showConfirmDialog(null, "Uygulamayı kapatmak istediğinize emin misiniz?", "Uyarı",
					                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					        
					        if (response == JOptionPane.YES_OPTION) {
					            System.exit(0); // Uygulamayı kapat
					        }
					}
				});
			}
		});
		
		
	}
}
