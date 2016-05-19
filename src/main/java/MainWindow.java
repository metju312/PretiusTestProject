import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
  private static MainWindow instance = null;

  public static MainWindow getInstance() {
    if (instance == null) {
      instance = new MainWindow();
    }
    return instance;
  }

  public MainWindow(){
  }
}
