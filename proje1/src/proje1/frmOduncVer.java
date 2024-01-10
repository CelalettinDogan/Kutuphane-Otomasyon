package proje1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class frmOduncVer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNumaraAra;
	private JTable table_1;
	private JScrollPane tblKitapListele;
	private JLabel lblKitapAd;
	private JTextField txtKitapAdiAra;
	private JLabel lblNewLabel_1;
	private JTextField txtNumara;
	private JLabel lblNewLabel_2;
	private JTextField txtUyeAd;
	private JLabel lblNewLabel_3;
	private JTextField txtUyeSoyad;
	private JLabel lblNewLabel_4;
	private JTextField txtEmail;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtKitapAdi;
	private JTextField txtAdet;
	private JTextField txtFiyat;
	private JTextField txtUyeID;
	private JTextField txtKitapID;
	private JButton btnCikis;
	private JButton btnGeriDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmOduncVer frame = new frmOduncVer();
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
	public frmOduncVer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane tblUyeListele = new JScrollPane();
		tblUyeListele.setBounds(10, 80, 480, 431);
		contentPane.add(tblUyeListele);
		
		
		cOdunc co = new cOdunc();
		
		table = new JTable();
		co.listele(table);
		tblUyeListele.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Numara:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 40, 89, 29);
		contentPane.add(lblNewLabel);
		
		txtNumaraAra = new JTextField();
		txtNumaraAra.setBounds(106, 40, 358, 29);
		contentPane.add(txtNumaraAra);
		txtNumaraAra.setColumns(10);
		
		tblKitapListele = new JScrollPane();
		tblKitapListele.setBounds(500, 82, 700, 429);
		contentPane.add(tblKitapListele);
		
		table_1 = new JTable();
		co.kitapListele(table_1);
		tblKitapListele.setViewportView(table_1);
		
		lblKitapAd = new JLabel("Kitap Adı:");
		lblKitapAd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKitapAd.setBounds(503, 40, 89, 29);
		contentPane.add(lblKitapAd);
		
		txtKitapAdiAra = new JTextField();
		txtKitapAdiAra.setColumns(10);
		txtKitapAdiAra.setBounds(602, 40, 358, 29);
		contentPane.add(txtKitapAdiAra);
		
		lblNewLabel_1 = new JLabel("Numara:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(1230, 94, 89, 29);
		contentPane.add(lblNewLabel_1);
		
		txtNumara = new JTextField();
		txtNumara.setColumns(10);
		txtNumara.setBounds(1340, 95, 185, 29);
		txtNumara.setEditable(false);
		contentPane.add(txtNumara);
		
		lblNewLabel_2 = new JLabel("Üye Ad:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(1230, 147, 89, 29);
		contentPane.add(lblNewLabel_2);
		
		txtUyeAd = new JTextField();
		txtUyeAd.setColumns(10);
		txtUyeAd.setBounds(1340, 147, 185, 29);
		txtUyeAd.setEditable(false);
		contentPane.add(txtUyeAd);
		
		lblNewLabel_3 = new JLabel("Üye Soyad:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(1200, 200, 120, 29);
		contentPane.add(lblNewLabel_3);
		
		txtUyeSoyad = new JTextField();
		txtUyeSoyad.setColumns(10);
		txtUyeSoyad.setBounds(1340, 201, 185, 29);
		txtUyeSoyad.setEditable(false);
		contentPane.add(txtUyeSoyad);
		
		lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(1199, 253, 120, 29);
		contentPane.add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(1340, 254, 185, 29);
		txtEmail.setEditable(false);
		contentPane.add(txtEmail);
		
		lblNewLabel_5 = new JLabel("Kitap Adı:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(1199, 353, 120, 29);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Adet:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(1199, 406, 120, 29);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Fiyat:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(1199, 459, 120, 29);
		contentPane.add(lblNewLabel_7);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setColumns(10);
		txtKitapAdi.setBounds(1340, 353, 185, 29);
		txtKitapAdi.setEditable(false);
		contentPane.add(txtKitapAdi);
		
		txtAdet = new JTextField();
	
		txtAdet.setColumns(10);
		txtAdet.setBounds(1340, 407, 185, 29);
		contentPane.add(txtAdet);
		
		txtFiyat = new JTextField();
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(1340, 460, 185, 29);
		txtFiyat.setEditable(false);
		contentPane.add(txtFiyat);
		
		txtUyeID = new JTextField();
		txtUyeID.setColumns(10);
		txtUyeID.setBounds(1530, 94, 15, 29);
		txtUyeID.setEnabled(false);
		txtUyeID.setVisible(false);
		contentPane.add(txtUyeID);
		
		txtKitapID = new JTextField();
		txtKitapID.setColumns(10);
		txtKitapID.setBounds(1535, 353, 15, 29);
		txtKitapID.setEnabled(false);
		txtKitapID.setVisible(false);
		contentPane.add(txtKitapID);
		
		JButton btnEkle = new JButton("Ekle");
	
		btnEkle.setBounds(1230, 510, 330, 86);
		contentPane.add(btnEkle);
		
		btnCikis = new JButton("Çıkış");
		
		btnCikis.setBounds(10, 610, 89, 90);
		contentPane.add(btnCikis);
		
		btnGeriDon = new JButton("Geri Dön");
	
		btnGeriDon.setBounds(106, 610, 89, 90);
		contentPane.add(btnGeriDon);
		
		for (int i = 0; i < table.getColumnCount(); i++) {
		    Class<?> col_class = table.getColumnClass(i);
		    table.setDefaultEditor(col_class, null);
		}
		
		for (int i = 0; i < table_1.getColumnCount(); i++) {
		    Class<?> col_class = table_1.getColumnClass(i);
		    table_1.setDefaultEditor(col_class, null);
		}
		
		txtNumaraAra.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cUyeler cu = new cUyeler();
		        cu.UyeGetirNumarayaGore(table, txtNumaraAra.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cUyeler cu = new cUyeler();
		        cu.UyeGetirNumarayaGore(table, txtNumaraAra.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cUyeler cu = new cUyeler();
		        cu.UyeGetirNumarayaGore(table, txtNumaraAra.getText());
			}

		 
		});
		
		
		txtKitapAdiAra.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		    	ck.kitapListeleOdunc(table_1, txtKitapAdiAra.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cKitap ck = new cKitap();
		    	ck.kitapListeleOdunc(table_1, txtKitapAdiAra.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cKitap ck = new cKitap();
		    	ck.kitapListeleOdunc(table_1, txtKitapAdiAra.getText());
			}

		 
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = table.getSelectedRow();

			       
			        if (selectedRow != -1) {
			          
			            txtUyeID.setText(table.getValueAt(selectedRow, 0).toString()); 
			            txtNumara.setText(table.getValueAt(selectedRow, 1).toString()); 
			            txtUyeAd.setText(table.getValueAt(selectedRow, 2).toString()); 
			            txtUyeSoyad.setText(table.getValueAt(selectedRow, 3).toString()); 
			            txtEmail.setText(table.getValueAt(selectedRow, 4).toString()); 
			          
			        }
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = table_1.getSelectedRow();

			       
			        if (selectedRow != -1) {
			          
			            txtKitapID.setText(table_1.getValueAt(selectedRow, 0).toString()); 
			            txtKitapAdi.setText(table_1.getValueAt(selectedRow, 1).toString()); 
			            txtFiyat.setText(table_1.getValueAt(selectedRow, 3).toString()); 
			            String fiyat = table_1.getValueAt(selectedRow, 3).toString(); 
			            
			            txtAdet.getDocument().addDocumentListener(new DocumentListener() {
			                @Override
			                public void insertUpdate(DocumentEvent e) {
			                    calculateTotal();
			                }

			                @Override
			                public void removeUpdate(DocumentEvent e) {
			                    calculateTotal();
			                }

			                @Override
			                public void changedUpdate(DocumentEvent e) {
			                    // Plain text components don't fire these events
			                }

			                private void calculateTotal() {
			                    try {
			                        int selectedRow = table_1.getSelectedRow();
			                        if (selectedRow != -1) {
			                            String fiyat = table_1.getValueAt(selectedRow, 3).toString(); // Fiyatı güncelleyin
			                            double adet = Double.parseDouble(txtAdet.getText());
			                            double Fiyat = Double.parseDouble(fiyat);
			                            double toplamFiyat = adet * Fiyat;
			                            txtFiyat.setText(String.valueOf(toplamFiyat));
			                        }
			                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
			                        txtFiyat.setText("Hesaplanamadı");
			                    }
			                }
			            });

			       
			           
			          
			        }
			}
		});
		


		btnEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mesaj;
				
				
			   co.set_uyeID(Integer.valueOf(txtUyeID.getText()));
			   co.set_kitapID(Integer.valueOf(txtKitapID.getText()));
			   co.set_adet(Integer.valueOf(txtAdet.getText()));
			   int KullaniciID = cVeritabani._kullaniciId;
			   co.set_kullaniciID(KullaniciID);
			   int adetKontrol=co.adetKontrol(Integer.valueOf(txtAdet.getText()), Integer.valueOf(txtKitapID.getText()));
			   
			   if(adetKontrol==1) {
				  co.adetSil(Integer.valueOf(txtAdet.getText()), Integer.valueOf(txtKitapID.getText())); 
				  co.borcEkleme(Double.valueOf(txtFiyat.getText()), Integer.valueOf(txtUyeID.getText()) );
				   boolean sonuc = co.emanetEkle(co);
				   if(sonuc) {
					   mesaj="Emanet eklendi";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				        model.setRowCount(0);

				       
				        co.kitapListele(table_1);
				   }
				   else {
					   mesaj="Eklenemedi";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				   }
			   }
			   else {
				   mesaj="Adet sayınızı büyük";
			        JOptionPane.showMessageDialog(contentPane, mesaj);
			   }
			  
			   
			}
		});
		
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int response = JOptionPane.showConfirmDialog(null, "Uygulamayı kapatmak istediğinize emin misiniz?", "Uyarı",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        if (response == JOptionPane.YES_OPTION) {
			            System.exit(0);
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
	}
}
