package app.parser;

public class Main {

	public static void main(String[] args) {
		GoogleResultParser parser = new GoogleResultParser();
		parser.run(args[0]);
	}
}
