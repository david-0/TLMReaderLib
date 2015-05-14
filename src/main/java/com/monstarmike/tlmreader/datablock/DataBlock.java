package com.monstarmike.tlmreader.datablock;

import java.util.Arrays;
import java.util.Date;

import com.monstarmike.tlmreader.util.PrimitiveUtils;

public abstract class DataBlock extends Block {

	public int get_timestamp() {
		byte[] timestampBytes = Arrays.copyOfRange(this.rawData, 0, 4);

		org.apache.commons.lang.ArrayUtils.reverse(timestampBytes);
		
		return PrimitiveUtils.toInt(timestampBytes);
	}

	public DataBlock(byte[] rawData) {
		super(rawData);
	}

	public static DataBlock createDataBlock(byte[] bytes) {
		DataBlock block = null;
		switch (bytes[4]) {
		case 0:
			// unknown
			break;

		case 0x01:
			// voltmeter - appears to be legacy.
			break;

		case 0x02:
			// temperature - appears to be legacy.
			break;

		case 0x03:
			// current (amperage) usage
			block = new CurrentBlock(bytes);
			break;

		case 0x0a:
			// powerbox
			block = new PowerboxBlock(bytes);
			break;

		case 0x11:
			// airspeed
			block = new AirspeedBlock(bytes);
			break;

		case 0x12:
			// altitude
			block = new AltitudeBlock(bytes);
			break;

		case 0x14:
			// gps
			block = new GForceBlock(bytes);
			break;

		case 126:

			break;

		case 127:

			break;
		}
		return block;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 20;
	}
}
