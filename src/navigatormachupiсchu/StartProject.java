

package navigatormachupiсchu;


public class StartProject {
    public static void main(String[] args) {
       
       char[][] m ={{'.','.','.','@','.'},{'#','#','#','#','.'},{'.','#','.','.','.'},{'.','.','x','.','.'}} ;
       NavigatorMachuPiсchu Navig = new NavigatorMachuPiсchu();
       m = Navig.searchRoute(m);
       if(m == null)
           System.out.print(m);
       else{
           
       for(int i = 0; i < 4; i ++){
           System.out.print('\n');
            for(int j = 0; j < 5; j ++){
                System.out.print(m[i][j]);
            }
       }
       }
       
    }
}
