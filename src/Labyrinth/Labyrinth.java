package Labyrinth;

public class Labyrinth {

    final int sizeX;
    final int sizeY;
    final Field[][] fieldArray;

    public Labyrinth(int sizeX, int sizeY) {
        this.sizeX = sizeX + 2;
        this.sizeY = sizeY + 2;
        this.fieldArray = new Field[this.sizeY][this.sizeX];
        insertFields();
    }

    void showLabyrinth() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                sb.append(fieldArray[i][j].getSign());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    void insertFields() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (j != 0 && j != sizeX-1 && i != 0 && i != sizeY-1) {
                    fieldArray[i][j] = new Field(j, i);
                } else {
                    fieldArray[i][j] = new Barrier(j, i);
                }
            }
        }
    }
}
