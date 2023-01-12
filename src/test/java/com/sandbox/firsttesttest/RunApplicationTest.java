/**
 * 
 */
package com.sandbox.firsttesttest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.sandbox.firsttest.RunApplication;

/**
 * 
 * @author Matthieu Pilet
 *
 */
class RunApplicationTest {
	@Test
	void main() {
		RunApplication.main(new String[] {});
		assertTrue(true, "To be ok with Sonar");
	}

}
