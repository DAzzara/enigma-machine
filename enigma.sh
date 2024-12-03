#!/bin/bash
javac main.java
java main
find . -name "*.class" -exec rm {} \;