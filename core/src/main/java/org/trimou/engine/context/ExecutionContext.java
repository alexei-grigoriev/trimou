/*
 * Copyright 2013 Martin Kouba
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trimou.engine.context;

import org.trimou.engine.segment.ExtendSectionSegment;
import org.trimou.engine.segment.ExtendSegment;

/**
 * A new execution context is created for each template rendering.
 *
 * Execution context is not considered to be thread-safe.
 *
 * @author Martin Kouba
 */
public interface ExecutionContext {

	/**
	 * @param key
	 * @return the object associated with the given key, or <code>null</code> if
	 *         no such object exists
	 */
	public Object get(String key);

	/**
	 * Push the context object on the context stack.
	 *
	 * @param contextObject
	 */
	public void push(Object contextObject);

	/**
	 * Removes the context object at the top of context stack.
	 *
	 * @return the removed context object
	 */
	public Object pop();

	/**
	 * Associate the specified defining section with the context, but only if no
	 * defining section with the same name is associated.
	 *
	 * @param name
	 * @param segment
	 * @see ExtendSegment
	 */
	public void addDefiningSection(String name, ExtendSectionSegment segment);

	/**
	 * @param name
	 * @return the defining section with the specified name or <code>null</code>
	 *         if no such associated with the context
	 * @see ExtendSegment
	 */
	public ExtendSectionSegment getDefiningSection(String name);

}