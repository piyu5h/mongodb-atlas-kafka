## MongoDB Atlas Source Kafka Formatter

##### Description
This repository provide example to implement Custom Json formatter for Mongo Kafka Source Connector.

This Custom implementation will dump json in same format as 
provided by

 https://docs.confluent.io/cloud/current/connectors/cc-mongo-db-source.html
for <b> JSON  </b> Output.
------------------


This jar can be used along with Mongo Kafka Source Connector.

  https://github.com/mongodb/mongo-kafka 

-------------
Use below config to enable this output formatter.

```
 "output.json.formatter": "com.mongodb.kafka.connect.source.json.formatter.CustomJson"

```

### Build

```
mvn package
```