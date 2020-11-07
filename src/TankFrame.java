import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank mytank = new Tank(200,200, Dir.DOWN);

    //初始化操作
    public TankFrame() throws HeadlessException {

        //设置窗体大小
        setSize(800, 600);
        //窗体不可拖动
        setResizable(false);
        //添加标题
        setTitle("Tank War");


        //添加按钮关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //添加键盘监听
        addKeyListener(new MyKeyListener());

        //显示窗体
        setVisible(true);
    }


    /**
     * 重绘窗口
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        mytank.paint(g);
    }

    public class MyKeyListener extends KeyAdapter {

        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key Released");
            int code = e.getKeyCode();
            switch (code){
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key Pressed");
            int code = e.getKeyCode();
            switch (code){
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){

            if (!bL && !bR && !bU && !bD){
                mytank.setMoving(false);
            } else {
                if (bL) mytank.setDir(Dir.LEFT);
                if (bR) mytank.setDir(Dir.RIGHT);
                if (bU) mytank.setDir(Dir.UP);
                if (bD) mytank.setDir(Dir.DOWN);
                mytank.setMoving(true);
            }
        }

    }
}
