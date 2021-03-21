# appium-guide

여기에 작성된 스크립트들은 모두 mac os, linux 기준으로 작성되었음.

windows의 경우에는 WSL(Windows Subsystem for Linux)를 사용하는 것을 권장함

### brew가 없다면
https://brew.sh/
```shell
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

### node가 없다면
```shell
brew install node
```

### appium 설치
```shell
npm install -g appium
```

### GUI 버전
```
https://github.com/appium/appium-desktop/releases
```

### 설치 확인
```shell
npm install -g appium-doctor
appium-doctor
appium-doctor --ios
appium-doctor --android
```

### appium 시작
```shell
appium
```

- 아니면 gui에서 서버 시작버튼을 눌러도 됨.
- 기본 서버 port는 4723
- 포트를 바꾸려면 appium -p 포트

### Driver 설정
appium은 각 플랫폼을 driver를 통해 지원하기 때문에 각 driver에 대한 이해가 필요함
- The XCUITest Driver (for iOS and tvOS apps)
- The Espresso Driver (for Android apps) (앱 내부 검증)
- The UiAutomator2 Driver (for Android apps) (앱 이외 화면과 여러앱을 검증)
- The Windows Driver (for Windows Desktop apps)
- The Mac Driver (for Mac Desktop apps)

### client 설정
- appium은 HTTP 서버기 때문에 client없이는 동작할 수 없음.
- selenium에서 쓰이는 WebDriver Protocol을 이용하기 때문에 관련된 라이브러리를 이용할 수도 있고
순수하게 http 요청으로 짤수도 있고 appium에서 제공하는 sdk를 이용할 수도 있음.
- https://github.com/appium/java-client
- https://github.com/appium/python-client
- https://github.com/webdriverio/webdriverio
- https://github.com/appium/appium-dotnet-driver

## Android 설정
[Android 설정](ANDROID_SETTING.md)

## ios 설정
[ios 설정](IOS_SETTING.md)