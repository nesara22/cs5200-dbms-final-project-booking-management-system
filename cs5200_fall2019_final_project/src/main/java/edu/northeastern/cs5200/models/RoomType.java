package edu.northeastern.cs5200.models;

public enum RoomType {
  AIR_CONDITIONED(1), NON_AIR_CONDITIONED(2), BEACH_FACING(3), BALCONY_VIEW(4),
  VALLEY_FACING(5), DORM_SAME_GENDER(6), DORM_MIX_GENDER(7);

  private int value;

  private RoomType(int value) {
    this.setValue(value);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public static RoomType getRoomType(int id) {
    RoomType[] r = new RoomType[RoomType.values().length];
    r = RoomType.values();
    return r[id-1];
  }
}
