package proje1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class frmUyeKitaplar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtKitapAdi;
	private JTextField txtYazar;
	private JTextField txtKategori;
	private JTextField txtYayinTarihi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUyeKitaplar frame = new frmUyeKitaplar();
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
	public frmUyeKitaplar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 1000, 432);
		contentPane.add(scrollPane);
		
		table = new JTable();
		cKitap ck = new cKitap();
		ck.kitapListele(table);
		scrollPane.setViewportView(table);
		
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
		btnCikis.setBounds(10, 548, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
		btnGeriDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUyeAnaSayfa frm = new frmUyeAnaSayfa();
		        setVisible(false);
		        frm.setVisible(true);
			}
		});
		btnGeriDon.setBounds(109, 548, 89, 90);
		contentPane.add(btnGeriDon);
		
        
	
	
		
		JLabel  lblYazar = new JLabel("Yazar:");
		lblYazar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYazar.setBounds(286, 32, 103, 24);
		contentPane.add(lblYazar);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Kategori:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(537, 32, 103, 24);
		contentPane.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Yayın Tarihi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(807, 32, 103, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Kitap Adı:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 32, 103, 24);
		contentPane.add(lblNewLabel_1_3);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setBounds(97, 30, 180, 30);
		contentPane.add(txtKitapAdi);
		txtKitapAdi.setColumns(10);
		
		txtYazar = new JTextField();
		txtYazar.setColumns(10);
		txtYazar.setBounds(347, 30, 180, 30);
		contentPane.add(txtYazar);
		
		txtKategori = new JTextField();
		txtKategori.setColumns(10);
		txtKategori.setBounds(617, 30, 180, 30);
		contentPane.add(txtKategori);
		
		txtYayinTarihi = new JTextField();
		txtYayinTarihi.setColumns(10);
		txtYayinTarihi.setBounds(907, 30, 180, 30);
		contentPane.add(txtYayinTarihi);
		
		txtKitapAdi.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirAd(table, txtKitapAdi.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirAd(table, txtKitapAdi.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirAd(table, txtKitapAdi.getText());
			}

		 
		});
	
		
		txtKategori.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirKategori(table, txtKategori.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirKategori(table, txtKategori.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirKategori(table, txtKategori.getText());
			}

		 
		});
		
		
		txtYazar.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirYazar(table, txtYazar.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYazar(table, txtYazar.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYazar(table, txtYazar.getText());
			}

		 
		});
		txtYayinTarihi.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirYayinTarihi(table, txtYayinTarihi.getText());
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYayinTarihi(table, txtYayinTarihi.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			     cKitap ck = new cKitap();
			        ck.KitapGetirYayinTarihi(table, txtYayinTarihi.getText());
			}

		 
		});
		for (int i = 0; i < table.getColumnCount(); i++) {
		    Class<?> col_class = table.getColumnClass(i);
		    table.setDefaultEditor(col_class, null);
		}
		
	}
}
