import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] array) {
        int m = array.length / 2;
        Arrays.sort(array);
        return array[m];
    }
}