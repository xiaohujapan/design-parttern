package org.dxh.java.basespring.tinyioc.step4;

import java.io.IOException;
import java.io.InputStream;

import org.dxh.java.basespring.tinyioc.step4.io.Resource;
import org.dxh.java.basespring.tinyioc.step4.io.ResourceLoader;

public class ResourceLoaderTest {

	public static void main(String[] args)throws IOException {
		ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc-test.xml");
        InputStream inputStream = resource.getInputStream();
        if(inputStream == null) {
        	System.out.println("NG");
        }else {
        	System.out.println("OK");
        }

	}

}
