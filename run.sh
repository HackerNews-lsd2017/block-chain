#!/bin/bash
clear
echo "Running mvn clean package command"
mvn clean package
echo "Running build command based on the dockerfile"
mvn dockerfile:build -U
echo "Running the compose command"
docker-compose up