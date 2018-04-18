public class Deputat {
    private String firstName;
    private String lastName;
    private int age;
    private boolean briber;
    private int bribeSize;

    public void giveBribe(int size){
        if(!briber){
            if(bribeSize > 1000000) {
                System.out.println("Oh, I don't know...");
            }else {
                System.out.println("I am not a Briber, fuck u, go away!");
            }
        }else{
            bribeSize = size;
        }
    }
}
