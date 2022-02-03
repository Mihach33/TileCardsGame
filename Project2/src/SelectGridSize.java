import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SelectGridSize extends JFrame {
    private ArrayList<GameInfo> gamesInfo;
    private String[] gridSize = { "2","4","6" };
    private int sizeNumber = 2;

    public SelectGridSize(ArrayList<GameInfo> gamesInfo) {
        setTitle("New Game");
        setVisible(true);
        setSize(new Dimension(300,150));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#ffe6cc"));

        this.gamesInfo = gamesInfo;

        add(new JLabel("Select grid size:"));
        add(sizeSelect());
        add(playButton(),BorderLayout.AFTER_LAST_LINE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


    }

    JButton playButton(){
        JButton playButton = new JButton("Play");
        playButton.addActionListener(
                e -> {
                    new Game(sizeNumber, gamesInfo);
                    this.dispose();
                });
        return playButton;
    }


    JComboBox sizeSelect(){
        JComboBox<String> size = new JComboBox<>(gridSize);
        size.addActionListener(e -> setSize(e));
        return size;
    }


    void setSize(ActionEvent e){
        if (((JComboBox<String>) e.getSource()).getSelectedItem().equals("2"))
      this.sizeNumber = 2;
        else if (((JComboBox<String>) e.getSource()).getSelectedItem().equals("4"))
            this.sizeNumber = 4;
        else
            this.sizeNumber = 6;
    }


}
