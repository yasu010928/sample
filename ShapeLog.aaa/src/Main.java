import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		//-------------------------------------------------
		//読み込みファイルパス
		//c:¥¥tmp¥¥test.txt
		String input_filepath = "//Users/yasuhiro/Desktop/work_site/merge/20180301.log";
		//書き込みファイルパス
		String output_filepath ="//Users/yasuhiro/Desktop/work_site/merge/output.csv";
		//マッチ文字パターン
		String searchString = "ab";
		fileShape(input_filepath, output_filepath, searchString);
		//-------------------------------------------------
//		String str = "A      B    C D";
//		String replaced = str.replaceAll(" +", ",");
//		System.out.println(replaced); // → "A B C D"
//		

	}
	
	public static void 	fileShape(String input_filepath, String output_filepath, String searchString) {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
	
		try {
			   br = new BufferedReader(new InputStreamReader(new FileInputStream(input_filepath)));	
			   bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_filepath)));
			   
			   String line;
			   while ((line = br.readLine()) != null) {
				   Pattern p = Pattern.compile(searchString,Pattern.CASE_INSENSITIVE);
				   Matcher m = p.matcher(line);
				   //System.out.println(line);
				   
				   if (m.find()) {
					   //置換処理
					   line = line.replaceAll(" +", ",");
				   
					   //ファイルへ書き込み
					   bw.write(line);
					   bw.newLine();
				   }
			
			   }	
		 } catch(IOException e) {
	            e.printStackTrace();
	        }finally{
	            if(br != null){
	                try{
	                    br.close();
	                }catch(IOException ie){
	                }
	            }
	            if(bw != null){
	                try{
	                    bw.close();
	                }catch(IOException ie){
	                }
	            }
	        }
	    }
}
