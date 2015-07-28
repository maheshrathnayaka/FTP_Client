/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ftp_server;

import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Mahesh Rathnayaka
 */

public class FileUploadDemo {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
        try {
            client.connect("shamalmahesh.net78.net");
            client.login("a9959679", "9P3IckDo");
            //
            // Create an InputStream of the file to be uploaded
            //
            String filename = "hello.txt";
            fis = new FileInputStream(filename);
            //
            // Store file to server
            //
            client.storeFile(filename, fis);
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
}
