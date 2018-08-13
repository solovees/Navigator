

package navigatormachupiсchu;


public class Graph {
    //максимальное количество вершин в графе
    private final int VERTEX_MAX = 10000;
    //массив для хранения вершин
    private Vertex[] vertexList;
    //текущее количество вершин в графе
    private int vertexCount;
    //матрица смежности
    private boolean[][] matrix;
    JQueue queue;
    
    
    public Graph()
    {
         matrix = new boolean[VERTEX_MAX][VERTEX_MAX];
        //перед началом работы заполняем матрицу смежности нулями
        for(int i = 0; i < VERTEX_MAX; i++)
            for(int j = 0; j < VERTEX_MAX; j++)
                matrix[i][j] = false;
        vertexCount = 0;
        vertexList = new Vertex[VERTEX_MAX];
        queue = new JQueue(100);
    }
    
    //добавление вершины
    public void addVertex(char label, int x, int y)
    {
        vertexList[vertexCount++] = new Vertex(label,x,y);
        
    }
    
    
    
    public Vertex[] getVertex(){
        return vertexList;
    }
    
    public int getVertexlength(){
        return vertexCount;
    }
    //добавление ребра
    public void addEdge(int begin, int end)
    {
        matrix[begin][end] = true;
        matrix[end][begin] = true;
    } 
    // добавить соседий
    
 /*   void findNaib(){
        for(int i = 0 ; i < 4; ++i){
           for(int j = 0 ; j < 4; ++j){
               if( i < 3 && vertexList[((i+1)*4)+j].getLabel() == '.' ){
                   addEdge((i*4)+j, ((i+1)*4)+j);
               }
               if( i > 0 && vertexList[((i-1)*4)+j].getLabel() == '.' ){
                  addEdge((i*4)+j, ((i-1)*4)+j);
               }
               if( j < 3 && vertexList[(i*4)+j+1].getLabel() == '.' ){
                  addEdge((i*4)+j, i*4+j+1);
               }
               if( j > 0 && vertexList[i*4+j-1].getLabel() == '.' ){
                  addEdge((i*4)+j, i*4+j-1);
               }
           }
        }
    }*/
    // добавить соседий
   /* void addNaib(){
       for(int i = 0 ; i < 4; ++i){
           for(int j = 0 ; j < 4; ++j){
               if( i < 3 && vertexListN[i+1][j].getLabel() == '.' ){
                  vertexListN[i][j].indNeib.add(vertexListN[i+1][j]);
               }
               if( i > 0 && vertexListN[i-1][j].getLabel() == '.' ){
                  vertexListN[i][j].indNeib.add(vertexListN[i-1][j]);
               }
               if( j < 3 && vertexListN[i][j+1].getLabel() == '.' ){
                  vertexListN[i][j].indNeib.add(vertexListN[i][j+1]);
               }
               if( j > 0 && vertexListN[i][j-1].getLabel() == '.' ){
                  vertexListN[i][j].indNeib.add(vertexListN[i][j-1]);
               }
               
           }*/
           
        
    
    
    
    //обход в ширину
   void bfs(int v)
   {
       vertexList[v].setVisited(true);
       
       queue.insert(v);
       int vertex;
 
       //выведем вершину, с которой начинается обход, на экран
       System.out.println("x:"+vertexList[v].getX() + "y:" + vertexList[v].getY() + " " + vertexList[v].getValue());
       
       while(!queue.isEmpty())//пока очередь не опустеет
       {
           int current = queue.pop();
           
           while((vertex = getSuccessor(current,vertexList[current].getValue())) != -1)
           {
               vertexList[vertex].setVisited(true);
              
               queue.insert(vertex);
	//вывод вершины на экран
	System.out.println("x:"+vertexList[vertex].getX() + "y:" + vertexList[vertex].getY() + " " + vertexList[vertex].getValue());
        
           }
 
       }
       
       //сброс флагов
       for(int j = 0; j < vertexCount; j++)
           vertexList[j].setVisited(false);
   } 
   //метод возвращает непосещенную вершину, смежную по отношению к v
    int getSuccessor (int v, int counter)
    {
        counter++;
    for(int j = 0; j < vertexCount; j++)
        if(matrix[v][j] == true && vertexList[j].isVisited() == false){
            vertexList[j].setValue(counter);
            return j; //возвращает первую найденную вершину
        }
            
            
    return -1; //таких вершин нет
    }

    
}
