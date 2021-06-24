package com.prac.binary.search.session.7;


import java.util.Arrays;

/*
* complexity = NlogN + 2(NlogN)

NlogN for sorting and 2 NlogN for 2 Binary Searches ( Ceil and Floor)
*
**/

public class FrequencyUsingBinarySearch {

    public static void main(String[] args) {
        int [] ary = {2, 8, 4, 10, 2, 2, 10, -6, 2, -6, 2, 10, 4, 4, 10, 10, 10, 12, 12, 21, 21};
        Arrays.sort(ary);


        for (int i=0;i<ary.length;i++){
            System.out.print(i+"   ");
        }
        System.out.println();
        for (int i : ary) {
            System.out.print(i+"   ");
        }
        findFreq(ary, 4);
    }

    private static void findFreq(int[] ary, int k) {

        int floor = BSFloor(ary, k);


        System.out.println("--------------------------Ceil---------------------");
        int ceil = BSCeil(ary, k);
        System.out.println();
        System.out.println("floor"+ floor +"-- ceil"+ ceil);

        int freq = floor-ceil+1;

        System.out.println("frequency is "+ freq);

    }

    private static int BSCeil(int[] ary, int k) {
        int lo =0,hi =ary.length-1, ans = Integer.MAX_VALUE, mid = 0;
        System.out.println();
        while(lo<=hi){
            mid = (hi+lo)/2;

            System.out.println("Lo == "+lo+ ", mid=="+mid +", Hi=="+hi);

            if(ary[mid]>= k){
                ans = mid;
                hi = mid -1;

            } else {
                lo = mid+1;
            }
        }
        return ans;
    }

    private static int BSFloor(int[] ary, int k) {

        int lo =0, hi = ary.length-1, ans = Integer.MIN_VALUE, mid =0;
        System.out.println();

        while(lo<=hi){
            mid = (hi+lo)/2;
            System.out.println("Lo == "+lo+ ", mid=="+mid +", Hi=="+hi);

            if(ary[mid] <= k){
                ans = mid;
                lo = mid +1;

            } else {
                hi = mid-1;
            }
        }
        return ans;

    }


}
