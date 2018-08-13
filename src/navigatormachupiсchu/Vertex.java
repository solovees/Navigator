

package navigatormachupiсchu;

import java.util.ArrayList;


public class Vertex {

    private char label;
    private boolean isVisited;
    private int value;
    private int x;
    private int y;
    ArrayList indNeib = new ArrayList();
    
    public Vertex(char label)
    {
        this.label = label;
        isVisited = false;
        this.value = 0;
    }
    
    public Vertex(char label, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.label = label;
        isVisited = false;
        this.value = 0;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.x = y;
    }
    
    public int getY(){
        return y;
    }
    
    public char getLabel() {
        return label;
    }
 
    public void setLabel(char label) {
        this.label = label;
    }
 
    public boolean isVisited() {
        return isVisited;
    }
 
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    public int getValue(){
        return value;
    }
    
    public Vertex getNaiverov(int i){
        return (Vertex) indNeib.get(i);
    }
    
    public void setValue( int value){
        this.value = value;
    }
}
