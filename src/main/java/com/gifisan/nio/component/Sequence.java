package com.gifisan.nio.component;

import com.gifisan.nio.component.concurrent.FixedAtomicInteger;

public class Sequence {

	public FixedAtomicInteger	AUTO_ENDPOINT_ID	= new FixedAtomicInteger(1, Integer.MAX_VALUE);

}
