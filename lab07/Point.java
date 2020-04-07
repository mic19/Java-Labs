
public class Point extends Shape{
	public Point(double x, double y){
		name = "Point";
		this.x = x;
		this.y = y;
	}

	double x;
	double y;

	public String toString(){
		return "[" + x + ", " + y + "]";
	}
}