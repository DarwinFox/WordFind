//*********************************************************
// WordFind.java   Author:  Harrison Fox
// 
// This program takes in a number of files from the
// command line and determines if the specified 
// word in the command line exists in the 
// text of the given files.
//
//**********************************************************


import java.io.*;
import java.util.*;

public class WordFind
{

//*************************************************************************
// The main method here makes sure that there are at least two 
// arguments passed into the program at the command line.
// Then it proceeds to locate any copies of that word in the given
// files regardless of case.
//*************************************************************************

        public static void main(String[] args)
        {

                if (args.length < 2)
                {
                System.out.println("Please enter a word to find and at least one file in command line.");
                System.exit(1);// The program exits if you have fewer than two arguments in the command line.
                }

                String wordToLocate = args[0];  // The first argument given on the command line is the word to search for.

                for(int i = 1; i < args.length; i++)

                        {

                        try
                                {

                                Scanner scan = new Scanner(new File(args [i])); //the scanner will accept a file here and scan the file.


                                while(scan.hasNextLine())
                                {
                                        String line = scan.nextLine();
                                        String lcline = line.toLowerCase();
                                        String find = wordToLocate.toLowerCase();


                                        if(lcline.indexOf(find) != -1)
                                                System.out.println(args [i]+ ":  " + line);

                         
                                }//end of while loop.
                                }//end of try.

                        catch (FileNotFoundException missing)
                        {
                		System.out.println("An Exception was found because a file may be missing.");
                                System.out.println("the exception message is: " +missing.getMessage());
                                System.out.println();
                                System.out.println("The call stack trace: ");
                                missing.printStackTrace();
                                System.out.println();
                        }
                                
                        catch (IOException bug)
                        {
                                System.out.println("An Exception was found because there may be an IO exception.");                                				   System.out.println("the exception message is: " +bug.getMessage());
                                System.out.println();
                                System.out.println("The call stack trace: ");
                                bug.printStackTrace();
                                System.out.println();
                        }
                                 
                        }//end of for loop.
                
                        
                }//end of main.
        }//end of class.
