Android Authenticator
----------------------------

This project is a basic [Android](https://www.android.com/) application using [Kotlin](https://kotlinlang.org/) as language

### Requirements

* [Android Studio](https://developer.android.com/studio)
* Pixel 6 emulator API level 33 and platform version 13

### To build the project

```bash
gradle assembleDebug
```

### To run emulator

```bash
${androidSdk}/emulator emulator -adv ${deviceName} 
```

Where:
- `${androidSdk}` is your Android SDK directory
- `${deviceName}` is device you created

### To install the app

```bash
${androidSdk}/platform-tools/adb -s emulator-5554 install ${projectHome}/app/build/outputs/apk/debug/app-debug.apk
```

Where:
- `${androidSdk}` is your Android SDK directory
- `${projectHome}` is your project directory

**Note:** Android authenticator uses [spring-web-resource-server](https://github.com/josdem/spring-web-resource-server) project as a backend service.