package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class Blockchain {

	// This should be a tree but ain't nobody got time for that
	private List<Block> blockchain = new ArrayList<>();

	public boolean chainBlock(Block newBlock) {
		Block lastBlock = getLatestBlock();

		
		if (validateLinkBetweenBlocks(getLatestBlock(),newBlock)==true) {
			// Click! Chain new block
			blockchain.add(newBlock);
			return true;
		}
		
		return false;
	}

	private boolean validateLinkBetweenBlocks(Block previousBlock, Block newBlock) {
		//if (previousBlock==null) 
		String hashOflastBlock;
		String hashOfNewBlock;
		//this is shit
		if (blockchain.size()==0) hashOflastBlock=getHashOfLatestBlock();
		else hashOflastBlock = previousBlock.getThisHash();
		hashOfNewBlock = newBlock.getThisHash();
		
		// Check if block "to be chained" has wrong prefix
		if (!hashOfNewBlock.startsWith("0000"))
			return false;
		
		// Check if new block is not a child of previous block
		if (!hashOflastBlock.equals(newBlock.getPreviousHash()))
			return false;

		// Check if hash that new block is presenting is not "honest"
		
		String expectedHash = DigestUtils.sha256Hex(
				newBlock.getNonce() + newBlock.transactionsToString(newBlock.getTransactions()) + hashOflastBlock);

		if (!hashOfNewBlock.equals(expectedHash))
			return false;
		
		return true;
	}

	//test for empty
	public boolean validateBlockchain() {
		if (blockchain.size()<=1) return true;
		Block ancestor,child;
		//this is too long refactor
		if (!blockchain.get(0).getPreviousHash().equals("000000000000000000000000000000000000000000000000000000000000000")) return false;
		for (int i=0;i<blockchain.size()-1;i++) {
			ancestor = blockchain.get(i);
			child = blockchain.get(i+1);
			if (validateLinkBetweenBlocks(ancestor, child)!=true) {
				return false;
			}
		}
		return true;
		 
	}

	public String getHashOfLatestBlock() {
		if (blockchain.size() == 0)
			return "000000000000000000000000000000000000000000000000000000000000000";
		return blockchain.get(blockchain.size() - 1).getThisHash();
	}
	
	public Block getLatestBlock() {
		if (blockchain.size() == 0)
			return null;
		return blockchain.get(blockchain.size() - 1);
	}

	public Block getAncestorOfBlock(Block ancestorHash) {
		for (Block block : blockchain) {
			if (block.getThisHash().equals(ancestorHash))
				return block;
		}
		return null;
	}

//	public Block getBlock() {
//		for (Block block : blockchain) {
//			if (block.getThisHash().equals(ancestorHash))
//				return block;
//		}
//		return null;
//	}


}
