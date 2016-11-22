package objects;

import java.util.ArrayList;

/**
 * Created by vincent on 22/11/16.
 */
public class Person {
    private String name;
    private ArrayList<Character> move;
    private int positionRow;
    private int positionCol;
    private Character orientation;
    private int treasure;
    protected int test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Character> getMove() {
        return move;
    }


    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }

    public void setMove(ArrayList<Character> move) {
        this.move = move;
    }

    public Character getOrientation() {
        return orientation;
    }

    public void setOrientation(Character orientation) {
        this.orientation = orientation;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }
}
