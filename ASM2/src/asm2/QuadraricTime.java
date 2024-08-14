/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author User
 */
public class QuadraricTime {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printAllPairs(arr);
    }

    public static void printAllPairs(int[] arr) {
        for (int i : arr) {
            for (int j : arr) {
                System.out.println("(" + i + ", " + j + ")"); // O(N^2)
            }
        }
    }
}
