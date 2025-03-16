package Labyrinth;

public class Labyrinth {

    final int sizeX;
    final int sizeY;
    final Field[][] fieldArray;

    public Labyrinth(int sizeX, int sizeY) {
        this.sizeX = sizeX + 2;
        this.sizeY = sizeY + 2;
        this.fieldArray = new Field[this.sizeX][this.sizeY];
        insertFields();
    }

    void showLabyrinth() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                sb.append(fieldArray[i][j].getSign());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    void insertFields() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (j != 0 && j != sizeY-1 && i != 0 && i != sizeX-1) {
                    fieldArray[j][i] = new Field(i, j);
                } else {
                    fieldArray[j][i] = new Barrier(i, j);
                }
            }
        }
    }
}
