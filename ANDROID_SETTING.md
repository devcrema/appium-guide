### java 설정
```shell
brew tap AdoptOpenJDK/openjdk
brew install --cask adoptopenjdk8

echo export JAVA_HOME=`/usr/libexec/java_home -v 1.8` >> ~/.zshrc
source ~/.zshrc
```

### android sdk 설치
```shell
# set path
mkdir -p ~/.android-home
echo export ANDROID_HOME=~/.android-home >> ~/.zshrc
# install android-sdk and link
brew install --cask android-sdk
ANDROID_SDK_HOME=$(brew info android-sdk | grep -o -m 1 -E ".+\/android-sdk\S+")
ln -s $ANDROID_SDK_HOME/tools ~/.android-home/tools
# install android-platform-tools and link
brew install --cask android-platform-tools
ANDROID_PLATFORM_TOOL_HOME=$(brew info android-platform-tools | grep -o -m 1 -E ".+\/android-platform-tools\/.+\/platform-tools")
ln -s $ANDROID_PLATFORM_TOOL_HOME ~/.android-home/platform-tools
source ~/.zshrc

# 설치 후 확인
appium-doctor --android
```

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