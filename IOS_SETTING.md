### xcode 설치
- App Store > xcode 설치
- xcode command line tools 설치
```
xcode-select --install

```
- xcode location 설정
    - Xcode > Preferences > Locations > Command Line Tools 눌러서 경로 지정
### carthage 설치
```
brew install carthage
```

### 설치 확인
```
appium-doctor --ios
```

### ios simulator 실행
```
open -a simulator
```

### 추가 요소 설치 (필요시)
- appium-idb
```
brew install python3
brew tap facebook/fb
brew install idb-companion
python3 -m pip install --user fb-idb
```
