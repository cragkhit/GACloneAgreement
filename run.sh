javac -cp "./lib/ecj.23.jar" src/ssbse/MaxOnes.java -d bin/
javac -cp "./lib/ecj.23.jar:./bin/" src/ssbse/InitialPopulationGenerator.java -d bin/
java -cp "./lib/ecj.23.jar:./bin/" ssbse.InitialPopulationGenerator
java -cp "./lib/ecj.23.jar:./bin" ec.Evolve -file clone.params
