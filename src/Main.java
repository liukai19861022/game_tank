public class Main {

    public static void main(String[] args) throws InterruptedException {
    	// write your code here
        TankFrame tf = new TankFrame();

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
