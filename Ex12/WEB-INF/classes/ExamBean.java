package Bean;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class ExamBean {
	List<String> questions,op1,op2,op3,op4;
	int result;

	public void set(List<String> q,List<String> op1,List<String> op2,List<String> op3,List<String> op4,int r) {
		this.questions = q;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.result = r;
	}
	public List<String> getQ() {
		return questions;
	}
	public List<String> getOp1() {
		return op1;
	}
	public List<String> getOp2() {
		return op2;
	}
	public List<String> getOp3() {
		return op3;
	}
	public List<String> getOp4() {
		return op4;
	}
	public int getLength() {
		return result;
	}
}
