package org.dxh.pattern.factory;


/**
 * Reserve Enum Class In order to  match object
 * 用枚举类型实现对象匹配
 * 列挙型を使って、対象を実現する
 * 
 * @author xiaohujapan
 * @since 8.0
 */
public enum Factory {
    CIRCLE(new Circle(),"CIRCLE"),
    RECTANGLE(new Rectangle(),"RECTANGLE"),
    SQUARE(new Square(),"SQUARE");
    
    private Shape shape;  
    private String name;  
    
    public static Shape getShape(String name) {  
        for (Factory c : Factory.values()) {  
            if (c.name.equals(name)){  
                return c.shape;  
            }  
        }  
        return null;  
    } 

    private Factory(Shape shape, String name) {  
        this.shape = shape;  
        this.name = name;  
    } 
    
    public String getName() {
        return name;
    }
    public Shape getShape() {
        return shape;
    }
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    public void setName(String name) {
        this.name = name;
    } 
    
}
