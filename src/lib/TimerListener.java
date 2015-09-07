package lib;

public interface TimerListener {
	public void startAction(long dt);
	public void stopAction(long dt);
	public void resetAction(long dt);
}
