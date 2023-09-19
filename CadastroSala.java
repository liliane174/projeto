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

public class CadastroSala extends JFrame {
	
	static Imovel imv;
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private static Connection conn;
	private static Statement stmt;

	private JPanel contentPane;
	private JTextField banheiro;
	private JTextField comodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroSala frame = new CadastroSala(di, imv, dc, df);
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
	public CadastroSala(DadosImoveis di, Imovel imv, DadosClientes dc, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CadastroSala.di = di;
		CadastroSala.imv = imv;
		this.dc = dc;
		this.df = df;
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Sala Comercial");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		lblNewLabel.setBounds(22, 11, 312, 29);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 38, 404, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Informe os dados da sala comercial:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 61, 234, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de banheiros");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 109, 125, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero de c\u00F4modos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(32, 140, 140, 14);
		contentPane.add(lblNewLabel_4);
		
		banheiro = new JTextField();
		banheiro.setBounds(158, 106, 86, 20);
		contentPane.add(banheiro);
		banheiro.setColumns(10);
		
		comodo = new JTextField();
		comodo.setBounds(158, 137, 86, 20);
		contentPane.add(comodo);
		comodo.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(349, 202, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaComercial sc = new SalaComercial (imv.getCodigo(), imv.getStatus(), imv.getArea(), imv.getDataConstrucao(), imv.getEndereco(), imv.getBairro(), imv.getValorSuge(),
						imv.getValorReal(), imv.getValorImob(), imv.getCpfProp(), imv.getDataEntrada(), imv.isRetirado(),  Integer.parseInt(banheiro.getText()), 
						Integer.parseInt(comodo.getText()));

				if (di.cadastrarSala(sc)) {
					JOptionPane.showMessageDialog(null,"Sala Comercial cadastrada!","Cadastro efetuado",JOptionPane.INFORMATION_MESSAGE);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Sala Comercial não cadastrada!","ERRO",JOptionPane.ERROR_MESSAGE);
				}
				
				try 
				{
					conectaBanco();
					stmt.executeUpdate("INSERT INTO salacomercial VALUES ('"+imv.getCodigo()+"','"+imv.getStatus()+"', '"+imv.getArea()+"', '"+imv.getDataConstrucao()+"', '"+imv.getEndereco()+"', '"+imv.getBairro()+"', '"+imv.getValorSuge()+"', '"+imv.getValorReal()+"', '"+imv.getValorImob()+"', '"+imv.getCpfProp()+"', '"+imv.getDataEntrada()+"', '"+imv.isRetirado()+"', '"+banheiro.getText()+"', '"+comodo.getText()+"')");
					System.out.println("Sala Comercial Cadastrada!!");
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
		btnNewButton_1.setBounds(243, 202, 98, 23);
		contentPane.add(btnNewButton_1);
	}

}
