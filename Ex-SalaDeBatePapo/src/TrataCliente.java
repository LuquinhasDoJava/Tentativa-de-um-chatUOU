import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TrataCliente implements Runnable, Subject {
	private Socket cliente;
	private TrataCliente[] listaClientes;
	private Observer[] observadores;

	public TrataCliente(Socket c) {
		this.observadores = new Observer[10];
		this.cliente = c;
	}

	@Override
	public void run() {
		while(true) {
			if(!(ler().isEmpty())) {
				notifyServidores(ler());
			}
		}
	}

	public String ler() {
		StringBuilder texto = new StringBuilder();
		try (InputStream input = cliente.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input))){
			String linha;
			
			while ((linha = reader.readLine())!= null) {
				texto.append(linha).append("\n");
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler a mensagem:"+ e.getMessage());
			e.printStackTrace();
		}
		return texto.toString();
	}

	public void escrever(String texto) {
		if (texto == null || texto.isEmpty()) {
			throw new IllegalArgumentException("Não enviar mensagem vazia!!");
		}
		try (OutputStream output = cliente.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true)) {
			writer.println(texto);
		} catch (IOException e) {
			System.out.println("Erro ao enviar a mensagem:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void addServidor(Observer servidor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeServidor(Observer servidor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyServidores() {
		// TODO Auto-generated method stub
		
	}
}
