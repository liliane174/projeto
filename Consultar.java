package imobiliaria;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Consultar extends JFrame {

	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet resultSet;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField escolha;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar frame = new Consultar(di, dc, df);
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
	public Consultar(DadosImoveis di, DadosClientes dc, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Consultar.di = di;
		this.df = df;
		this.dc = dc;
		
		JLabel lblNewLabel = new JLabel("Informe o Codigo do Imovel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(28, 151, 224, 23);
		contentPane.add(lblNewLabel);
		
		escolha = new JTextField();
		escolha.setBounds(229, 154, 183, 20);
		contentPane.add(escolha);
		escolha.setColumns(10);
		
		JRadioButton casa = new JRadioButton("Casa");
		buttonGroup.add(casa);
		casa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		casa.setBounds(203, 88, 59, 23);
		contentPane.add(casa);
		
		JRadioButton apartamento = new JRadioButton("Apartamento");
		buttonGroup.add(apartamento);
		apartamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		apartamento.setBounds(264, 88, 103, 23);
		contentPane.add(apartamento);
		
		JRadioButton terreno = new JRadioButton("Terreno");
		buttonGroup.add(terreno);
		terreno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		terreno.setBounds(369, 88, 81, 23);
		contentPane.add(terreno);
		
		JRadioButton salacomercial = new JRadioButton("Sala Comercial");
		buttonGroup.add(salacomercial);
		salacomercial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		salacomercial.setBounds(452, 87, 118, 23);
		contentPane.add(salacomercial);
		
		
		JLabel lblNewLabel_1 = new JLabel("Dados do Imovel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(28, 218, 157, 14);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Endereco", "Data Constru\u00E7\u00E3o", "Area", "Bairro", "Proprietario"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(76);
		table.setBounds(28, 288, 530, 80);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(51, 263, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereco");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(131, 263, 59, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CPF propriet\u00E1rio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(472, 263, 86, 14);
		contentPane.add(lblNewLabel_4);	
		
		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(229, 263, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DataConstru\u00E7\u00E3o");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(296, 263, 93, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u00C1rea");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(404, 263, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Consultar Im\u00F3vel");
		lblNewLabel_8.setFont(new Font("Myanmar Text", Font.BOLD, 40));
		lblNewLabel_8.setBounds(28, 22, 327, 46);
		contentPane.add(lblNewLabel_8);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(156, 230, 402, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(17, 66, 540, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_9 = new JLabel("Informe o tipo do im\u00F3vel");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(28, 79, 169, 37);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (casa.isSelected()) { 
					try 
					{
						conectaBanco();
						resultSet = stmt.executeQuery("SELECT * from casa WHERE codigo ='"+escolha.getText()+"'");
						
						while (resultSet.next()) {
							table.setValueAt(resultSet.getString("codigo"), 0, 0);
							table.setValueAt(resultSet.getString("endereco"),0, 1);
							table.setValueAt(resultSet.getString("cpfprop"), 0, 5);
							table.setValueAt(resultSet.getString("bairro"),0, 2);
							table.setValueAt(resultSet.getString("dataconstrucao"),0, 3);
							table.setValueAt(resultSet.getString("area"),0, 4);
						}
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"Casa não cadastrada!","ERRO",JOptionPane.ERROR_MESSAGE);
					} finally {
						try {
							if (resultSet != null) resultSet.close();
							if (stmt != null) stmt.close();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				if (terreno.isSelected()) { 
					try 
					{
						conectaBanco();
						resultSet = stmt.executeQuery("SELECT * from terreno WHERE codigo='"+escolha.getText()+"'");
						
						while (resultSet.next()) {
							table.setValueAt(resultSet.getString("codigo"), 0, 0);
							table.setValueAt(resultSet.getString("endereco"),0, 1);
							table.setValueAt(resultSet.getString("cpfprop"), 0, 5);
							table.setValueAt(resultSet.getString("bairro"),0, 2);
							table.setValueAt(resultSet.getString("dataconstrucao"),0, 3);
							table.setValueAt(resultSet.getString("area"),0, 4);
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (resultSet != null) resultSet.close();
							if (stmt != null) stmt.close();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				if (apartamento.isSelected()) { 
					try 
					{
						conectaBanco();
						resultSet = stmt.executeQuery("SELECT * from apartamento WHERE codigo ='"+escolha.getText()+"'");
						
						while (resultSet.next()) {
							table.setValueAt(resultSet.getString("codigo"), 0, 0);
							table.setValueAt(resultSet.getString("endereco"),0, 1);
							table.setValueAt(resultSet.getString("cpfprop"), 0, 5);
							table.setValueAt(resultSet.getString("bairro"),0, 2);
							table.setValueAt(resultSet.getString("dataconstrucao"),0, 3);
							table.setValueAt(resultSet.getString("area"),0, 4);
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (resultSet != null) resultSet.close();
							if (stmt != null) stmt.close();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				if (salacomercial.isSelected()) { 
					try 
					{
						conectaBanco();
						resultSet = stmt.executeQuery("SELECT * from salacomercial WHERE codigo ='"+escolha.getText()+"'");
						
						while (resultSet.next()) {
							table.setValueAt(resultSet.getString("codigo"), 0, 0);
							table.setValueAt(resultSet.getString("endereco"),0, 1);
							table.setValueAt(resultSet.getString("cpfprop"), 0, 5);
							table.setValueAt(resultSet.getString("bairro"),0, 2);
							table.setValueAt(resultSet.getString("dataconstrucao"),0, 3);
							table.setValueAt(resultSet.getString("area"),0, 4);
						}
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"Sala comercial não cadastrada!","ERRO",JOptionPane.ERROR_MESSAGE);
					} finally {
						try {
							if (resultSet != null) resultSet.close();
							if (stmt != null) stmt.close();
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				/*
				 * O códido comentado é para fazer busca em imóveis armazenados na memória.
				 * 
				Imovel i2 = di.buscar(textField.getText());
				if (i2 != null) {
					table.setValueAt(i2.getCodigo(), 0, 0);
					table.setValueAt(i2.getEndereco(),0, 1);
					table.setValueAt(i2.getCpfProp(), 0, 5);
					table.setValueAt(i2.getBairro(),0, 2);
					table.setValueAt(i2.getDataConstrucao(),0, 3);
					table.setValueAt(i2.getArea(),0, 4);
				}
				else {
					JOptionPane.showMessageDialog(null,"Imóvel não cadastrado!","Erro",JOptionPane.ERROR_MESSAGE);
				}
				*/
			}
			
		});
		btnNewButton.setBounds(422, 153, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null,"Deseja finalizar a consulta?","Finalizar",JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_2.setBounds(487, 393, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(17, 393, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
