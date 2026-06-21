package org.embulk;

import liqp.antlr.CharStreamWithLocation;
import liqp.antlr.NameResolver;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmbulkNameResolver implements NameResolver {
    public final static String EMBULK_SUFFIX = "_";
    public final static String EMBULK_EXTENSION = ".yml.liquid";
    private final String templateIncludePath;

    public EmbulkNameResolver(String templateIncludePath) {
        this.templateIncludePath = templateIncludePath;
    }

    @Override
    public CharStreamWithLocation resolve(String name) throws IOException {
        name = EMBULK_SUFFIX + name + EMBULK_EXTENSION;
        Path path = Paths.get(templateIncludePath, name);
        return new CharStreamWithLocation(path.toAbsolutePath());
    }
}
