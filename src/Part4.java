/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S332647338
 */
public class Part4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int i = 7;
        int j = 9;
        int k = 1;
        String space = "          ";
        while (i >= 1){

           j = j*10+i+1;
            System.out.print(space.substring(k) +j +" * " +9 +" + " +i + " = " +(j*9+i-1) +"\n");
            i--;
            k++;
    }
    
}
}
