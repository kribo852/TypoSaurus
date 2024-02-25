package typeosaurusRexRun;

public class TestTextRepository implements TextToWriteRepository {
	
	private String typed = "";
	private String untyped ="the rain in spain stays mainly in the plane";

	@Override
	public String getUntyped() {
		return untyped;
	}

	@Override
	public String getTyped() {
		return typed;
	}

	@Override
	public void completeNextChar() {
		typed += untyped.charAt(0);
		untyped = untyped.substring(1);
		if(untyped.isEmpty()) {
			untyped = typed;
			typed = "";
		}
	}

}
