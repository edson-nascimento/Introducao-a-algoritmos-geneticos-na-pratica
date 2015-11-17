import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;


public class Tela extends JFrame {

	private JPanel contentPane;
	private TextArea txtFrase;
	private TextField txtEpoca;
	private TextField txtMutacao;
	private TextField txtCross;
	private TextField txtPop;
	private TextField txtMelhor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFrase = new JLabel("Frase");
		lblFrase.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblFrase.setBounds(21, 49, 46, 14);
		contentPane.add(lblFrase);
		
		txtFrase = new TextArea();
		txtFrase.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtFrase.setBounds(21, 73, 308, 108);
		contentPane.add(txtFrase);
		
		Label label = new Label("Ep\u00F3cas");
		label.setFont(new Font("Consolas", Font.PLAIN, 12));
		label.setBounds(21, 243, 62, 22);
		contentPane.add(label);
		
		txtEpoca = new TextField();
		txtEpoca.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtEpoca.setText("10");
		txtEpoca.setBounds(109, 243, 148, 22);
		contentPane.add(txtEpoca);
		
		txtMutacao = new TextField();
		txtMutacao.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtMutacao.setText("0.3");
		txtMutacao.setBounds(109, 285, 148, 22);
		contentPane.add(txtMutacao);
		
		Label label_1 = new Label("Tx Muta\u00E7\u00E3o");
		label_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		label_1.setBounds(21, 285, 62, 22);
		contentPane.add(label_1);
		
		txtCross = new TextField();
		txtCross.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtCross.setText("0.6");
		txtCross.setBounds(109, 325, 148, 22);
		contentPane.add(txtCross);
		
		Label label_2 = new Label("Tx CrossOver");
		label_2.setFont(new Font("Consolas", Font.PLAIN, 12));
		label_2.setBounds(21, 325, 82, 22);
		contentPane.add(label_2);
		
		txtPop = new TextField();
		txtPop.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtPop.setText("100");
		txtPop.setBounds(109, 365, 148, 22);
		contentPane.add(txtPop);
		
		Label label_3 = new Label("Pop Inicial");
		label_3.setFont(new Font("Consolas", Font.PLAIN, 12));
		label_3.setBounds(21, 365, 62, 22);
		contentPane.add(label_3);
		
		TextArea txtSolucao = new TextArea();
		txtSolucao.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtSolucao.setBounds(368, 73, 446, 347);
		contentPane.add(txtSolucao);
		
		Label label_5 = new Label("Solu\u00E7\u00E3o");
		label_5.setFont(new Font("Consolas", Font.PLAIN, 12));
		label_5.setBounds(368, 45, 62, 22);
		contentPane.add(label_5);
		
		JButton btnNewButton = new JButton("Executar");
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(Tela.class.getResource("/Imagens/Yes.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String frase 		= txtFrase.getText();
				frase = (frase.length() > 5)? frase : frase+"     ";
				double txMutacao 	= Double.parseDouble(txtMutacao.getText());
				double txCross 		= Double.parseDouble(txtCross.getText());
				int epocas 		= Integer.parseInt(txtEpoca.getText());
				int popInicial  = Integer.parseInt(txtPop.getText());
				
				Execute.executar(frase, txCross, txMutacao, epocas, popInicial);
				
				txtSolucao.setText(Execute.resposta.toString());
				txtMelhor.setText(Execute.melhorIndividuo);
			}
		});
		btnNewButton.setBounds(79, 428, 165, 51);
		contentPane.add(btnNewButton);
		
		txtMelhor = new TextField();
		txtMelhor.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtMelhor.setBounds(368, 457, 446, 22);
		contentPane.add(txtMelhor);
		
		Label label_4 = new Label("Melhor Solu\u00E7\u00E3o");
		label_4.setFont(new Font("Consolas", Font.PLAIN, 12));
		label_4.setBounds(368, 437, 110, 22);
		contentPane.add(label_4);
		
		JLabel lblConfiguraes = new JLabel("Configura\u00E7\u00F5es");
		lblConfiguraes.setFont(new Font("Consolas", Font.BOLD, 15));
		lblConfiguraes.setBounds(123, 205, 104, 14);
		contentPane.add(lblConfiguraes);
	}
}
