# agile4j-kts-loader

## 如何引入

>Gradle
```groovy
dependencies {
    compile "com.agile4j:agile4j-kts-loader:1.0.0"
}
```

>Maven
```xml
<dependency>
    <groupId>com.agile4j</groupId>
    <artifactId>agile4j-kts-loader</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 使用方式
### 执行脚本
```Kotlin
eval("src/test/resources/test-script.kts")
```

> src/test/resources/test-script.kts
```Kotlin
println("test-script")
```

### 执行脚本并返回对象
```Kotlin
val model = load<Model>("src/test/resources/test-load-model-script.kts")
```

> src/test/resources/test-script.kts
```Kotlin
import com.agile4j.kts.loader.Model

Model(1L)
```