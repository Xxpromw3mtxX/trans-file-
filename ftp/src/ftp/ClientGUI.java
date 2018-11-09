/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Francesco
 */
public class ClientGUI extends JFrame{
    private JPanel panel;
    private JButton button;
    private BufferedImage transbuff;
    private JLabel translogo;
    private JFileChooser transchooser;
    private int returnVal;
    
    public ClientGUI() throws IOException {
        this.panel = new JPanel();
        this.button = new JButton("Choose file");
        this.transbuff = ImageIO.read(new File("src/res/logo.png"));
        this.translogo = new JLabel(new ImageIcon(transbuff));
        this.transchooser = new JFileChooser();
    }
    
    // Create the window
    public void build() throws IOException{
        add(panel);
        init();
        setDefaultCloseOperation(3);
        setPreferredSize(new Dimension(400, 200));
        ImageIcon img = new ImageIcon("src/res/ftp.png");
        setIconImage(img.getImage());
        setResizable(false);
        setTitle("TRANS(FILE)");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        actions();
    }
    
    // Add things to the window
    private void init() throws IOException{
        panel.add(translogo);
        panel.add(button);
    }
    
    //ActionListener
    private void actions() {
        button.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                returnVal = transchooser.showOpenDialog(ClientGUI.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = transchooser.getSelectedFile();
                    Client fc = new Client(1988,file.toString());
                } 
            }
        });
    }
}
