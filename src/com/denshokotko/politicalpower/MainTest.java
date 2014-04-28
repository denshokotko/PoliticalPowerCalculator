package com.denshokotko.politicalpower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	
	
	  public static long nextPermutation(long x) {
		    long s = x & -x;
		    long r = x + s;
		    long ones = x ^ r;
		    ones = (ones >> 2) / s;
		    return r | ones;
		  }

		  public static boolean nextPermutation(int[] p) {
		    for (int a = p.length - 2; a >= 0; --a)
		      if (p[a] < p[a + 1])
		        for (int b = p.length - 1;; --b)
		          if (p[b] > p[a]) {
		            int t = p[a];
		            p[a] = p[b];
		            p[b] = t;
		            for (++a, b = p.length - 1; a < b; ++a, --b) {
		              t = p[a];
		              p[a] = p[b];
		              p[b] = t;
		            }
		            return true;
		          }
		    return false;
		  }

		  public static void generatePermutations(int[] p, int depth) {
		    int n = p.length;
		    if (depth == n) {
		      System.out.println(Arrays.toString(p));
		      return;
		    }
		    for (int i = 0; i < n; i++) {
		      if (p[i] == 0) {
		        p[i] = depth;
		        generatePermutations(p, depth + 1);
		        p[i] = 0;
		      }
		    }
		  }

		  public static long permNumber(int[] p) {
		    int n = p.length;
		    long[] fact = new long[n];
		    fact[0] = 1;
		    for (int i = 1; i < n; i++) {
		      fact[i] = i * fact[i - 1];
		    }
		    long res = 0;
		    for (int i = 0; i < n; i++) {
		      int a = p[i];
		      for (int j = 0; j < i; j++) {
		        if (p[j] < p[i]) {
		          --a;
		        }
		      }
		      res += a * fact[n - 1 - i];
		    }
		    return res;
		  }

		  public static List<List<Integer>> decomposeIntoCycles(int[] p) {
		    int n = p.length;
		    boolean[] vis = new boolean[n];
		    List<List<Integer>> res = new ArrayList<List<Integer>>();
		    for (int i = 0; i < n; i++) {
		      if (vis[i])
		        continue;
		      int j = i;
		      List<Integer> cur = new ArrayList<Integer>();
		      do {
		        cur.add(j);
		        vis[j] = true;
		        j = p[j];
		      } while (j != i);
		      res.add(cur);
		    }
		    return res;
		  }

		  // Usage example
		  public static void main(String[] args) {
		   
		    int[] p = {0, 1, 2, 3, 4, 5};
		    int counter = 0;
		    do {
		      System.out.println(Arrays.toString(p));
		      counter++;
		    } while (nextPermutation(p));

		 System.out.println(counter);
		  }
	
	
	
	// это наша рекусивная метода
	/*
	static void printRes(char[] arr, char[] res, int index) {
	       if (index == arr.length) {
	           System.out.println(Arrays.toString(res));
	           if (allNumbersUnique(res)) {
	        	   addToUnique
	           }
	           return;
	       }

	       for (char c : arr) {
	           res[index] = c;
	           printRes(arr, res, index + 1);
	       }
	   }

	   public static void main(String[] args) {
	       char[] arr = {'1','2','3', '4','5','6'};
	       char[] res = new char[arr.length];
	       printRes(arr, res, 0);
	       
	   }
	   */
	
	
	
	
	   
}
