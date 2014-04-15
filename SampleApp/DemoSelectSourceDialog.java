import java.awt.Image;
import java.awt.FileDialog;
import java.io.File;
import com.asprise.util.jtwain.Source;
import com.asprise.util.jtwain.SourceManager;

/*
 * $Id$
 * 
 */

public class DemoSelectSourceDialog extends JTwainDemoCode {
	public DemoSelectSourceDialog() {
		
		try {
			Source source = SourceManager.instance().selectSourceUI();
			
			if(source.isUIEnabled())
				source.setUIEnabled(false);				
				source.setIndicators(false);
			if(source == null) {
				error("No source has been selected!");
				return;
			}

			source.open();
			Image image = source.acquireImage();
						
			ImageDisplayer imageDisplayer=new ImageDisplayer("DemoSelectSourceDialog", image);
		FileDialog fileDialog = new FileDialog(imageDisplayer.getFrame(), "Save the image acquired into a file: ", FileDialog.SAVE);
		fileDialog.show();
		source.saveLastAcquiredImageIntoFile(new File(fileDialog.getDirectory(), fileDialog.getFile()+".jpg"));
			
		}catch(Exception e) {
			exception(e);
		}finally{
			SourceManager.closeSourceManager();
		}
	}

	public static void main(String[] args) {
		new DemoSelectSourceDialog();
	}
}
