import java.util.LinkedList;
import java.util.Scanner;

public class usaco2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[] idealTemp = sc.nextLine().split(" ");
        String[] currTemp = sc.nextLine().split(" ");
        sc.close();

        int[] ideal = new int[size];
        int[] curr = new int[size];
        LinkedList<Integer> diff = new LinkedList<>();

        for(int i = 0; i < size; i++) {
            ideal[i] = Integer.parseInt(idealTemp[i]);
            curr[i] = Integer.parseInt(currTemp[i]);
            diff.add(ideal[i] - curr[i]);
        }
        // fin parsing data

        int moves = 0;
        
        // for(Integer i : diff) {
        //     System.out.print(i + " ");
        // }System.out.println();

        int start = 1;
        int end = 0;

        while(start<=diff.size()) {
            for(int i = start; i <= diff.size(); i++) {
                if(i == diff.size()) {
                    end = diff.size();
                    break;
                }
                if(diff.get(i) > 0 && diff.get(i-1) > 0 || diff.get(i) < 0 && diff.get(i-1) < 0) {
                    end = i;
                } else {
                    end++;
                    break;
                }
            }
            start -= 1;
            // System.out.println("START: " + start + " END: " + end);

            if(diff.get(start) > 0) {
                int prev = 0;

                for(int i = start; i < end; i++) {
                    if(diff.get(i) > prev) {
                        moves += diff.get(i)-prev;
                        //System.out.println(moves);

                        prev = diff.get(i);
                    } else {
                        prev = diff.get(i);
                    }
                }
            } else {
                int prev = 0;

                for(int i = start; i < end; i++) {
                    if(Math.abs(diff.get(i)) > prev) {
                        moves += Math.abs(diff.get(i)-prev);
                        //System.out.println(moves);

                        prev = diff.get(i);
                    } else {
                        prev = diff.get(i);
                    }
                }
            }

            // for(int i = start; i < end; i++) {
            //     if(diff.get(i) > 0) {
            //         int prev = 0;
            //         if(diff.get(i) > prev) {
            //             moves += diff.get(i)-prev;
            //             prev = diff.get(i);
            //         } else {
            //             prev = diff.get(i);
            //         }
            //     } else {
            //         int prev = 0;
            //         if(diff.get(i) < prev) {
            //             moves += Math.abs(diff.get(i));
            //             prev = diff.get(i);
            //         } else {
            //             prev = diff.get(i);
            //         }
            //     }
            // }
            start = end+1;
        }

        System.out.println(moves);


        // int c = 0;
        // // for(Integer i : diff) {
        // //     System.out.print(i + " ");
        // // }System.out.println();

        // int lowest = 100001;
        // // for(Integer i : diff) {
        // //     if(i < lowest) lowest = i;
        // // }
        // // System.out.println(lowest);
        // // for(int i = 0; i < diff.size(); i++) {
        // //     diff.set(i, diff.get(i)-lowest);
        // // }
        // // moves += Math.abs(lowest);


        // int start = 0;
        // int end = 0;

        // while(c!=1) {
        //     //find lowest in current chunk
        //     for(int i = start; i < diff.size(); i++) {
        //         if(diff.get(i) <= 0) end = i;
        //     }

        //     lowest = 100001;
        //     for(int i = start; i < end; i++) {
        //         if(diff.get(i) < lowest) lowest = diff.get(i);
        //     }

        //     for(int i = start; i < end; i++) {
        //         diff.set(i, diff.get(i)-lowest);
        //     }
        //     moves += Math.abs(lowest);
        //     c++;
        // }
        // for(Integer i : diff) {
        //     System.out.print(i + " ");
        // }System.out.println();

        // // for(Integer i : diff) {
        // //     i = i-lowest;
        // // }

        // while(c!=1) {
        //     // System.out.println(diff.size());
        //     // if(diff.size() == 1) {
        //     //     moves += Math.abs(diff.getFirst());
        //     //     diff.removeFirst();
        //     //     //System.out.println(moves);
        //     //     //break; 
            
        //     // } else if(diff.getFirst() > 0 && diff.getLast() > 0) {
        //     //     d = Math.min(diff.getFirst(), diff.getLast());
        //     //     moves += Math.abs(d);

        //     //     for(int i = 0; i < diff.size(); i++) {
        //     //         diff.set(i, diff.get(i)-d); ///////////
        //     //     }

        //     // } else if(diff.getFirst() < 0 && diff.getLast() < 0) {
        //     //     d = Math.max(diff.getFirst(), diff.getLast());
        //     //     moves += Math.abs(d);

        //     //     for(int i = 0; i < diff.size(); i++) {
        //     //         diff.set(i, diff.get(i)-d); /////////////
        //     //     }
           
        //     // } else {
        //     //     if(Math.abs(diff.getFirst()) > Math.abs(diff.getLast())) {
        //     //         d = diff.getLast();
        //     //         int counter = diff.size()-1;
        //     //         if(diff.getLast() > 0) {
        //     //             while(diff.get(counter) > 0) {
        //     //                 diff.set(counter, diff.get(counter)-d); ///////////
        //     //                 counter--;
        //     //             }

        //     //         } else {
        //     //             while(diff.get(counter) < 0) {
        //     //                 diff.set(counter, diff.get(counter)-d); /////////
        //     //                 counter--;
        //     //             }
        //     //         }
        //     //     } else {
        //     //         d = diff.getFirst();
        //     //         int counter = 0;
        //     //         if(diff.getFirst() > 0) {
        //     //             while(diff.get(counter) > 0) {
        //     //                 diff.set(counter, diff.get(counter)-d); ///////////
        //     //                 counter++;
        //     //             }

        //     //         } else {
        //     //             while(diff.get(counter) < 0) {
        //     //                 diff.set(counter, diff.get(counter)-d); /////////
        //     //                 counter++;
        //     //             }
        //     //         }
        //     //     }
        //     //     moves += Math.abs(d);
        //     // }

        //     // // System.out.println("d"+d);

        //     // while(diff.size() > 0 && diff.getFirst() == 0) {
        //     //     diff.removeFirst();
        //     // }
        //     // while(diff.size() > 0 && diff.getLast() == 0) {
        //     //     diff.removeLast();
        //     // }

        //     // System.out.println("d" + d);

            
        //     // diff.set(0, diff.getFirst()+d);
        //     // diff.set(diff.size()-1, diff.getLast()+d);

        //     // // if(diff.getFirst() > 0) {
        //     // //     diff.set(0,diff.getFirst() + d);
        //     // // } else {
        //     // //     diff.set(0,diff.getFirst() - d);
        //     // // }

        //     // // if(diff.getLast() > 0) {
        //     // //     diff.set(diff.size()-1,diff.getLast() + d);
        //     // // } else {
        //     // //     diff.set(diff.size()-1,diff.getLast() - d);
        //     // // }

        //     // // diff.set(0, diff.getFirst() - d);
        //     // // diff.set(diff.size()-1, diff.getLast() - d);
        //     // moves += Math.abs(d);

        //     // //getting rid of prev iterations 0s
        //     // while(diff.size() > 0 && diff.getFirst() == 0) {
        //     //     diff.removeFirst();
        //     //     if(diff.getFirst() > 0) {
        //     //         diff.set(0,diff.getFirst() - d);
        //     //     } else {
        //     //         diff.set(0,diff.getFirst() + d);
        //     //     }
        //     // }
        //     // while(diff.size() > 0 && diff.getLast() == 0) {
        //     //     diff.removeLast();
        //     //     if(diff.getLast() > 0) {
        //     //         diff.set(diff.size()-1,diff.getLast() - d);
        //     //     } else {
        //     //         diff.set(diff.size()-1,diff.getLast() + d);
        //     //     }
        //     // }
            
        //     // System.out.println("DSIZE:" + diff.size());
        //     for(Integer i : diff) {
        //         System.out.print(i + " ");
        //     }System.out.println();

        //     c++;
        // }
        // //System.out.println(moves);


        // // // if(diff.getFirst() == 0) diff.removeFirst(); // while it has 0s at head or tail
        // // // if(diff.getFirst() > 0 && diff.getLast() > 0 || diff.getFirst() < 0 && diff.getLast() < 0) {
        // // //     d = Math.min(diff.getFirst(), diff.getLast());
        // // //     if(diff.getFirst() > 0) {
        // // //         diff.set(0, diff.getFirst() - d);
        // // //         diff.set(diff.size()-1, diff.getLast() - d);
        // // //         moves += d;
        // // //     }
        // // // }

        // // // if(diff.getFirst() == 0) diff.removeFirst(); // while it has 0s at head or tail
        // // // if(diff.getLast() == 0) diff.removeLast(); // while it has 0s at head or tail

        // // // diff.set(0, diff.getFirst() - d);
        // // // diff.set(diff.size()-1, diff.getLast() - d);

        // // // if(diff.getFirst() > 0 && diff.getLast() > 0 || diff.getFirst() < 0 && diff.getLast() < 0) {
        // // //     d = Math.min(diff.getFirst(), diff.getLast());
        // // //     //if(diff.getFirst() > 0) {
        // // //         diff.set(0, diff.getFirst() - d);
        // // //         diff.set(diff.size()-1, diff.getLast() - d);
        // // //         moves += Math.abs(d);
        // // //     //} else {
        // // //         //diff.set(0, diff.getFirst() + d);
        // // //         //diff.set(diff.size()-1, diff.getLast() + d);
        // // //     //}
        // // // }

        // // for(Integer i : diff) {
        // //     System.out.print(i);
        // // }

        // System.out.println(moves);
    }
}
