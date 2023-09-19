package imobiliaria;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadastroCasa extends JFrame {
	
	static Imovel imv;
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private static Connection conn;
	private static Statement stmt;
	
	private JPanel contentPane;
	private JTextField quarto;
	private JTextField suite;
	private JTextField garagem;
	private JTextField armario;
	private JTextField piscina;
	private JTextField condominio;
	private JTextField sala_estar;
	private JTextField descricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCasa frame = new CadastroCasa(di, imv, dc, df);
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
	public CadastroCasa(DadosImoveis di, Imovel imv, DadosClientes dc, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CadastroCasa.di = di;
		CadastroCasa.imv = imv;
		this.df = df;
		this.dc = dc;		
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Casa");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		lblNewLabel.setBounds(22, 11, 222, 29);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 38, 404, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Informe os dados da casa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 61, 176, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de quartos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 109, 161, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero de Su\u00EDtes");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(203, 109, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero de salas de estar");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(32, 202, 161, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vagas de garagem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(366, 109, 122, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Possui arm\u00E1rios?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(32, 161, 110, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Possui piscina?");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(203, 161, 93, 14);
		contentPane.add(lblNewLabel_7);
		
		quarto = new JTextField();
		quarto.setBounds(149, 106, 22, 20);
		contentPane.add(quarto);
		quarto.setColumns(10);
		
		suite = new JTextField();
		suite.setBounds(309, 106, 22, 20);
		contentPane.add(suite);
		suite.setColumns(10);
		
		garagem = new JTextField();
		garagem.setBounds(479, 106, 22, 20);
		contentPane.add(garagem);
		garagem.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fica em condominio?");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(354, 161, 135, 14);
		contentPane.add(lblNewLabel_8);
		
		armario = new JTextField();
		armario.setBounds(131, 158, 51, 20);
		contentPane.add(armario);
		armario.setColumns(10);
		
		piscina = new JTextField();
		piscina.setBounds(299, 158, 45, 20);
		contentPane.add(piscina);
		piscina.setColumns(10);
		
		condominio = new JTextField();
		condominio.setBounds(479, 158, 39, 20);
		contentPane.add(condominio);
		condominio.setColumns(10);
		
		sala_estar = new JTextField();
		sala_estar.setBounds(176, 199, 22, 20);
		contentPane.add(sala_estar);
		sala_estar.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(232, 202, 64, 14);
		contentPane.add(lblNewLabel_9);
		
		descricao = new JTextField();
		descricao.setBounds(299, 199, 204, 20);
		contentPane.add(descricao);
		descricao.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(429, 266, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casa c = new Casa (imv.getCodigo(), imv.getStatus(), imv.getArea(), imv.getDataConstrucao(), imv.getEndereco(), imv.getBairro(), imv.getValorSuge(),
						imv.getValorReal(), imv.getValorImob(), imv.getCpfProp(), imv.getDataEntrada(), imv.isRetirado(),  Integer.parseInt(quarto.getText()), 
						Integer.parseInt(suite.getText()), Integer.parseInt(sala_estar.getText()),  Integer.parseInt(garagem.getText()), Boolean.parseBoolean(armario.getText()),
					    descricao.getText(), Boolean.parseBoolean(condominio.getText()), Boolean.parseBoolean(piscina.getText()));

				if (di.cadastrarCasa(c)) {
					JOptionPane.showMessageDialog(null,"Casa cadastrada!","Cadastro efetuado",JOptionPane.INFORMATION_MESSAGE);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Casa não cadastrada!","ERRO",JOptionPane.ERROR_MESSAGE);
				}
				
				try 
				{
					conectaBanco();
					stmt.executeUpdate("INSERT INTO casa VALUES ('"+imv.getCodigo()+"','"+imv.getStatus()+"', '"+imv.getArea()+"', '"+imv.getDataConstrucao()+"', '"+imv.getEndereco()+"', '"+imv.getBairro()+"', '"+imv.getValorSuge()+"', '"+imv.getValorReal()+"', '"+imv.getValorImob()+"', '"+imv.getCpfProp()+"', '"+imv.getDataEntrada()+"', '"+imv.isRetirado()+"','"+quarto.getText()+"','"+suite.getText()+"','"+sala_estar.getText()+"','"+garagem.getText()+"','"+armario.getText()+"','"+descricao.getText()+"','"+condominio.getText()+"','"+piscina.getText()+"')");
					System.out.println("Casa Cadastrada!!");
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
		btnNewButton_1.setBounds(321, 266, 98, 23);
		contentPane.add(btnNewButton_1);
	}
}