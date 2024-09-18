package com.sixkery.basis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author sixkery
 * @since 2024/9/17
 */
public class HdfsClient {

    private FileSystem fileSystem;

    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("hdfs://hadoop100:8020");
        Configuration entries = new Configuration();
        String user = "guigu";
        fileSystem = FileSystem.get(uri, entries, user);
    }

    @After
    public void close() throws IOException {
        fileSystem.close();
    }


    @Test
    public void testMkdir() throws IOException {
        fileSystem.mkdirs(new Path("/basis/test/mkdir2"));
    }
}
