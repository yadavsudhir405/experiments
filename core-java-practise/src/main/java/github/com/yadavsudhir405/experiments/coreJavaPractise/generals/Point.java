package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

/**
 * @author sudhir
 *         Date:2/4/17
 *         Time:3:09 PM
 *         Project:core-java-practise
 */
public class Point  {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    /*public Point clone() throws CloneNotSupportedException{
        Point point=(Point) super.clone();
        point.x=x;
        point.y=y;
        return point;
    }*/
    public void display(){

    }

    protected int getX() {
        return x;
    }
    protected int getY(){
        return y;
    }
}
