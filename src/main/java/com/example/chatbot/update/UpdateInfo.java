package com.example.chatbot.update;

import com.google.gson.annotations.SerializedName;

/**
 * Simple DTO for the update API payload.
 */
public final class UpdateInfo {
    @SerializedName("version")
    private String version;

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("release_notes")
    private String releaseNotes;

    @SerializedName("is_mandatory")
    private boolean mandatory;

    public String getVersion() {
        return version == null ? "" : version.trim();
    }

    public String getDownloadUrl() {
        return downloadUrl == null ? "" : downloadUrl.trim();
    }

    public String getReleaseNotes() {
        return releaseNotes == null ? "" : releaseNotes.trim();
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public boolean isValid() {
        return !getVersion().isEmpty() && !getDownloadUrl().isEmpty();
    }
}
