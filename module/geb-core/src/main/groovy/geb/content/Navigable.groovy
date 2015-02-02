/* Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package geb.content

import geb.navigator.Navigator
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

interface Navigable {

	Navigator find()

	Navigator $()

	Navigator find(int index)

	Navigator find(Range<Integer> range)

	Navigator $(int index)

	Navigator $(Range<Integer> range)

	Navigator find(String selector)

	Navigator $(String selector)

	Navigator find(String selector, int index)

	Navigator find(String selector, Range<Integer> range)

	Navigator $(String selector, int index)

	Navigator $(String selector, Range<Integer> range)

	Navigator $(Map<String, Object> attributes, By bySelector)

	Navigator find(Map<String, Object> attributes, By bySelector)

	Navigator $(Map<String, Object> attributes, By bySelector, int index)

	Navigator find(Map<String, Object> attributes, By bySelector, int index)

	Navigator $(Map<String, Object> attributes, By bySelector, Range<Integer> range)

	Navigator find(Map<String, Object> attributes, By bySelector, Range<Integer> range)

	Navigator $(By bySelector)

	Navigator find(By bySelector)

	Navigator $(By bySelector, int index)

	Navigator find(By bySelector, int index)

	Navigator $(By bySelector, Range<Integer> range)

	Navigator find(By bySelector, Range<Integer> range)

	Navigator find(Map<String, Object> attributes)

	Navigator $(Map<String, Object> attributes)

	Navigator find(Map<String, Object> attributes, int index)

	Navigator find(Map<String, Object> attributes, Range<Integer> range)

	Navigator $(Map<String, Object> attributes, int index)

	Navigator $(Map<String, Object> attributes, Range<Integer> range)

	Navigator find(Map<String, Object> attributes, String selector)

	Navigator $(Map<String, Object> attributes, String selector)

	Navigator find(Map<String, Object> attributes, String selector, int index)

	Navigator find(Map<String, Object> attributes, String selector, Range<Integer> range)

	Navigator $(Map<String, Object> attributes, String selector, int index)

	Navigator $(Map<String, Object> attributes, String selector, Range<Integer> range)

	Navigator $(Navigator[] navigators)

	Navigator $(WebElement[] elements)
}