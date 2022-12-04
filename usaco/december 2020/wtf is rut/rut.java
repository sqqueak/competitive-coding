
// /*
// ID: heyitssqueak
// LANG: JAVA
// TASK: rut
// */
// import java.io.*;
// import java.util.ArrayList;

// public class rut {

//     public static class Cow {
//         String direction;
//         int xcoord;
//         int ycoord;
//         GrassField grass;
//         int stepsTaken;
//         boolean isMoving;

//         public Cow(String direction, int xcoord, int ycoord) {
//             this.direction = direction;
//             this.xcoord = xcoord;
//             this.ycoord = ycoord;
//         }

//         public Cow() {

//         }
//     }

//     public static class GrassField {
//         int distanceFromLastCow;
//         int xcoord;
//         int ycoord;
//         boolean isAssigned;
//         Cow trampled;

//         public GrassField(int xcoord, int ycoord) {
//             this.xcoord = xcoord;
//             this.ycoord = ycoord;
//             isAssigned = false;
//             distanceFromLastCow = (int)Float.POSITIVE_INFINITY;
//         }

//         public GrassField() {
//             isAssigned = false;
//             distanceFromLastCow = (int)Float.POSITIVE_INFINITY;

//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//         int numOfCows = Integer.parseInt(f.readLine());

//         String[] tempCowInput = new String[numOfCows];

//         for (int i = 0; i < numOfCows; i++) {
//             tempCowInput[i] = f.readLine();
//         }

//         String[][] coord = new String[tempCowInput.length][3];
//         Cow[] cows = new Cow[numOfCows];

//         for (int i = 0; i < tempCowInput.length; i++) {
//             coord[i] = tempCowInput[i].split(" ");
//             cows[i] = new Cow();
//             cows[i].direction = coord[i][0];
//             cows[i].xcoord = Integer.parseInt(coord[i][1]);
//             cows[i].ycoord = Integer.parseInt(coord[i][2]);
//         }

//         // for(Cow singleCow : cows) {
//         // System.out.println(singleCow.direction + " " + singleCow.xcoord + " " +
//         // singleCow.ycoord);
//         // }

//         int[][] tempCoords = new int[coord.length][2];

//         for (int row = 0; row < coord.length; row++) {
//             if (coord[row][0].equals("E")) {
//                 tempCoords[row][1] = Integer.parseInt(coord[row][2]);
//             } else if ((coord[row][0]).equals("N")) {
//                 tempCoords[row][0] = Integer.parseInt(coord[row][1]);
//             }
//         }

//         // for(int row = 0; row < tempCoords.length; row++) {
//         // System.out.println(tempCoords[row][0] + " " + tempCoords[row][1]);
//         // }

//         ArrayList<int[]> coords = new ArrayList<>();

//         for (int i = 0; i < tempCoords.length; i++) {
//             if (tempCoords[i][0] == 0) {

//             } else {
//                 for (int j = 0; j < tempCoords.length; j++) {
//                     if (tempCoords[j][1] == 0) {

//                     } else {
//                         coords.add(new int[] { tempCoords[i][0], tempCoords[j][1] });
//                     }
//                 }
//             }
//         }

//         // for(int[] temp : coords) {
//         // System.out.println(temp[0] + " " + temp[1]);
//         // }

//         boolean cowUniqueCoords = false;
//         ArrayList<GrassField> eatenGrass = new ArrayList<>();

//         // while(cowUniqueCoords == false) {
//         for (Cow cow : cows) {

//             if (cow.direction.equals("E")) {

//                 for (int[] coordinate : coords) {
//                     if (coordinate[1] == cow.ycoord && coordinate[0] >= cow.xcoord) {

//                         eatenGrass.add(new GrassField(coordinate[0], coordinate[1]));

//                         // System.out.println("ELIGIBLE COORDS FOR COW: " +
//                         // cow.xcoord + " " + cow.ycoord);
//                         // System.out.println(coordinate[0] + " " + coordinate[1]);
//                     }
//                 }
//             }
//         }

//         // for (GrassField grass : eatenGrass) {
//         //     System.out.println(grass.xcoord + " " + grass.ycoord);
//         // }

//         // for(Cow cow : cows) {
//         //     System.out.println(cow.xcoord + " " + cow.ycoord);
//         // }

//         // char[][] grassmap = new char[1000][1000];

//         // for(int i = 0; i < 500; i++) {
//         //     for(Cow cow : cows) {

