
public interface Subject {
	public void addServidor(Observer servidor);
	public void removeServidor(Observer servidor);
	public void notifyServidores();

}
