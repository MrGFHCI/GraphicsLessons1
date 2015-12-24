
import javax.swing.JFrame;

public class FraMain extends JFrame {

    public FraMain() {
        PanBoard panBoard = new PanBoard();
        add(panBoard);
        setTitle("Howdy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DO_NOTHING_ON_CLOSE
        setSize(1200, 600); //1370, 730 for fullscreen for laptop
        this.setResizable(true);
        setLocationRelativeTo(null);
        //pack();
        setVisible(true);
    }

}
