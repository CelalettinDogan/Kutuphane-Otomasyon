package proje1;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;


public class frmUyeIslemleri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtGuncelBorc;
	private JTextField txtUyeNumarasi;
	private JTextField txtUyeAd;
	private JTextField txtUyeSoyad;
	private JTextField txtUyeNumara;
	private JTextField txtUyeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeIslemleri frame = new frmUyeIslemleri();
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
	public frmUyeIslemleri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(223, 223, 223));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JScrollPane tblUyeListele = new JScrollPane();
		tblUyeListele.setEnabled(false);
		
		tblUyeListele.setBounds(548, 97, 1000, 441);
		contentPane.add(tblUyeListele);
		
		table = new JTable();
		cUyeler cu = new cUyeler();
		cu.UyeListele(table);
		tblUyeListele.setViewportView(table);
        cUyeler uyeler = new cUyeler();
        
        JButton btnUSil = new JButton("Seçili Üyeyi Sil");
        btnUSil.setFont(new Font("Tahoma", Font.BOLD, 9));
        btnUSil.setBounds(323, 61, 146, 25);
        contentPane.add(btnUSil);
        
        txtGuncelBorc = new JTextField();
        txtGuncelBorc.setBounds(50, 378, 263, 35);
        contentPane.add(txtGuncelBorc);
        txtGuncelBorc.setColumns(10);
        
        JButton btnBorcGuncelle = new JButton("Güncelle");
        btnBorcGuncelle.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnBorcGuncelle.setBounds(327, 383, 100, 25);
        contentPane.add(btnBorcGuncelle);
        
        JLabel lblUyeSec = new JLabel("Üye Numara");
        lblUyeSec.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUyeSec.setBounds(50, 21, 110, 20);
        contentPane.add(lblUyeSec);
        
        JLabel lblGüncelBorc = new JLabel("Seçili Üyenin Borcu:");
        lblGüncelBorc.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblGüncelBorc.setBounds(50, 348, 170, 19);
        contentPane.add(lblGüncelBorc);
        
        JLabel lblBorc = new JLabel("...");
        lblBorc.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBorc.setForeground(new Color(0, 128, 0));
        lblBorc.setBounds(208, 347, 90, 20);
        contentPane.add(lblBorc);
        
        JLabel lblNewLabel = new JLabel("Üye Numarası:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel.setBounds(548, 38, 158, 48);
        contentPane.add(lblNewLabel);
        
        txtUyeNumarasi = new JTextField();
        txtUyeNumarasi.setBounds(700, 44, 220, 35);
        contentPane.add(txtUyeNumarasi);
     
        txtUyeNumarasi.setColumns(10);
        
        txtUyeAd = new JTextField();
        txtUyeAd.setText("Üye seçiniz...");
        txtUyeAd.setColumns(10);
        txtUyeAd.setBounds(50, 138, 263, 35);
        txtUyeAd.setEditable(false);
        contentPane.add(txtUyeAd);
        
        JLabel lblyeAd = new JLabel("Üye Ad");
        lblyeAd.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblyeAd.setBounds(50, 109, 110, 20);
        contentPane.add(lblyeAd);
        
        JLabel lblUyeSec_1_1 = new JLabel("Üye Soyad");
        lblUyeSec_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUyeSec_1_1.setBounds(50, 192, 110, 20);
        contentPane.add(lblUyeSec_1_1);
        
        txtUyeSoyad = new JTextField();
        txtUyeSoyad.setText("Üye seçiniz...");
        txtUyeSoyad.setColumns(10);
        txtUyeSoyad.setBounds(50, 223, 263, 35);
        txtUyeSoyad.setEditable(false);
        contentPane.add(txtUyeSoyad);
        
        txtUyeNumara = new JTextField();
        txtUyeNumara.setText("Üye seçiniz...");
        txtUyeNumara.setColumns(10);
        txtUyeNumara.setBounds(50, 58, 263, 35);
        txtUyeNumara.setEditable(false);
        contentPane.add(txtUyeNumara);
        
        txtUyeID = new JTextField();
        txtUyeID.setColumns(10);
        txtUyeID.setBounds(21, 58, 19, 35);
        txtUyeID.setVisible(false);
        contentPane.add(txtUyeID);
        
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
        btnCikis.setBounds(21, 610, 89, 90);
        contentPane.add(btnCikis);
        
        JButton btnGeriDon = new JButton("Geri Dön");
        btnGeriDon.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmKullaniciAnaSayfa frm = new frmKullaniciAnaSayfa();
		        setVisible(false);
		        frm.setVisible(true);
        	}
        });
        btnGeriDon.setBounds(119, 610, 89, 90);
        contentPane.add(btnGeriDon);
        
        JCheckBox chbKrediKart = new JCheckBox("Kredi Kartı ile Ödeme");
        chbKrediKart.setBounds(50, 274, 214, 23);
        contentPane.add(chbKrediKart);
        
        JCheckBox chbNakit = new JCheckBox("Nakit İle Ödeme");
        chbNakit.setBounds(50, 318, 211, 23);
        contentPane.add(chbNakit);
        
        JButton btnyeEkle = new JButton("Üye Ekle");
        btnyeEkle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmUyeEkle ue = new frmUyeEkle();
        		setVisible(false);
        		ue.setVisible(true);
        		
        	}
        });
        btnyeEkle.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnyeEkle.setBounds(1422, 581, 126, 119);
        contentPane.add(btnyeEkle);
        
        
        
        
    
    
    	
		for (int i = 0; i < table.getColumnCount(); i++) {
		    Class<?> col_class = table.getColumnClass(i);
		    table.setDefaultEditor(col_class, null);
		}
		
		txtUyeNumarasi.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	
		        cu.uyeIslemleriNumara(table,txtUyeNumarasi.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cu.uyeIslemleriNumara(table,txtUyeNumarasi.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			
				cu.uyeIslemleriNumara(table,txtUyeNumarasi.getText());
			}

		 
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = table.getSelectedRow();

			       
			        if (selectedRow != -1) {
			          
			            txtUyeID.setText(table.getValueAt(selectedRow, 0).toString()); 
			            txtUyeNumara.setText(table.getValueAt(selectedRow, 3).toString()); 
			            txtUyeAd.setText(table.getValueAt(selectedRow, 1).toString()); 
			            txtUyeSoyad.setText(table.getValueAt(selectedRow, 2).toString()); 
			            lblBorc.setText(table.getValueAt(selectedRow, 6).toString()); 
			           
			          
			          
			        }
			}
		});
		  btnUSil.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	 String mesaj;
        	cUyeler cu = new cUyeler();
        	boolean sonuc =cu.UyeSil(txtUyeID.getText());
        	if(sonuc) {
        		  mesaj = "Üye silinmiştir ";
                  JOptionPane.showMessageDialog(contentPane, mesaj);
                  DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setRowCount(0); 

			    
			        cu.UyeListele(table);
        	}
        	else {
        		  mesaj = "Lütfen bir kişi seçiniz. ";
                  JOptionPane.showMessageDialog(contentPane, mesaj);
        	}
        	 
        	
        }
    });
		  
		   btnBorcGuncelle.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 String mesaj;
	            	if(txtGuncelBorc.getText().isEmpty()) {
	            		 mesaj = "Lütfen bir değer giriniz.";
	                      JOptionPane.showMessageDialog(contentPane, mesaj); 
	            	}
	            	else {
	            	
			            	
	            		if (chbNakit.isSelected() && chbKrediKart.isSelected()) {
	            		    mesaj = "Lütfen tek bir ödeme yöntemi seçiniz.";
	            		    JOptionPane.showMessageDialog(contentPane, mesaj);
	            		}
			                else if(chbNakit.isSelected()) {
			                	OdemeFactory of = new cOdemeNakitFactory();
					        	Odeme odeme = of.createOdeme();
					        	int uyeID = Integer.parseInt(txtUyeID.getText());
					            double silinecekBorc = Double.parseDouble(txtGuncelBorc.getText());
					            boolean sonuc=cu.borcSil(uyeID, silinecekBorc);
					           
					            if(sonuc) {
					            	mesaj =odeme.proccess();
					            	
							        JOptionPane.showMessageDialog(contentPane, mesaj);
							        
							        DefaultTableModel model = (DefaultTableModel) table.getModel();
							        model.setRowCount(0); 
							        
							    
							        cu.UyeListele(table);
					            }
					            else {
					            	mesaj="Yazılan miktar borçtan büyüktür.Lütfen daha küçük miktar giriniz.";
							        JOptionPane.showMessageDialog(contentPane, mesaj);
					            }
			                }
			                else if(chbKrediKart.isSelected()) {
			                	OdemeFactory of = new cOdemeKrediKartFactory();
					        	Odeme odeme = of.createOdeme();
					        	int uyeID = Integer.parseInt(txtUyeID.getText());
					            double silinecekBorc = Double.parseDouble(txtGuncelBorc.getText());
					            boolean sonuc=cu.borcSil(uyeID, silinecekBorc);
					           
					            if(sonuc) {
					            	mesaj =odeme.proccess();
					            	
							        JOptionPane.showMessageDialog(contentPane, mesaj);
							        DefaultTableModel model = (DefaultTableModel) table.getModel();
							        model.setRowCount(0); 
		
							    
							        cu.UyeListele(table);
					            }
					            else {
					            	mesaj="Yazılan miktar borçtan büyüktür.Lütfen daha küçük miktar giriniz.";
							        JOptionPane.showMessageDialog(contentPane, mesaj);
					            }
			                }
			                else  {
			                	  mesaj = "Lütfen bir ödeme yöntemi seçiniz.";
			                      JOptionPane.showMessageDialog(contentPane, mesaj); 
	                }
	            	}
	            }
	            	
	        });
    
	}
	}


