package org.xez.jip.labs.locale;

import java.util.*;

/**
 * Default implementation of {@link org.xez.jip.labs.locale.LocaleProvider LocaleProvider} interface <p>
 *     This class is for providing access to localised strings from Resource Bundle in directory "locale"
 */
class DefaultLocaleProvider implements LocaleProvider {

    /** Locale Resource Bundle link */
    private ResourceBundle locale;

    /**
     * @param localeStorage reference to locale Resource Bundle storage
     * @param locales browser locales preference
     */
    DefaultLocaleProvider(LocaleStorage localeStorage, Enumeration<Locale> locales) {
        locale = localeStorage.getResourceBundle(locales);
    }

    /**
     * @param key Resource Bundle key
     * @return localised String
     */
    @Override
    public String getUi(String key) {
        return locale.getString(key);
    }
}
