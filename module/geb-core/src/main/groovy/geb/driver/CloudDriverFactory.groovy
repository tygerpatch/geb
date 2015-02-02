/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package geb.driver

import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities

abstract class CloudDriverFactory {

	abstract String assembleProviderUrl(String username, String password)

	protected void configureCapabilities(DesiredCapabilities desiredCapabilities) {
	}

	WebDriver create(String specification, String username, String password, Map<String, Object> additionalCapabilities = [:]) {
		def remoteDriverOperations = new RemoteDriverOperations(getClass().classLoader)
		Class<? extends WebDriver> remoteWebDriverClass = remoteDriverOperations.remoteWebDriverClass
		if (!remoteWebDriverClass) {
			throw new ClassNotFoundException('org.openqa.selenium.remote.RemoteWebDriver needs to be on the classpath to create RemoteWebDriverInstances')
		}

		def url = new URL(assembleProviderUrl(username, password))

		Properties capabilities = new Properties()
		capabilities.load(new StringReader(specification))
		capabilities.putAll(additionalCapabilities)

		def browser = remoteDriverOperations.softLoadRemoteDriverClass('DesiredCapabilities').newInstance()
		capabilities.each { capability, value ->
			browser.setCapability(capability, value)
		}
		configureCapabilities(browser)

		remoteWebDriverClass.getConstructor(URL, Capabilities).newInstance(url, browser)
	}
}
