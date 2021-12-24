package me.jvegaf.musikbox.tracks;

public final class Art {
  private final byte[] data;
  private final String description;
  private final String imageUrl;
  private final boolean linked;
  private final String mimeType;
  private final Integer pictureType;

  public Art(byte[] data, String description, String imageUrl, boolean linked, String mimeType, Integer pictureType) {
    this.data = data;
    this.description = description;
    this.imageUrl = imageUrl;
    this.linked = linked;
    this.mimeType = mimeType;
    this.pictureType = pictureType;
  }

  public byte[] getData() {
    return this.data;
  }

  public String getDescription() {
    return this.description;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public boolean isLinked() {
    return this.linked;
  }

  public String getMimeType() {
    return this.mimeType;
  }

  public Integer getPictureType() {
    return this.pictureType;
  }
}