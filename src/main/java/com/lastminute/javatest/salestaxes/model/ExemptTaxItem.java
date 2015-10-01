package com.lastminute.javatest.salestaxes.model;

import com.lastminute.javatest.common.Utils;

public class ExemptTaxItem extends Item {
	
	public float getTaxAmount() {
		float tax = 0f;
		if (isImported) tax = Taxable.IMPORT_TAX;
		return Utils.roundUpNearest005(price * (tax / 100f));
	}

}
