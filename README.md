# 📊 Customer Tracking System
> 오픈소스 SW 설계 수업에서 진행한 프로젝트입니다.<br/>
> 매장 운영을 돕기 위한 **고객 추적 및 관리 시스템**으로 방문자 정보를 수집하여 통계를 제공하고 매출 증대를 돕는 것을 목표로 설계되었습니다.

## 💡 Project Highlight: Architectural Discovery
이 프로젝트는 웹/앱 프로그래밍을 본격적으로 학습하기 전, **Java Swing**을 활용해 구현한 애플리케이션입니다.
개발 과정에서 필요에 의해 스스로 고안한 구조가 현재의 **MVC 패턴** 및 **Client-Server 아키텍처**와 유사하다는 점에서 **백엔드적 사고의 기초를 다지게 된 중요한 프로젝트**입니다.

- **UI와 로직의 분리 (MVC 패턴의 발견)**
  - 개발 초기에는 한 파일에 코드를 작성했으나 복잡도를 낮추기 위해 화면(UI)과 흐름 제어(Control)를 분리했습니다.
  - `MainControl.java`: 웹의 **Router** 역할. 메인, 로그인, 로그아웃 등의 전체적인 흐름 제어 및 화면 전환 담당.
  - `ManagerMain.java`, `OwnerMain.java`: 사용자 권한(관리자/점주)에 따른 전용 **View** 구현.

- **서버 및 데이터 관리의 필요성 인지 (Simulated Server)**
  - 데이터를 중앙에서 관리해야 할 필요성을 느껴 `Server.java`를 구현하여 로컬 환경이지만 **가상의 서버** 역할을 수행하도록 설계했습니다.
  - `User.java`, `Manager.java`, `Owner.java`, `Customer.java`: 파일 시스템을 활용하여 데이터를 저장하는 **Domain/Service Layer** 역할을 수행합니다.

- **데이터 최적화 및 통계 설계 (Data Modeling)**
  - `Translation.java`: 고객 정보를 효율적으로 저장하고 통계 그래프를 그리기 위해 문자열(String) 데이터를 숫자(int) 코드로 변환/매핑하는 번역 클래스를 설계했습니다. (DB의 인덱싱/Enum 매핑과 유사한 접근)

 - **순수 자바 라우팅의 한계와 프레임워크의 필요성 체감 (Retrospective)**
   - `MainControl.java`에서 모든 화면 전환과 클라이언트 요청을 직접 분기 처리하다 보니, 기능이 추가될수록 컨트롤러가 비대해지고 객체 간 결합도가 급격히 높아지는 문제(Routing Complexity)에 직면했습니다.
   - 이 뼈아픈 경험은 이후 Spring Boot 생태계에 입문했을 때, 프레임워크가 제공하는 **`DispatcherServlet`의 중앙 집중식 요청 처리**와 <b>제어의 역전(IoC)</b>이 얼마나 우아하고 혁신적인 아키텍처인지 깊이 통감하고 흡수하게 해 준 최고의 자양분이 되었습니다.

## 🛠 Tech Stack
![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=openjdk&logoColor=white) 
![Java Swing](https://img.shields.io/badge/Java%20Swing-E76F00?style=flat&logo=java&logoColor=white) 
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=flat&logo=intellij-idea&logoColor=white)

## 📂 Contents

### 📐 SW Design Reports
SW 설계 프로세스에 따라 작성된 산출물입니다.
- **Conceptualization**: 시스템 컨텍스트 다이어그램 (System Context Diagram)
- **Analysis**: 유스케이스(Use Case) 다이어그램, UI 프로토타입
- **Design**: 클래스(Class), 시퀀스(Sequence), 상태 머신(State Machine) 다이어그램

### 💻 Program Code
- **Source files**: `CustomerTrackingSystem/src/main`
- **Library files**: `lib`

### 🎥 Demo Video
- **실행 영상 보기**: [구글 드라이브 링크](https://drive.google.com/file/d/1G7gNC6YPThfDiN8dcv6-2BeIRPUZd_cQ/view?usp=drive_link)

## 🚀 How to Run
1. **Environment**: JDK 21.0.6, IntelliJ IDEA
2. **Library**: `lib` 디렉토리 내의 jar 파일들이 Classpath에 포함되어야 합니다.
3. **Execution**: `MainControl` 클래스를 실행하면 프로그램이 시작됩니다.
