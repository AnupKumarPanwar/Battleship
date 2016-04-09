package battleship;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;

import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


/**
 *
 * @author Anup Panwar
 */




public class Battleship extends JFrame
{
    
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane ;
    
    
    
    static String dataValues[][]=
        {
            {"Row 1", "", "", "", "", ""},
            {"Row 2", "", "", "", "", ""},
            {"Row 3", "", "", "", "", ""},
            {"Row 4", "", "", "", "", ""},
            {"Row 5", "", "", "", "", ""}
        };
    
    String name;
    
    
   
    public void draw_Battleship()
    {
       
        
        setTitle(name);
        setSize(500, 160);
        
        topPanel= new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        String columnNames[]={"", "Column 1", "Column 2", "Column 3", "Column 4", "Column 5"};
        
        
//        System.out.print(dataValues[0][0]);
        
        table=new JTable(dataValues, columnNames);
        table.setEnabled(false);
        
        scrollPane=new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        
                
                
    }
    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       String randomships[][]=
        {
            {"Row 1", "", "", "", "", ""},
            {"Row 2", "", "", "", "", ""},
            {"Row 3", "", "", "", "", ""},
            {"Row 4", "", "", "", "", ""},
            {"Row 5", "", "", "", "", ""}
        };
                
    for(int i=0; i<5; i++)
    {
        for(int j=1; j<6; j++)
        {
            Random r =new Random();
            randomships[i][j]=Integer.toString(r.nextInt(3));
//            System.out.print(randomships[i][j]);
        }

    }
    
    
        Battleship mainFrame=new Battleship();
        mainFrame.name="Attack On The Ships";
        
        
        mainFrame.draw_Battleship();
        mainFrame.setVisible(true);
        
        System.out.print("\nEnter The Row And The Column No to Fire a Missile : ");
        int m=0;
        int score=0;
        while(m<10)
        {
            
            Scanner location=new Scanner(System.in);
            System.out.print("\n\n\t\tCurrent Score " + score);
            System.out.print("\n\nMissiles Left " + (10-m));
            System.out.print("\n\tRow : ");
            int row=location.nextInt();
            System.out.print("\n\tColumn : ");
            int column=location.nextInt();
            if(row<1 || row>5 || column<1 || column>5)
            {
            System.out.print("\nSkipped");
            continue;}
            
            if(randomships[row-1][column].equals("1"))
            {
                dataValues[row-1][column]="X";
                score+=4;
            }
            
            else
            {
                dataValues[row-1][column]="O";
                score-=2;
            }
            
//            mainFrame=null;
//            mainFrame = new Battleship();
            mainFrame.draw_Battleship();
            mainFrame.setVisible(true);
            
            
            
            m++;
        }
        
        Battleship shipLocation=new Battleship();
        shipLocation.name="Actual Ship Location";
        shipLocation.dataValues=randomships;
        for(int i=0; i<5; i++)
        {
            for(int j=1; j<6; j++ )
                    {
                        if(shipLocation.dataValues[i][j].equals("1"))
                        {
                            shipLocation.dataValues[i][j]="X";
                        }
                        else
                        {
                            shipLocation.dataValues[i][j]=" ";
                        }
                    }
        }
        shipLocation.draw_Battleship();;
        shipLocation.setBounds(0, 160, 500, 160);
        shipLocation.setVisible(true);
        
        
        
        
        
    }
    
}
