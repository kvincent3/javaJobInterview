package objects;

/**
 * Created by vincent on 22/11/16.
 */
public class Box {
    private boolean hasMountain;
    private int tresureValue;

    public boolean hasMountain() {
        return hasMountain;
    }

    public void setHasMountain(boolean hasMountain) {
        this.hasMountain = hasMountain;
    }

    public boolean hasTreasure() {
        return tresureValue > 0;
    }

    public int getTresureValue() {
        return tresureValue;
    }

    public void setTresureValue(int tresureValue) {
        this.tresureValue = tresureValue;
    }
}
