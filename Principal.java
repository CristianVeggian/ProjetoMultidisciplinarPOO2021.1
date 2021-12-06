package proj;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Principal extends JFrame implements ActionListener{	
	
	private static final long serialVersionUID = 1L;
	
	private JRadioButton rdbtnDeut, rdbtnProt, rdbtnTrit; 
	private JRadioButton rdbtnMedico, rdbtnPaciente;
	private JRadioButton rdbtnLogin, rdbtnRegister;
	private JButton submit;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtClnica;
	private JTextField txtCrm;
	private JLabel nomeCor;
	private JLabel userInfo;
	private boolean logado;
	ArrayList<Usuario> users = new ArrayList<Usuario>();
	
	public Principal() {
		super("Identifica Cor");	
        getContentPane().setLayout(null);   
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,250);
		
		ButtonGroup userType = new ButtonGroup();
		
		rdbtnMedico = new JRadioButton("M\u00E9dico");
		rdbtnMedico.setBounds(6, 7, 109, 23);
		userType.add(rdbtnMedico);
		add(rdbtnMedico);
		
		rdbtnPaciente = new JRadioButton("Paciente");
		rdbtnPaciente.setBounds(6, 33, 109, 23);
		userType.add(rdbtnPaciente);
		add(rdbtnPaciente);
		
		ButtonGroup instruction = new ButtonGroup();
		
		rdbtnLogin = new JRadioButton("Logar");
		rdbtnLogin.setBounds(117, 7, 109, 23);
		instruction.add(rdbtnLogin);
		add(rdbtnLogin);
		
		rdbtnRegister = new JRadioButton("Registrar");
		rdbtnRegister.setBounds(117, 33, 109, 23);
		instruction.add(rdbtnRegister);
		add(rdbtnRegister);
		
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(232, 8, 178, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setText("Senha");
		txtSenha.setBounds(232, 34, 178, 20);
		add(txtSenha);
		txtSenha.setColumns(10);
		
		
		txtClnica = new JTextField();
		txtClnica.setText("Cl\u00EDnica");
		txtClnica.setBounds(232, 65, 178, 20);
		add(txtClnica);
		txtClnica.setColumns(10);
		
		txtCrm = new JTextField();
		txtCrm.setText("Crm");
		txtCrm.setBounds(232, 96, 178, 20);
		add(txtCrm);
		txtCrm.setColumns(10);
				
		ButtonGroup dalton = new ButtonGroup();
		
		rdbtnDeut = new JRadioButton("D - Deuteranopia");
		rdbtnDeut.setBounds(6, 90, 130, 25);
		dalton.add(rdbtnDeut);
		add(rdbtnDeut);
		
		rdbtnProt = new JRadioButton("P - Protanopia");
		rdbtnProt.setBounds(6, 120, 110, 25);
		dalton.add(rdbtnProt);
		add(rdbtnProt);
		
		rdbtnTrit = new JRadioButton("T - Tritanopia");
		rdbtnTrit.setBounds(6, 150, 110, 25);
		dalton.add(rdbtnTrit);
		add(rdbtnTrit);
		
		submit = new JButton("Enviar");
	    submit.setActionCommand("submit");
	    submit.addActionListener(this);
		submit.setBounds(232, 126, 178, 20);
		submit.setVisible(true);
		add(submit);
		
		txtClnica.setVisible(false);
		txtCrm.setVisible(false);
		rdbtnDeut.setVisible(false);
		rdbtnProt.setVisible(false);
		rdbtnTrit.setVisible(false);
		
		nomeCor = new JLabel("");
		nomeCor.setBounds(232, 141, 178, 34);
		add(nomeCor);
		
		userInfo = new JLabel("Deslogado");
		userInfo.setBounds(6, 177, 300, 23);
		add(userInfo);
		
		setVisible(true);
		
	}

	public void Escutador() {
		
		if(rdbtnLogin.isSelected()) {
			txtClnica.setVisible(false);
			txtCrm.setVisible(false);
			rdbtnDeut.setVisible(false);
			rdbtnProt.setVisible(false);
			rdbtnTrit.setVisible(false);
		}
		if(rdbtnRegister.isSelected()) {
			if(rdbtnMedico.isSelected()) {
				txtClnica.setVisible(true);
				txtCrm.setVisible(true);
				rdbtnDeut.setVisible(false);
				rdbtnProt.setVisible(false);
				rdbtnTrit.setVisible(false);
			} else if(rdbtnPaciente.isSelected()) {
				txtClnica.setVisible(false);
				txtCrm.setVisible(false);
				rdbtnDeut.setVisible(true);
				rdbtnProt.setVisible(true);
				rdbtnTrit.setVisible(true);
			}
		}
		Cor cor = new Cor();
		for(Usuario x: users) {
			if(x.isLogado()) {
				userInfo.setText(x.toString());
			}
		}
		nomeCor.setText(cor.findColor());
		
	}
	
	
	  public void actionPerformed(ActionEvent evt) {
		  if(rdbtnLogin.isSelected() && evt.getActionCommand().equals("submit")) {
			for(Usuario x: users) {
				if(x.logar(txtNome.getText(),txtSenha.getText())) {
					x.setLogado(true);
					JOptionPane.showMessageDialog(null, "Logado com Sucesso!");
					logado = true;
				} else x.setLogado(false);
			}
			if (!logado) JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
		  }
		  if(rdbtnRegister.isSelected()) {
				if(rdbtnMedico.isSelected()) {
					if(evt.getActionCommand().equals("submit")) {
						try {
							if(txtNome.getText().equals("Nome")) throw new ExceptionRegister("Nome faltante");
							if(txtSenha.getText().equals("Senha")) throw new ExceptionRegister("Senha faltante");
							if(txtClnica.getText().equals("Clínica")) throw new ExceptionRegister("Clínica faltante");
							if(txtCrm.getText().equals("Crm")) throw new ExceptionRegister("Crm faltante");
							users.add(new Medico(txtNome.getText(), txtSenha.getText(), Integer.parseInt(txtCrm.getText()), txtClnica.getText()));
							JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
						}catch(Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				} else if(rdbtnPaciente.isSelected()) {
					if(evt.getActionCommand().equals("submit")) {
						try {
							if(txtNome.getText().equals("Nome")) throw new ExceptionRegister("Nome faltante");
							if(txtSenha.getText().equals("Senha")) throw new ExceptionRegister("Senha faltante");
							if(rdbtnDeut.isSelected()) {
								users.add(new Paciente(txtNome.getText(), txtSenha.getText(), 'D'));
							} else if (rdbtnProt.isSelected()) {
								users.add(new Paciente(txtNome.getText(), txtSenha.getText(), 'P'));
							} else if (rdbtnTrit.isSelected()) {
								users.add(new Paciente(txtNome.getText(), txtSenha.getText(), 'T'));
							} else throw new ExceptionRegister("Distúrbio faltante");
							JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
						}catch(Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
					}
				}
		  }
	  }
	
	  
	
	public static void main(String[] args) {

		Principal s = new Principal();
		
		while(true) {
			s.Escutador();
		}
		
		
	}
	
}