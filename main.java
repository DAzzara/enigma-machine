import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		
		String input1 = myObj.nextLine();
		input1 = input1.toUpperCase();
		
		String input2 = myObj.nextLine();
		input2 = input2.toUpperCase();
		
		String input3 = myObj.nextLine();
		input3 = input3.toUpperCase();
		
		myObj.close();

		String reflector = "";
		switch (input1.charAt(0)) {
		case 'A': 
			reflector = "EJMZALYXVBWFCRQUONTSPIKHGD";
			break;
		case 'B':
			reflector = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
			break;
		case 'C':
			reflector = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
			break;
		}
		
		Rotor rotorL = new Rotor(input1.charAt(1), input1.charAt(4));
		Rotor rotorM = new Rotor(input1.charAt(2), input1.charAt(5));
		Rotor rotorR = new Rotor(input1.charAt(3), input1.charAt(6));
		
		char[] plugs = new char[26];//init as null(0)
		if (!input2.isBlank()) {
			for (String str : input2.split(",")) {
				char letter1 = str.charAt(0);
				char letter2 = str.charAt(1);
				if (plugs[letter1 - 65] == 0 && plugs[letter2 - 65] == 0) {
					plugs[letter1 - 65] = letter2;
					plugs[letter2 - 65] = letter1;
				}
			} 
		}
		String output = "";
		for(char in : input3.toCharArray()) {
			char c = in;
			
			if(rotorR.rotate() || rotorM.canDoubleStep()) {
				if(rotorM.rotate()) {
					rotorL.rotate();
				}
			}
			
			if(plugs[c - 65] != 0) {
				c = plugs[c - 65];
			}
			
			c = rotorR.fromRight(c);
			c = rotorM.fromRight(c);
			c = rotorL.fromRight(c);
			
			c = reflector.charAt(c-65);
			
			c = rotorL.fromLeft(c);
			c = rotorM.fromLeft(c);
			c = rotorR.fromLeft(c);
			
			if(plugs[c - 65] != 0) {
				c = plugs[c - 65];
			}
			
			output += c;
		}

		System.out.println(output);
	}

}
