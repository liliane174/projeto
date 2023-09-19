package imobiliaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class CadastrarCliente extends JFrame {
	
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cfp;
	private JTextField endereco;
	private JTextField sexo;
	private JTextField telefone;
	private JTextField estadocivil;
	private JTextField email;
	private JTextField profissao;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente(dc, di, df);
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
	public CadastrarCliente(DadosClientes dc, DadosImoveis di, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dc = dc;
		this.di = di;
		this.df = df;
		
		JLabel lblNewLabel = new JLabel("Escolha o tipo de cliente que deseja cadastrar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 72, 297, 36);
		contentPane.add(lblNewLabel);
		
		JRadioButton proprietario = new JRadioButton("Cliente propriet\u00E1rio");
		buttonGroup.add(proprietario);
		proprietario.setBounds(79, 115, 136, 23);
		contentPane.add(proprietario);
		
		JRadioButton usuario = new JRadioButton("Cliente usu\u00E1rio");
		buttonGroup.add(usuario);
		usuario.setBounds(288, 115, 120, 23);
		contentPane.add(usuario);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(46, 195, 37, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(46, 234, 37, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(46, 269, 52, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(288, 195, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(286, 269, 37, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(46, 305, 37, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Estado Civil");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(288, 234, 67, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Profiss\u00E3o");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(288, 305, 67, 14);
		contentPane.add(lblNewLabel_8);
		
		nome = new JTextField();
		nome.setBounds(95, 193, 155, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cfp = new JTextField();
		cfp.setBounds(93, 232, 155, 20);
		contentPane.add(cfp);
		cfp.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(108, 267, 140, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		sexo = new JTextField();
		sexo.setBounds(79, 303, 171, 20);
		contentPane.add(sexo);
		sexo.setColumns(10);
		
		telefone = new JTextField();
		telefone.setBounds(347, 193, 150, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		estadocivil = new JTextField();
		estadocivil.setBounds(357, 232, 140, 20);
		contentPane.add(estadocivil);
		estadocivil.setColumns(10);
		
		email = new JTextField();
		email.setBounds(333, 267, 164, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		profissao = new JTextField();
		profissao.setBounds(347, 303, 150, 20);
		contentPane.add(profissao);
		profissao.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cadastrar Cliente");
		lblNewLabel_9.setFont(new Font("Myanmar Text", Font.BOLD, 40));
		lblNewLabel_9.setBounds(26, 11, 436, 65);
		contentPane.add(lblNewLabel_9);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 54, 482, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(172, 165, 325, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_10 = new JLabel("Dados do cliente");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(26, 153, 155, 23);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (usuario.isSelected()) {
					Cliente c = new Cliente (nome.getText(), cfp.getText(), endereco.getText(), telefone.getText(), email.getText(), sexo.getText(), Integer.parseInt(estadocivil.getText()),profissao.getText());
					CadastroUsuario uc = new CadastroUsuario(dc, c, di, df);
					uc.setVisible(true);
					dispose();
				}
				
				if (proprietario.isSelected()) {
					Cliente c = new Cliente (nome.getText(), cfp.getText(), endereco.getText(), telefone.getText(), email.getText(), sexo.getText(), Integer.parseInt(estadocivil.getText()),profissao.getText());
					CadastroProprietario cp = new CadastroProprietario (dc, c, di, df);
					cp.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(319, 372, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 372, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cadastro cancelado!","Cancelamento",JOptionPane.INFORMATION_MESSAGE);
				Menu m1 = new Menu(di, dc, df);
				m1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(413, 372, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
