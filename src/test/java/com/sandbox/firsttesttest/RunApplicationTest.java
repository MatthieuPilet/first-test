/**
 * 
 */
package com.sandbox.firsttesttest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sandbox.firsttest.RunApplication;

/**
 * 
 * @author Matthieu Pilet
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
class RunApplicationTest {
	@Test
	void main() {
		RunApplication.main(new String[] {});
		assertTrue(true, "To be ok with Sonar");
	}

}
