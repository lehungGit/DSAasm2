/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class LinearSpace {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> squares = calculateSquares(n);
        System.out.println("Squares: " + squares);
    }

    public static List<Integer> calculateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            squares.add(i * i); // O(N) space complexity
        }
        return squares;
    }
}
