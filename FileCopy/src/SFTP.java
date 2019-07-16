import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTP {
	
	public static void main(String[] args) throws JSchException, SftpException, FileNotFoundException, IOException  {
		
		//Server
		String host = "host";
		
		// port
		int port = 22;
		
		// User
		String user = "user";
		
		// password
		String password = "password";
		
		String dir = "/dir";
		
		String fileName = "xxxx.log";
		
		JSch jsch;
		Session session = null;
		ChannelSftp channel = null;
		FileInputStream fin = null;
		BufferedInputStream bin = null;
		
		try {
			
			jsch = new JSch();
			session = jsch.getSession(user, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			channel.cd(dir);
			
			// アップロード
			//fin = new FileInputStream(fileName);
			//channel.put(fin, fileName);
			
			// ダウンロード
//			bin = new BufferedInputStream(channel.get(fileName));
//            ByteArrayOutputStream bout = new ByteArrayOutputStream();
//            byte[] buf = new byte[1024];
//            int length;
//            while (true) {
//                length = bin.read(buf);
//                if (length == -1) {
//                    break;
//                }
//                bout.write(buf, 0, length);
//            }
//            //標準出力
//            System.out.format("ダウンロードしたファイル=%1$s", new String(bout.toByteArray(), StandardCharsets.UTF_8));
			
			// ファイル取得(get)
			// 第一引数：転送元ファイル名
			// 第二引数：転送先ファイル名
			//---------------------------------------------------
			channel.get("転送元", "転送先");
			
			File fromFile = new File("c:\\test\\test1\\a.txt");
		    File toFile = new File("c:\\test\\test2\\b.txt");
		    FileUtils.moveFile(fromFile, toFile);
		
		}
        finally {
            if (fin != null) {
                try {
                    fin.close();
                }
                catch (IOException e) {
                }
            }
            if (bin != null) {
                try {
                    bin.close();
                }
                catch (IOException e) {
                }
            }
            if (channel != null) {
                try {
                    channel.disconnect();
                }
                catch (Exception e) {
                }
            }
            if (session != null) {
                try {
                    session.disconnect();
                }
                catch (Exception e) {
                }
            }
		
        }

	}

}