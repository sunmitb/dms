
/*
 * $Id$
 * 
 */

/**
 * @author 	JACK	(Jan 30, 2004)
 */
public abstract class JTwainDemoCode {
	
	public static class OutputListener {
		public void error(String error) {
			System.err.println(error);
		}
		public void message(String message) {
			System.out.println(message);
		}
		public void exception(Throwable e) {
			
		}
	}
	
	static OutputListener outputListener = new OutputListener();

	public void error(String error) {
		outputListener.error(error);
	}


	public void message(String message) {
		outputListener.message(message);
	}
	
	public void exception(Throwable e) {
		outputListener.exception(e);
	}
	/**
	 * @return
	 */
	public static OutputListener getOutputListener() {
		return outputListener;
	}

	/**
	 * @param listener
	 */
	public static void setOutputListener(OutputListener listener) {
		outputListener = listener;
	}

}
