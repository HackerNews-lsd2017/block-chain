package datastructures;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
	// This should be a tree but ain't nobody got time for that
	private List<Block> blockchain = new ArrayList<>();
    // "\A[0]{63}" -> 63 zeros
	private final String GENESIS_HASH = new String(new char[63]).replace('\0', '0');

	public boolean chainBlock(Block newBlock) {
		Block lastBlock = getLatestBlock();

		if (validateLinkBetweenBlocks(lastBlock, newBlock)) {
			// Click! Chain new block
			blockchain.add(newBlock);
            System.out.println("Successfully chained a new block: " + newBlock);
			return true;
		}

        System.out.println("Couldn't chain block");
		return false;
	}

	private boolean validateLinkBetweenBlocks(Block previousBlock, Block newBlock) {
		String previousBlockHash;
		String newBlockHash;

		if (blockchain.size() == 0) {
            previousBlockHash = getLatestBlockHash();
        } else {
            previousBlockHash = previousBlock.getBlockHash();
        }
		newBlockHash = newBlock.getBlockHash();
		
		// Check if block "to be chained" has wrong prefix
		if (!newBlockHash.startsWith("0000")) {
            return false;
        }
		
		// Check if new block is not a child of previous block
		if (!previousBlockHash.equals(newBlock.getPreviousHash())) {
            return false;
        }

		// Check if hash that new block is presenting is not "honest"
		String expectedHash = DigestUtils.sha256Hex(
				newBlock.getNonce() + newBlock.transactionsToString(newBlock.getTransactions()) + previousBlockHash);

        return newBlockHash.equals(expectedHash);
    }

	//test for empty
	public boolean validateBlockchain() {
		if (blockchain.size() <= 1) {
            return true;
        }

		Block ancestor, child;

		if (!blockchain.get(0).getPreviousHash().equals(GENESIS_HASH)) {
            return false;
        }

		for (int i = 0; i < blockchain.size() - 1; i++) {
			ancestor = blockchain.get(i);
			child = blockchain.get(i + 1);

			if (!validateLinkBetweenBlocks(ancestor, child)) {
				return false;
			}
		}
		return true;
	}

	public String getLatestBlockHash() {
		if (blockchain.size() == 0) {
            return GENESIS_HASH;
        }
		return blockchain.get(blockchain.size() - 1).getBlockHash();
	}
	
	public Block getLatestBlock() {
		if (blockchain.size() == 0) {
            return null;
        }
		return blockchain.get(blockchain.size() - 1);
	}

	public Block getAncestorOfBlock(Block ancestorHash) {
		for (Block block : blockchain) {
			if (block.getBlockHash().equals(ancestorHash)) {
                return block;
            }
		}
		return null;
	}

//	public Block getBlock() {
//		for (Block block : blockchain) {
//			if (block.getBlockHash().equals(ancestorHash))
//				return block;
//		}
//		return null;
//	}


}
