/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp_server;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

/**
 *
 * @author Mahesh Rathnayaka
 */
public class Ftp_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        download_files("a9959679", "9P3IckDo", "shamalmahesh.net78.net", "public_html/testing", "Look.txt", "Downloaded");
//        FileUpload f = new FileUpload();
//        f.uploading();
//        f.fileSelecting();
        WatchDir wd = new WatchDir(Paths.get("D:/jpg/"), true);
        wd.processEvents();
    }

    public static void download_files(String un, String pw, String ip, String dir, String fn, String fp) {
        URLConnection con;
        BufferedInputStream in = null;
        FileOutputStream out = null;
        try {
            URL url = new URL("ftp://" + un + ":" + pw + "@" + ip + "/" + dir + "/" + fn + ";type=i");
            con = url.openConnection();
            in = new BufferedInputStream(con.getInputStream());
            out = new FileOutputStream(fp + fn);
            int i = 0;
            byte[] bytesIn = new byte[1024];
            while ((i = in.read(bytesIn)) >= 0) {
                out.write(bytesIn, 0, i);
            }
        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
            System.out.println("Error while FTP'ing " + fn);
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error while closing FTP connection");
            }
        }
    }
}
