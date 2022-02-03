import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameMenu extends JFrame {

    private ArrayList<GameInfo> gamesInfo;

    public GameMenu(ArrayList<GameInfo> gamesInfo) {

        setTitle("Memory Game");
        setSize(new Dimension(400,400));
        setResizable(false);
        setVisible(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupContentPane();

        this.gamesInfo = gamesInfo;
    }

    void setupContentPane(){
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(5,1));
        jp.setBackground(Color.decode("#ffe6cc"));
        jp.add(gameName(),BorderLayout.PAGE_START);
        jp.add(ska(),BorderLayout.AFTER_LAST_LINE);
        jp.add(menuButtonNewGame(),BorderLayout.AFTER_LAST_LINE);
        jp.add(menuButtonHighScores(),BorderLayout.AFTER_LAST_LINE);
        jp.add(menuButtonExit(),BorderLayout.AFTER_LAST_LINE);
        jp.setBorder(BorderFactory.createEmptyBorder(50, 90,50,90));
        add(jp,BorderLayout.CENTER);
    }

    JLabel gameName(){
        JLabel gameName = new JLabel("Memory The Game");
        gameName.setHorizontalAlignment(SwingConstants.CENTER);
        return gameName;
    }

    JLabel ska(){
        JLabel ska = new JLabel("s20511");
        ska.setHorizontalAlignment(SwingConstants.CENTER);
        return ska;
    }


    JButton menuButtonNewGame(){
        JButton newGame = new JButton("New Game");

        newGame.addActionListener(
                e -> {
            new SelectGridSize(gamesInfo);
            this.dispose();
        });
        return newGame;
    }

    JButton menuButtonHighScores(){
        JButton highScores = new JButton("High Scores");
        highScores.addActionListener( e -> new HighScoresList(gamesInfo) );
        return highScores;
    }

    JButton menuButtonExit(){
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        return exit;
    }

}
