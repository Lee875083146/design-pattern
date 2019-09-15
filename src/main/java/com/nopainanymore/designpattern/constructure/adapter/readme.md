
## 概念

把一个接口转换为客户端希望的另一个接口，适配器模式使接口不兼容的类也可以一起工作。

适配器模式可以是类结构型模式，也可以是对象结构型模式。

## 结构和工作原理

适配器模式包含一下角色：
* Target：目标抽象类
* Adapter：适配器类
* Adaptee：适配者类
* Client：客户端

当客户端调用适配器的方法时，在适配器内部将调用适配者类的方法，这个过程对客户端是透明的，客户端并不直接访问适配者类。因此，适配器可以使由于接口不兼容而不能交互的类可以一起工作。

### 类结构型模式

类结构型模式中，适配器类既是目标抽象类也是适配者类的子类。

### 对象结构型模式

对象结构型中，适配器类中有适配者类的引用。


## 优缺点

### 优点
* 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，而无须修改原有代码。
* 增加了类的透明性和复用性，将具体的实现封装在适配者类中，对于客户端类来说是透明的，而且提高了适配者的复用性。
* 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
* 
类适配器模式还具有如下优点：
由于适配器类是适配者类的子类，因此可以在适配器类中置换一些适配者的方法，使得适配器的灵活性更强。

对象适配器模式还具有如下优点：
一个对象适配器可以把多个不同的适配者适配到同一个目标，也就是说，同一个适配器可以把适配者类和它的子类都适配到目标接口。

### 缺点

类适配器模式的缺点如下：
对于Java、C#等不支持多重继承的语言，一次最多只能适配一个适配者类，而且目标抽象类只能为抽象类，不能为具体类，其使用有一定的局限性，不能将一个适配者类和它的子类都适配到目标接口。

对象适配器模式的缺点如下：
与类适配器模式相比，要想置换适配者类的方法就不容易。如果一定要置换掉适配者类的一个或多个方法，就只好先做一个适配者类的子类，将适配者类的方法置换掉，然后再把适配者类的子类当做真正的适配者进行适配，实现过程较为复杂。


## 代码示例

```java
public interface Interface {

    void connect();
}
```

```java
@Slf4j
public class HDMIInterface implements Interface {

    @Override
    public void connect() {
        log.info("HDMIInterface- display- connect to HDMI display device ");
    }
}
```

```java
@Slf4j
public class USBInterface implements Interface {

    @Override
    public void connect() {
        log.info("USBInterface- connect to USB device");
    }

}
```


```java
@Slf4j
@Getter
@Setter
public class ThunderboltInterface implements Interface {

    private Interface hdmi;

    private Interface usb;

    public ThunderboltInterface() {
    }

    @Override
    public void connect() {
        charging();
        transferByUSB();
        display();
    }

    private void charging() {
        log.info("ThunderboltInterface- charging to Mac");
    }

    private void transferByUSB() {
        if (usb != null) {
            usb.connect();
        } else {
            log.info("ThunderboltInterface- interface is Thunderbolt, transfer data with high speed");
        }
    }

    private void display() {
        if (hdmi != null) {
            hdmi.connect();
        } else {
            log.info("ThunderboltInterface- display- interface is Thunderbolt, display by Thunderbolt 3");
        }
    }
}
```

```java
public class Client {

    public static void main(String[] args) {
        ThunderboltInterface thunderboltInterface = new ThunderboltInterface();
        thunderboltInterface.setHdmi(new HDMIInterface());
        thunderboltInterface.connect();

        ThunderboltInterface thunderboltInterface1 = new ThunderboltInterface();
        thunderboltInterface1.setUsb(new USBInterface());
        thunderboltInterface1.connect();
    }

}

```

## 参考资料
[Graphic Design Patterns](https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/adapter.html)