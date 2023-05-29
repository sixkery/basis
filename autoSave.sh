#!/bin/bash
time=`date`
cd /Users/sixkery/learn/basis
git status
git add .
git commit -m "${time}"
git push