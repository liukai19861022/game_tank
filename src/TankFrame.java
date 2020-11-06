import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

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

        //显示窗体
        setVisible(true);
    }
}
