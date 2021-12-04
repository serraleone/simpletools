import java.io.File;
import java.util.ArrayList;
import entity.FileEntity;

public class FileReader {
   
    public FileEntity file;

    public ArrayList findAllFilesInFolder(File folder) {
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				System.out.println(file.getName());
			} else {
				findAllFilesInFolder(file);
			}
		}
	}
}
