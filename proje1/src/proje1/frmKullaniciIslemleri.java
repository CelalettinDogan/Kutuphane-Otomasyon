package proje1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class frmKullaniciIslemleri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSifre;
	private JTextField txtSifreTekrar;
	private JTextField txtKullaniciId;
	private JTextField txtGorevliSifre;
	private JTextField txtGorevliSifreT;
	private JTable table;
	private JTextField txtKullaniciAd;
	private JTextField txtKullaniciSoyad;
	private JTextField txtEmail;
	private JTextField txtKullaniciID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKullaniciIslemleri frame = new frmKullaniciIslemleri();
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
	public frmKullaniciIslemleri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(223, 223, 223));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSifre = new JLabel("Yeni Şifre:");
		lblSifre.setBounds(37, 103, 156, 42);
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSifre);
		
		JLabel lblKullancSeiniz = new JLabel("Kullanıcı Seçiniz:");
		lblKullancSeiniz.setBounds(37, 50, 156, 35);
		lblKullancSeiniz.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblKullancSeiniz.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblKullancSeiniz);
		
	
		
		txtSifre = new JTextField();
		txtSifre.setBounds(218, 106, 263, 35);
		contentPane.add(txtSifre);
		txtSifre.setColumns(10);
		
		txtSifreTekrar = new JTextField();
		txtSifreTekrar.setBounds(218, 163, 263, 35);
		txtSifreTekrar.setColumns(10);
		contentPane.add(txtSifreTekrar);
		
		JLabel lblTyeniifre = new JLabel("T. Yeni Şifre:");
		lblTyeniifre.setBounds(37, 160, 156, 42);
		lblTyeniifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTyeniifre.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblTyeniifre);
		
		JButton btnSifreDegistir = new JButton("Şifre Değiştir");
		btnSifreDegistir.setBounds(69, 232, 412, 62);
	
		btnSifreDegistir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnSifreDegistir);
		
		final JComboBox<Object> cbKullaniciGetir = new JComboBox<Object>();
		cbKullaniciGetir.setBounds(218, 49, 263, 35);
		cKullanicilar kullanici= new cKullanicilar();
		kullanici.kullaniciGetir(cbKullaniciGetir);
		contentPane.add(cbKullaniciGetir);
		
		txtKullaniciId = new JTextField();
		txtKullaniciId.setBounds(491, 50, 19, 35);
		txtKullaniciId.setText("1");
		txtKullaniciId.setColumns(10);
		txtKullaniciId.setVisible(false);
		contentPane.add(txtKullaniciId);
		
		JButton btnCikis = new JButton("Çıkış");
		btnCikis.setBounds(10, 610, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
		btnGeriDon.setBounds(109, 610, 89, 90);
		contentPane.add(btnGeriDon);
		
		JLabel lblGorevliSifre = new JLabel("Yeni Şifre:");
		lblGorevliSifre.setBounds(37, 103, 156, 42);
		lblGorevliSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGorevliSifre.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblGorevliSifre.setVisible(false);
		contentPane.add(lblGorevliSifre);
		
		JLabel lblSifreTekrarGo = new JLabel("T. Yeni Şifre:");
		lblSifreTekrarGo.setBounds(37, 160, 156, 42);
		lblSifreTekrarGo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifreTekrarGo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSifreTekrarGo.setVisible(false);
		contentPane.add(lblSifreTekrarGo);
		
		txtGorevliSifre = new JTextField();
		txtGorevliSifre.setBounds(218, 106, 263, 35);
		txtGorevliSifre.setColumns(10);
		txtGorevliSifre.setVisible(false);
		contentPane.add(txtGorevliSifre);
		
		txtGorevliSifreT = new JTextField();
		txtGorevliSifreT.setBounds(218, 163, 263, 35);
		txtGorevliSifreT.setColumns(10);
		txtGorevliSifreT.setVisible(false);
		contentPane.add(txtGorevliSifreT);
		
		final JLabel txtGorevId = new JLabel("New label");
		txtGorevId.setBounds(37, 25, 46, 14);
		txtGorevId.setText(String.valueOf(cVeritabani._kullaniciId));
		txtGorevId.setVisible(false);
		contentPane.add(txtGorevId);
		
		JButton btnGorevliSifreDegistir = new JButton("Şifre Değiştir");
		btnGorevliSifreDegistir.setBounds(69, 232, 412, 62);
		
		btnGorevliSifreDegistir.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnGorevliSifreDegistir.setVisible(false);
		contentPane.add(btnGorevliSifreDegistir);
		
		final JScrollPane tbKullaniciListele = new JScrollPane();
		tbKullaniciListele.setEnabled(false);
		
		tbKullaniciListele.setBounds(559, 39, 750, 441);
		contentPane.add(tbKullaniciListele);
		
		table = new JTable();
		cKullanicilar ck = new cKullanicilar();
		ck.kullaniciListele(table);
		tbKullaniciListele.setViewportView(table);
	
		JLabel lblAd_2 = new JLabel("Ad:");
		lblAd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAd_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAd_2.setBounds(1300, 40, 156, 35);
		contentPane.add(lblAd_2);
		
		JLabel lblAd_1 = new JLabel("Soyad:");
		lblAd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAd_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAd_1.setBounds(1300, 106, 156, 35);
		contentPane.add(lblAd_1);
		
		JLabel lblAd_1_1 = new JLabel("Email:");
		lblAd_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAd_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAd_1_1.setBounds(1300, 172, 156, 35);
		contentPane.add(lblAd_1_1);
		
		txtKullaniciAd = new JTextField();
		txtKullaniciAd.setColumns(10);
		txtKullaniciAd.setBounds(1475, 37, 263, 35);
		txtKullaniciAd.setEditable(false);;
		contentPane.add(txtKullaniciAd);
		
		
		txtKullaniciSoyad = new JTextField();
		txtKullaniciSoyad.setColumns(10);
		txtKullaniciSoyad.setEditable(false);
		txtKullaniciSoyad.setBounds(1475, 103, 263, 35);
		contentPane.add(txtKullaniciSoyad);
		
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(1475, 170, 263, 35);
		txtEmail.setEditable(false);
		contentPane.add(txtEmail);
		
		txtKullaniciID = new JTextField();
		txtKullaniciID.setColumns(10);
		txtKullaniciID.setBounds(1750, 37, 22, 35);
		txtKullaniciID.setVisible(false);
		contentPane.add(txtKullaniciID);
		
		JButton btnEkle = new JButton("Ekle");
		
		btnEkle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnEkle.setBounds(1300, 511, 216, 107);
		contentPane.add(btnEkle);
		
		final JButton btnSil = new JButton("Sil");
	
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnSil.setBounds(1530, 511, 216, 107);
		contentPane.add(btnSil);

		
		String lblKullaniciIDText = txtGorevId.getText();
		int kullaniciID = Integer.parseInt(lblKullaniciIDText);
		int kullaniciGorevID = ck.kullaniciGorevIdGetir(kullaniciID);
		
		if(kullaniciGorevID==2) {
			lblGorevliSifre.setVisible(true);
			lblSifreTekrarGo.setVisible(true);
			txtGorevliSifre.setVisible(true);
			txtGorevliSifreT.setVisible(true);
			lblTyeniifre.setVisible(false);
			txtSifreTekrar.setVisible(false);
			txtSifre.setVisible(false);
			lblKullancSeiniz.setVisible(false);
			lblSifre.setVisible(false);
			cbKullaniciGetir.setVisible(false);
			btnGorevliSifreDegistir.setVisible(true);
			btnSifreDegistir.setVisible(false);
			btnSil.setVisible(false);
			btnEkle.setVisible(false);
			lblAd_2.setVisible(false);
			lblAd_1.setVisible(false);
			lblAd_1_1.setVisible(false);
			txtKullaniciAd.setVisible(false);
			txtKullaniciSoyad.setVisible(false);
			txtKullaniciID.setVisible(false);
			table.setVisible(false);
			txtEmail.setVisible(false);
			tbKullaniciListele.setVisible(false);
			setBounds(100, 100, 700, 750);
		

		}
		else {
			lblGorevliSifre.setVisible(false);
			lblSifreTekrarGo.setVisible(false);
			txtGorevliSifre.setVisible(false);
			txtGorevliSifreT.setVisible(false);
			lblTyeniifre.setVisible(true);
			txtSifreTekrar.setVisible(true);
			txtSifre.setVisible(true);
			lblKullancSeiniz.setVisible(true);
			lblSifre.setVisible(true);
			cbKullaniciGetir.setVisible(true);
			btnGorevliSifreDegistir.setVisible(false);
			btnSifreDegistir.setVisible(true);
		}
		
		
		cbKullaniciGetir.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            cKullanicilar selectedUser = (cKullanicilar) cbKullaniciGetir.getSelectedItem();
		            if (selectedUser != null) {
		                txtKullaniciId.setText(String.valueOf(selectedUser.get_Id()));
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
		
		btnSifreDegistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mesaj;
				if(txtSifre.getText().equals(txtSifreTekrar.getText())) {
					cKullanicilar ck = new cKullanicilar();
					int id = Integer.valueOf(txtKullaniciId.getText());
		            boolean sonuc = ck.kullaniciSifreDegistir(id,txtSifre.getText());
		            if(sonuc) {
		            	mesaj="Şifreniz başarıyla değiştirilmiştir.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		            }
		            else {
		            	mesaj="Hata";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		            }
				}
				else {
					 mesaj="Şifrenin doğru değildir. Lütfen aynı şifreyi giriniz.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				}
			}
		});
		btnGorevliSifreDegistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mesaj;
				if(txtGorevliSifre.getText().equals(txtGorevliSifreT.getText())) {
					cKullanicilar ck = new cKullanicilar();
					
					String lblKullaniciIDText = txtGorevId.getText();
					int kullaniciID = Integer.parseInt(lblKullaniciIDText);
		            boolean sonuc = ck.kullaniciSifreDegistir(kullaniciID,txtGorevliSifre.getText());
		            if(sonuc) {
		            	mesaj="Şifreniz başarıyla değiştirilmiştir.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		            }
		            else {
		            	mesaj="Hata";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		            }
				}
				else {
					 mesaj="Şifrenin doğru değildir. Lütfen aynı şifreyi giriniz.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				}
			}
				
			
		});
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = table.getSelectedRow();

			       
			        if (selectedRow != -1) {
			          
			            txtKullaniciID.setText(table.getValueAt(selectedRow, 0).toString()); 
			            txtKullaniciAd.setText(table.getValueAt(selectedRow, 1).toString()); 
			            txtKullaniciSoyad.setText(table.getValueAt(selectedRow, 2).toString()); 
			            txtEmail.setText(table.getValueAt(selectedRow, 5).toString()); 
			          
			        }
			}
		});


	
		for (int i = 0; i < table.getColumnCount(); i++) {
		    Class<?> col_class = table.getColumnClass(i);
		    table.setDefaultEditor(col_class, null);
		}
		
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKullaniciEkle kEkle = new frmKullaniciEkle();
	    	 	setVisible(false);
	    	 	kEkle.setVisible(true);
			}
		});
		
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
				 int response = JOptionPane.showConfirmDialog(null, "Kullanıcıyı silmek istediğinize emin misiniz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			        	cKullanicilar ck = new cKullanicilar();
						
						String kullaniciSilId = txtKullaniciID.getText();
						int kullaniciID = Integer.parseInt(kullaniciSilId);
			            boolean sonuc = ck.kullaniciSil(kullaniciID);
			            if(sonuc) {
			            	mesaj="Kullanıcı silinmiştir.";
					        JOptionPane.showMessageDialog(contentPane, mesaj);
					        DefaultTableModel model = (DefaultTableModel) table.getModel();
					        model.setRowCount(0); 

					    
					    	ck.kullaniciListele(table);
					    
					     
			            }
			            else {
			            	mesaj="Kullanıcı silinememiştir";
					        JOptionPane.showMessageDialog(contentPane, mesaj);
			            }
			        }
					
				
				
				
			}
		});

	}
}
