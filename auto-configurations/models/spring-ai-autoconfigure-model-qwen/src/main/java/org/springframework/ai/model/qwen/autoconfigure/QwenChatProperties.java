/*
 * Copyright 2023-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ai.model.qwen.autoconfigure;

import org.springframework.ai.qwen.QwenChatOptions;
import org.springframework.ai.qwen.api.QwenApi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Configuration properties for DeepSeek chat client.
 *
 * @author Geng Rong
 */
@ConfigurationProperties(QwenChatProperties.CONFIG_PREFIX)
public class QwenChatProperties extends QwenParentProperties {

	public static final String CONFIG_PREFIX = "spring.ai.qwen.chat";

	public static final String DEFAULT_CHAT_MODEL = QwenApi.ChatModel.QWEN_CHAT.getValue();

	private static final Double DEFAULT_TEMPERATURE = 1D;

	public static final String DEFAULT_COMPLETIONS_PATH = "/chat/completions";

	public static final String DEFAULT_BETA_PREFIX_PATH = "/beta";

	/**
	 * Enable DeepSeek chat client.
	 */
	private boolean enabled = true;

	private String completionsPath = DEFAULT_COMPLETIONS_PATH;

	private String betaPrefixPath = DEFAULT_BETA_PREFIX_PATH;

	@NestedConfigurationProperty
	private QwenChatOptions options = QwenChatOptions.builder()
		.model(DEFAULT_CHAT_MODEL)
		.temperature(DEFAULT_TEMPERATURE)
		.build();

	public QwenChatOptions getOptions() {
		return this.options;
	}

	public void setOptions(QwenChatOptions options) {
		this.options = options;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCompletionsPath() {
		return this.completionsPath;
	}

	public void setCompletionsPath(String completionsPath) {
		this.completionsPath = completionsPath;
	}

	public String getBetaPrefixPath() {
		return this.betaPrefixPath;
	}

	public void setBetaPrefixPath(String betaPrefixPath) {
		this.betaPrefixPath = betaPrefixPath;
	}

}
