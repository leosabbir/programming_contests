
public class Operation {
	
	private int parent;
	private int operation;
	private int op1, op2;
	
	public Operation(int parent, int operation, int op1, int op2) {
		this.parent = parent;
		this.operation = operation;
		this.op1 = op1;
		this.op2 = op2;
	}

	public int getParent() {
		return parent;
	}

	public int getOperation() {
		return operation;
	}

	public int getOp1() {
		return op1;
	}

	public int getOp2() {
		return op2;
	}
	
	// just for debugging
	public String toString(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		sb.append(" obtained from ");
		sb.append(parent);
		sb.append(" ");
		sb.append(op1);
		if (operation == 0) {
			sb.append( " add " );
		} else if (operation == 1) {
			sb.append(" multiply ");
			sb.append(op2);
		} else {
			sb.append(" swap ");
			sb.append(op2);
		}
		
		return sb.toString();
	}
	
	public String toString() {
		switch (this.operation) {
		case 0:
			return "Added " + op1;
		case 1:
			return "Multiplied " + op1 + " and " + op2;
		default:
			return "Swapped bits " + op1 + " and " + op2;
		}
	}
	
}
