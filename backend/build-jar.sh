for directory in */; do
    cd $directory
    mvn clean package
    cd ..
done