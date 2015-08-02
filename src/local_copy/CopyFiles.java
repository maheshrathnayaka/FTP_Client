/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local_copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Daminda
 */
public class CopyFiles {
    
    public static void main(String[] args) throws IOException{
        
        File source = new File("C:\\Users\\Daminda\\Desktop\\01");
        File dest = new File("C:\\Users\\Daminda\\Desktop\\02");
        copyDirectory(source,dest);
    }
    
     public static void copyDirectory(File sourceLocation , File targetLocation)
    throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
                
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
                
                
            }
            in.close();
            out.close();
            sourceLocation.delete();
        }
    }
    
}
