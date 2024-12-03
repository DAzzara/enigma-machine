public class Rotor {
	String rotorString;
	int top;
	int notch;
	
	public Rotor(char rotor, char startChar) {
		top = startChar - 65;
		
		switch(rotor - 48) {
		case 1:
			rotorString = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
			notch = 16;
			break;
		case 2:
			rotorString = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
			notch = 4;
			break;
		case 3:
			rotorString = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
			notch = 21;
			break;
		case 4:
			rotorString = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
			notch = 9;
			break;
		case 5:
			rotorString = "VZBRGITYUPSDNHLXAWMJQOFECK";
			notch = 25;
			break;
		}
	}

	public boolean rotate() {
		boolean moveNext = top == notch;
		top++;
		top %= 26;
		return moveNext;
	}

	public char fromLeft(char in) {
		in += top;
		if(in > 90) {
			in -= 26;
		}

		int outInt = (char) rotorString.indexOf(in);

		outInt -= top;
		if(outInt < 0) {
			outInt += 26;
		}
		return (char) ((outInt %26) + 65);
	}

	public char fromRight(char in) {
		int index = in - 65;
		index += top;

		char out = rotorString.charAt(index%26);

		int outInt = (out - 65) - top;
		if(outInt < 0) {
			outInt += 26;
		}
		return (char) ((outInt %26) + 65);
	}

	public boolean canDoubleStep() {
		return top == notch;
	}
	
}
