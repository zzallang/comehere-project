
프로젝트 소개
- 운동모임을 빠르고 간편하게 찾을 수 있고, 누구나 쉽게 모임을 만들거나 참여할 수 있는 모임 기능과 더불어 회원들이 서로 소통하고 정보를 공유할수 있는 커뮤니티 기능을 가진 종합 운동 사이트.

프로젝트 진행기간
- 2022년 9월 8일 ~ 2022년 11월 25일

프로젝트 주요 사용 기술 

- Java / Spring Boot 
- MariaDB/ mybatis / undertow / Thymeleaf
- JS / Ajax/ jquery / Bootstrap / SweeetAlert
- Eclipse / VScode / Gradle 
- GitHub / GitKraken / Sequel Pro

프로젝트 아키텍처

![](https://velog.velcdn.com/images/hunsik0302/post/a697957b-72a7-484e-a9c9-a55d2e1d6f4d/image.png)



프로젝트 수행 절차

![](https://velog.velcdn.com/images/hunsik0302/post/4b44e069-c5fe-453f-858d-e1b604309d9a/image.PNG)

프로젝트 수행

1. Kakao Oven을 통한 UI 프로토타입 작성
![](https://velog.velcdn.com/images/hunsik0302/post/5c0125d7-553f-40e2-8500-15bef781f7c0/image.PNG)


2. Use-Case 작성

![](https://velog.velcdn.com/images/hunsik0302/post/f2c6990f-a097-4ace-843c-c3321cd59e11/image.PNG)

3.데이터 모델링 및 데이터 입력.

![](https://velog.velcdn.com/images/hunsik0302/post/9d3a9ed1-ea7d-45cf-bd4f-db84954e43a7/image.PNG)


4.메인 페이지 UI 및 기능 구현


![](https://velog.velcdn.com/images/hunsik0302/post/7f288079-39e5-4f26-9a7a-53dd2174d1de/image.PNG)


5.로그인 UI 및 기능 구현

![](https://velog.velcdn.com/images/hunsik0302/post/30422d6f-19a8-42de-9b89-7d17f9d79950/image.PNG)

6.신고 UI 및 기능 구현

![](https://velog.velcdn.com/images/hunsik0302/post/d9d47b7e-e75a-40d9-b5d4-64dc3fe45235/image.PNG)


7.Review UI 및 기능 구현

![](https://velog.velcdn.com/images/hunsik0302/post/8cf2ceed-f5cf-48c6-83ef-945b7a56240d/image.PNG)


8.GitKraken 을 사용해 통합 및 테스트.


![](https://velog.velcdn.com/images/hunsik0302/post/5043d002-cce7-480e-9b00-4d935f7acafd/image.PNG)

9.수많은 디버깅 후 프로젝트 발표.

<br>
10.프로젝트 후기

 처음 시작하면서 UI 작성하고 USE-Case 작성할때만 해도 정말 막막하기만 했었는데 정말 좋은 팀원들을 만나 너무 즐겁고 행복한 시간을 보냈다.
프로젝트를 하면서 정말 중요하다고 느꼇던건 소통과 포기하지 않는것. 이 두가지를 배웠던거 같다. 
 
## 소통의 소중함
 프로젝트를 시작하자마자 한 팀이 소통 자체가 안되서 프로젝트가 시작되자마자 분열 되어
팀이 해체가 되었는데 그 팀을 보면서 더욱 더 열심히하고 소통을 잘해야 겠다는 생각이 들었다.
초기 프로젝트할때는 각자 맡은 부분만 하다가 나중에 Gitkraken으로 병합하면서 서로의 코드가 엉망이 되어 
소통을 하기 시작해 매주 발표가 있어 발표 전 코드를 통합할 때마다 이번엔 나 부터 Pull Commit 하고 Push를 해볼까?아니면
각자의 Branch에서 Pull하고 Commit한다음 LocalMain 으로가서 각자 Branch랑 병합하고 그걸 메인이랑 Merge 한다음 순서대로 해볼까? 
이런저런 의견을 서로 맞추며 프로젝트 발표 전까지 Gitkraken을 이용해 통합해가며 소통을 했었다.

 DB Modelling 할때 또한 합숙을 하며 밤새 우리 MemberTable안에 Column은 이런게 들어가는게 좋을까? MemberTable과 보드 Table은
1대 다의 관계인가? 나중에 Table 간에 Join 할때 PK,FK 중복 되는거없나? 정말 꼼꼼히 서로 밤새 소통하며 다음날 학원 등원했던것도
기억에 많이 남고, 직접 홈페이지 구현하면서도 정말 많은 시행 착오가 있었지만 소통하며
프로젝트가 끝날때까지 단 한 번도 큰 다툼 및 감정싸움 없이 잘 마무리 할수 있었다.
서로의 시간 맞을때마다 합숙을 하면서 소통하면서 누구보다 열정적으로 해준 팀원들에게 다시 한번더 고맙다.

## 포기하지 않는것
정말 처음 프로젝트를 구현하라고 했을때 너무 막막해 답답한 마음에 브라우저 창만 열어놓고 무엇을 검색해야 할지 몰라
멍하니있던 것을 기억한다. 그러면서 할 수있는거라도 조금씩 해보자! 라는 마음으로 하다보니 조금씩 풀리기 시작했고,
조금씩 하다보니 자신감도 생기면서 개발에 속도가 붙어 재미도 느끼고, 로그인에 비밀번호찾기를 Thymeleaf와 Ajax 통신을 하면서
유효성검사가 됬을때 그 희열은 아직도 잊을수 없다. 

프로젝트를 하면 할수록 모르는게 얼마나 많은지 새롭게 느꼇고, 평생을 공부해도 다 할 수 있을까? 라는 생각도 문득 들었지만
평생 배울 수 있다는 생각에 잠을 설치던 시간도 있었고, 처음보는 기술이나 메소드 등등 더 알아보고 직접 코드 입력하면서 원리와 
사용법을 알고 싶었지만 프로젝트 기간이 정해져있다보니 넘어간 부분이 많은데, 현재 프로젝트가 끝나서 혼자 개인적으로 아쉬운부분이
많아서 세미 프로젝트로 게시판도 혼자 다시 만들어보고 로그인도 API를 활용해서 로그인도 다시 만들어보고 있다.

나중에 개발자가 되어서 현업에 가서도 팀원들과의 소통은 디폴트이고 고객과의 소통도 중요하다고 느끼게 되었다.
고객과 소통하면서 원하는 바가 무엇인지 캐치를 해서 구현하는 게 중요하다고 느꼇고, 역시 포기만 안하면 뭐든 다 할수 있다고 느끼게
되는 계기가 되었고, 개발자는 평생 배우며 살아가야 한다는 그 사실이 가슴을 뛰게 한다.




11.토이 프로젝트 수행

 1) form 
![](https://velog.velcdn.com/images/hunsik0302/post/94bcb7a4-5715-4378-baf4-cb619ca1a904/image.png)

2) list 
![](https://velog.velcdn.com/images/hunsik0302/post/b0cfc64c-e2bd-4322-a799-c87da0de5ea6/image.png)

3) detail

![](https://velog.velcdn.com/images/hunsik0302/post/495b3e88-4f3d-47bc-96e8-3b151f10bf41/image.png)

