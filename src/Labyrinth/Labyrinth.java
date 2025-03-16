package Labyrinth;

public class Labyrinth {

    final int sizeX;
    final int sizeY;
    final Field[][] fieldArray;

    public Labyrinth(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.fieldArray = new Field[sizeX][sizeY];
        insertFields();
    }

    void showLabyrinth() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= sizeX; i++) {
            sb.append("|");
            for (int j = 0; j < sizeY; j++) {
                if (i < sizeX) {
                    sb.append(fieldArray[i][j].getSign());
                } else {
                    sb.append("---");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    void insertFields() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                fieldArray[j][i] = new Field(i, j);
            }
        }
    }
}
