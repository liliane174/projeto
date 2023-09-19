package imobiliaria;

import java.awt.BorderLayout;
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

public class CadastroCorretor extends JFrame {

	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField celular;
	private JTextField ingresso;
	private JTextField salario;
	private JTextField cargo;
	private JTextField usuario;
	private JTextField senha;
	private JTextField ingressocorretor;
	private JTextField curso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCorretor frame = new CadastroCorretor(dc, di, df);
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
	public CadastroCorretor(DadosClientes dc, DadosImoveis di, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dc = dc;
		this.di = di;
		this.df = df;
		
		JLabel lblNewLabel = new JLabel("Cadastrar Corretor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(17, 23, 360, 51);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 72, 646, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Informe os dados abaixo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(37, 109, 240, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(37, 158, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(37, 195, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Endere\u00E7o");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(37, 233, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("telefone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(37, 271, 56, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone celular");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(37, 308, 101, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Data de ingresso");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(37, 346, 101, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Sal\u00E1rio");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(397, 159, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cargo");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(397, 196, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Usu\u00E1rio");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(397, 234, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Senha");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(397, 272, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Data de ingresso como corretor");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(397, 309, 184, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Possui algum curso?");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(397, 347, 129, 14);
		contentPane.add(lblNewLabel_13);
		
		nome = new JTextField();
		nome.setBounds(76, 156, 240, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(76, 193, 240, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(98, 231, 218, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		telefone = new JTextField();
		telefone.setBounds(103, 269, 213, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		celular = new JTextField();
		celular.setBounds(136, 306, 180, 20);
		contentPane.add(celular);
		celular.setColumns(10);
		
		ingresso = new JTextField();
		ingresso.setBounds(136, 344, 180, 20);
		contentPane.add(ingresso);
		ingresso.setColumns(10);
		
		salario = new JTextField();
		salario.setBounds(440, 156, 223, 20);
		contentPane.add(salario);
		salario.setColumns(10);
		
		cargo = new JTextField();
		cargo.setBounds(440, 193, 223, 20);
		contentPane.add(cargo);
		cargo.setColumns(10);
		
		usuario = new JTextField();
		usuario.setBounds(440, 231, 223, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(440, 269, 223, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		ingressocorretor = new JTextField();
		ingressocorretor.setBounds(577, 306, 86, 20);
		contentPane.add(ingressocorretor);
		ingressocorretor.setColumns(10);
		
		curso = new JTextField();
		curso.setBounds(515, 344, 148, 20);
		contentPane.add(curso);
		curso.setColumns(10);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		voltar.setBounds(17, 390, 89, 23);
		contentPane.add(voltar);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Corretor c = new Corretor(nome.getText(), cpf.getText(), endereco.getText(), telefone.getText(), celular.getText(), ingresso.getText(), Float.parseFloat(salario.getText()), cargo.getText(), usuario.getText(), senha.getText(), ingressocorretor.getText(), Boolean.parseBoolean(curso.getText()));
				
				if (df.cadastrar(c)) {
					JOptionPane.showMessageDialog(null,"Corretor cadastrado!","Cadastro efetuado",JOptionPane.OK_OPTION);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Corretor não cadastrado!","ERRO",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		cadastrar.setBounds(466, 390, 101, 23);
		contentPane.add(cadastrar);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		Cancelar.setBounds(574, 390, 89, 23);
		contentPane.add(Cancelar);
	}
}
