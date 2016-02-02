#!/usr/bin/env bash

categories=( "simulazioni" "esami" )

# Clean everything up
if [ -d "results" ]; then
	echo "Removing old data.."
	rm -rf "results"
fi

echo "Generating folder structure.."
mkdir -p "results"

# Iterate through projects
for group in ${categories[@]}; do
	for proj in $(ls $group); do

		# Clone results folder
		res_path="$group/$proj/build/reports/tests"

		if [ -d "$res_path" ]; then
			echo "Cloning '$group/$proj'"
			cp -r "$res_path" "results/$proj"

			# Link html
			res_file="$proj/packages/default-package.html"

			if [ -f "results/$res_file" ]; then
				echo "Linking Test Results for '$proj'"
				echo "<html><head><meta http-equiv=\"refresh\" content=\"0; url=$res_file\" /></head><body></body></html>" > "results/$proj.html"
			fi
		fi
	done
done

# Fix Symlinks
touch "results/.nojekyll"
