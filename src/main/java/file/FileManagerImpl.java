package file;

import objects.Box;
import objects.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vincent on 22/11/16.
 */
public class FileManagerImpl implements FileManager {

    public Box[][] getInitializedMap(Person person) {
        Box[][] boxes = null;
        // We Assume that the file is correct
        ArrayList<String> lines = getFile("input");
        for (String line : lines) {
            String[] splits = line.split(" ");
            String charac = splits[0];
            switch (charac) {
                case "C":
                    int columnC = Integer.parseInt(splits[1]);
                    int rowC = Integer.parseInt(splits[2]);
                    boxes = new Box[rowC][columnC];
                    for(int i=0; i<rowC;i++){
                        for(int j=0; j<columnC;j++) {
                            boxes[i][j] = new Box();
                        }
                    }
                    break;
                case "T":
                    String place[] = splits[1].split("-");
                    int columnT = Integer.parseInt(place[0]) - 1;
                    int rowT = Integer.parseInt(place[1]) - 1;
                    boxes[rowT][columnT].setTresureValue(Integer.parseInt(splits[2]));
                    break;
                case "M":
                    String placeM[] = splits[1].split("-");
                    int columnM = Integer.parseInt(placeM[0]) - 1;
                    int rowM = Integer.parseInt(placeM[1]) - 1;
                    boxes[rowM][columnM].setHasMountain(true);
                    break;
                default:
                    String placeCh[] = splits[1].split("-");
                    int columnCh = Integer.parseInt(placeCh[0]) -1;
                    int rowCh = Integer.parseInt(placeCh[1]) - 1;
                    person.setPositionRow(rowCh);
                    person.setPositionCol(columnCh);
                    person.setName(splits[0]);
                    ArrayList<Character> moves = new ArrayList<>();
                    for (char c : splits[3].toCharArray()) {
                        moves.add(c);
                    }
                    person.setOrientation(splits[2].charAt(0));
                    person.setMove(moves);
                    break;
            }
        }
        return boxes;
    }

    @Override
    public void save(String result) {
        String filename = "result.txt";
        try {

            File file = new File(filename);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<String> getFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }
}
