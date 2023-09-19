package imobiliaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastrarImovel extends JFrame {
	
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarImovel frame = new CadastrarImovel(di, dc, df);
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
	public CadastrarImovel(DadosImoveis di, DadosClientes dc, DadosFuncionarios df) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 475);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.di = di;
		this.dc = dc;
		this.df = df;
		
		JLabel lblNewLabel = new JLabel("Informe o tipo do Imovel:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 60, 147, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 179, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(178, 179, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u00C1rea (em m2)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(385, 269, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data da constru\u00E7\u00E3o");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(318, 179, 137, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Endere\u00E7o");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(30, 227, 67, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Bairro");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(331, 227, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Valor sugerido");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(196, 269, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Valor real");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(30, 270, 67, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Valor a ser repassado para imobiliaria");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(238, 306, 217, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("CPF do Propriet\u00E1rio");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(30, 342, 130, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Data do cadastro");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(30, 306, 130, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Im\u00F3vel retirado?");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(297, 342, 102, 14);
		contentPane.add(lblNewLabel_12);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(429, 402, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 402, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_13 = new JLabel("Cadastrar Imovel");
		lblNewLabel_13.setFont(new Font("Myanmar Text", Font.BOLD, 30));
		lblNewLabel_13.setBounds(20, 11, 379, 38);
		contentPane.add(lblNewLabel_13);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 47, 430, 2);
		contentPane.add(separator);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Casa");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(30, 81, 54, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Apartamento");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(100, 81, 107, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Terreno");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(209, 81, 83, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Sala Comercial");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(301, 81, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(196, 142, 298, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_14 = new JLabel("Dados do Im\u00F3vel");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(31, 131, 175, 23);
		contentPane.add(lblNewLabel_14);
		
		textField = new JTextField();
		textField.setBounds(72, 176, 72, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(222, 176, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(432, 176, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(84, 224, 224, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(364, 224, 130, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(84, 267, 93, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(278, 267, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(470, 267, 48, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(126, 303, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(446, 303, 72, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(158, 339, 93, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(399, 339, 72, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					Imovel imv = new Imovel (textField.getText(), Integer.parseInt(textField_1.getText()), Float.parseFloat(textField_7.getText()), textField_2.getText(), textField_3.getText(), textField_4.getText(), Float.parseFloat(textField_6.getText()),
								Float.parseFloat(textField_5.getText()), Float.parseFloat(textField_9.getText()), textField_10.getText(), textField_8.getText(), Boolean.parseBoolean(textField_11.getText()));
					CadastroCasa cc = new CadastroCasa(di, imv, dc, df);
					cc.setVisible(true);
					dispose();
				}
				
				if (rdbtnNewRadioButton_1.isSelected()) {
					Imovel imv = new Imovel (textField.getText(), Integer.parseInt(textField_1.getText()), Float.parseFloat(textField_7.getText()), textField_2.getText(), textField_3.getText(), textField_4.getText(), Float.parseFloat(textField_6.getText()),
							Float.parseFloat(textField_5.getText()), Float.parseFloat(textField_9.getText()), textField_10.getText(), textField_8.getText(), Boolean.parseBoolean(textField_11.getText()));
					CadastroApart ca = new CadastroApart(di, imv, dc, df);
					ca.setVisible(true);
					dispose();
				}
				
				if (rdbtnNewRadioButton_2.isSelected()) {
					Imovel imv = new Imovel (textField.getText(), Integer.parseInt(textField_1.getText()), Float.parseFloat(textField_7.getText()), textField_2.getText(), textField_3.getText(), textField_4.getText(), Float.parseFloat(textField_6.getText()),
							Float.parseFloat(textField_5.getText()), Float.parseFloat(textField_9.getText()), textField_10.getText(), textField_8.getText(), Boolean.parseBoolean(textField_11.getText()));
					CadastroTerreno ct = new CadastroTerreno(di, imv, dc, df);
					ct.setVisible(true);
					dispose();
				}
				
				if (rdbtnNewRadioButton_3.isSelected()) {
					Imovel imv = new Imovel (textField.getText(), Integer.parseInt(textField_1.getText()), Float.parseFloat(textField_7.getText()), textField_2.getText(), textField_3.getText(), textField_4.getText(), Float.parseFloat(textField_6.getText()),
							Float.parseFloat(textField_5.getText()), Float.parseFloat(textField_9.getText()), textField_10.getText(), textField_8.getText(), Boolean.parseBoolean(textField_11.getText()));
					CadastroSala cs = new CadastroSala(di , imv, dc, df);
					cs.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(333, 402, 89, 23);
		contentPane.add(btnNewButton);
	}
}