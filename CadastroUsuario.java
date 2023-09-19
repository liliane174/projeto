package imobiliaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class CadastroUsuario extends JFrame {
	
	static Cliente cli;
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario(dc, cli, di, df);
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
	public CadastroUsuario(DadosClientes dc, Cliente c, DadosImoveis di, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dc = dc;
		cli = c;
		this.di = di;
		this.df = df;
		
		JLabel lblNewLabel = new JLabel("Informe os dados do Cliente Usu\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(33, 79, 206, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF da pessoa que o indicou");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(33, 177, 175, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome da pessoa que o indicou");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(33, 135, 184, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(206, 133, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 175, 175, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar Usu\u00E1rio");
		lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 30));
		lblNewLabel_3.setBounds(20, 25, 274, 43);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 55, 438, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteUsuario c1 = new ClienteUsuario(cli.getNome(), cli.getCpf(), cli.getEndereco(), cli.getTelefone(), cli.getEmail(), cli.getSexo(), cli.getEstadoCivil(), cli.getProfissao(), textField.getText(), textField_1.getText());
				
				if (dc.cadastrarUsuario(c1)) {
					JOptionPane.showMessageDialog(null,"Cliente cadastrado!","Cadastro efetuado",JOptionPane.OK_OPTION);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Cliente não cadastrado!","ERRO",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(266, 238, 102, 23);
		contentPane.add(btnNewButton);

		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(378, 238, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}

}
