/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battaleship2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Anup Panwar
 */

class map
{
    int size;
    int no_of_ships;
    Scanner input=new Scanner(System.in);
    public void get_size()
    {   
       
       System.out.print("\nEnter The Size Of Map : ");
       size=input.nextInt();
       
    }
    
    public void get_no_of_ships()
    {
        System.out.print("\nEnter The No of Ships on Map : ");
        no_of_ships=input.nextInt();
    }
    
    public int put_size()
    {
        return size;
    }
    
    public int put_no_of_ships()
    {
        return no_of_ships;
    }
};




class ship
{
    int size;
    int direction;
    int[] location=new int[3];
};




public class Battaleship2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        final map M=new map();
        M.get_size();
        M.get_no_of_ships();
        
        final ship[] ship_array;
        ship_array = new ship[M.put_no_of_ships()];
//        System.out.print(M.put_no_of_ships());
        Random r=new Random();
        for(int i=0; i<M.put_no_of_ships(); i++)
        {
            ship_array[i]=new ship();
            ship_array[i].size=r.nextInt(3)+1;
            ship_array[i].direction=r.nextInt(2);
            int success=0;
            int flag=1;
            while(success!=1)
            {
                ship_array[i].location[0]=r.nextInt((M.put_size()-1)*(M.put_size()-1)-ship_array[i].size+1);
//                ship_array[i].location[0][1]=r.nextInt(M.put_size()-ship_array[i].size+1);
                
                if(ship_array[i].direction==0)
                {
                    for(int l=1; l<=3-ship_array[i].size; l++)
                    {
                            ship_array[i].location[l]=ship_array[i].location[0];
//                            ship_array[i].location[l][1]=ship_array[i].location[0][0];
                           
                    }
                        
                        
                    for(int l=3-ship_array[i].size; l<2; l++)
                    {
                        ship_array[i].location[l+1]=ship_array[i].location[l]+1;
//                        ship_array[i].location[l+1][1]=ship_array[i].location[l][0];
                        
                    }
                    
                }
                
                if(ship_array[i].direction==1)
                {
                    for(int l=1; l<=3-ship_array[i].size; l++)
                    {
                            ship_array[i].location[l]=ship_array[i].location[0]+l*M.put_size();
//                            ship_array[i].location[1][l]=ship_array[i].location[0][0];
                           
                    }
                        
                        
                    for(int l=3-ship_array[i].size; l<2; l++)
                    {
                        ship_array[i].location[l+1]=ship_array[i].location[0]+((l+1)*M.put_size());
//                        ship_array[i].location[1][l+1]=ship_array[i].location[l][0];
                        
                    }
                    
                }
                
                
                for(int j=0; j<i; j++)
                {
                    for(int k=0; k<3; k++ )
                    {
                        for(int m =0; m<3; m++)
                        {
                            if(ship_array[j].location[k]==ship_array[i].location[m])
                            {
                                success=0;
                                flag=0;
                                break;
                            }
                            
                            }
                        if (flag==0)
                                break;
                        
                        
                    }
                    
                    if (flag==0)
                                break;
                        
                }
                
                if (flag!=0)
                                success=1;
                        
                
              
            }
            
        }
        
        
        
    /*    for(int i=0; i<M.put_no_of_ships(); i++)
        {
            System.out.print("\n" +ship_array[i].location[0]);
            System.out.print("\t" +ship_array[i].location[1]);
            System.out.print("\t" +ship_array[i].location[2]);
        }*/
        

for(int i=1; i<= M.put_size()*M.put_size(); i++)
    
{
    
    System.out.print((i-1) + "\t");
    if(i%M.put_size()==0)
    {
        System.out.print("\n");
    }
}



class player
{
    int [] missiles= new int[M.put_no_of_ships()*3];
    int Score=0;
    public void check_target(int t)
    {
        int hit=0;
        for(int i=0; i<M.put_no_of_ships(); i++)
        {
           
            for(int j=0; j<3; j++)
            {
                if(t==ship_array[i].location[j])
                {
                    if(ship_array[i].size==1)
                    {
                        System.out.print("\n\tKill");
                        Score+=10;
                    }
                    else
                    {
                         check_kill(i);
                    }
                   
                    hit=1;
                    
                    break;
                   
                }
                
                else
                {
                    hit=0;
                }
            }
        }
        if(hit==0)
        {
            System.out.print("\nMissed");
            Score-=5;
        }
    }
    
   public void check_kill(int where )
    {
        int hit_count=0;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<missiles.length; j++)
            {
                if(ship_array[where].location[i]==missiles[j])
                hit_count++;
            }
        }
        
        if(hit_count==3)
        {
            System.out.print("\n\tKill");
            Score+=ship_array[where].size*10;
        }
        
        else
        {
            System.out.print("\n\tHit");
        }
        
    }
};

player P = new player();
System.out.print("\nEnter The Location No to Fire a Missile");
for(int i=0; i<M.put_no_of_ships()*3; i++)
{
    System.out.print("\nCurrent Score : " + P.Score);
    System.out.print("\n\n" + (M.put_no_of_ships()*3-i) +" Missiles Left\nFire at : ");
    P.missiles[i]=input.nextInt();
    P.check_target(P.missiles[i]);
    
}

    }
    
}
