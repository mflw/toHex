package com.toHex;

import java.io.*;
import java.util.Scanner;

public class Main {
	

  public static void main(String[] argv) throws Exception {
  	Scanner scanner = new Scanner(System.in);
  	String input;
  	int k = 0;
  	System.out.println("toHex!");
  	while(true) {
  		k++;
  		System.out.println("Input path to file (without spaces) or drag&drop:");
  		input = scanner.next();
  		if (input.equals("exit")) System.exit(0);
    	FileInputStream fin = new FileInputStream(input);
    	FileOutputStream outputStream = new FileOutputStream("hexOut"+k+".txt");

    	int len;
    	byte data[] = new byte[16];
      System.out.println("--Reading..");
    	// Read bytes until EOF is encountered.
    	do {
      	len = fin.read(data);
      	for (int j = 0; j < len; j++) {
      		String str = "\\x"+String.format("%02x", data[j]);
      		outputStream.write(str.getBytes());
        	//System.out.print(str);
        }
    	} while (len != -1);
    	System.out.println("\nCompleted.");
      System.out.println("Saved to file: hexOut"+k+".txt");

  	}
  }

}
