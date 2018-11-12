/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

import java.net.*;
import java.io.*;

/**
 *
 * @author francescometta, aaleeexx
 */
public class Client{
    private Socket clientSocket;

    public Client(int port, String file) {
        try {
            clientSocket = new Socket("localhost", port);
            sendFile(file);
	} catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String file) throws IOException {
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[52428800];

        while (fis.read(buffer) > 0) {
            dos.write(buffer);
        }
        
        fis.close();
	dos.close();
    }

}
