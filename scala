WITH SCHEMA IN FILE CSV:
[cloudera@quickstart ~]$ spark-shell --packages com.databricks:spark-csv_2.10:1.5.0
scala> val xyz = sqlContext.read.format("com.databricks.spark.csv").option("header","true").option("inferschema","true").load("file:///home/cloudera/Desktop/MOCK_DATA.csv”)
## option(“header”,true) ==. In input file if it has schema in first line.
xyz: org.apache.spark.sql.DataFrame = [id: int, first_name: string, last_name: string, email: string, gender: string, ip_address: string]
scala> xyz.show()
+---+-----------+---------+--------------------+------+---------------+
| id| first_name|last_name|               email|gender|     ip_address|
+---+-----------+---------+--------------------+------+---------------+
|  1|      Lorry| Tatchell|ltatchell0@weibo.com|Female|    141.27.33.8|
|  2|Archaimbaud|  O'Keefe|aokeefe1@gizmodo.com|  Male|  60.146.226.91|
|  3|       Penn|   Furzey|pfurzey2@studiopr...|  Male| 126.197.56.153|
|  4|    Trstram|  Maloney|tmaloney3@unesco.org|  Male|  70.75.170.136|
|  5|      Selma|   Vaskin|svaskin4@rakuten....|Female| 10.226.181.124|
|  6|       Sela|  Pilgrim|spilgrim5@stanfor...|Female|184.248.208.251|
|  7|    Rhiamon|   Durman|    rdurman6@mlb.com|Female|  57.76.236.244|
|  8| Bernardina|  Wilcock|bwilcock7@dagonde...|Female| 111.201.214.47|
|  9|     Milena|   Robker| mrobker8@flickr.com|Female| 148.107.161.41|
| 10|        Leo| Fellgatt|lfellgatt9@delici...|  Male|129.132.173.115|
+---+-----------+---------+--------------------+------+———————+
##WITHOUT SCHEMA IN FILE CSV
scala> val abc = sqlContext.read.format("com.databricks.spark.csv").option("header","false").option("inferschema","true").load("file:///home/cloudera/Desktop/MOCK_DATA.csv")
abc: org.apache.spark.sql.DataFrame = [C0: int, C1: string, C2: string, C3: string, C4: string, C5: string]

##if it has no schema in header option = fasle:

scala> abc.registerTempTable("hi")

scala> sqlContext.sql("select * from hi")
