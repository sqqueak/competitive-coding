/*
ID: heyitssqueak
LANG: JAVA
TASK: rut
*/
import java.io.*;
import java.util.ArrayList;

public class rut4 {
    public static class Cow {
        String direction;
        int xcoord;
        int ycoord;
        int stepsTaken;
        boolean isMoving;

        public Cow(String direction, int xcoord, int ycoord) {
            this.direction = direction;
            this.xcoord = xcoord;
            this.ycoord = ycoord;
        }

        public Cow() {

        }
    }

    public static class GrassField {
        int distanceFromLastCow;
        int xcoord;
        int ycoord;
        boolean isAssigned;
        Cow trampled;

        public GrassField(int xcoord, int ycoord) {
            this.xcoord = xcoord;
            this.ycoord = ycoord;
            isAssigned = false;
            distanceFromLastCow = (int)Float.POSITIVE_INFINITY;
        }

        public GrassField() {
            isAssigned = false;
            distanceFromLastCow = (int)Float.POSITIVE_INFINITY;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numOfCows = Integer.parseInt(f.readLine());

        String[] tempCowInput = new String[numOfCows];

        for (int i = 0; i < numOfCows; i++) {
            tempCowInput[i] = f.readLine();
        }

        String[][] coord = new String[tempCowInput.length][3];
        Cow[] cows = new Cow[numOfCows];

        for (int i = 0; i < tempCowInput.length; i++) {
            coord[i] = tempCowInput[i].split(" ");
            cows[i] = new Cow();
            cows[i].direction = coord[i][0];
            cows[i].xcoord = Integer.parseInt(coord[i][1]);
            cows[i].ycoord = Integer.parseInt(coord[i][2]);
        }

        int[][] tempCoords = new int[coord.length][2];

        for (int row = 0; row < coord.length; row++) {
            if (coord[row][0].equals("E")) {
                tempCoords[row][1] = Integer.parseInt(coord[row][2]);
            } else if ((coord[row][0]).equals("N")) {
                tempCoords[row][0] = Integer.parseInt(coord[row][1]);
            }
        }

        // for(int row = 0; row < tempCoords.length; row++) {
        // System.out.println(tempCoords[row][0] + " " + tempCoords[row][1]);
        // }

        ArrayList<int[]> coords = new ArrayList<>();

        for (int i = 0; i < tempCoords.length; i++) {
            if (tempCoords[i][0] == 0) {

            } else {
                for (int j = 0; j < tempCoords.length; j++) {
                    if (tempCoords[j][1] == 0) {

                    } else {
                        coords.add(new int[] { tempCoords[i][0], tempCoords[j][1] });
                    }
                }
            }
        }

        for(Cow singleCow : cows) {
        System.out.println(singleCow.direction + " " + singleCow.xcoord + " " +
        singleCow.ycoord);
        }

        ArrayList<GrassField> eatenGrass = new ArrayList<>();

        // while(cowUniqueCoords == false) {
        for (Cow cow : cows) {

            if (cow.direction.equals("E")) {

                for (int[] coordinate : coords) {
                    if (coordinate[1] == cow.ycoord && coordinate[0] >= cow.xcoord) {

                        eatenGrass.add(new GrassField(coordinate[0], coordinate[1]));

                        // System.out.println("ELIGIBLE COORDS FOR COW: " +
                        // cow.xcoord + " " + cow.ycoord);
                        // System.out.println(coordinate[0] + " " + coordinate[1]);
                    }
                }
            }
        }

        char[][] map = new char[1000][1000];

        for(int i = 0; i < 900; i++) {
            
            for(Cow cow : cows) {
                
                if(cow.direction.equals("E")) {
                    if(map[cow.ycoord][cow.xcoord] != 'X' && map[cow.ycoord+1][cow.xcoord] != 'X') {
                        cow.ycoord++;
                        cow.stepsTaken++;

                        for(GrassField grass : eatenGrass) {
                            if(grass.xcoord == cow.xcoord && grass.ycoord == cow.ycoord) {
                                map[grass.ycoord][grass.xcoord] = 'X';
                            }
                        }

                    } else {
                        cow.isMoving = false;
                    }
                } else if(cow.direction.equals("N")) {
                    if(map[cow.ycoord][cow.xcoord] != 'X' && map[cow.ycoord][cow.xcoord+1] != 'X') {
                        cow.stepsTaken++;
                        cow.xcoord++;

                        for(GrassField grass : eatenGrass) {
                            if(grass.xcoord == cow.xcoord && grass.ycoord == cow.ycoord) {
                                map[grass.ycoord][grass.xcoord] = 'X';
                            }
                        }
                    } else {
                        cow.isMoving = false;
                    }
                }


            }

        }

        for(Cow cow : cows) {
            if(cow.isMoving = true) {
                System.out.println("Infinity");
            } else {
                System.out.println(cow.stepsTaken);
            }
        }
    }
}
