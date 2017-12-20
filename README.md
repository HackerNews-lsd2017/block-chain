# block-chain

Blockchain in Java Spring

Provide references to all sources that you used for your implementation.

This blockchain project is implemented in java Spring. It consists of 4 nodes (p2p network) which are all represented by java servers which communicate with each other through HTTP protocol.

All nodes can be spinned up by using the command ```docker-compose -f docker-compose.yml up --build``` in the root folder. 

The following operations can be done:
- send a greeting message to all peers
- create blocks
- chain the blocks in the blockchain
- add transactions to a block
- 1 method of mining 

##Problems encountered in development

Before starting to work on creating our blockchain we looked at online resources to see as to how they made their blockchains. We could see a general pattern that most had used JavaScript in order to create the blockchain. These projects had also used external modules in order to accomplish certain small tasks. This made us decide to try and create a blockchain using Java and trying to not use any external "cypto" or blockchain libraries. A long and hard development cycle followed as we were not able to use general online "inspiration" to create the blockchain. We also tried to develop our blockchain from what we understood as to how it should work. 

This led us to have a functioning blockchain and network. But unfortunately the two do not work in unison. We were also able to create a docker script that spins up 4 nodes onto our network. All in all we were pretty close to a functional product but did not achieve what we expected.
