package Assignment_Reports;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

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
        new Assignment3(100, 1000, 1000).runBenchmarks();
        new Assignment3(50, 2000, 2000).runBenchmarks();
        new Assignment3(20, 4000, 4000).runBenchmarks();
        new Assignment3(10, 8000, 8000).runBenchmarks();
        new Assignment3(5, 16000, 16000).runBenchmarks();

    }

    private void benchmarkGeneric(final String description, int n, int m) {
        int start= -m;
         int end= m-1;
         int mid= m/2;

        switch (description) {
            case"randomArray" :

                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                }
                break;
            case "orderedArray":

                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                    Arrays.sort(array);
                }
                break;
            case "partially-orderedArray":

                for(int i=0;i<n;i++)
                {
                    Random r = new Random();
                    int no = r.nextInt(((end-start)+1))+start;
                    array[i]=no;
                    Arrays.sort(array,0,mid);
                }
                break;
            case "reverse-orderedArray":

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
        Benchmark_Timer object = new Benchmark_Timer<>("description",null,array->insertionSort.sort((Integer[]) array,0,n),null);
        double time = object.run(array,m);
        System.out.println(description + " time taken for " + n + " runs " + time);

    }
    private final int runs;
    private final int n;
    private final int m;
    private Integer[] array;
}
