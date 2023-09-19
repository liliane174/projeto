package imobiliaria;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroTerreno extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2932719077211260252L;
	private static Connection conn;
	private static Statement stmt;
	
	static Imovel imv;
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroTerreno frame = new CadastroTerreno(di, imv, dc, df);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void conectaBanco() 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://tuffi.db.elephantsql.com:5432/gqdtgano","gqdtgano","0I1l0XJgmSQK6ObbHzx6sElSd5B5Lfoy");
			stmt = conn.createStatement();
			System.out.println("Banco de dados conectado com sucesso!");
			} catch (Exception e) {
			System.out.println("Banco de dados não conectado!");
			return;
		}
	}

	/**
	 * Create the frame.
	 */
	public CadastroTerreno(DadosImoveis di, Imovel imv, DadosClientes dc, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CadastroTerreno.di = di;
		CadastroTerreno.imv = imv;
		this.dc = dc;
		this.df = df;
		
		JLabel lblNewLabel = new JLabel("Cadastrar Terreno");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		lblNewLabel.setBounds(22, 11, 222, 29);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 38, 404, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Informe os dados do terreno:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 61, 176, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Comprimento");
		lblNewLabel_2.setBounds(32, 109, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Largura");
		lblNewLabel_3.setBounds(32, 145, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Possui aclive ou declive?");
		lblNewLabel_4.setBounds(32, 179, 142, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(123, 106, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 142, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 176, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBounds(323, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terreno t = new Terreno (imv.getCodigo(), imv.getStatus(), imv.getArea(), imv.getDataConstrucao(), imv.getEndereco(), imv.getBairro(), imv.getValorSuge(),
										imv.getValorReal(), imv.getValorImob(), imv.getCpfProp(), imv.getDataEntrada(), imv.isRetirado(), Float.parseFloat(textField.getText()), 
										Float.parseFloat(textField_1.getText()), Integer.parseInt(textField_2.getText()));
				
				if (di.cadastrarTerreno(t)) {
					JOptionPane.showMessageDialog(null,"Terreno cadastrado!","Cadastro efetuado",JOptionPane.INFORMATION_MESSAGE);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Terreno não cadastrado!","ERRO",JOptionPane.ERROR_MESSAGE);
				}
				
				try 
				{
					conectaBanco();
					stmt.executeUpdate("INSERT INTO terreno VALUES ('"+imv.getCodigo()+"','"+imv.getStatus()+"', '"+imv.getArea()+"', '"+imv.getDataConstrucao()+"', '"+imv.getEndereco()+"', '"+imv.getBairro()+"', '"+imv.getValorSuge()+"', '"+imv.getValorReal()+"', '"+imv.getValorImob()+"', '"+imv.getCpfProp()+"', '"+imv.getDataEntrada()+"', '"+imv.isRetirado()+"', '"+textField.getText()+"', '"+textField_1.getText()+"', '"+textField_2.getText()+"')");
					System.out.println("Terreno Cadastrado!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		btnNewButton_1.setBounds(211, 227, 102, 23);
		contentPane.add(btnNewButton_1);
	}

}
