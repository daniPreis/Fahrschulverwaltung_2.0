package fold_logic;

public interface Subject {

	public abstract void attach(Observer o);
	
	public abstract void detach(Observer o);
	
	public abstract void notifyAllO();
}
