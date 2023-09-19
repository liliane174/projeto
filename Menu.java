package imobiliaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;

public class Menu extends JFrame {

	static DadosImoveis di = new DadosImoveis();
	static DadosClientes dc = new DadosClientes();
	static DadosFuncionarios df = new DadosFuncionarios();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(di, dc, df);
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
	public Menu(DadosImoveis di_2, DadosClientes dc_2, DadosFuncionarios df_2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		di = di_2;
		dc = dc_2;
		df = df_2;
		
		
		JLabel lblNewLabel = new JLabel("Selecione uma das opcoes abaixo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 62, 268, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setFont(new Font("Myanmar Text", Font.BOLD, 40));
		lblNewLabel_1.setBounds(22, 11, 239, 40);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 46, 388, 23);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Im\u00F3vel");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 108, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(95, 120, 312, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Cliente e Corretor");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 231, 157, 14);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(164, 243, 239, 2);
		contentPane.add(separator_2);
		
		JButton btnNewButton = new JButton("Cadastrar Imovel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarImovel obj = new CadastrarImovel(di, dc, df);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(33, 145, 187, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar Imovel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar obj = new Consultar(di, dc, df);
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(129, 179, 187, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover Imovel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverImovel obj = new RemoverImovel(di, dc, df);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(224, 145, 187, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?","Sair",JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_3.setBounds(328, 351, 96, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cadastrar Cliente");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente obj = new CadastrarCliente(dc, di, df);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(22, 271, 187, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cadastrar Corretor");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCorretor obj = new CadastroCorretor(dc, di, df);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(220, 271, 187, 23);
		contentPane.add(btnNewButton_5);
	}
}
