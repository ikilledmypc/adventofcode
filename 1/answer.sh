previous=100000000
count=0
while IFS= read -r line; do
 	if [ $line -gt $previous ] 
	then 
		count=$((count+1))	
	else
		echo smaller
	fi
	previous=$line
done < input.txt
echo $count
