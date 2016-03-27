# delete all dfr_* indexes
javac -cp "./lib/ecj.23.jar" src/ssbse/MaxOnes.java 
mv src/ssbse/MaxOnes.class bin/ssbse/MaxOnes.class 
java -cp "./lib/ecj.23.jar:./bin" ec.Evolve -file clone.params
