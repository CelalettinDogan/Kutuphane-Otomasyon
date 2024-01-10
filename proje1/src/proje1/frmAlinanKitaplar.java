package proje1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAlinanKitaplar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtKitapAdi;
	private JLabel lblToplamBor;
	private JTextField txtToplamBorc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAlinanKitaplar frame = new frmAlinanKitaplar();
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
	public frmAlinanKitaplar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 91, 900, 405);
		contentPane.add(scrollPane);
		
		table = new JTable();
		int uyeId = cVeritabani._uyeId;
		cUyeler cu = new cUyeler();
		cu.alinanKitapListele(table, uyeId);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Kitap Adı:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 31, 126, 30);
		contentPane.add(lblNewLabel);
		
		txtKitapAdi = new JTextField();
		txtKitapAdi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtKitapAdi.setBounds(136, 31, 293, 30);
		contentPane.add(txtKitapAdi);
		txtKitapAdi.setColumns(10);
		
		lblToplamBor = new JLabel("Toplam Borç:");
		lblToplamBor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblToplamBor.setBounds(956, 92, 126, 30);
		contentPane.add(lblToplamBor);
		
		txtToplamBorc = new JTextField();
		txtToplamBorc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtToplamBorc.setColumns(10);
		txtToplamBorc.setEditable(false);
		txtToplamBorc.setBounds(1085, 93, 200, 30);
		contentPane.add(txtToplamBorc);
		double borc = cu.borcGetir(uyeId);
		txtToplamBorc.setText(String.valueOf(borc));
		
		JButton btnBorcSil = new JButton("Borç Öde");
	
		btnBorcSil.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnBorcSil.setBounds(951, 148, 350, 97);
		contentPane.add(btnBorcSil);
		
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
		btnCikis.setBounds(10, 609, 89, 90);
		contentPane.add(btnCikis);
		
		JButton btnGeriDon = new JButton("Geri Dön");
		btnGeriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUyeAnaSayfa frm = new frmUyeAnaSayfa();
		        setVisible(false);
		        frm.setVisible(true);
			}
		});
		btnGeriDon.setBounds(109, 609, 89, 90);
		contentPane.add(btnGeriDon);

		
		txtKitapAdi.getDocument().addDocumentListener(new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        // Metin değiştiğinde yapılacak işlemler
		    	cKitap ck = new cKitap();
		        ck.KitapGetirAdUye(table, txtKitapAdi.getText(), uyeId);
		    }

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cKitap ck = new cKitap();
		        ck.KitapGetirAdUye(table, txtKitapAdi.getText(), uyeId);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				cKitap ck = new cKitap();
		        ck.KitapGetirAdUye(table, txtKitapAdi.getText(), uyeId);
			}

		 
		});
		btnBorcSil.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String mesaj;
		        JTextField textField = new JTextField();
		        Object[] message = {"Ödemeniz Kredi Kartı ile gerçekleştirilecektir.\nBorcu Silinecek Miktar:", textField};
		        int option = JOptionPane.showConfirmDialog(null, message, "Borç Sil", JOptionPane.OK_CANCEL_OPTION);
		        
		        if (option == JOptionPane.OK_OPTION) {
		        	OdemeFactory of = new cOdemeKrediKartFactory();
		        	Odeme odeme = of.createOdeme();
		        
		            double silinecekBorc = Double.parseDouble(textField.getText());
		            boolean sonuc=cu.borcSil(uyeId, silinecekBorc);
		           
		            if(sonuc) {
		            	mesaj =odeme.proccess();
		            	
				        JOptionPane.showMessageDialog(contentPane, mesaj);
				        double borc = cu.borcGetir(uyeId);
						txtToplamBorc.setText(String.valueOf(borc));
				        
		            }
		            else {
		            	mesaj="Borcunuz silinememiştir.";
				        JOptionPane.showMessageDialog(contentPane, mesaj);
		            }
		        }
		    }
		});

	}
}
