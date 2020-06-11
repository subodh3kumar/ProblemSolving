package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05_FindProduct {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String arrayStr = br.readLine();
        String[] strs = arrayStr.split(" ");
        br.close();
        long product = 1;
        for (int i = 0; i < size; i++) {
            product = (product * Integer.parseInt(strs[i])) % ((long) Math.pow(10, 9) + 7);
        }
        System.out.println(product);
    }
}
