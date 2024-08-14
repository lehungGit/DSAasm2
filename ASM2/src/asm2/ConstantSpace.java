/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;

/**
 *
 * @author User
 */
public class ConstantSpace {
    public static void main(String[] args) {
        int n = 10;
        int result = calculateSum(n);
        System.out.println("Sum: " + result);
    }

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i; // O(1) space complexity
        }
        return sum;
    }
}
