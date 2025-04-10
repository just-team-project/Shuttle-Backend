package jooq.custom.generator.converter;

import org.jooq.Converter;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * please explain class!
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 5:33
 */
public class BinaryUuidToStringConverter implements Converter<byte[], String> {

  @Override
  public String from(byte[] databaseObject) {
    if (databaseObject == null) return null;
    ByteBuffer bb = ByteBuffer.wrap(databaseObject);
    long high = bb.getLong();
    long low = bb.getLong();
    return new UUID(high, low).toString(); // UUID → String
  }

  @Override
  public byte[] to(String userObject) {
    if (userObject == null) return null;
    UUID uuid = UUID.fromString(userObject);
    ByteBuffer bb = ByteBuffer.allocate(16);
    bb.putLong(uuid.getMostSignificantBits());
    bb.putLong(uuid.getLeastSignificantBits());
    return bb.array(); // String → UUID → byte[]
  }

  @Override
  public Class<byte[]> fromType() {
    return byte[].class;
  }

  @Override
  public Class<String> toType() {
    return String.class;
  }
}