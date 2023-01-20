
package com.mongodb.kafka.connect.source.json.formatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.bson.BsonDocument;
import org.bson.json.JsonWriterSettings;

  public class TestCustomJson {

    private static final BsonDocument DEFAULT_TEST_DOCUMENT =
        BsonDocument.parse(
            "{'_id': {'$oid': '5f15aab12435743f9bd126a4'}, "
                + "'myString': 'some foo bla text', "
                + "'myInt': 42, "
                + "'myDouble': {'$numberDouble': '20.21'}, "
                + "'mySubDoc': {'A': {'$binary': {'base64': 'S2Fma2Egcm9ja3Mh', 'subType': '00'}}, "
                + "  'B': {'$date': {'$numberLong': '1577863627000'}}, 'C': {'$numberDecimal': '12345.6789'}}, "
                + "'myArray': [{'$binary': {'base64': 'S2Fma2Egcm9ja3Mh', 'subType': '00'}}, "
                + "  {'$date': {'$numberLong': '1577863627000'}}, {'$numberDecimal': '12345.6789'}], "
                + "'myBytes': {'$binary': {'base64': 'S2Fma2Egcm9ja3Mh', 'subType': '00'}}, "
                + "'myDate': {'$date': {'$numberLong': '1577863627000'}}, "
                + "'myDecimal': {'$numberDecimal': '12345.6789'}}");

    private static final BsonDocument EXTENDED_TEST_DOCUMENT =
        BsonDocument.parse(
            "{'_id': {'$oid': '5f15aab12435743f9bd126a4'}," +
                " 'clusterTime': { "+
                "      '$timestamp': { "+
                "        't': 1674202191, "+
                "        'i': 1 " +
                "      } }"
                + "'myString': 'some foo bla text', "
                + "'myInt': {'$numberInt': '42'}, "
                + "'myDouble': {'$numberDouble': '20.21'}, "
                + "'mySubDoc': {'A': {'$binary': {'base64': 'S2Fma2Egcm9ja3Mh', 'subType': '00'}}, "
                + "  'B': {'$date': {'$numberLong': '1577863627000'}}, 'C': {'$numberDecimal': '12345.6789'}}, "
                + "'myArray': [{'$binary': {'base64': 'S2Fma2Egcm9ja3Mh', 'subType': '00'}}, "
                + "  {'$date': {'$numberLong': '1577863627000'}}, {'$numberDecimal': '12345.6789'}], "
                + "'myBytes': {'$binary': {'base64': 'S2Fma2Egcm9ja3Mh', 'subType': '00'}}, "
                + "'myDate': {'$date': {'$numberLong': '1577863627000'}}, "
                + "'myDecimal': {'$numberDecimal': '12345.6789'}}");

    private static final BsonDocument SIMPLIFIED_TEST_DOCUMENT =
        BsonDocument.parse(
            "{_id: '5f15aab12435743f9bd126a4', "
                + "clusterTime : 1674202191000,"
                + "myString: 'some foo bla text', "
                + "myInt: 42, "
                + "myDouble: 20.21, "
                + "mySubDoc: {A: 'S2Fma2Egcm9ja3Mh', B: 1577863627000, C: '12345.6789'},"
                + "myArray: ['S2Fma2Egcm9ja3Mh', 1577863627000, '12345.6789'],"
                + "myBytes: 'S2Fma2Egcm9ja3Mh', "
                + "myDate: 1577863627000, "
                + "myDecimal: '12345.6789'}");




    @Test
    @DisplayName("test simplified json settings")
    void testSimplifiedJson() {
      JsonWriterSettings jsonWriterSettings = new CustomJson().getJsonWriterSettings();
     System.out.println( EXTENDED_TEST_DOCUMENT.toJson(jsonWriterSettings));
      assertEquals(
          SIMPLIFIED_TEST_DOCUMENT.toJson(), EXTENDED_TEST_DOCUMENT.toJson(jsonWriterSettings));
    }
}
