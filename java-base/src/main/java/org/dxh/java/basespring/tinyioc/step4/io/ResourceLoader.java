package org.dxh.java.basespring.tinyioc.step4.io;

import java.net.URL;

public class ResourceLoader {
	
    public Resource getResource(String location){
        URL resource = this.getClass().getResource(location);
        return new UrlResource(resource);
    }

}
