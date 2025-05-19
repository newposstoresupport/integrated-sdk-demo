# integrated-sdk-demo
This project provides the official Huazhirong integration method and steps as well as key points to note, helping access personnel to quickly integrate.

## [integrated-sdk-demo](https://github.com/newposstoresupport/integrated-sdk-demo) for NEWPOS Android

for Android(Kotlin) ([project](https://github.com/newposstoresupport/integrated-sdk-demo-kotlin))

### PREREQUISITES

* JDK 11+
* Android SDK

### BUILD

* Install prerequisites
* Clone the repo using `git clone https://github.com/newposstoresupport/integrated-sdk-demo.git`


## How to integrated sdk in your project?

### 1.step1
#### You need to add the SDK dependency to your project.
```
compileOnly(files("external/sdk_example.jar"))
```
[View Details](./app/build.gradle)

* 1.If you put the sdk.jar in the regular libs folder, even if you use
```
compileOnly(files("libs/sdk_example.jar"))
```
there will be problems if you have
```
implementation fileTree(include: ['*.jar'], dir: 'libs')
```
in your configuration.

* 2.sdk.jar is only involved in compilation and not in packaging


### 2.step2 
#### Adding a shared library
```xml
<application
    android:name=".MainApplication">
    ...
    <uses-library android:name="com.pos.device" android:required="false"/>
    <activity>
        ...
    </activity>
    ...
</application>
```
[View Details](./app/src/main/AndroidManifest.xml)

You need to add the shared library configuration under the
application node of the manifest so that the Android system
can help the app load the corresponding shared library.


### 3.step3 Initialize SDK
```java
import com.pos.device.SDKManager;
import com.pos.device.SDKManagerCallback;
SDKManager.init(context, new SDKManagerCallback() {
    @Override
    public void onFinish() {
        Log.w("SDK", "init sdk success");
    }
});
```
#### Call our SDKManager to initialize and then you can develop related business
[View Details](./app/src/main/java/com/newpos/integrated/sdk/demo/MainApplication.java)

* 1.If you initialize in your application, be sure to apply the 
application to the manifest.
* 2.Or you can initialize it before calling any interface. We 
recommend initializing it in the application to facilitate building 
an integrated project.


License
-------

```
Copyright 2025 NEWPOSTech Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```