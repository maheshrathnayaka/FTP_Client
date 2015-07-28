/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp_server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Mahesh Rathnayaka
 */
public class FileUpload {

    public void fileSelecting() throws IOException {
        File f = new File("D:\\jpg");
        FilenameFilter textfile = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return name.toLowerCase().endsWith(".jpg");
            }
        };
        File[] files = f.listFiles(textfile);
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory");
            } else {
                System.out.println("File : ");
            }
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getName());
        }
    }

    public void uploading() {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
        try {
            client.connect("shamalmahesh.net78.net");
            client.login("a9959679", "9P3IckDo");
            client.setFileType(FTP.BINARY_FILE_TYPE);
            int reply = client.getReplyCode();
            if (FTPReply.isPositiveCompletion(reply)) {
                System.out.println("Uploading....");
            } else {
                System.out.println("Failed connect to the server!");
            }
//            String filename = "DownloadedLook1.txt";
            String path = "D:\\jpg\\";
//            String filename = "1.jpg";
            String filename = "appearance.jpg";
            System.out.println(path+filename);
            fis = new FileInputStream(path + filename);
            System.out.println(fis.toString());
            boolean status = client.storeFile("/public_html/testing/" + filename, fis);
            System.out.println("Status : " + status);
            System.out.println("Done!");
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadingWithProgress() {
        FTPClient ftp = new FTPClient();
        FileInputStream fis = null;
        try {
            ftp.connect("shamalmahesh.net78.net");
            ftp.login("a9959679", "9P3IckDo");
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory("/public_html/testing");
            int reply = ftp.getReplyCode();
            if (FTPReply.isPositiveCompletion(reply)) {
                System.out.println("Uploading....");
            } else {
                System.out.println("Failed connect to the server!");
            }
            File f1 = new File("D:\\jpg\\1.jpg");

//            fis = new FileInputStream(ftp.storeFile("one.jpg", fis));
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
