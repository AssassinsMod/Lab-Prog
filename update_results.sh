#!/usr/bin/env bash

git add results
git commit -m "[AUTO] Updated test results"
git subtree push --prefix results origin gh-pages
