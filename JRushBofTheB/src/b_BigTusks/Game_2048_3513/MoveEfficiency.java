package b_BigTusks.Game_2048_3513;

// непонял зачемимплементить Comparable не на классе что будет сравниваться
// и сравнивать вообще другие объекты внутри текущего через метод compareTo(..) - явно не ход как из книг..
public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private final int numberOfEmptyTiles;
    private final int score;
    private final Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        int resNumber = Integer.compare(this.numberOfEmptyTiles, o.numberOfEmptyTiles);
//        if (this.numberOfEmptyTiles > o.numberOfEmptyTiles) {
//            resNumber = 1;
//        }
//        if (this.numberOfEmptyTiles < o.numberOfEmptyTiles) {
//            resNumber = -1;
//        }
//        if (this.numberOfEmptyTiles == o.numberOfEmptyTiles) {
//            resNumber = 0;
//        }

        if (resNumber == 0) {
            resNumber = Integer.compare(this.score, o.score);
        }
        return resNumber;
    }
}
