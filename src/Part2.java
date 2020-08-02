
public class Part2 {

    public static void main(String[] args) {
       
        int i = 1;
        long j = 0;
        String space = "              ";
        while (i <= 7){
            
            j = j*10+1;
            
            System.out.println(space.substring(i*2) +j +" * " +j +" = " +(j*j));
            
            
            i++;
            
            
        }
            
    }
    
}
