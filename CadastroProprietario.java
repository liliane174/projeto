package imobiliaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProprietario extends JFrame {

	static Cliente c;
	static DadosImoveis di;
	static DadosClientes dc;
	static DadosFuncionarios df;
	
	private JPanel contentPane;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProprietario frame = new CadastroProprietario(dc, c, di, df);
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
	public CadastroProprietario(DadosClientes dc1, Cliente c1, DadosImoveis di, DadosFuncionarios df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		dc = dc1;
		c = c1;
		this.df = df;
		this.di = di;
		
		
		
		JLabel lblNewLabel = new JLabel("Informe os dados do Cliente Proprietário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(33, 106, 270, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar Propriet\u00E1rio");
		lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 30));
		lblNewLabel_3.setBounds(33, 19, 421, 49);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 65, 381, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Data do primeiro cadastro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(55, 147, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(205, 145, 132, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteProp c2 = new ClienteProp(c.getNome(), c.getCpf(), c.getEndereco(), c.getTelefone(), c.getEmail(), c.getSexo(), c.getEstadoCivil(), c.getProfissao(), textField.getText());
				
				if (dc.cadastrarProp(c2)) {
					JOptionPane.showMessageDialog(null,"Cliente cadastrado!","Cadastro efetuado",JOptionPane.OK_OPTION);
					Menu m1 = new Menu(di, dc, df);
					m1.setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null,"Cliente não cadastrado!","ERRO",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setBounds(278, 208, 97, 23);
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
		btnNewButton_2.setBounds(385, 208, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
