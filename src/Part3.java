/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S332647338
 */
public class Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 2;
        int j = 0;
        String space = "          ";
        while (i <= 10){

           j = j*10+i-1;
            System.out.print(space.substring(i) +j +" * " +9 +" + " +i + " = " +(j*9+i) +"\n");
            i++;
    }
    
}
}
