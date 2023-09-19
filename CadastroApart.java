package imobiliaria;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadastroApart extends JFrame {
	
	static Imovel imv;
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private static Connection conn;
	private static Statement stmt;

	private JPanel contentPane;
	private JTextField quartos;
	private JTextField suites;
	private JTextField garagem;
	private JTextField armario;
	private JTextField salas_estar;
	private JTextField andar;
	private JTextField valorcond;
	private JTextField portaria;
	private JTextField descricao_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroApart frame = new CadastroApart(di, imv, dc, df);
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
	public CadastroApart(DadosImoveis di, Imovel imv, DadosClientes dc, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CadastroApart.di = di;
		CadastroApart.imv = imv;
		this.dc = dc;
		this.df = df;
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Apartamento");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		lblNewLabel.setBounds(22, 11, 309, 29);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 38, 404, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Informe os dados do apartamento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 61, 212, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de quartos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 109, 161, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero de Su\u00EDtes");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(203, 109, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel sala_estar = new JLabel("N\u00FAmero de salas de estar");
		sala_estar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sala_estar.setBounds(32, 202, 161, 14);
		contentPane.add(sala_estar);
		
		JLabel lblNewLabel_5 = new JLabel("Vagas de garagem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(373, 109, 122, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Possui arm\u00E1rios?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(32, 161, 110, 14);
		contentPane.add(lblNewLabel_6);
		
		quartos = new JTextField();
		quartos.setBounds(143, 107, 34, 20);
		contentPane.add(quartos);
		quartos.setColumns(10);
		
		suites = new JTextField();
		suites.setBounds(307, 107, 34, 20);
		contentPane.add(suites);
		suites.setColumns(10);
		
		garagem = new JTextField();
		garagem.setBounds(479, 107, 34, 20);
		contentPane.add(garagem);
		garagem.setColumns(10);
		
		armario = new JTextField();
		armario.setBounds(125, 159, 52, 20);
		contentPane.add(armario);
		armario.setColumns(10);
		
		salas_estar = new JTextField();
		salas_estar.setBounds(177, 200, 34, 20);
		contentPane.add(salas_estar);
		salas_estar.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Andar");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(423, 162, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		andar = new JTextField();
		andar.setBounds(458, 159, 34, 20);
		contentPane.add(andar);
		andar.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Valor do condom\u00EDnio");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(203, 161, 128, 14);
		contentPane.add(lblNewLabel_7);
		
		valorcond = new JTextField();
		valorcond.setBounds(323, 159, 52, 20);
		contentPane.add(valorcond);
		valorcond.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Possui portaria 24h?");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(284, 202, 140, 14);
		contentPane.add(lblNewLabel_8);
		
		portaria = new JTextField();
		portaria.setBounds(409, 200, 86, 20);
		contentPane.add(portaria);
		portaria.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(32, 240, 64, 14);
		contentPane.add(lblNewLabel_9);
		
		descricao_1 = new JTextField();
		descricao_1.setBounds(91, 238, 404, 48);
		contentPane.add(descricao_1);
		descricao_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(433, 307, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Apartamento ap = new Apartamento (imv.getCodigo(), imv.getStatus(), imv.getArea(), imv.getDataConstrucao(), imv.getEndereco(), imv.getBairro(), imv.getValorSuge(),
						imv.getValorReal(), imv.getValorImob(), imv.getCpfProp(), imv.getDataEntrada(), imv.isRetirado(),  Integer.parseInt(quartos.getText()), 
						Integer.parseInt(suites.getText()), Integer.parseInt(salas_estar.getText()),  Integer.parseInt(garagem.getText()), Boolean.parseBoolean(armario.getText()),
					    descricao_1.getText(), Integer.parseInt(andar.getText()), Float.parseFloat(valorcond.getText()), Boolean.parseBoolean(portaria.getText()));

				if (di.cadastrarApartamento(ap)) {
					JOptionPane.showMessageDialog(null,"Apartamento cadastrado!","Cadastro efetuado",JOptionPane.INFORMATION_MESSAGE);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Apartamento não cadastrado!","ERRO",JOptionPane.ERROR_MESSAGE);
				}
				
				try 
				{
					conectaBanco();
					stmt.executeUpdate("INSERT INTO apartamento VALUES ('"+imv.getCodigo()+"','"+imv.getStatus()+"','"+imv.getArea()+"','"+imv.getDataConstrucao()+"','"+imv.getEndereco()+"','"+imv.getBairro()+"','"+imv.getValorSuge()+"','"+imv.getValorReal()+"','"+imv.getValorImob()+"','"+imv.getCpfProp()+"','"+imv.getDataEntrada()+"','"+imv.isRetirado()+"','"+quartos.getText()+"','"+suites.getText()+"','"+salas_estar.getText()+"','"+garagem.getText()+"','"+armario.getText()+"','"+descricao_1.getText()+"','"+andar.getText()+"','"+valorcond.getText()+"','"+portaria.getText()+"')");
					System.out.println("Apartamento Cadastrado!!");
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
		btnNewButton_1.setBounds(323, 307, 101, 23);
		contentPane.add(btnNewButton_1);
	}

}
