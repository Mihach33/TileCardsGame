import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoresList extends JFrame {

    ArrayList<GameInfo> gamesInfo;

    public HighScoresList(ArrayList<GameInfo> gamesInfo) {

        this.gamesInfo = gamesInfo;

        setTitle("High Scores");
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#ffe6cc"));

        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        createList();

    }

    void createList(){

        Collections.sort(gamesInfo);
        String [] gamesInfoString = new String[gamesInfo.size()];
        for (int i = 0; i <gamesInfoString.length; i++){
            gamesInfoString[i] = gamesInfo.get(i).toString();
        }
        JList playersList = new JList(gamesInfoString);
        playersList.setBackground(Color.decode("#ffe6cc"));
        playersList.setCellRenderer(new MyCellRenderer());

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) playersList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        playersList.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        playersList.setPreferredSize(new Dimension(300,300));
        JScrollPane scrollPane = new JScrollPane(playersList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }



}
