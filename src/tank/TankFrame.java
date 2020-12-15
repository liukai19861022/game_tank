package tank;

import fireStrategy.TwoDirFireStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;


    GameModel gm = GameModel.getInstance();

    //初始化操作
    public TankFrame() throws HeadlessException {

        //设置窗体大小
        setSize(GAME_WIDTH, GAME_HEIGHT);
        //窗体不可拖动
        setResizable(false);
        //添加标题
        setTitle("tank.Tank War");

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

        gm.paint(g);
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {

        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    public class MyKeyListener extends KeyAdapter {

        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyReleased(KeyEvent e) {
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
                case 157 : //mac ⌘、发射子弹
                    gm.getMaintank().fire(TwoDirFireStrategy.getInstance());
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){

            Tank maintank = gm.getMaintank();
            if (!bL && !bR && !bU && !bD){
                maintank.setMoving(false);
            } else {
                if (bL) maintank.setDir(Dir.LEFT);
                if (bR) maintank.setDir(Dir.RIGHT);
                if (bU) maintank.setDir(Dir.UP);
                if (bD) maintank.setDir(Dir.DOWN);
                maintank.setMoving(true);
            }
        }
    }
}
