#!/usr/bin/env bash

categories=( "simulazioni" "esami" )


# Cleaning
if [ -d "html" ]; then
	echo -n "Removing old data.."
	rm -rf "html"
	echo "done!"
fi

echo -n "Generating folder structure.."
mkdir -p "html"
echo "done!"

# Coping
for group in ${categories[@]}; do
	echo -e "\n$group"

	for proj in $(ls $group); do
		echo "  $proj"

		# Reports
		res_path="$group/$proj/build/reports/tests"
		if [ -d "$res_path" ]; then
			echo -n "    test results   "
			
			mkdir -p "html/test"
			cp -r "$res_path" "html/test/$proj"

			echo "done!"
		fi

		# Docs
		doc_path="$group/$proj/build/docs/javadoc"
		if [ -d "$doc_path" ]; then
			echo -n "    javadocs       "

			mkdir -p "html/docs"
			cp -r "$doc_path" "html/docs/$proj"

			echo "done!"
		fi
	done
done

# Fix Symlinks
touch "html/.nojekyll"

echo -e "\nComplete!"
