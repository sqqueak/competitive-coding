// Passport Processing

package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4 {
    public static void main(String args[]) {
        part1();
        part2();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day4\\input.txt");
        try {
            Scanner scanner = new Scanner(input);
            String user = "";

            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();

                if(currLine.isBlank()) {
                    inputs.add(user);
                    user = "";
                } else {
                    user += (currLine + " ");
                }
            }
    
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<String[]> passports = new ArrayList<>();
        for(String i : inputs) {
            passports.add(i.split(" "));
        }

        int validPassports = 0;

        for(String[] passport : passports) {
            if(passport.length == 8) {
                validPassports++;
            } else if(passport.length == 7) {
                boolean hasCid = false;
                for(String field : passport) {
                    if(field.contains("cid:")) {
                        hasCid = true;
                    };
                }

                if(!hasCid) {
                    validPassports++;
                }
            }
        }

        System.out.println(validPassports);
    }

    public static void part2() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day4\\input.txt");
        try {
            Scanner scanner = new Scanner(input);
            String user = "";

            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();

                if(currLine.isBlank()) {
                    inputs.add(user);
                    user = "";
                } else {
                    user += (currLine + " ");
                }
            }
    
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<String[]> passports = new ArrayList<>();
        for(String i : inputs) {
            passports.add(i.split(" "));
        }

        ArrayList<String[]> validPart1 = new ArrayList<>();

        for(String[] passport : passports) {
            if(passport.length == 8) {
                validPart1.add(passport);
            } else if(passport.length == 7) {
                boolean hasCid = false;
                for(String field : passport) {
                    if(field.contains("cid:")) {
                        hasCid = true;
                    };
                }

                if(!hasCid) {
                    validPart1.add(passport);
                }
            }
        }

        int validPassports = 0;

        for(String[] passport : validPart1) {
            int validity = 0;
            for(String field : passport) {
                if(field.contains("byr:")) {
                    int birthYear = Integer.parseInt(field.split(":")[1]);
                    if(birthYear >= 1920 && birthYear <= 2002) validity++;

                } else if(field.contains("iyr")) {
                    int issueYear = Integer.parseInt(field.split(":")[1]);
                    if(issueYear >= 2010 && issueYear <= 2020) validity++;

                } else if(field.contains("eyr")) {
                    int expirYear = Integer.parseInt(field.split(":")[1]);
                    if(expirYear >= 2020 && expirYear <= 2030) validity++;

                } else if(field.contains("hgt")) {
                    if(field.contains("cm")) {
                        String height = field.split(":")[1];
                        int digit = Integer.parseInt(height.split("cm")[0]);

                        if(digit >= 150 && digit <= 193) validity++;
                    } else if(field.contains("in")) {
                        String height = field.split(":")[1];
                        int digit = Integer.parseInt(height.split("in")[0]);
 
                        if(digit >= 59 && digit <= 76) validity++;
                    }

                } else if(field.contains("hcl")) {
                    String hairColor = field.split(":")[1];
                    if(hairColor.matches("#[0-9,a-f]{6}")) validity++;
                    
                } else if(field.contains("ecl")) {
                    String eyeColor = field.split(":")[1];
                    if(eyeColor.matches("(amb|blu|brn|gry|grn|hzl|oth)")) validity++;
                    
                } else if(field.contains("pid")) {
                    String passportID = field.split(":")[1];
                    if(passportID.matches("^[0-9]{9}$")) validity++;
                } else {

                }

            }

            if(validity == 7) {
                validPassports++;
                // for(String field : passport) {
                //     System.out.print(field  + " ");
                // }
                // System.out.println("\n");
            } 
        }

        System.out.println(validPassports);
    }
}
