package core;

import objects.Box;
import objects.Person;
import objects.Wrapper;

import java.util.HashMap;

/**
 * Created by vincent on 22/11/16.
 */
public class ProcessManagerImpl implements ProcessManager {
    private String res = "";

    @Override
    public void process(Person person, Box[][] boxes) throws ArrayIndexOutOfBoundsException {
        update(person,boxes, person.getPositionRow(), person.getPositionCol());
        info(person);
        for (char c : person.getMove()) {
            int rowP = person.getPositionRow();
            int colP = person.getPositionCol();
            switch(c) {
                case 'A':
                    HashMap<Character, Wrapper> map = new HashMap<>();
                    map.put('N', new Wrapper(rowP - 1, colP));
                    map.put('E', new Wrapper(rowP, colP + 1));
                    map.put('S', new Wrapper(rowP + 1, colP));
                    map.put('O', new Wrapper(rowP, colP - 1));
                    move(person, boxes, map);
                    break;
                case 'D':
                    HashMap<Character, Character> rOppositeOr = new HashMap<>();
                    rOppositeOr.put('N','E');
                    rOppositeOr.put('S','O');
                    rOppositeOr.put('O','N');
                    rOppositeOr.put('E','S');
                    person.setOrientation(rOppositeOr.get(person.getOrientation()));
                    sleep();
                    info(person);
                    break;
                case 'G':
                    HashMap<Character, Character> lOppositeOr = new HashMap<>();
                    lOppositeOr.put('N','O');
                    lOppositeOr.put('S','E');
                    lOppositeOr.put('O','S');
                    lOppositeOr.put('E','N');
                    person.setOrientation(lOppositeOr.get(person.getOrientation()));
                    sleep();
                    info(person);
                    break;
            }
        }
    }

    @Override
    public String getResult() {
        return res;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void move(Person person, Box[][] boxes, HashMap<Character, Wrapper> map) {
        switch (person.getOrientation()) {
            case 'N':
                if (update(person, boxes, map.get('N').getRow(), map.get('N').getCol())) {
                    person.setPositionRow(map.get('N').getRow());
                    sleep();
                }
                break;
            case 'E':
                if (update(person, boxes, map.get('E').getRow(), map.get('E').getCol())) {
                    person.setPositionCol(map.get('E').getCol());
                    sleep();
                }
                break;
            case 'S':
                if (update(person, boxes, map.get('S').getRow(), map.get('S').getCol())) {
                    person.setPositionRow(map.get('S').getRow());
                    sleep();
                }
                break;
            case 'O':
                if (update(person, boxes, map.get('O').getRow(), map.get('O').getCol())) {
                    person.setPositionCol(map.get('O').getCol());
                    sleep();
                }
                break;
        }
        info(person);
    }

    private void info(Person person) {
        String info = person.getName() + " is on the box (" + (person.getPositionCol() + 1) + "," +
                (person.getPositionRow() + 1) + "); orientation :" + person.getOrientation() + " money :" + person.getTreasure();
        System.out.println(info);
        res += info + "\n";
    }

    private boolean update(Person person, Box[][] boxes, int rowP, int colP) {
        boolean res = true;
        if (boxes[rowP][colP].hasMountain()) {
            String info = "There is a mountain so " +  person.getName() + " cannot go there";
            System.out.println(info);
            this.res +=  info + "\n";
            info(person);
            sleep();
            res = false;
        } else if (boxes[rowP][colP].hasTreasure()) {
            person.setTreasure(person.getTreasure() + boxes[rowP][colP].getTresureValue());
            sleep();
        }
        return res;
    }

}
