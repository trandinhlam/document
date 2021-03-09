package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UsingHBaseAdmin {
    public static final String TABLE_NAME = "my-table";
    public static final String CF_1 = "colFa1";
    public static final String CF_2 = "colFa2";

    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.master", "localhost:60000");
        Connection con = ConnectionFactory.createConnection(conf);
        Admin admin = con.getAdmin();
        _createdTable(admin);
        _deleteTable(admin);
        _createdTable(admin);
    }


    private static void _createdTable(Admin admin) throws IOException {
        TableName tableName = TableName.valueOf(TABLE_NAME);
        List<ColumnFamilyDescriptor> columnFamilies = Arrays.asList(
                ColumnFamilyDescriptorBuilder.of(CF_1),
                ColumnFamilyDescriptorBuilder.of(CF_2)
        );
        admin.createTable(TableDescriptorBuilder.newBuilder(tableName).setColumnFamilies(columnFamilies).build());
    }

    private static void _deleteTable(Admin admin) throws IOException {
        TableName tableName = TableName.valueOf(TABLE_NAME);
        admin.disableTable(tableName);
        admin.deleteTable(tableName);
    }
}

