package OCR.ImageToText;

import java.io.File;

public class FileManager {
	public File[] scanDirectory(String directoryPath){
		File directory = new File(directoryPath);
		return directory.listFiles();
	}
	public String getExtention(File image) {
		String[] nameParts = image.getName().split("\\."); 
		return nameParts[nameParts.length-1];
	}
	public String getName(File imageName) {
		return imageName.getName().substring(0,imageName.getName().lastIndexOf('.'));
	}
}
