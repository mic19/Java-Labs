
public class Square extends Point{
	public Square(double z, double x, double y){
		super(x, y);
		name = "Square";
		side = z;
	}
	
	double side;

	public String toString(){
		return "Corner = " + super.toString() + "; side = " + side;
	}

	public double area(){
		return side*side;
	}
}