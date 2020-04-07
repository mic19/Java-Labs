
import static java.lang.System.out;

//klasa z ktorej budowany jest stos
class Element<T>{
	Element(T elem){
		val = elem;
		prev = null;
	}

	public void setPrev(Element<T> n){
		prev = n;
	}

	public Element<T> getPrev(){
		return prev;
	}

	public T getVal(){
		return val;
	}

	public String toString(){
		return "{" + val +"} ";
	}

	protected T val;
	protected Element<T> prev;
}

//klasa stos
public class Stos<T>{
	Stos(){
		last = null;
	}

	public void push(T elem){
		if(last == null)
			last = new Element<T>(elem);
		else{
			Element<T> temp = new Element<T>(elem);
			temp.setPrev(last);
			last = temp;
		}

	}

	public T pop(){
		T temp = last.getVal();
		last = last.getPrev();
		return temp;
	}

	public String toString(){
		String str = "";

		Element<T> iter = last;
		while(iter != null){
			str += iter.toString();
			iter = iter.getPrev();
		}

		return str;
	}

	Element<T> last;

}


