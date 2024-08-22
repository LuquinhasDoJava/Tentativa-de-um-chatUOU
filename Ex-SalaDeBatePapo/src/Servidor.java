import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Observer{
	
	private ServerSocket server;
	
	public Servidor() {
		TrataCliente[] listaCliente = new TrataCliente[10];
	}
	
	public void executar() {
		try (Socket s = server.accept()){
			TrataCliente tc = new TrataCliente(s);
			Thread tr = new Thread(tc);
			tr.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		
	}
}
