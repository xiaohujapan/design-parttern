package org.dxh.java.basespring.tinyioc.step5.io;

import java.io.InputStream;

import org.dxh.java.basespring.tinyioc.step5.io.Resource;
import org.dxh.java.basespring.tinyioc.step5.io.ResourceLoader;

public class ResourceLoaderTest {

	public static void main(String[] args)throws Exception{
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
