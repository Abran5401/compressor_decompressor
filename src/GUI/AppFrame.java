package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;


public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton =new JButton("Compress");
        compressButton.setBounds(250,100,200,30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Decompress");
        decompressButton.setBounds(50,100,200,40);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,500);
        this.getContentPane().setBackground(Color.RED);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response= fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());;
                }
            }
        }

        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response= fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());;
                }
            }

        }

    }
}
