package encryptdecrypt;

import java.util.Scanner;
/*TO DO: more elegant parsing of arguments*/
public class Main {
    public static void main(String[] args) {
        String input = "";
        String output = "";
        String data = "";
        String mode = "enc";
        String algo = "shift";
        int key = 0;

        CypherIO io = new CypherIO();
        EncryptAction ea = new EncryptAction();


        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    if (i + 1 < args.length)
                        mode = args[i + 1];
                    break;

                case "-alg":
                    if (i + 1 < args.length)
                        algo = args[i + 1];
                    break;

                case "-key":
                    if (i + 1 < args.length)
                        key = Integer.valueOf(args[i + 1]);
                    break;

                case "-data":
                    if (i + 1 < args.length)
                        data = args[i + 1];
                    break;

                case "-in":
                    if (i + 1 < args.length)
                        input = args[i + 1];
                    break;

                case "-out":
                    if (i + 1 < args.length)
                        output = args[i + 1];
                    break;
            }
        }

        switch (mode) {
            case "enc":
                if (!output.isEmpty()) {
                    /*use specified algorithm then print to file*/
                    if (!algo.equalsIgnoreCase("shift")) {
                        if (data.isEmpty()) {
                            io.writeFile(output, ea.unicodeEncryption(io.readFile(input), key));
                        } else {
                            io.writeFile(output, ea.unicodeEncryption(data, key));
                        }
                    } else {
                        if (data.isEmpty()) {
                            io.writeFile(output, ea.shiftEncryption(io.readFile(input), key));
                        } else {
                            io.writeFile(output, ea.shiftEncryption(data, key));
                        }
                    }

                } else {
                    /*use specified algorithm then print to standard output*/
                    if(!algo.equalsIgnoreCase("shift")) {
                        if (data.isEmpty()) {
                            System.out.println(ea.shiftEncryption(io.readFile(input), key));
                        } else {
                            System.out.println(ea.shiftEncryption(data, key));
                        }
                    } else {
                        if (data.isEmpty()) {
                            System.out.println(ea.shiftEncryption(io.readFile(input), key));
                        } else {
                            System.out.println(ea.shiftEncryption(data, key));
                        }

                    }
                }

                //end case
                break;

            case "dec": {
                if (!output.isEmpty()) {
                    /*use specified algorithm then print to file*/
                    if (!algo.equalsIgnoreCase("shift")) {
                        if (data.isEmpty()) {
                            io.writeFile(output, ea.unicodeDecryption(io.readFile(input), key));
                        } else {
                            io.writeFile(output, ea.unicodeDecryption(data, key));
                        }
                    } else {
                        if (data.isEmpty()) {
                            io.writeFile(output, ea.shiftDecryption(io.readFile(input), key));
                        } else {
                            io.writeFile(output, ea.shiftDecryption(data, key));
                        }
                    }

                } else {
                    /*print to standard output*/
                    if (!algo.equalsIgnoreCase("shift")) {
                        if (data.isEmpty()) {
                            System.out.println(ea.unicodeDecryption(io.readFile(input), key));
                        } else {
                            System.out.println(ea.unicodeDecryption(data, key));
                        }
                    } else  {
                        if (data.isEmpty()) {
                            System.out.println(ea.unicodeDecryption(io.readFile(input), key));
                        } else {
                            System.out.println(ea.unicodeDecryption(data, key));
                        }

                    }

                }
            }

            //end case
            break;
        }

    }

}
