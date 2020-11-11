# agile4j-kts-loader

* 该工程方案来自于[KtsRunner](https://github.com/s1monw1/KtsRunner)，因[KtsRunner](https://github.com/s1monw1/KtsRunner)不支持Kotlin 1.3.30及以上版本，所以另起炉灶，通过增加依赖kotlin-scripting-compiler-embeddable解决该问题。
* 使用方式：
```Kotlin
eval("src/test/resources/test-script.kts")
```