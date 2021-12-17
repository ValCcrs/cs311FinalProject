import java.util.Scanner;
import java.util.Random;

public class Dijkstras 
{
        
        private static void dijkstraAlg(int[][]adjMatrix) 
        {        
                int v =adjMatrix.length;//representative of the vertices
                boolean point[] = new boolean[v];
                int distance[] = new int[v];
                distance[0] = 0;
                for(int i = 1; i < v; i++)
                {
                        distance[i] = Integer.MAX_VALUE;
                        
                }
                
                for(int i = 0; i < v - 1; i++) {
                        //will find vertex with shortest distance
                        int minVertex = findMinVertex(distance, point);
                        point[minVertex] = true;
                        //Will explore neighbors
                        for(int j = 0; j < v; j++) {
                                if(adjMatrix[minVertex][j] != 0 && !point[j] && distance[minVertex] != Integer.MAX_VALUE) {
                                        int newDistance = distance[minVertex] + adjMatrix[minVertex][j];
                                        if(newDistance < distance[j]) {
                                                distance[j] = newDistance;
                                        }
                                }
                        }
                }
                
                for(int i = 0; i < v; i++) {
                        System.out.println( i + " " + distance[i]);
                }
        }
        
        private static int findMinVertex(int[]distance, boolean point[])
        {
                int minVertex = -1;
                for(int i = 0; i < distance.length; i ++) {
                        if(!point[i] && (minVertex == -1 || distance[i] < distance[minVertex]))
                        {
                                minVertex = i;
                                
                        }
                }
                return minVertex;
        }
        
        public static void main(String[] args) {                
                Random random = new Random();
                
                System.out.print("Please enter the width of Map: ");               
                
                Scanner scan = new Scanner(System.in);
                int v = scan.nextInt();
                int adjMatrix[][] = new int [v][v];
                for(int i = 0; i < v; i++) 
                {
                for(int j = 1; j < v; j++) 
                {
                        int v1 =  i; 
                        int v2 =  j;
                        
                        int weight = random.nextInt (100);//generating random num, weight can be any value 
                        
                        adjMatrix[v1][v2] = weight;
                        adjMatrix[v2][v1] = weight;
                }
                }
                dijkstraAlg(adjMatrix);
        }
        
}