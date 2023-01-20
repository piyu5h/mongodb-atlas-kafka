package com.mongodb.kafka.connect.source.json.formatter;

import java.util.Base64;
import org.bson.json.*;



public class MongoDBAtlasJson implements JsonWriterSettingsProvider {


  @Override
  public org.bson.json.JsonWriterSettings getJsonWriterSettings() {
    return JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).binaryConverter((value, writer) -> {
      writer.writeString(Base64.getEncoder().encodeToString(value.getData()));
    }).dateTimeConverter((value, writer) -> {
      writer.writeNumber(value.toString());
    }).decimal128Converter((value, writer) -> {
      writer.writeString(value.toString());
    }).objectIdConverter((value, writer) -> {
      writer.writeString(value.toHexString());
    }).symbolConverter((value, writer) -> {
      writer.writeString(value);
    }).timestampConverter((value,writer)-> {
      writer.writeNumber(String.valueOf(value.getTime()*1000L));
        })
        .build();
  }
}
