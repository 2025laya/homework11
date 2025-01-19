
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
package stronggraph;

/**
 *
 * @author XPRISTO
 */
public class StrongGraph {
int a[][];
int dfsCounter=0;
int  finishCounter=0;
int status[];
int dfsNumber[];
int finishNumber[];
int n=0;
public StrongGraph(int m){
  n=m;
dfsNumber=new int[n] ;
finishNumber=new int[n];
status=new int[n];
}
public  StrongGraph(int n,int m){
    a=new int[n][m];
    
}
public void Graph(int n,int m)
{
for(int i=0;i<=n;i++)
    for(int j=0;j<=m;j++) 
    System.out.println(a[i][j]);
}
public void init( int a[][]){
dfsCounter=0;
finishCounter=0;
for(int i=0;i<=n;i++)
    status[i]=0;
}
public void GraphEdge(int n,int m){
    for(int i=0;i<=n;i++)
        for(int j=0;j<=m;j++)
if(a[i][j]==0){
    System.out.println("No Edge between  i and j ");
   if(a[i][j]==1) 
       System.out.println(" exists Edge btween i and j");
}
}
public void dfs (int i){
  
    status[i]=1;
    dfsCounter++;
    dfsNumber[i]=dfsCounter;
   for(int j=0;j<=n;j++){
       if (a[i][j]==1){
            if (status[j]==0) {
                dfs(j);
            }
       }
   }
   finishCounter++;
   finishNumber[i]=finishCounter;
  status[i]=2;
}
public  void StrongGraphOrNOT(int G[][],int n,int m){
ArrayList<Integer>A =new ArrayList<>();
ArrayList<Integer>B =new ArrayList<>();
 for(int i=1;i<n;i++){
 init(G);
dfs(i);
for (int j=1;j<n;j++){
    if (status[j]==2)
    A.add(j);
    if (A.size()==n)
        B.add(i);
}
 
 if(B.size()==i)
     System.out.println("TRUE");
 else System.out.println("FALSE");
 }
}
public static void main(String[] args){
 StrongGraph G=new StrongGraph(6,8)  ;
 G.GraphEdge(6,8);
  G.Graph(6,8);
 G.StrongGraphOrNOT(G.a, 6, 8);
}
 
}  




        
        
        
        




   


   

    /**
     * @param args the command line arguments
     */
 
        // TODO code application logic here
        // ليلك قرطيش , بيان الحسين , بتول حسن
    
    

