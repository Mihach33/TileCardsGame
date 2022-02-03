

public class GameInfo implements Comparable {

    private String playerName;
    private int gridSize;
    private int time;
    private int triesCount;

    public GameInfo(String playerName, int gridSize, int time, int triesCount) {
        this.playerName = playerName;
        this.gridSize = gridSize;
        this.time = time;
        this.triesCount = triesCount;
    }


    @Override
    public int compareTo(Object p) {
        GameInfo g = (GameInfo) p;
        return g.gridSize / g.time * g.triesCount - gridSize / time * triesCount;
    }

    @Override
    public String toString() {
        return  playerName + " (Time: " + time/60 + "." + time%60 + ", grid" + gridSize + "x" + gridSize + ")";
    }
}
