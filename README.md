# Blockchain Project
README required for the final hand in  

## Requirements:
- Docker
- Docker -compose
- Java
- Maven

## To run the project with only one command - unix systems:
1. Navigate to the project directory
2. Run: ./run.sh 

## To run the project manually
1. mvn clean package (necessary if you had only images built)
2. mvn dockerfile:build -U (Forces a check for missing releases and updated snapshots or remote repositories)
3. docker-compose up

## Snapshots of a running blockchain in the network of 4 nodes
Zoom in if the text on the picture is unreadable, screenshots have high resolution.

1. This is a picture of the docker compose command being run and all 4 nodes starting up their own servers. The nodes run a Spring server each which will mine blocks from received transactions and then keep all block chains up to date.

![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.54.34.png)

2. Here you can see that the nodes are mining the first transactions. The first node to have mined the transactions is then broadcasting the block to all other nodes which are then affirming that they recieved a valid block (each node verifies if the block received is valid) and then adding that block to their block chain.

![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.50.48.png)

3. This image shows the continuation of mining from the nodes. It is visible, although a little hard to see, that the blockchains are the same for each node. The reason for it being hard to see is that the nodes mine asynchronously and the output is a *jumbled up*.  

![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.52.34.png)

4. Here the process of random transactions being pushed to the nodes is ending after 25 seconds. The process then ends and the test scenario is done running.

![alt text](https://github.com/HackerNews-lsd2017/block-chain/blob/master/imgs/Screen%20Shot%202018-01-19%20at%2018.53.07.png)

Resources:    
* https://github.com/Will1229/Blockchain 
* https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa 
* https://marmelab.com/blog/2016/04/28/blockchain-for-web-developers-the-theory.html 
