make:
	javac Main.java
	javac MonkeyPlan.java
	javac Move.java
	javac WorldState.java

clean:
	rm Main.class
	rm MonkeyPlan.class
	rm Move.class
	rm WorldState.class