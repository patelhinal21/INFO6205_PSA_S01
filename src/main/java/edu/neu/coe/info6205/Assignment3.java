package edu.neu.coe.info6205;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Utilities;

import java.util.Arrays;
import java.util.Random;

public class Assignment3 {

    public Assignment3(int runs, int n, int m) {
        this.runs = runs;
        this.n = n;
        this.m = m;
        this.array = new Integer[n];
    }


   public void runBenchmarks() {

        benchmarkGeneric("randomArray", n,m);
        benchmarkGeneric("orderedArray",n,m);
        benchmarkGeneric("partially-orderedArray",  n,m);
        benchmarkGeneric("reverse-orderedArray",  n,m);
    }

    public static void main(String[] args) {
        new Assignment3(100, 250, 250).runBenchmarks();
        new Assignment3(50, 500, 500).runBenchmarks();
        new Assignment3(20, 1000, 1000).runBenchmarks();
        new Assignment3(10, 2000, 2000).runBenchmarks();
        new Assignment3(5, 4000, 4000).runBenchmarks();

    }

    private void benchmarkGeneric(final String description, int n, int m) {
        int start= -m;
         int end= m-1;
         int mid= m/2;
        int desc = 4;
        switch (desc) {
            case 1:
                description.equals("randomArray");
                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                }
                break;
            case 2:
                description.equals("orderedArray");
                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                    Arrays.sort(array);
                }
                break;
            case 3:
                description.equals("partially-orderedArray");
                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                    Arrays.sort(array,0,mid);
                }
                break;
            case 4:
                description.equals("reverse-orderedArray");
                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                    Arrays.sort(array,mid+1,n-1);
                }
                break;

        }
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Benchmark_Timer object = new Benchmark_Timer<>("description",array->insertionSort.sort((Integer[]) array,0,n));
        double time = object.run(array,m);

    }
    private final int runs;
    private final int n;
    private final int m;
    private Integer[] array;
}
