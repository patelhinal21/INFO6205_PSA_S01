//package edu.neu.coe.info6205.util;
//
//import java.util.Random;
//
//public class UF_client {
//
//    public static void main(String[] args) {
//        int[] array = new int [args];
//        if (args.length == 0)
//            throw new RuntimeException("Syntax: RandomWalk steps [experiments]");
//        int n = Integer.parseInt(args[0]); // Number of sites
//        for(int i=0;i<n;i++)
//        {
//            Random r = new Random();
//            int no = r.nextInt(((end-start)+1))+start;
//            array[i]=no;
//        }
//        int m = 30;
//        if (args.length > 1) n = Integer.parseInt(args[1]);
//
//        System.out.println( " Number of Objects (N) " + n + " Number of Pairs " + m );
//    }
//
//}
