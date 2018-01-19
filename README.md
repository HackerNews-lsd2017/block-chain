# Blockchain Project
README required for the final hand in  

## Requirements:
- have docker installed together with docker-compose

## To run the project with only one command - unix systems:
1. Navigate to the project directory
2. Run: ./run.sh 

## To run the project manually
1. mvn clean package (necessary if you had only images built)
2. mvn dockerfile:build -U (Forces a check for missing releases and updated snapshots or remote repositories)
3. docker-compose up

## Snapshots of a running blockchain in the network of 4 nodes
Zoom in if the text on the picture is unreadable, screenshots have high resolution.

1.
![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.54.34.png)

2.
![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.50.48.png)

3.
![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.52.34.png)

4.
![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.33.33.png)

Resources:    
https://github.com/Will1229/Blockchain
https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
