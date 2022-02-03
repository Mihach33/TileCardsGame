import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerName extends JFrame {
    private ArrayList<GameInfo> gamesInfo;
    String playerName;
    JTextField textField;
    private int gridSize;
    private int time;
    private int triesCount;


    public PlayerName(int gridSize, int time, int triesCount, ArrayList<GameInfo> gamesInfo) {

        setTitle("Rank");
        setVisible(true);
        setLayout(new BorderLayout());
        setSize(new Dimension(200,100));
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#ffe6cc"));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        this.gridSize = gridSize;
        this.time = time;
        this.triesCount = triesCount;
        this.gamesInfo = gamesInfo;

        addMenu();


    }

    void addMenu(){

        add(commandName(),BorderLayout.PAGE_START);
        add(textField(), BorderLayout.CENTER);
        add(okButton(), BorderLayout.PAGE_END);

    }

    JLabel commandName(){
        JLabel jl = new JLabel("Enter Your Name:");
        jl.setHorizontalAlignment(JLabel.CENTER);
        return jl;
    }

    JTextField textField(){
        textField = new JTextField(20);
        textField.setBackground(Color.WHITE);
        textField.setMaximumSize(new Dimension(60, 15));

        return textField;
    }

    JButton okButton(){
        JButton jb = new JButton("OK");

        jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerName = textField.getText();
                    if (!playerName.equals("")) {
                        gamesInfo.add(new GameInfo(playerName, gridSize, time, triesCount));
                        new GameMenu(gamesInfo);
                        windowDispose();
                    }
                }
            });
        return jb;
    }

    void windowDispose(){
        this.dispose();
    }

}
