#!/usr/bin/env bash

git checkout master
git push origin master --tags
git checkout develop
git push origin develop