//                 if(cow.direction.equals("E")) {
//                     if(grassmap[cow.ycoord][cow.xcoord] != 'X') {
//                         for(GrassField grass : eatenGrass) {
//                             if(grass.xcoord == cow.xcoord && grass.ycoord == cow.ycoord) {
//                                 grassmap[grass.ycoord][grass.xcoord] = 'X';
//                                 cow.stepsTaken = i;
//                             }
//                         }
//                         cow.ycoord++;
//                     } else {
//                         cow.isMoving = false;
//                     }
//                 } else if(cow.direction.equals("N")) {
//                     if(grassmap[cow.ycoord][cow.xcoord] != 'X') {
//                         for(GrassField grass : eatenGrass) {
//                             if(grass.ycoord == cow.ycoord && grass.xcoord == cow.xcoord) {
//                                 grassmap[grass.ycoord][grass.xcoord] = 'X';
//                                 cow.stepsTaken = i;
//                             }
//                         }
//                         cow.xcoord++;
//                     } else {
//                         cow.isMoving = false;
//                     }
//                 }
//             }
//         }

//         for(GrassField grass : eatenGrass) {
//             System.out.println(grass.xcoord + " " + grass.ycoord);
//         }

//         // for(Cow cow : cows) {

//         //     System.out.println("Infinity");
//         //     // if(cow.isMoving == true) {
//         //     //     System.out.println("Infinity");
//         //     // } else {
//         //     //     System.out.println(cow.stepsTaken);
//         //     // }
//         // }


//         for(GrassField grass: eatenGrass) {

//             for(Cow cow : cows) {
                
//                 if(cow.direction.equals("E")) {
//                     if(grass.ycoord == cow.ycoord && grass.xcoord - cow.xcoord < grass.distanceFromLastCow) {
//                         grass.distanceFromLastCow = grass.xcoord - cow.xcoord;
//                         grass.isAssigned = true;
//                         grass.trampled = cow;
//                         cow.grass = grass;
//                     }
//                 } else if(cow.direction.equals("N")) {
//                     if(grass.xcoord == cow.xcoord && grass.ycoord - cow.ycoord < grass.distanceFromLastCow) {
//                         grass.distanceFromLastCow = grass.ycoord - cow.ycoord;
//                         grass.isAssigned = true;
//                         grass.trampled = cow;
//                         cow.grass = grass;
//                     }
//                 }
//             }
//         }

//         for(GrassField grass : eatenGrass) {
//             System.out.println(grass.distanceFromLastCow);
//         }

//         // for(Cow cow1 : cows) {

//         //     for(Cow cow2 : cows) {

//         //         if(cow1.grass != null && cow2.grass != null && cow1.grass.equals(cow2.grass)) {
                    
//         //             if(cow1.direction.equals("E")) {
//         //                 if(cow1.grass.ycoord - cow1.ycoord > cow2.grass.xcoord - cow2.xcoord) {
//         //                     cow2.grass = null;
//         //                 } else if(cow1.grass.xcoord - cow1.xcoord < cow2.grass.ycoord - cow2.ycoord){
//         //                     cow1.grass = null;
//         //                 }

//         //             } else if(cow1.direction.equals("N")) {
//         //                 if(cow1.grass.xcoord - cow1.xcoord > cow2.grass.ycoord - cow2.ycoord) {
//         //                     cow2.grass = null;
//         //                 } else if(cow1.grass.xcoord - cow1.xcoord < cow2.grass.ycoord - cow2.ycoord){
//         //                     cow1.grass = null;
//         //                 }
//         //             }


//                 //}

//             //}
//         //

//         for(Cow cow : cows) {
//             if(cow.grass.trampled == cow) {
//                 System.out.println("Infinity");
//             } else {
//                 System.out.println(cow.grass.distanceFromLastCow);
//             }
//         }



//         // for(Cow cow : cows) {

//         //     if(cow.direction.equals("E")) {

//         //         for(GrassField grass : eatenGrass) {
//         //             if(grass.ycoord == cow.ycoord) {
//         //                 if(cow.xcoord < grass.xcoord) {
//         //                     grass.distanceFromLastCow = grass.xcoord - cow.xcoord;
//         //                     cow.grass = grass;
//         //                 }
//         //             } 
//         //         }

//         //     } else if(cow.direction.equals("N")) {
//         //         for(GrassField grass : eatenGrass) {
//         //             if(grass.xcoord == cow.xcoord) {
//         //                 if(cow.ycoord < grass.ycoord) {
//         //                     grass.distanceFromLastCow = grass.ycoord - cow.ycoord;
//         //                     cow.grass = grass;
//         //                 }
//         //             } 
//         //         }
//         //     }
//         // }

//         // for(GrassField grass : eatenGrass) {
//         //     System.out.println(grass.distanceFromLastCow);
//         // }


//         // for(Cow cow : cows) {
//         //     for(Cow cow2 : cows) {
//         //         if()
//         //     }
//         // }

//         // for(Cow cow : cows) {
//         //     System.out.println(cow.grass.distanceFromLastCow);
//         // }

//         // for(Cow cow : cows) {
//         //     if(cow.grass == null) {
//         //         System.out.println("Infinity");
//         //     } else {
//         //         System.out.println(cow.grass.distanceFromLastCow);
//         //     }
//         // }

//         // }

//     }
// }