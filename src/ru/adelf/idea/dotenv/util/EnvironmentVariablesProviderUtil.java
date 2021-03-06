package ru.adelf.idea.dotenv.util;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.extensions.Extensions;
import ru.adelf.idea.dotenv.api.EnvironmentVariablesProvider;
import ru.adelf.idea.dotenv.api.EnvironmentVariablesUsagesProvider;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EnvironmentVariablesProviderUtil {
    public static final Set<EnvironmentVariablesProvider> PROVIDERS = getEnvVariablesProviders();

    public static final Set<EnvironmentVariablesUsagesProvider> USAGES_PROVIDERS = getEnvVariablesUsagesProviders();

    private static Set<EnvironmentVariablesProvider> getEnvVariablesProviders() {
        Set<EnvironmentVariablesProvider> providers = new HashSet<>();

        Collections.addAll(providers, Extensions.getExtensions(ExtensionPointName.create("ru.adelf.idea.dotenv.environmentVariablesProvider")));

        return providers;
    }

    private static Set<EnvironmentVariablesUsagesProvider> getEnvVariablesUsagesProviders() {
        Set<EnvironmentVariablesUsagesProvider> providers = new HashSet<>();

        Collections.addAll(providers, Extensions.getExtensions(ExtensionPointName.create("ru.adelf.idea.dotenv.environmentVariablesUsagesProvider")));

        return providers;
    }
}
