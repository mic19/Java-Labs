
public class Cube extends Square{
	public Cube(double z, double x, double y){
		super(z,x,y);
		name = "Cube";
	}

	public String toString(){
		return super.toString() + "; depth = " + side;
	}

	public double area(){
		return 6*super.area();
	}

	public double volume(){
		return side*side*side;
	}

}