package org.trimou.engine.resolver;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.trimou.AbstractTest;

import com.google.common.collect.ImmutableMap;

/**
 *
 * @author Martin Kouba
 */
public class MapResolverTest extends AbstractTest {

	@Test
	public void testInterpolation() {
		Map<String, Integer> map = new HashMap<String, Integer>(2);
		map.put("foo", 1);
		map.put("bar", 2);
		Map<String, Object> data = ImmutableMap.<String, Object>of("map", map);
		String templateContents = "Hello {{map.foo}} or {{map.bar}}!|{{map.nonExisting}}";
		assertEquals("Hello 1 or 2!|", engine.compileMustache("map", templateContents).render(data));
	}

}