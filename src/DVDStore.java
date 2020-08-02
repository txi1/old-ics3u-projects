public class DVDStore {
    
    private int lengthM, movieRating, movieScenes, DVD_ID;
    private static int numDVD;
    private double moviePrice, lengthH;
    private String title, lengthHM;
    
    public void myDVD(int len, int sceneNum, int rating, double cost,String name){
        lengthM = len;
        movieScenes = sceneNum;
        movieRating = rating;
        moviePrice = cost;
        title = name;
        numDVD ++;
        DVD_ID = numDVD;
    }
    
    public void myDVD(){
        lengthM = 90;
        movieScenes = 5;
        movieRating = 4;
        moviePrice = 19.99;
        title = "Freelance Movie";
        numDVD ++;
        DVD_ID = numDVD;
    }
    
    public double getLengthH(){
        lengthH = (double)lengthM/60;
        return lengthH;
    }
    
    public double getLengthM(){
        return lengthM;
    }
    
    public String getLengthHM(){
        lengthHM += lengthM%60;
        lengthHM += " Hours, and ";
        lengthHM += lengthM-((lengthM%60)*60);
        lengthHM += " minutes";
        return lengthHM;
    }
    
    public int getRating(){
        return movieRating;
    }
    
    public void setRating(int rating){
        movieRating = rating;
    }
    
    public int getScenes(){
        return movieScenes;
    }
    
    public void setScenes(int scenes){
        movieScenes = scenes;
    }
    
    public int getID(){
        return DVD_ID;
    }
    
    public static int getNumDVD(){
        return numDVD;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String name){
        title = name;
    }
    
    public double getPrice(){
        return moviePrice;
    }
    
    public void setPrice(double cost){
        moviePrice = cost;
    }
}
