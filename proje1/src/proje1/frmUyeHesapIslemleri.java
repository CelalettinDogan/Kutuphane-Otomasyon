package proje1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmUyeHesapIslemleri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSifre;
	private JLabel lblifreTekrar;
	private JTextField txtSifreTekrar;
	private JTextField txtUyeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeHesapIslemleri frame = new frmUyeHesapIslemleri();
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
	public frmUyeHesapIslemleri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Şifre:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(55, 102, 100, 25);
		contentPane.add(lblNewLabel);
		
		txtSifre = new JTextField();
		txtSifre.setBounds(165, 102, 261, 25);
		contentPane.add(txtSifre);
		txtSifre.setColumns(10);
		
		lblifreTekrar = new JLabel("Şifre Tekrar:");
		lblifreTekrar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifreTekrar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblifreTekrar.setBounds(31, 169, 124, 25);
		contentPane.add(lblifreTekrar);
		
		txtSifreTekrar = new JTextField();
		txtSifreTekrar.setColumns(10);
		txtSifreTekrar.setBounds(165, 169, 261, 25);
		contentPane.add(txtSifreTekrar);
		
		JButton btnSifreDegistir = new JButton("Şifre Değiştir");
		
		btnSifreDegistir.setBounds(55, 282, 431, 84);
		contentPane.add(btnSifreDegistir);
		
		txtUyeID = new JTextField();
		txtUyeID.setColumns(10);
		txtUyeID.setBounds(436, 102, 11, 25);
		txtUyeID.setVisible(false);
		contentPane.add(txtUyeID);
		int uyeId = cVeritabani._uyeId;
		txtUyeID.setText(String.valueOf(uyeId));
		
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
		btnCikis.setBounds(10, 424, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
		btnGeriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUyeAnaSayfa ua = new frmUyeAnaSayfa();
				setVisible(false);
				ua.setVisible(true);
			}
		});
		btnGeriDon.setBounds(109, 424, 89, 90);
		contentPane.add(btnGeriDon);
		
		btnSifreDegistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
				if(txtSifre.getText().equals(txtSifreTekrar.getText())) {
					cUyeler cu = new cUyeler();
					boolean sonuc = cu.uyeSifreDegistir(uyeId, txtSifre.getText());
					if(sonuc) {
						mesaj="Şifreniz başarıyla değiştirilmiştir.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
					}
					else {
						mesaj="Şifre Değiştirilirken bir hatayla karşılaşıldı.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
					}
				}
				else {
					 mesaj="Şifrenin doğru değildir. Lütfen aynı şifreyi giriniz.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				}
			}
		});
	}
}
