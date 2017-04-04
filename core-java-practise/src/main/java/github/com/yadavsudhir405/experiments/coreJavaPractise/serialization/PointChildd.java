package github.com.yadavsudhir405.experiments.coreJavaPractise.serialization;

import github.com.yadavsudhir405.experiments.coreJavaPractise.generals.Point;

/**
 * @author sudhir
 *         Date:2/4/17
 *         Time:3:21 PM
 *         Project:core-java-practise
 */
public class PointChildd extends Point {
    private int z;
    public PointChildd(int x, int y,int z) {
        super(x,y);
        this.x=x;
    }
    public PointChildd clone(){
        return new PointChildd(x,y,this.z);
    }

}
