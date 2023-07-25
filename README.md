# spring_notice_board


## 배운거 정리

### 1 일차 - (1) 스프링 부트 시작, (2) MVC 패턴 이해와 실습

<img width="448" alt="image" src="https://github.com/jongheonleee/spring_notice_board/assets/87258372/f5fcd109-3418-4f3c-a797-b840117293d6">
<br/>

- 스프링 부트는 자바 웹 제작을 도와주는 도구
- localhost:8080 내컴을 의미
- 브라우저에 "localhost:8080" 치면 내 컴퓨터에 운영되고 있는 서버와 통신
- 서버 내부에 있는 파일을 직접 가져다가 쓸 수 가 있음, 이때 클라이언트가 localhost:8080/hello.html이라고 요청하면
  스프링은 src/main/resources/static에서 해당 파일을 반환함
- 또 다른 방법은 템플릿을 쓰는 것, 템플릿은 웹 페이지 틀로서 그 틀 위에다가 변수를 통해서 서로 다른 데이터를 같은 웹 페이지 틀에다가 보여줄 수 있음
- mvc에서 model은 데이터, view는 템플릿, controller는 사용자 요청에 따른 서버 내부에서 작업흐름을 컨트롤해줌
- controller는 @Controller로 컨트롤러라고 명시하고 내부적으로 @GetMapping과 같은 애노테이션을 특정 메서드에 적용하여 특정 요청에 따른 작업을 진행할 수 있게함
- 이때, 메서드의 파라미터로 Model을 통해서 템플릿에서 사용할 변수를 저장했다가 메서드가 템플릿을 호충하면 템플릿은 Model에 있는 변수를 보여줌

### 간단하게 정리 - 클라이언트의 단순한 요청에 따른 서버 내부의 작업 흐름과 응답을 배움 


<br/>

### 2 일차 - (3) 게시판 만들고 새 글 작성하기

#### 1. form 전송에 따른 서버 내부 작동 원리

- 클라가 form을 통해 데이터를 담아서 서버에 전송할 때 서버 내부의 작동 원리 설명
- 일단, 클라가 form을 작성하는 페이지에서 form 태그에는 action과 method가 있는데 이는 해당 form을 어디로(url), 어떻게(http api method) 보낼지에 대한 정보임
- 또한, form에 데이터를 입력하는 부분에는 name이라는 속성이 있는데 name에 서버 내부에서 정의된 dto의 필드이름이 적혀져 있음
- 이를 통해 form -> dto로 변환함
- controller에서 클라한테 요청이 올때는 먼저 url, method를 확인하여 그에 맞는 작업을 해주는 메서드를 호출함, 이때 dto를 해당 메서드의 파라미터로 넘겨줌

#### 2. DB에 데이터를 저장할 때 서버 내부 작동 원리

<img width="781" alt="image" src="https://github.com/jongheonleee/spring_notice_board/assets/87258372/3dbe28d3-5be4-48d5-a715-1588748dcdc5">
<br/>

- dto -> entity로 변환해주어야함
- dto는 사용자가 입력한 데이터만을 담는 것이라면 entity는 db에 저장될 테이블을 dto 기반으로 만들어서 db에 저장할 수 있게끔 도와줌
- dto에 각 필드를 column으로 만들어서 테이블을 제작함
- 생성된 entity를 db에 저장해야함
- 이때, db에 데이터를 추가 수정 삭제를 할 때 sql이 필요하며 이를 돕는 다양한 도구들이 있음, 우리가 사용할 것은 Jpa로 자바를 통해서 db에 명령을 내릴 수 있게끔 도와주는 툴임
- 다양한 기술들이 존재하기 때문에 Repository를 인터페이스로 선언하여 변경에 용이하게 함

### 간단하게 정리하기 클라이언트가 서버로 데이터를 보낼 때 해당 데이터는 dto, entity 형식으로 보낸다, 이때 dto는 클라이언트가 입력한 데이터를 보관하는 용도고 entity는 dto를 기반으로 테이블을 만들어서 db에 저장하는 용도임
