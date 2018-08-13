package navigatormachupiсchu;
import java.io.PrintStream;
import navigatorI.Navigator;

 
/**
 *
 * @author Егор Соловьев
 */

public class NavigatorMachuPiсchu implements Navigator{

    public void printM(char[][] map){
          
               System.out.print('\n');
               for(int i = 0; i < map.length; i ++){
                    System.out.print('\n');
                    for(int j = 0; j < map[0].length ; j ++){
                        System.out.print(map[i][j]);  
                }
            }
    }

    @Override
    public char[][] searchRoute(char[][] map) {
        
        
        Graph g = new Graph();
        
        int maxSizeI = map.length;
        int maxSizeJ = map[0].length;  
        //System.out.println(maxSizeI);
       // System.out.println(maxSizeJ);
        for(int i = 0; i < maxSizeI; i ++){
            for(int j = 0; j < maxSizeJ; j ++){
                char s = map[i][j];
                g.addVertex(s,j,i);      
            }
        }
       
        for(int i = 0 ; i < maxSizeI; ++i){
           for(int j = 0 ; j < maxSizeJ; ++j){
               if(map[i][j] != '#'){
               if( i < maxSizeI-1 && (map[i+1][j] == '.' || map[i+1][j] == '@' || map[i+1][j] == 'x')){
                   g.addEdge((i*maxSizeJ)+j, ((i+1)*maxSizeJ)+j);
               }
               if( i > 0 && (map[i-1][j] == '.' || map[i-1][j] == '@' || map[i-1][j] == 'x')){
                  g.addEdge((i*maxSizeJ)+j, ((i-1)*maxSizeJ)+j);
               }
               if( j < maxSizeJ-1 && (map[i][j+1] == '.' || map[i][j+1] == '@' || map[i][j+1] == 'x')){
                  g.addEdge((i*maxSizeJ)+j, i*maxSizeJ+j+1);
               }
               if( j > 0 && (map[i][j-1] == '.' || map[i][j-1] == '@' || map[i][j-1] == 'x')){
                  g.addEdge((i*maxSizeJ)+j, i*maxSizeJ+j-1);
               }
           }
           }
        }
       
        int start = 0;
        int stI = 0 ;
        int stJ = 0 ;
        // поиск старта 
        for(int i = 0 ; i < maxSizeI; ++i)
           for(int j = 0 ; j < maxSizeJ; ++j)
               if (map[i][j]== '@'){
                   start = maxSizeJ*i+j;
                   stI = i ;
                   stJ = j ;
                   break;
               }
         
        // поиск финиша
        int finI = 0;
        int finJ = 0;
         for(int i = 0 ; i < maxSizeI; ++i)
           for(int j = 0 ; j < maxSizeJ; ++j)
               if (map[i][j] == 'x'){
                   
                   finI = i ;
                   finJ = j ;
                   break;
               }
         
         
       g.bfs(start);
       
       if(g.getVertex()[finI*maxSizeJ+finJ].getValue() == 0){
           return null;
       }
       
       while(maxSizeJ*finI+finJ != maxSizeJ*stI+stJ ){
           int c = 0;
           //System.out.print("yyyyy");
           if((finI < maxSizeI-1 && g.getVertex()[maxSizeJ*(finI+1)+finJ].getValue()+1 == g.getVertex()[maxSizeJ*finI+finJ].getValue() ) && map[finI+1][finJ] != '#'){
               finI++;
               map[finI][finJ] = '+';
               //printM(map);
               
         
           }
           else if((finI > 0 && g.getVertex()[maxSizeJ*(finI-1)+finJ].getValue()+1 == g.getVertex()[maxSizeJ*finI+finJ].getValue()) && map[finI-1][finJ] != '#'){
               finI = finI-1;
               map[finI][finJ] = '+';
               //printM(map);
             
           }
           else if((finJ < maxSizeJ-1 && g.getVertex()[maxSizeJ*finI+finJ+1].getValue()+1 == g.getVertex()[maxSizeJ*finI+finJ].getValue() ) && map[finI][finJ+1] != '#' ){
               finJ = finJ+1;
               map[finI][finJ] = '+';
               //printM(map);
       
           }
           else if((finJ > 0 && g.getVertex()[(maxSizeJ*finI)+finJ-1].getValue()+1 == g.getVertex()[maxSizeJ*finI+finJ].getValue() ) && map[finI][finJ-1] != '#'){
               finJ = finJ-1;
               map[finI][finJ] = '+';
               //printM(map);
         
       }
       }
       
       
       map[stI][stJ] = '@';
       
           
       
        
        
        return map;
       
       
    }
}     

