package Bean;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class EvalBean {
	List<String> answers;
	int result;

	public void set(List<String> a,int r) {
		this.answers = a;
		this.result = r;
	}
	public List<String> getA() {
		return answers;
	}
	public int getLength() {
		return result;
	}
}
