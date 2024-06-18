/**
 * Created by lujxu on 2017/10/25.
 */
public class Map {
    private final String MAP_DEFAULT = "-";
    private int size;
    private Player d1;
    private Player d2;

    public Map(int size, Player d1, Player d2) {
        setSize(size);
        this.d1 = d1;
        this.d2 = d2;
    }

    /**
     * 请在此方法中编辑代码
     * 返回当前地图中两个player的位置信息，或二者位置重合，则返回枚举类Result中的ENCOUNTER; 否则，返回DRAW
     * 
     * @return
     */
    public Result resultEvaluation() {
        if (d1.getX() == d2.getX() && d1.getY() == d2.getY()) {
            return Result.ENCOUNTER;
        }
        return Result.DRAW;
    }

    /**
     * 请在此方法中编辑代码
     * 打印地图信息
     * player的位置用Player.getSymbol()表示，其余位置用MAP_DEFAULT表示，注意每个位置之间都用空格隔开
     * 若x,y二者重合则优先输出x
     */
    public void print() {
        String lineBreak = System.getProperty("line.separator");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == d1.getX() && j == d1.getY()) {
                    System.out.print(d1.getSymbol());
                } else if (i == d2.getX() && j == d2.getY()) {
                    System.out.print(d2.getSymbol());
                } else {
                    System.out.print(MAP_DEFAULT);
                }
                System.out.print(j == size - 1 ? lineBreak : " ");
            }
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

}
