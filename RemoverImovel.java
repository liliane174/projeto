package imobiliaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RemoverImovel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private static Connection conn;
	private static Statement stmt;
	
	private JPanel contentPane;
	private JTextField escolha;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverImovel frame = new RemoverImovel(di, dc, df);
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
	public RemoverImovel(DadosImoveis di, DadosClientes dc, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		RemoverImovel.di= di;
		this.df = df;
		this.dc = dc;
		
		escolha = new JTextField();
		escolha.setBounds(129, 151, 137, 20);
		contentPane.add(escolha);
		escolha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo do im\u00F3vel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 153, 115, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton checkcasa = new JRadioButton("Casa");
		buttonGroup.add(checkcasa);
		checkcasa.setBounds(24, 105, 54, 23);
		contentPane.add(checkcasa);
		
		JRadioButton checkapto = new JRadioButton("Apartamento");
		buttonGroup.add(checkapto);
		checkapto.setBounds(95, 105, 112, 23);
		contentPane.add(checkapto);
		
		JRadioButton checkterreno = new JRadioButton("Terreno");
		buttonGroup.add(checkterreno);
		checkterreno.setBounds(209, 105, 76, 23);
		contentPane.add(checkterreno);
		
		JRadioButton checksala = new JRadioButton("Sala Comercial");
		buttonGroup.add(checksala);
		checksala.setBounds(287, 105, 125, 23);
		contentPane.add(checksala);
		
		lblNewLabel_1 = new JLabel("Remover Im\u00F3vel");
		lblNewLabel_1.setFont(new Font("Myanmar Text", Font.BOLD, 40));
		lblNewLabel_1.setBounds(24, 11, 406, 59);
		contentPane.add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setBounds(24, 57, 388, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Informe o tipo de im\u00F3vel que deseja remover:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(24, 70, 261, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// O código comentado serve apenas pra remover os imóveis cadastrados na memória!
				if (di.excluir(escolha.getText()) != false) {
					JOptionPane.showMessageDialog(null,"Imóvel Excluído da memória!","Excluir",JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"O imóvel que deseja remover não está cadastrado!","Erro",JOptionPane.ERROR_MESSAGE);
				}
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
				if (checkcasa.isSelected()) {
					try 
					{
						conectaBanco();
						stmt.executeUpdate("DELETE FROM casa WHERE codigo='"+escolha.getText()+"'");
						System.out.println("Casa deletada do banco de dados!!");
						dispose();
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
				
				if (checkapto.isSelected()) {
					try 
					{
						conectaBanco();
						stmt.executeUpdate("DELETE FROM apartamento WHERE codigo='"+escolha.getText()+"'");
						System.out.println("Apartamento deletado do banco de dados!!");
						dispose();
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
				
				if (checkterreno.isSelected()) {
					try 
					{
						conectaBanco();
						stmt.executeUpdate("DELETE FROM terreno WHERE codigo='"+escolha.getText()+"'");
						System.out.println("Terreno deletado do banco de dados!!");
						dispose();
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
				
				if (checksala .isSelected()) {
					try 
					{
						conectaBanco();
						stmt.executeUpdate("DELETE FROM salacomercial WHERE codigo='"+escolha.getText()+"'");
						System.out.println("Sala comercial deletada do banco de dados!!");
						dispose();
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
			}
		});
		
		btnNewButton.setBounds(276, 150, 118, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
