package org.bofa.controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import org.omg.CORBA.portable.InputStream;

 public class PacTester {
       /**
       * @param args
       * @throws IOException
        */
       public static void main(String[] args) throws IOException {
              String abc = "c:/Users/ZKSAMN0/Downloads/pacparser-1.3.0-win32/gwmtproxy_services_us_ml_com";
              ProcessBuilder pb = new ProcessBuilder("./char");

              pb.redirectErrorStream(true);
              try{
                     Process p = pb.start();
                     String line;
                     BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                     File file = new File("Book3.txt");
                      // if file doesnt exists, then create it
                      if (!file.exists()) {
                      file.createNewFile();
                      }
                   
                      FileWriter fw = new FileWriter(file.getAbsoluteFile());
                      BufferedWriter bw = new BufferedWriter(fw);
                      String str = br.readLine();
                     while (str != null) {
                             System.out.println(str);
                             bw.write(str);
                             bw.write("\n");
                             str = br.readLine();
                           }
                     bw.close();


                     System.out.println("Exit Value:" + p.waitFor());
                     p.getErrorStream().close();
                     p.getInputStream().close();
                     p.getOutputStream().close();
                     }catch (Exception ex) {
            ex.printStackTrace();
        }
       }
}
