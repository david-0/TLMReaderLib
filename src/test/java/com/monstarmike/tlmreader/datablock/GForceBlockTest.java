package com.monstarmike.tlmreader.datablock;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monstarmike.tlmreader.DataBlockBuilder;

public class GForceBlockTest {

	private static final short GFORCE_DATABLOCK_MAKER = (short) 0x1400;

	@Test
	public void testGetXInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(163, 0x6).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(163 , gforceBlock.getXInHunderthOfG());
	}
	
	@Test
	public void testGetYInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(283, 0x8).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(283 , gforceBlock.getYInHunderthOfG());
	}

	@Test
	public void testGetZInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(117, 0x0A).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(117, gforceBlock.getZInHunderthOfG());
	}
	
	@Test
	public void testGetMaxXInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(426, 0x0C).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(426, gforceBlock.getMaxXInHunderthOfG());
	}
	
	@Test
	public void testGetMaxYInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(-119, 0x0E).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(-119, gforceBlock.getMaxYInHunderthOfG());
	}
	
	@Test
	public void testGetMaxZInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(887, 0x10).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(887, gforceBlock.getMaxZInHunderthOfG());
	}
	
	@Test
	public void testGetMinZInG() {
		byte[] testBlock = new DataBlockBuilder(0, GFORCE_DATABLOCK_MAKER).setValue(14, 0x12).get();
		GForceBlock gforceBlock = (GForceBlock) DataBlock.createDataBlock(testBlock, null);
		assertEquals(14, gforceBlock.getMinZInHunderthOfG());
	}
}
