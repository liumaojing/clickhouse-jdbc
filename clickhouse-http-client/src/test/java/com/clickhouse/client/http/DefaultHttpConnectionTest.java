package com.clickhouse.client.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.clickhouse.client.BaseIntegrationTest;
import com.clickhouse.client.ClickHouseClient;
import com.clickhouse.client.ClickHouseNode;
import com.clickhouse.client.ClickHouseProtocol;
import com.clickhouse.client.ClickHouseRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DefaultHttpConnectionTest extends BaseIntegrationTest {
    @Test(groups = { "integration" })
    public void testConnectionReuse() throws Exception {
        ClickHouseNode server = getServer(ClickHouseProtocol.HTTP);

        try (ClickHouseClient client = ClickHouseClient.newInstance()) {
            ClickHouseRequest<?> req = client.connect(server);

            ClickHouseHttpConnection conn = ClickHouseHttpConnectionFactory.createConnection(server, req, null);
        }
    }
}
