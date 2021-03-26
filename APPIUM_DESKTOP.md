appium 서버를 cli가 아니라 버튼으로 띄울 수 있음
그외 inspect같이 몇가지 도움을 주는 툴들이 있음.

용도는 이것으로 production에 쓸만한 전체 테스트를 작성하는 것이 아니라
테스트코드를 작성하는데에 도움을 얻는 용도.

## 사용법
- 각 OS에 맞게 .dmg파일이나 .exe파일을 다운받는다. (https://github.com/appium/appium-desktop/releases)
- mac에서 실행이 안되면 option을 누르고 우클릭해서 실행하면 됨.
- start server
- 우측 상단의 돋보기 모양의 start inspector session
- custom server를 누르고 Desired Capabilities에 `platformName, Android` 넣고 start session
- 연결이 잘 되었다면 왼쪽에 실제 화면이 보여지고 클릭을 통해 해당 요소의 id나 속성들을 확인할 수 있음 
