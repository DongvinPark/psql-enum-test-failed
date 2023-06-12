# postgresql의 enum 타입과 JPA 호환되게 만들기

### 결과적으로 아직 성공하지 못했다.
- 구글링 결과 방법을 설명하는 글을 보고 적용해봤지만, 실제 우리 디비의 [ ..._enum ] 타입이 아니라, 결국은 ordinal 로 설정돼 버리고 만다.
- 게다가 코드도 길고 복잡하다.
- 애초에 NestJS에서 왜 type: enum을 썼는지 생각해보자. 결국 해당 enum 타입이 아닌 값은 DB에 입력하고 싶지 않은 것 아닌가? 그런 거라면, JPA에서 지원하고, 다른 디비들과도 잘 호환되는 Enumerated String 으로 해도 충분하다. 그런데 Typeorm에서 괜히 enum 타입을 써서 같은 일을 굳이 더 특정 디비에 종속적이고 코드도 더 복잡하게 처리하고 있다.
- 가장 근본적인 문제는 JPA에서 지원하는 enum 처리 방법과 psql에 이미 셋팅돼 있는 USER DEFINED 타입인 어쩌고저쩌고 enum이 서로 호환되지 않는다는 것이다.
- 이미 psql에 자의적으로 셋팅해놓은 user defined 타입들이 JPA 로직을 방해하고 있으며, 서로 호환되지도 않을 뿐더러, 그걸 해결하기 위해서 들어갈 시간은 예측 불가능할 정도로 많을 것 같은데, 그걸로 얻는 이득은 JPA에서 이미 잘 지원하고 있는 emumerated string 타입으로 얻는 이득보다 크지도 않은 것이다.