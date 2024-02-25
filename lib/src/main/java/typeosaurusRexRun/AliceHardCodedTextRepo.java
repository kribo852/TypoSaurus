package typeosaurusRexRun;

public class AliceHardCodedTextRepo implements TextToWriteRepository {
	
	static int letterPointer = 0;
	static String toWrite = "Presently she began again.  `I wonder if I shall fall right\n"
			+ "THROUGH the earth!  How funny it'll seem to come out among the\n"
			+ "people that walk with their heads downward!  The Antipathies, I\n"
			+ "think--' (she was rather glad there WAS no one listening, this\n"
			+ "time, as it didn't sound at all the right word) `--but I shall\n"
			+ "have to ask them what the name of the country is, you know.\n"
			+ "Please, Ma'am, is this New Zealand or Australia?' (and she tried\n"
			+ "to curtsey as she spoke--fancy CURTSEYING as you're falling\n"
			+ "through the air!  Do you think you could manage it?)  `And what\n"
			+ "an ignorant little girl she'll think me for asking!  No, it'll\n"
			+ "never do to ask:  perhaps I shall see it written up somewhere.'";
	
	String[] rows;
	int row = 0;
	String typed;
	String untyped;
	
	public AliceHardCodedTextRepo() {
		toWrite = toWrite.toLowerCase();
		toWrite = toWrite.replaceAll("[^a-z \\n]", "");
				
		rows = toWrite.split("\\n");
		
		for(int i = 0; i < rows.length; i++) {
			rows[i] = rows[i].replaceAll("[\\s]+", " ");
		}
		initForRow();
	}
	
	void initForRow() {
		untyped = rows[row];
		typed = "";
	}

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
		if(untyped.isBlank()) {
			row = (row + 1)%rows.length;
			initForRow();
		}
	}

}
