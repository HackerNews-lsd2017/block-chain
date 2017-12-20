# block-chain

Blockchain in Java Spring

Implement actions, such as, adding transactions, mining of blocks, a simple consensus algorithm of your choice, etc.
Implement at least two versions for mining, especially for the proof of work, so that they do the same but are differently fast.
Formal Requirements:

Provide a reproducible setup. That is, provide a Bash script, that can be run from any Linux machine, which instantiates your blockchain with some example nodes and which executes a test scenario on your blockchain.

Provide a screencast demonstrating all functions of your running blockchain, with the help of the above script.

Provide references to all sources that you used for your implementation.

This blockchain project is implemented in java Spring. It consists of 4 hardcoded nodes (p2p network) which are all represented by java servers which communicate with each other through HTTP protocol.

All nodes can be spinned up by using the command ```docker-compose -f docker-compose.yml up --build``` in the root folder. 

The following operations can be done:
- send a greeting message to all peers
- create blocks
- chain the blocks in the blockchain
- add transactions to a block

##Problems encountered in development

Before starting to work on creating our blockchain we looked at online resources to see as to how they made their blockchains. We could see a general pattern that most had used JavaScript in order to create the blockchain. These projects had also used external modules in order to accomplish certain smallish tasks. This made us decide to try and create a blockchain using Java and trying to not use any external "cypto" or blockchain libraries. A long and hard development cycle followed as we were not able to use general online "inspiration" to create the blockchain. We also tried to develop our blockchain from what we understood as to how it should work. 

Another problem we faced was only using HTTP in order to communicate between the nodes in the network. This made us face another problem and we noticed the importance of this problem too late in the development cycle.

This led us to have a functioning blockchain and network. But unfortunately the two do not work in unison. We were also able to create a docker script that spins up 4 nodes onto our network. All in all we were pretty close to a functional product but did not achieve what we expected.
