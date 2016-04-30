release=$1

if [ ! -d results ]; then
	echo "Couldn't find results folder...creating"
	mkdir results
fi

if [ ! -d results/$release ]; then
	echo "Couldn't find results/$release folder ... creating"
	mkdir results/$release
fi

cat orig.params | sed -e s/my.sysname=x/my.sysname=$1/g > clone.params
../ssbse2016/clean.sh
SSBSEDIR=/home/cragkhit/ssbse2016

for i in `seq $2`; do
echo "execution $i"
javac -cp "./lib/ecj.23.jar" src/ssbse/MaxOnes.java -d bin/
javac -cp "./lib/ecj.23.jar:./bin/" src/ssbse/InitialPopulationGenerator.java -d bin/
java -cp "./lib/ecj.23.jar:./bin/" ssbse.InitialPopulationGenerator
java -cp "./lib/ecj.23.jar:./bin" ec.Evolve -file clone.params

count=`ls -l results/$release/ | wc -l`
count=$((($count-1)/3))
outname=out.stat.$count
logname=log.txt.$count
outputname=output.txt.$count

mv out.stat results/$release/$outname
mv $SSBSEDIR/log.txt results/$release/$logname
mv $SSBSEDIR/output.txt results/$release/$outputname

done
