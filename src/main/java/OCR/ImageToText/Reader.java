package OCR.ImageToText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Reader {
	public void readImage(File image,String dataPath, String outputDirectory) {
		Tesseract tesseract = new Tesseract();
		FileManager fileMgr = new FileManager();
		try {
			tesseract.setDatapath(dataPath);
			String text = tesseract.doOCR(image);
			File file = new File(outputDirectory+fileMgr.getName(image)+".txt");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
			System.out.println(">>>>>>>>>>>> Complete reading file : "+fileMgr.getName(image));
		}
		catch (TesseractException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
