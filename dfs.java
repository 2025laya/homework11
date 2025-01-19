/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deapthfirstsearch;

import java.util.Arrays;

/**
 *
 * @author DALAA
 */
public class MatrixGraph {
    int x[][];
    int dfsCounter;
    int finishCounter;
    int dfsNumber[];
    int status[];
    // 0 ==> new  , 1==> active , 2==> finish
    int finishNumber[];
    int n;
    MatrixGraph(int n){
        this.n=n;
        x=new int [n][n];
        dfsNumber= new int [n];
        finishNumber= new int [n];
        status=new int[n];
    }
    void addEdge(int i , int j){
        x[i][j]=1;
    }
    void printGraph(){
        for(int i=0 ; i <n ; i++){
        for(int j = 0 ; j < n ; j++)
            System.out.print(x[i][j]+"  ");
        System.out.println("");
    }
    }
    
    void init(){
        dfsCounter=0;
        finishCounter=0;
        for (int i =0; i<n;i++){
            status[i]=0;
        }
    }
    
    void dfs(int u){
        status[u]=1;
        System.out.println("now dfs runnig on "+u);
        dfsNumber[u]=++dfsCounter;
        for(int i=0;i<n;i++){
            if (x[u][i]==1)
               if(status[i]==0) 
                   dfs(i);
        }
        status[u]=2;
        finishNumber[u]=++finishCounter;
    }
    void printDfsNumber(){
        for(int i =0;i<n;i++){
            System.out.print(dfsNumber[i]+"  ");
        }
    }
    
    void DFSG(){
        for (int i= 0 ; i< n ; i++){
            if (status[i]==0)
                dfs (i);
        }
    }
    
}
*********************


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deapthfirstsearch;

/**
 *
 * @author RAND
 */
public class DeapthFirstSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatrixGraph g = new MatrixGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 0);
        g.addEdge(3, 2);
        g.dfs(0);
        g.printGraph();
        System.out.println("");
        g.printDfsNumber();
        
        System.out.println("\n*******");
        g.DFSG();
        g.printDfsNumber();
    }
    
}
//رند حمد , دلع سعيد