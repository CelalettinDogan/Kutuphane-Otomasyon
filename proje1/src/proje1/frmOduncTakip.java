package proje1;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class frmOduncTakip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNumaraAra;
	private JTextField txtNumara;
	private JTextField txtUyeAd;
	private JTextField txtUyeSoyad;
	private JTextField txtKitapAdi;
	private JTextField txtKitapID;
	private JTextField txtTeslimTarihi;
	private JTextField txtEmanetID;
	private JTextField txtAdet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmOduncTakip frame = new frmOduncTakip();
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
	public frmOduncTakip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(223, 223, 223));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 73, 900, 430);
		contentPane.add(scrollPane);
		
		table = new JTable();
		cOduncTakip ot = new cOduncTakip();
		ot.listele(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Numara:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(54, 30, 96, 29);
		contentPane.add(lblNewLabel);
		
		txtNumaraAra = new JTextField();
		txtNumaraAra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNumaraAra.setBounds(145, 31, 231, 29);
		contentPane.add(txtNumaraAra);
		txtNumaraAra.setColumns(10);
		
		JButton btnCikis = new JButton("Çıkış");
		
		btnCikis.setBounds(10, 634, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
		
		btnGeriDon.setBounds(109, 634, 89, 90);
		contentPane.add(btnGeriDon);
		
		JButton btnEmanetSil = new JButton("İade");
		
		btnEmanetSil.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEmanetSil.setBounds(252, 514, 170, 120);
		contentPane.add(btnEmanetSil);
		
		JButton btnSureEkle = new JButton("Emanet Süre Ekle");

		btnSureEkle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSureEkle.setBounds(432, 514, 170, 120);
		contentPane.add(btnSureEkle);
		
		JLabel lblNewLabel_1 = new JLabel("Numara:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(994, 95, 89, 29);
		contentPane.add(lblNewLabel_1);
		
		txtNumara = new JTextField();
		txtNumara.setEditable(false);
		txtNumara.setColumns(10);
		txtNumara.setBounds(1093, 95, 185, 29);
		contentPane.add(txtNumara);
		
		JLabel lblNewLabel_2 = new JLabel("Üye Ad:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(994, 158, 89, 29);
		contentPane.add(lblNewLabel_2);
		
		txtUyeAd = new JTextField();
		txtUyeAd.setEditable(false);
		txtUyeAd.setColumns(10);
		txtUyeAd.setBounds(1093, 158, 185, 29);
		contentPane.add(txtUyeAd);
		
		JLabel lblNewLabel_3 = new JLabel("Üye Soyad:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(963, 213, 120, 29);
		contentPane.add(lblNewLabel_3);
		
		txtUyeSoyad = new JTextField();
		txtUyeSoyad.setEditable(false);
		txtUyeSoyad.setColumns(10);
		txtUyeSoyad.setBounds(1093, 213, 185, 29);
		contentPane.add(txtUyeSoyad);
		
		JLabel lblNewLabel_5 = new JLabel("Kitap Adı:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(963, 282, 120, 29);
		contentPane.add(lblNewLabel_5);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setEditable(false);
		txtKitapAdi.setColumns(10);
		txtKitapAdi.setBounds(1093, 282, 185, 29);
		contentPane.add(txtKitapAdi);
		
		txtKitapID = new JTextField();
		txtKitapID.setEditable(false);
		txtKitapID.setColumns(10);
		txtKitapID.setBounds(1288, 282, 15, 29);
		txtKitapID.setVisible(false);
		contentPane.add(txtKitapID);
		
		JLabel lblNewLabel_5_1 = new JLabel("Teslim Tarihi:");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(954, 336, 130, 29);
		contentPane.add(lblNewLabel_5_1);
		
		txtTeslimTarihi = new JTextField();
		txtTeslimTarihi.setEditable(false);
		txtTeslimTarihi.setColumns(10);
		txtTeslimTarihi.setBounds(1093, 336, 185, 29);
		contentPane.add(txtTeslimTarihi);
		
		txtEmanetID = new JTextField();
		txtEmanetID.setEditable(false);
		txtEmanetID.setColumns(10);
		txtEmanetID.setBounds(1288, 95, 15, 29);
		txtEmanetID.setVisible(false);
		contentPane.add(txtEmanetID);
		
		txtAdet = new JTextField();
		txtAdet.setEditable(false);
		txtAdet.setColumns(10);
		txtAdet.setBounds(1288, 158, 15, 29);
		txtAdet.setVisible(false);
		contentPane.add(txtAdet);
		
		
		
		for (int i = 0; i < table.getColumnCount(); i++) {
		    Class<?> col_class = table.getColumnClass(i);
		    table.setDefaultEditor(col_class, null);
		}
		
		txtNumaraAra.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	
		        ot.emanetGetirNumara(table,txtNumaraAra.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ot.emanetGetirNumara(table,txtNumaraAra.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			
				ot.emanetGetirNumara(table,txtNumaraAra.getText());
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = table.getSelectedRow();

			       
			        if (selectedRow != -1) {
			          
			            txtEmanetID.setText(table.getValueAt(selectedRow, 0).toString()); 
			            txtNumara.setText(table.getValueAt(selectedRow, 1).toString()); 
			            txtUyeAd.setText(table.getValueAt(selectedRow, 2).toString()); 
			            txtUyeSoyad.setText(table.getValueAt(selectedRow, 3).toString()); 
			            txtKitapID.setText(table.getValueAt(selectedRow, 4).toString()); 
			            txtKitapAdi.setText(table.getValueAt(selectedRow, 5).toString()); 
			            txtAdet.setText(table.getValueAt(selectedRow, 6).toString()); 
			            txtTeslimTarihi.setText(table.getValueAt(selectedRow, 8).toString()); 
			          
			          
			        }
			}
		});
		btnEmanetSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
				int emanetID = Integer.parseInt(txtEmanetID.getText());
				boolean sil = ot.emanetSil(emanetID);
				if(sil) {
				int adet = Integer.parseInt(txtAdet.getText());
					int kitapID = Integer.parseInt(txtKitapID.getText());
					  ot.adetEkle(adet,kitapID );
					  mesaj="Emanet Silindi";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				        DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.setRowCount(0); 

				    
				        ot.listele(table);
				}
				else {
					  mesaj="Emanet Silinemedi";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				}
			}
		});
		btnSureEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj;
				boolean sonuc = ot.eklemeKontrol(Integer.parseInt(txtEmanetID.getText()));
				
				if(sonuc) {
					 mesaj="1 AY DOLMUŞTUR";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				       
				
				}
				else {
					 mesaj="Süre Eklendi";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
					ot.sureEkle(Integer.parseInt(txtEmanetID.getText()));
					   DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.setRowCount(0);

				     
				        ot.listele(table);
				}
				
			}
		});
		
	}
}
