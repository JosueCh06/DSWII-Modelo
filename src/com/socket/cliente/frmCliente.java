package com.socket.cliente;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.socket.entidad.Empleado;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmCliente extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JButton btnEnviar;
	private JButton btnCierre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCliente frame = new frmCliente();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(0);
		setBounds(100, 100, 558, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEnviar = new JButton("");
		btnEnviar.setIcon(new ImageIcon(frmCliente.class.getResource("/img/mensajeCliente.png")));
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(124, 73, 89, 73);
		contentPane.add(btnEnviar);
		
		btnCierre = new JButton("");
		btnCierre.setIcon(new ImageIcon(frmCliente.class.getResource("/img/cerrarCliente.png")));
		btnCierre.addActionListener(this);
		btnCierre.setBounds(376, 73, 89, 73);
		contentPane.add(btnCierre);
	}
	public void actionPerformed(final ActionEvent arg0) {
		if (arg0.getSource() == btnCierre) {
			actionPerformedBtnCierre(arg0);
		}
		if (arg0.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(arg0);
		}
	}
	protected void actionPerformedBtnEnviar(final ActionEvent arg0) {
		try {
			Socket cliente=new Socket("localhost",1025);
			List<Empleado> lista=new ArrayList<Empleado>();
			lista.add(new Empleado(1, "Ana", "Soto Ayala", 1500));
			lista.add(new Empleado(2, "Alicia", "Soto Ayala", 2500));
			lista.add(new Empleado(3, "Gloria", "Soto Ayala", 3500));
			ObjectOutputStream stream=new ObjectOutputStream(cliente.getOutputStream());
			stream.writeObject(lista);
			stream.close();
			cliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void actionPerformedBtnCierre(final ActionEvent arg0) {
		System.exit(0);
	}

	

	
		
}
