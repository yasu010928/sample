package moveFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//-----------------------------------------------------
		//　当日日付を取得 
		Date d = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");
		String today = d1.format(d);
		
		File from = new File("//Users/yasuhiro/Desktop/work_nksol");
		File to = new File("//Users/yasuhiro/Desktop/move_test/");
//		FileUtils.moveDirectory(from, to);
	
		String dirPath = "//Users/yasuhiro/Desktop/work_nksol";
		//makeLogDir(today, dirPath);
		
		moveFile(today, dirPath);
	}
	
	
	public static void makeLogDir(String today, String dirPath) {
		String[] dirName = {
							today + "_y1ciseffv01_RGD_log",
							today + "_y1ciseffv02_RGD_log",
							today + "_y1ciseffv03_RGD_log",
							today + "_y1ciseffv04_RGD_log",
							today + "_y1ciseffv05_RGD_log",
							today + "_y1ciseffv06_RGD_log",
							today + "_y1ciseffv07_RGD_log",
							today + "_y1ciseffv08_RGD_log"
							};
				
		
		
		for (int i = 0; i <  dirName.length; i++) {
			System.out.println(dirName.length);
			File newfile = new File(dirPath + "/" + dirName[i]);
			if (!newfile.exists()) {
				newfile.mkdir();
			} else {
				System.out.println("ディレクトリが存在します");
			}
		}
		
	}
	
	public static void moveFile(String today, String dirpath) throws IOException {
		String[] dirName = {
				today + "_y1ciseffv01_RGD_log",
				today + "_y1ciseffv02_RGD_log",
				today + "_y1ciseffv03_RGD_log",
				today + "_y1ciseffv04_RGD_log",
				today + "_y1ciseffv05_RGD_log",
				today + "_y1ciseffv06_RGD_log",
				today + "_y1ciseffv07_RGD_log",
				today + "_y1ciseffv08_RGD_log"
				};
		
		
		String[] access_log_dir = {
								  today + "_y1ciseffv01_RGD_access_log/http",
								  today + "_y1ciseffv02_RGD_access_log/http",
								  today + "_y1ciseffv03_RGD_access_log/http",
								  today + "_y1ciseffv04_RGD_access_log/http",
								  today + "_y1ciseffv05_RGD_access_log/http",
								  today + "_y1ciseffv06_RGD_access_log/http",
								  today + "_y1ciseffv07_RGD_access_log/http",
								  today + "_y1ciseffv08_RGD_access_log/http"
								  };
		
		String[] efront_log_dir = {
								  today + "_y1ciseffv01_RGD_client_log/efront",
								  today + "_y1ciseffv02_RGD_client_log/efront",
								  today + "_y1ciseffv03_RGD_client_log/efront",
								  today + "_y1ciseffv04_RGD_client_log/efront",
								  today + "_y1ciseffv05_RGD_client_log/efront",
								  today + "_y1ciseffv06_RGD_client_log/efront",
								  today + "_y1ciseffv07_RGD_client_log/efront",
								  today + "_y1ciseffv08_RGD_client_log/efront"
								  
								  };
		
		for (int i = 0; i < dirName.length; i++) {
			File toFilePath = new File(dirpath + "/" + dirName[i] + "/http");
			File fromFilePath = new File(dirpath + "/" + access_log_dir[i]);
			FileUtils.moveDirectory(fromFilePath,toFilePath);
		}
		
		for (int i = 0; i < dirName.length; i++) {
			File toFilePath = new File(dirpath + "/" + dirName[i] + "/efront");
			File fromFilePath = new File(dirpath + "/" + efront_log_dir[i]);
			FileUtils.moveDirectory(fromFilePath,toFilePath);
		}
	
		//-------------------------------------------------
		//後処理 ディレクトリ削除
		//-------------------------------------------------
		File access_dir = new File("//Users/yasuhiro/Desktop/work_nksol/" + today + "_y1ciseffv01_RGD_access_log");
		access_dir.delete();
		System.out.println("ファイル削除しました。");
		//		for (int i = 0; i < access_log_dir.length; i++) {
//			File access_dir = new File(dirpath + "/" + access_log_dir[i].replace("/http",","));
//			File efront_dir = new File(dirpath + "/" + efront_log_dir[i].replace("/efront",","));
//			FileUtils.deleteDirectory(access_dir);
//			FileUtils.deleteDirectory(efront_dir);
//			
//		}
		
	}
}
