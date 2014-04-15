import java.awt.Image;

import com.asprise.util.jtwain.Source;
import com.asprise.util.jtwain.SourceManager;

/*
 * $Id$
 * 
 */

public class DemoSimple extends JTwainDemoCode{
	
	public DemoSimple() {
		try {
			Source source = SourceManager.instance().getDefaultSource();
			System.out.println(source.getSourceName());
			if(source == null) {
				error("There is no (default) source on the system!");
				return;
			}
			
			source.open();
			
			Image image = source.acquireImage();
			
			new ImageDisplayer("DemoSimple", image);
			
			source.close();
			
		}catch(Exception e) {
			e.getMessage();
			//exception(e);
		}finally{
			SourceManager.closeSourceManager();
		}
	}

	public static void main(String[] args) {
		new DemoSimple();
	}
	
}
