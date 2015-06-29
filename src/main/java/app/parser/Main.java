package app.parser;

public class Main {

	public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You should provide search query.");
            return;
        }
		GoogleResultParser parser = new GoogleResultParser();
		parser.run(args[0]);
	}
}
