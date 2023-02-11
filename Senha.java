import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.Random;  
import classes.Criptografia;

public class Senha extends JFrame { 

    private JTextField campoSenha, campoCripto; 
	private JButton btnExecutar, btnCriptografar;
	
	public Senha(){
		
		Font letra = new Font ("Arial", Font.BOLD, 18); 
		
		campoSenha = new JTextField(""); 
		campoSenha.setBounds(50,50,400,40); 
		campoSenha.setFont(letra); 
		add(campoSenha);  
		
		campoCripto = new JTextField(""); 
		campoCripto.setBounds(50,100,400,40); 
		campoCripto.setFont(letra); 
		add(campoCripto); 
		
		btnCriptografar = new JButton("Criptografar Senha"); 
		btnCriptografar.setBounds(50,150,200,40); 
		btnCriptografar.setFont(letra); 
		add(btnCriptografar); 
		btnCriptografar.addActionListener(
		    new ActionListener(){
				public void actionPerformed(ActionEvent e){ 
				  String senhaCripto = Criptografia.criptografar(campoSenha.getText()); 
				  
				  campoCripto.setText(senhaCripto);
				}
			}
		
		); 
		
		btnExecutar = new JButton("Gerar Senha"); 
		btnExecutar.setBounds(250,150,200,40); 
		btnExecutar.setFont(letra); 
		add(btnExecutar); 
		btnExecutar.addActionListener(
		    new ActionListener(){
				public void actionPerformed(ActionEvent e){ 
				    campoSenha.setText("");
					campoSenha.setText(geraSenha(10));
				}
			}
		
		);
	}  
	
	public String geraSenha(int tamanho){
		String senha = "";  
		String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYZ0123456789@#$?"; 
		
		Random rnd = new Random(new Random().nextLong()); 
		
		for(int i = 0; i < tamanho;i++){
			int index = rnd.nextInt(caracteres.length()-1) ;
			senha += caracteres.substring(index, index + 1);
		}
		
		return senha;
	}
	
	public static void main(String args[]){
		
		Senha form = new Senha(); 
		form.setLayout(null); 
		form.setBounds(0,0,500,300); 
		form.setLocationRelativeTo(null); 
		form.setVisible(true); 
		form.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		form.setTitle("Senha aleatória");
	}
	
}