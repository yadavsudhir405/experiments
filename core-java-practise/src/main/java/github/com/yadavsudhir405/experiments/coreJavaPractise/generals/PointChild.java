package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

/**
 * @author sudhir
 *         Date:2/4/17
 *         Time:3:11 PM
 *         Project:core-java-practise
 */
public class PointChild extends Point implements Cloneable{
    private  int z;

    public PointChild(int x, int y, int z) {
        super(x,y);
        System.out.println("Constructor got called");
        this.z = z;

    }
    public PointChild clone(){
        try {
            PointChild pointChild=(PointChild) super.clone();
            //pointChild.x=this.x;
            //pointChild.y=this.y;
            pointChild.z=this.z;
            return pointChild;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("CloneNotSupportedException");
        }

    }

    @Override
    public String toString() {
        return "PointChild{" +
                "x="+x+
                "y="+y+
                "z=" + z +
                '}';
    }
}
