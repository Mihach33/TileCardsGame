import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class Game extends JFrame {

    private ArrayList<GameInfo> gamesInfo;

    ArrayList<ImageIcon> listOfIcons = new ArrayList<ImageIcon>();
    ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
    ArrayList<JButton> flippedCards = new ArrayList<JButton>();

    private int triesCount = 0;
    private int gridSize;
    private ImageIcon bgImage = new ImageIcon("src/Icons/questionmark.jpg");
    private final ImageIcon[] images = {
            new ImageIcon("src/Icons/1.jpg"),
            new ImageIcon("src/Icons/2.jpg"),
            new ImageIcon("src/Icons/3.jpg"),
            new ImageIcon("src/Icons/4.jpg"),
            new ImageIcon("src/Icons/5.jpg"),
            new ImageIcon("src/Icons/6.jpg"),
            new ImageIcon("src/Icons/7.jpg"),
            new ImageIcon("src/Icons/8.jpg"),
            new ImageIcon("src/Icons/9.jpg"),
            new ImageIcon("src/Icons/10.jpg"),
            new ImageIcon("src/Icons/11.jpg"),
            new ImageIcon("src/Icons/12.jpg"),
            new ImageIcon("src/Icons/13.jpg"),
            new ImageIcon("src/Icons/14.jpg"),
            new ImageIcon("src/Icons/15.jpg"),
            new ImageIcon("src/Icons/16.jpg"),
            new ImageIcon("src/Icons/17.jpg"),
            new ImageIcon("src/Icons/18.jpg"),
    };

    JLabel timer = new JLabel(0 + "." + 0);
    private boolean gameFinished = false;
    int secondsPassed = 0;
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask(){
        @Override
        public void run() {
            secondsPassed++;
            timer.setText(secondsPassed/60 + "." + secondsPassed%60);

        }
    };


    public Game(int s, ArrayList<GameInfo> gamesInfo) {
        this.gamesInfo = gamesInfo;
        this.gridSize = s;

        if (gridSize == 2) {
            setSize(new Dimension(230, 270));
        } else if (gridSize == 4) {
            setSize(new Dimension(450, 500));
        } else if (gridSize == 6) {
            setSize(new Dimension(670, 720));
        }
        setResizable(false);

        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#ffe6cc"));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(new BorderLayout());



        setImagesList();
        setGrid();
        buttonsAction();
        this.start();
    }

    void setImagesList() {
        Collections.shuffle(Arrays.asList(images));
        for (int i = 0; i < gridSize * gridSize / 2; i++) {
            listOfIcons.add(images[i]);
            listOfIcons.add(images[i]);
        }
        Collections.shuffle(listOfIcons);
    }

    void setGrid() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(gridSize, gridSize));
        jPanel.setBackground(Color.decode("#ffe6cc"));


        for (int i = 0; i < listOfIcons.size(); i++) {

            JButton jb = new JButton();
            jb.setIcon(bgImage);

            jb.setMinimumSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
            jb.setMaximumSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
            jb.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            listOfButtons.add(jb);
            jPanel.add(jb);
        }
        add(jPanel);

        timer.setHorizontalAlignment(JLabel.CENTER);
        timer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));;
        add(timer, BorderLayout.PAGE_END);
    }


   public void start(){
        myTimer.scheduleAtFixedRate(task, 1000,1000);
    }


    void buttonsAction(){
        for (int i = 0; i < listOfButtons.size(); i++) {
            JButton j = listOfButtons.get(i);
            ImageIcon icon = listOfIcons.get(i);

            listOfButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkFlippedCards(j, icon);
                }
                });
        }
    }




    void checkFlippedCards(JButton jb, ImageIcon icon) {


        if (flippedCards.size() < 2 && jb.getIcon() == bgImage) {
            jb.setIcon(icon);

            flippedCards.add(jb);

            Runnable task = () ->
            {
                if (flippedCards.size() == 2) {
                    if (flippedCards.get(0).getIcon() != flippedCards.get(1).getIcon()) {
                        try {
                            synchronized (this) {
                                new Thread().sleep(1000);
                            }
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        flippedCards.get(0).setIcon(bgImage);
                        flippedCards.get(1).setIcon(bgImage);
                    }
                    flippedCards.clear();
                    this.triesCount++;
                }
            };

            Thread thread = new Thread(task);
            thread.start();

        }

        for (JButton j: listOfButtons) {
            if (j.getIcon() == bgImage){
                this.gameFinished = false;
                break;
            }
            else gameFinished = true;
        }

        if (gameFinished){
            int finalTime = secondsPassed;
            myTimer.cancel();
            myTimer.purge();
            this.dispose();
            new PlayerName(gridSize, finalTime, triesCount, gamesInfo);
        }
    }

}

