package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
    Tank mytank = new Tank(200,200, Dir.DOWN, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> tanks = new ArrayList<Tank>();
    List<Explode> explodes = new ArrayList<Explode>();

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

        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹数量 ： "+ bullets.size(),10,60);
        g.drawString("敌人数量 ： "+ tanks.size(),10,80);

        g.setColor(c);

        mytank.paint(g);

        //使用计数循环解决 java.util.ConcurrentModificationException 此问题
        for (int i=0; i<bullets.size(); i++){
            bullets.get(i).paint(g);
        }

        for (int i=0; i<tanks.size(); i++){
            tanks.get(i).paint(g);
        }

        //子弹与敌方tank碰撞检测
        for (Iterator<Bullet> bulIt = bullets.iterator(); bulIt.hasNext();){

            Bullet bullet = bulIt.next();
            for (Iterator<Tank> tankIt = tanks.iterator(); tankIt.hasNext(); ){

                Tank tank = tankIt.next();
                bullet.collideWith(tank);
            }
        }

        //爆炸特效
        for (Iterator<Explode> it = explodes.iterator(); it.hasNext();){
            Explode e = it.next();
            e.paint(g);
            if (!e.isLiving()){
                it.remove();
            }
        }
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
                    mytank.fire();
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
