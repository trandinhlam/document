package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class UsingHTable {
    public static final String TABLE_NAME = "my-table";
    public static final String CF_1 = "colFa1";
    public static final String CF_2 = "colFa2";

    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.master", "localhost:60000");
        Connection con = ConnectionFactory.createConnection(conf);
        Table table = con.getTable(TableName.valueOf(UsingHBaseAdmin.TABLE_NAME));
        byte[] rowKey = Bytes.toBytes("rowKey1");
        byte[] cf1 = Bytes.toBytes(CF_1);
        Put put = new Put(rowKey);
        put.addColumn(cf1, Bytes.toBytes("qual1"), Bytes.toBytes("value1"));
        put.addColumn(cf1, Bytes.toBytes("qual2"), Bytes.toBytes("value2"));
        put.addColumn(Bytes.toBytes(CF_2), Bytes.toBytes("qual1"), Bytes.toBytes("value3"));
        table.put(put);

        Get get = new Get(rowKey);
        Result result = table.get(get);
        System.out.println(result.listCells());
        byte[] value = result.getValue(cf1, Bytes.toBytes("qual2"));
        System.out.println(Bytes.toString(value));
        table.close();
    }
}
