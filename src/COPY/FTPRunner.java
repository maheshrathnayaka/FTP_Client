/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COPY;

import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author Mahesh Rathnayaka
 */
public class FTPRunner {
    public static void main(String[] args) throws IOException {
        Watcher w = new Watcher(Paths.get("D:/jpg/"), true);
        w.processEvents();
    }
}
