/*
 * The MIT License
 *
 * Copyright (c) 2017, Sebastian Hasait
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.custombuildproperties;

import java.io.Serializable;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

/**
 *
 */
public class SetCustomBuildPropertyStep extends AbstractStepImpl implements Serializable {

	private final String key;
	private final Object value;
	private boolean onlySetIfAbsent;

	@DataBoundConstructor
	public SetCustomBuildPropertyStep(String key, Object value) {
		super();

		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public boolean isOnlySetIfAbsent() {
		return onlySetIfAbsent;
	}

	@DataBoundSetter
	public void setOnlySetIfAbsent(final boolean onlySetIfAbsent) {
		this.onlySetIfAbsent = onlySetIfAbsent;
	}

	@Extension
	public static final class DescriptorImpl extends AbstractStepDescriptorImpl {

		public DescriptorImpl() {
			super(SetCustomBuildPropertyStepExecution.class);
		}

		@Override
		public String getDisplayName() {
			return "Set Custom BuildProperty";
		}

		@Override
		public String getFunctionName() {
			return "setCustomBuildProperty";
		}

	}

}
