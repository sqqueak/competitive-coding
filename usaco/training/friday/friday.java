package training.friday;

/*
ID: heyitssqueak
LANG: JAVA
TASK: friday
*/
import java.io.*;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int[] numOfFridays = new int[7];

        int year = 1900;
        int weekday = 0;

        // 1st = mon : 13th = sat
        // tue : sun
        // wed : mon
        // thurs : tue
        // fri : wed
        // sat : thurs
        // sun : fri

        int target = Integer.parseInt(f.readLine()) + year;

        while(year != target) {
            if(year % 4 == 0) { 
                if(year % 400 == 0) { // leap year (366)
                    for(int month = 0; month < 12; month++) {
                        int friday = 0;
    
                        if(month == 1) { // feb
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 16) % 7;
    
                        } else if(month == 3 || month == 5 || month == 8 || month == 10) { // 30 days
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 17) % 7;
    
                        } else { // 31 days
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 18) % 7;
                        }
                    }

                } else if(year % 100 == 0) { // not leap year (365)
                    for(int month = 0; month < 12; month++) {
                        int friday = 0;
    
                        if(month == 1) { // feb
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 15) % 7;
    
                        } else if(month == 3 || month == 5 || month == 8 || month == 10) { // 30 days
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 17) % 7;
    
                        } else { // 31 days
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 18) % 7;
                        }
                    }
                } else { // leap year (366)
                    for(int month = 0; month < 12; month++) {
                        int friday = 0;
    
                        if(month == 1) { // feb
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 16) % 7;
    
                        } else if(month == 3 || month == 5 || month == 8 || month == 10) { // 30 days
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 17) % 7;
    
                        } else { // 31 days
                            friday = (weekday + 13) % 7;
                            numOfFridays[friday]++;
    
                            weekday = (friday + 18) % 7;
                        }
                    }
                }

            } else { // not leap year (365)
                for(int month = 0; month < 12; month++) {
                    int friday = 0;

                    if(month == 1) { // feb
                        friday = (weekday + 13) % 7;
                        numOfFridays[friday]++;

                        weekday = (friday + 15) % 7;

                    } else if(month == 3 || month == 5 || month == 8 || month == 10) { // 30 days
                        friday = (weekday + 13) % 7;
                        numOfFridays[friday]++;

                        weekday = (friday + 17) % 7;

                    } else { // 31 days
                        friday = (weekday + 13) % 7;
                        numOfFridays[friday]++;

                        weekday = (friday + 18) % 7;
                    }
                }
            }

            year++;
        }

        out.print(numOfFridays[6]);
        for(int i = 0; i < numOfFridays.length -1; i++) {
            out.print(" " + numOfFridays[i]);
        }
        out.println();

        out.close();
        f.close();
    }
}