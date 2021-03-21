### java 설정
```shell
brew tap AdoptOpenJDK/openjdk
brew install --cask adoptopenjdk8

echo export JAVA_HOME=`/usr/libexec/java_home -v 1.8` >> ~/.zshrc
source ~/.zshrc
```

## android sdk 설치
### android studio 없이 brew로만 사용
```shell
brew install --cask android-sdk
brew install --cask intel-haxm
echo export ANDROID_HOME=/usr/local/share/android-sdk >> ~/.zshrc
source ~/.zshrc
sdkmanager "platform-tools" "emulator" "extras;intel;Hardware_Accelerated_Execution_Manager" "platforms;android-27" "build-tools;27.0.0" "system-images;android-27;google_apis;x86"
avdmanager create avd -n test_avd -k "system-images;android-27;google_apis;x86"
# change emulator link
unlink /usr/local/bin/emulator
ln -s /usr/local/share/android-sdk/emulator/emulator /usr/local/bin/emulator
```
### emulator 사용법
```shell
# list
emulator -list-avds
# run
emulator -avd test_avd
```
### 다른 종류의 emulator 등록
```shell
# list
avdmanager list device
# set -n [name of avd] -d [number of device]
avdmanager create avd -n name_of_avd -d 17 -k "system-images;android-27;google_apis;x86"
```

### 설치 후 확인
- `appium-doctor --android`

### 만약 mac에서 확인되지 않은 개발자라고 하며 emulator를 실행할 수 없다고 나오면?
- `xattr -d com.apple.quarantine emulator`

### 추가 기능 설치 (필요시)
```shell
# 아래 모듈들의 appium 연동은 추가 설정이 필요할 수 있음
brew update
brew install opencv@4
brew link --force opencv@4
npm install --save opencv4nodejs
brew install ffmpeg
npm i -g mjpeg-consumer
brew install bundletool
brew install gstreamer
```