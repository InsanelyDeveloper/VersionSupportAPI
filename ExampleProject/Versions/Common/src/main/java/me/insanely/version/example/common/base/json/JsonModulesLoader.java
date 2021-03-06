package me.insanely.version.example.common.base.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.insanely.version.example.common.base.MinecraftVersion;
import me.insanely.version.example.common.base.VersionProviderRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public interface JsonModulesLoader {

    void load(@NotNull VersionProviderRegistry registry, @NotNull MinecraftVersion version, @NotNull ObjectMapper objectMapper, @NotNull InputStream jsonInputStream)
            throws IllegalArgumentException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException;

    void registerModuleClassLoader(@NotNull JsonModuleClassLoader classLoader);

    @NotNull static JsonModulesLoader createJsonModulesLoader() {
        return new JsonModulesLoaderImpl();
    }

}