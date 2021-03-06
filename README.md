# glb-ctl

A Java client for the [Galera Load Balancer](https://github.com/codership/glb) [control interface](https://github.com/codership/glb#runtime-management)

## Warning

All of this project was done really quickly (in less than an hour) 
to be used in an other project. It works OK for me, but may set your computer on fire, 
YMMV. Use at your own risk.

## Usage

In your `pom.xml`:

```xml
<dependency>
    <groupId>ca.pjer</groupId>
    <artifactId>glb-ctl</artifactId>
    <version>0.0.1</version>
</dependency>
```

In your code:

```java
import ca.pjer.glbctl.GlbCtl;
import ca.pjer.glbctl.GlbCtlFactory;
import ca.pjer.glbctl.GlbNode;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // try-with-resources to open and finally close the connection
        try (GlbCtl ctl = GlbCtlFactory.connect("127.0.0.1", 4444)) {

            // add or update node (weight of -1 to remove, 0 to drain)
            ctl.update(new GlbNode("10.0.0.1", 8080), 5);

            // query node
            ctl.getInfo().getRouter().entrySet().forEach(entry ->
                    System.out.println(entry.getKey().getHost() + ":" + entry.getKey().getPort()
                            + " has a weight of " + entry.getValue().getWeight()
                            + " and " + entry.getValue().getConns() + " active connections"));

            // query stats
            System.out.println("Stats: " + ctl.getStat());


        } catch (InterruptedException e) {
            // ignore
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
