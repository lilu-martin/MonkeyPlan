make:
	javac Main.java
	javac MonkeyPlan.java
	javac Move.java
	javac WorldState.java
	javac Push.java
	javac ClimbUp.java
	javac ClimbDown.java
	javac Grab.java

clean:
	rm Main.class
	rm MonkeyPlan.class
	rm Move.class
	rm WorldState.class
	rm Push.class
	rm ClimbUp.class
	rm ClimbDown.class
	rm Grab.class