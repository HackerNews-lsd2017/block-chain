package datastructures;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private Block root = new Block();
	private List<Block> blockchain = new ArrayList<>();

	public Blockchain() {
		Block gb = new Block();
        String GENESIS_HASH = new String(new char[63]).replace('\0', '0');
        gb.setPreviousHash(GENESIS_HASH);
		gb.mine(GENESIS_HASH);
		this.blockchain.add(gb);
	}

	public void addBlock(Block block) {
		blockchain.add(block);
	}

	public Block getLatestBlock() {
		return blockchain.get(blockchain.size() - 1);
	}

	public boolean chainBlock(Block newBlock) {
		Block lastBlock = getLatestBlock();

        if (validateLinkBetweenBlocks(lastBlock, newBlock)) {
            // Click! Chain new block
			blockchain.add(newBlock);
            System.out.println("Successfully chained a new block: " + newBlock);
			return true;
		}

		return false;
	}

	private boolean validateLinkBetweenBlocks(Block previousBlock, Block newBlock) {
		String previousBlockHash;
		String newBlockHash;

        previousBlockHash = previousBlock.getBlockHash();
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for (Block block : blockchain) {
			builder.append(block.toString());
			builder.append("\n");
		}
		return builder.toString();
	}
}
