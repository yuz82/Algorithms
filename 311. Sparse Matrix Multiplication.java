/**
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] res = new int[m][nB];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]!=0){
                    for(int k=0;k<nB;k++){
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}


//new data structure
public class Solution {
    class Node{
        int index;
        int value;
        Node(int i, int v){
            this.index = i; this.value = v;
        }
    }
    int m, n, nB;
    public int[][] multiply(int[][] A, int[][] B) {
        if(A==null || B==null || A.length==0 || B.length==0) { return new int[0][0]; }
        this.m = A.length;
        this.n = A[0].length;
        this.nB = B[0].length;
        int[][] res = new int[m][nB];
        List<Node> a = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]!=0){
                    a.add(new Node(i*n+j, A[i][j]));
                }
            }
        }
        List<Node> b = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<nB;j++){
                if(B[i][j]!=0){
                    b.add(new Node(i*nB+j, B[i][j]));
                }
            }
        }
        for(Node na : a){
            int ai = na.index/n, aj = na.index%n;
            for(Node nb : b){
                int bi = nb.index/nB, bj = nb.index%nB;
                if(aj==bi){
                    res[ai][bj] += na.value * nb.value;
                }
            }
        }
        return res;
    }
}
