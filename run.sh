release=$1
cat orig.params | sed -e s/my.sysname=x/my.sysname=$1/g > clone.params

for i in `seq $2`; do
echo "execution $i"
javac -cp "./lib/ecj.23.jar" src/ssbse/MaxOnes.java -d bin/
javac -cp "./lib/ecj.23.jar:./bin/" src/ssbse/InitialPopulationGenerator.java -d bin/
java -cp "./lib/ecj.23.jar:./bin/" ssbse.InitialPopulationGenerator
java -cp "./lib/ecj.23.jar:./bin" ec.Evolve -file clone.params

count=`ls -l results/$release/ | wc -l`
name=out.stat.$(($count-1))
mv out.stat results/$release/$name
done
