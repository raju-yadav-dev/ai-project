package com.altarix.util;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;

public final class IconResources {
    private static final List<String> STAGE_ICON_PATHS = List.of(
        "/icon/Altarix-16.png",
        "/icon/Altarix-32.png",
        "/icon/Altarix-64.png",
        "/icon/Altarix-128.png",
        "/icon/Altarix-256.png",
        "/icon/Altarix-512.png"
    );

    private IconResources() {
    }

    public static void addStageIcons(Stage stage, Class<?> resourceAnchor) {
        if (stage == null || resourceAnchor == null) {
            return;
        }

        for (String path : STAGE_ICON_PATHS) {
            URL resource = resourceAnchor.getResource(path);
            if (resource != null) {
                stage.getIcons().add(new Image(resource.toExternalForm()));
            }
        }
    }

    public static Image loadBestFit(Class<?> resourceAnchor, int preferredSize) {
        if (resourceAnchor == null) {
            return null;
        }

        List<String> candidates = preferredSize <= 32
            ? List.of(
                "/icon/Altarix-16.png",
                "/icon/Altarix-32.png",
                "/icon/Altarix-64.png",
                "/icon/Altarix-128.png"
            )
            : List.of(
                "/icon/Altarix-64.png",
                "/icon/Altarix-128.png",
                "/icon/Altarix-256.png",
                "/icon/Altarix-512.png"
            );

        for (String path : candidates) {
            URL resource = resourceAnchor.getResource(path);
            if (resource != null) {
                return new Image(resource.toExternalForm());
            }
        }

        URL fallback = resourceAnchor.getResource("/icon/Altarix-256.png");
        return fallback != null ? new Image(fallback.toExternalForm()) : null;
    }
}

