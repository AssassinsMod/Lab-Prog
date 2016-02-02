#!/usr/bin/env bash

git add "html"
git commit -m "[AUTO] Updated html sites"
git subtree push --prefix "html" origin gh-pages
