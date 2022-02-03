import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<GameInfo> gamesInfo = new ArrayList<GameInfo>();

        SwingUtilities.invokeLater(
                () -> {
                    JFrame jf = new GameMenu(gamesInfo);

                }
        );
    }
}
