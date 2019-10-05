package OCR.ImageToText;

import java.io.File;
import java.util.Set;

public class Application {
	public static void main(String args[]) throws InterruptedException {
		long startTime = System.nanoTime();
		String inputDirectory = "/home/shebeen/Programming/TestIO/input/";
		String outputDirectory = "/home/shebeen/Programming/TestIO/output/";
		FileManager fileMgr = new FileManager();
		File[] files = fileMgr.scanDirectory(inputDirectory);
		if(files.length>0) {
			for(File img:files) {
				if(fileMgr.getExtention(img).equals("jpeg") || fileMgr.getExtention(img).equals("png")) {
					System.out.println(">>>>>>>>>>>>>>>> Started reading file : "+ fileMgr.getName(img));
					Thread ocrThread = new Thread(()-> {
						new Reader().readImage(img,inputDirectory, outputDirectory);
					});
					ocrThread.start();
				}
			}
		}
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for(Thread t:threadSet) {
			if(t.getName().startsWith("Thread-"))
				t.join();
		}
		long endTime = System.nanoTime();
		long timeTaken = (endTime - startTime)/1000000000;
		System.out.println("Time taken : "+timeTaken +"s");
	}
}
