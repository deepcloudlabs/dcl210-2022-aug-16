package com.example.networking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpApp {
	public static void main(String[] args) throws SocketException, IOException {
		Task task = new Task();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			try {
				var ftp = new FTPClient();
				ftp.setControlEncoding("UTF-8");
				ftp.setAutodetectUTF8(true);
				ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
				ftp.connect("ftp.example.com", 21);
				int reply = ftp.getReplyCode();
				if (!FTPReply.isPositiveCompletion(reply)) {
					ftp.disconnect();
					throw new IOException("Exception in connecting to FTP Server");
				}
				ftp.login("user", "password");
				ftp.enterRemotePassiveMode();
				ftp.enterLocalPassiveMode();
				ftp.changeWorkingDirectory("/path");
				FTPFile[] files = ftp.listFiles("/path");
				var lastFile = Arrays.stream(files).filter(FTPFile::isFile)
						.max(Comparator.comparing(FTPFile::getTimestamp)).orElseThrow();
				FileOutputStream out = new FileOutputStream(new File("src", lastFile.getName()));
				ftp.retrieveFile(lastFile.getName(), out);
			} catch (Exception e) {
			}

		}
	}

}