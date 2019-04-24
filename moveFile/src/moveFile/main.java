package moveFile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File from = new File("//Users/yasuhiro/Desktop/work_nksol");
		File to = new File("//Users/yasuhiro/Desktop/move_test/");
		FileUtils.moveDirectory(from, to);

	}

}
