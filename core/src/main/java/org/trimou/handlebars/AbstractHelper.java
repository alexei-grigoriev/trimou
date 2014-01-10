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
package org.trimou.handlebars;

import org.trimou.engine.MustacheTagType;
import org.trimou.engine.config.AbstractConfigurationAware;

/**
 *
 * @author Martin Kouba
 */
public abstract class AbstractHelper extends AbstractConfigurationAware
        implements Helper {

    @Override
    public void validate(HelperDefinition definition) {
        // No-op by default
    }

    protected Object getHashValue(Options options, String key) {
        return options.getHash().isEmpty() ? null : options.getHash().get(key);
    }

    protected boolean isSection(Options options) {
        return options.getTagInfo().getType().equals(MustacheTagType.SECTION);
    }

    protected boolean isVariable(Options options) {
        return options.getTagInfo().getType().equals(MustacheTagType.VARIABLE)
                || options.getTagInfo().getType()
                        .equals(MustacheTagType.UNESCAPE_VARIABLE);
    }
}
