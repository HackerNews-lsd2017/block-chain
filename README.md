# block-chain

README required for the final hand in  

##Requirements:
- have docker installed together with docker-compose

To run the project with only one command - unix systems:
1. Navigate to the project directory
2. Run: ./run.sh 

To run the project manually
1. mvn clean package (necessary if you had only images built)
2. mvn dockerfile:build -U (Forces a check for missing releases and updated snapshots or remote repositories)
3. docker-compose up


Resources:    
https://github.com/Will1229/Blockchain
https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
