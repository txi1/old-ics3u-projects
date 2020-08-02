
public class Part1 {

    public static void main(String[] args) {
        
        int i = 1;
        int j = 0;
        String space = "          ";
        while (i <= 9){

           j = j*10+i;
            System.out.print(space.substring(i) +j +" * " +8 +" + " +i + " = " +(j*8+i) +"\n");
            i++;
            
        }
        
    }
}
    

