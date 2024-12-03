# Enigma Machine
In the first line, the program will take the code for the reflector (A/B/C), numbers for three
rotors, starting from left to right (1,2,3,4,5), and each rotor’s starting position (A-Z). In the second
line, the program will take the plugboard connection in the form of comma-separated character
pairs (“AB,JK,NR”). This list will only include valid plugboard setups (no duplicates); it may also
be empty. In the third line, the user will provide the input to the Enigma machine. Your program
should print the output.

Example 1
Input:

B123AAA

AB,CD,EF

SECURITY

Output:
JKJRFLHF

Example 2
Input:

B421ZBD

GI

SECURITY

Output:
ORBVTPIK

Run the shell script to start the code.
