# Spring Framework 정리 자료
스프링 핵심 원리 기본편 정리 문서

## 객체지향 설계와 스프링

#### 스프링이란?
- 필수
  - 스프링 프레임워크
  - 스프링 부트
- 선택
  - 스프링 데이터
  - 스프링 시큐리티
  - 스프링 배치
  - 스프링 클라우드
  - 스프링 세션
- 스프링 프레임워크
  - `핵심 기술`: 스프링 DI 컨테이너, AOP, 이벤트, 기타
  - 웹 기술: 스프링 MVC, 스프링 WebFlux
  - 데이터 접근 기술: 트랜잭션, JDBC, ORM 지원, XML 지원
  - 기술 통합: 캐시, 이메일, 원격접근, 스케줄링
  - 테스트: 스프링 기반 테스트 지원
  - 언어: 코틀린, 그루비
- 스프링 부트
  - 스프링을 편리하게 사용할 수 있도록 지원
  - Tomcat 같은 웹 서버를 내장
  - 단독으로 실행
  - 손쉬운 빌드 구성을 위한 starter 종속성 제공
  - 스프링과 3rd parth(외부) 라이브러리 자동 구성
  - 간결한 설정
- 스프링의 핵심
  - 스프링은 자바 언어 기반의 프레임워크
  - 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
  - 스프링은 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크

#### 좋은 객체 지향 프로그래밍이란?
- 객체 지향 특징
  - 추상화
  - 캡슐화 - 정보 은닉
  - `다형성:객체 지향의 꽃`
  - 상속
- 객체 지향 프로그래밍
  - 객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위, 즉 `객체`들의 모임으로 파악하고자 하는 것
- 다형성
  - `역할과 구현으로 구분`하면 세상이 단순해지고, 유연해지며 변경
- 다형성 장점
  - 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
  - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
  - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다. 
  - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
- 다형성 단점
  - 역할(인터페이스) 자체가 변하면, 클라이언트, 서버 모두에 큰 변경이 발생한다.
- 역할과 구현을 분리
  - 역할 = 인터페이스
  - 구현 = 인터페이스를 구현한 클래스, 구현 객체
  - 객체 설계 시 `역할(인터페이스)을 먼저 부여하고`, 그 역할을 수행하는 구현 객체 만들기
- 다형성의 본질
  - 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경
  - 클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경
- 자바 언어의 다형성
  - 다형성으로 `인터페이스`를 구현한 객체를 실행 시점에 유연하게 변경
  - 클래스 `상속 관계`도 다형성, 오버 라이딩 적용 가능
- 스프링과 객체 지향
  - 스프링에서 이야기하는 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원

#### 좋은 객체 지향 설계의 5가지 원칙(SOLID)
- 객체 지향 설계의 5가지 원칙
  - `SRP`: 단일 책임 원칙(single responsibility principle)
  - `OCP`: 개방-폐쇄 원칙 (Open/closed principle)
  - `LSP`: 리스코프 치환 원칙 (Liskov substitution principle) 
  - `ISP`: 인터페이스 분리 원칙 (Interface segregation principle)
  - `DIP`: 의존관계 역전 원칙 (Dependency inversion principle)
- SRP 단일 책임 원칙
  - 한 클래스는 하나의 책임만 가져야함
  - 중요한 기준은 변경으로 `변경이 있을 때 파급 효과가 적으면` 단일 책임 원칙을 잘 따른 것
- OCP 개방-폐쇄 원칙
  - 소프트웨어 요소는 확장에는 열려 있으나 `변경에는 닫혀 있어야함`
  - 다형성을 활용해서 구현을 분리를 잘 황용해야하나 구현 객체를 변경하려면 클라이언트 코드를 변경하는 문제가 있음
  - 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요가 한데 스프링에서는 스프링 컨테이너가 이를 해줌
- LSP 리스코프 치환 원칙
  - `다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것`으로 다형성을 지원하기 위한 원칙
  - 인터페이스를 구현한 구현체는 믿고 사용하려면 이 원칙이 필요
- ISP 인터페이스 분리 원칙
  - `특정 클라이언트를 위한 인터페이스 여러 개`가 범용 인터페이스 하나보다 낫다는 원칙
- DIP 의존관계 역전 원칙
  - 클라이언트 코드가 구현 클래스에 의존하지 않고 `인터페이스(역할)에만 의존해야한다는 원칙`
  - 의존성 주입은 이 원칙 을 따르는 방법 중 하나
- 다형성 만으로는 OCP, DIP를 지킬 수 없어 클라이언트 코드의 변경이 필요해지므로 스프링을 활용

#### 객체지향 설계와 스프링
- 스프링은 다형성에 OCP와 DIP를 가능하게 지원하는 프레임워크로 클라이언트 코드의 변경 없이 기능 확장
- 이상적으로는  역할과 구현을 분리하기 위해 모든 설계에 인터페이스를 부여하는 것이지만, 추상화라는 비용이 발생
- 기능을 확장할 가능성이 없다면 구체 클래스를 직접 사용하고, 향후 꼭 필요할 때 리팩터링해서 인터페이스를 도입

## 스프링 핵심 원리 이해 - 객체 지향 원리 적용

#### IoC, DI, 그리고 컨테이너
- 제어의 역전(Inversion of Control)
  - 일반적인 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고, 연결하고, 실행
  - 구현 객체는 자신의 로직을 실행하는 역할만 담당하고 프로그램의 제어, 할당, 흐름은 이제 외부 매체가 대신 해줌
  - 프로그램의 제어 흐름을 `직접 제어하는 것이 아니라 외부에서 관리하는 것이 제어의 역전(IoC)`
- 프레임워크 vs 라이브러리
  - 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크
  - 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 라이브러리
- 의존관계 주입
  - 의존 관계: 상속, 인터페이스 구현, 객체 사용 등등을 말함
  - 의존 관계 주입: `애플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것`
  - 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리 해서 생각해야 올바른 의존관계 주입이 가능
  - 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경 가능
  - 정적인 클래스 의존관계
    - 클래스 내에서 코드로 보여지는 의존 관계
  - 동적인 클래스 의존관계
    - 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계
- IoC 컨테이너(DI 컨테이너)
  - 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것
  - ApplicationContext를 스프링 컨테이너라고 함
  - 스프링 컨테이너는 @Configuration 이 붙은 코드를 설정(구성) 정보로 사용한다. 여기서 @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록하고 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라고함

## 스프링 컨테이너와 스프링 빈

#### 스프링 컨테이너
- 스프링 컨테이너 생성
  ```java
  ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
  ```
  - ApplicationContext라는 인터페이스는 스프링 컨테이너라고 하고 AnnotationConfigApplicationContext은 구현체 중 하나
  - XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스를 만듦
- 스프링 컨테이너 생성 및 빈 등록
  - 스프링 컨테이너를 생성할 때는 파라미터로 구성 정보를 지정 받음
  - 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록(빈 이름은 항상 다른 이름을 부여)
- 스프링 빈 의존관계 설정
  - 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입
- 컨테이너에 등록된 모든 빈 조회
  - ApplicationContext의 getBeanDefinitionNames()는 스프링에 등록된 모든 빈 이름을 조회
  - ApplicationContext의 getBean()은 빈의 이름으로 빈 객체(인스턴스)를 조회
  - BeanDefinition의 getRole()을 통해서 스프링 내부의 빈이 구분이 가능한데, ROLE_APPLICATION은 일반적으로 사용자가 정의한 빈이고 ROLE_INFRASTRUCTURE은 스프링이 내부에서 사용하는 빈

#### 스프링 빈
- 스프링 빈 기본 조회(1개)
  - ApplicationContext.getBean(타입)
  - ApplicationContext.getBean(빈 이름, 타입)
- 스프링 빈 동일한 타입이 둘 이상 조회
  - ApplicationContext.getBeansOfType() 을 사용하면 해당 타입의 모든 빈을 조회
- 스프링 빈 상속 관계 조회
  - 부모 타입으로 조회하면, 자식 타입도 함께 조회

#### BeanFactory와 ApplicationContext
- BeanFactory
  - 스프링 컨테이너의 최상위 인터페이스
  - 스프링 빈을 관리하고 조회하는 역할을 담당
  - getBean() 을 제공
- ApplicationContext
  - BeanFactory 기능을 모두 상속받아서 제공
  - BeanFactory에 여러가지 부가 기능이 추가된 것
    - 메시지소스를 활용한 국제화 기능
    - 환경변수
    - 애플리케이션 이벤트
    - 편리한 리소스 조회

#### 다양한 설정 형식 지원
- 애노테이션 기반 자바 코드 설정
  - `AnnotationConfigApplicationContext` 클래스를 사용하면서 자바 코드로된 설정 정보를 넘긺
- XML 설정
  - `GenericXmlApplictionContext` 클래스를 사용하면서 xml 설정 파일을 넘긺


#### BeanDefinition
- BeanDefinition: @Bean이나 <bean> 당 각각 하나씩 메타 정보가 생성되는 `스프링 빈 설정 메타 정보`
- BeanDefinition 정보
  - BeanClassName: 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)   
  - factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig   
  - factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
  - Scope: 싱글톤(기본값)
  - lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
  - InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명   
  - DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명   
  - Constructor arguments, Properties: 의존관계 주입에서 사용 (자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)
- BeanDefinition에 대해서는 너무 깊이있게 이해하기 보다는, 스프링이 다양한 형태의 설정 정보를 BeanDefinition으로 추상화해서 사용하는 것 정도만 이해

## 싱글톤 컨테이너

#### 싱글톤 패턴
- 웹 애플리케이션과 싱글톤
  - 웹 애플리케이션은 보통 동시에 여러 요청이 옴
  - 요청 마다 객체가 생성이 되면 메모리 낭비가 심하므로 스프링은 해당 객체가 딱 1개만 생성되고 공유하도록 설계하는 `싱글톤` 방식 이용
- 싱글톤 패턴
  - 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
  ```java
  public class SingletonService {
    
    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();
    
    //2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
          return instance;
    }

    //3. 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성을 막음
    private SingletonService() {
    }

  } 
  ```
- 싱글톤 패턴의 문제점
  - 싱글톤 패턴을 구현하는 코드 자체가 많이 들어감
  - 의존관계상 클라이언트가 구체 클래스에 의존 (DIP/OCP 위반)
  - private 생성자로 자식 클래스를 만들기 어려움

#### 실글톤 컨테이너
- 스프링 컨테이너
  - 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 싱글톤(1개만 생성)으로 관리
  - 스프링 컨테이너는 `싱글톤 컨테이너` 역할하고 이런 기능을 싱글톤 레지스트리라고 부름
  - 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 됨
  - DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용
  - 스프링의 기본 빈 등록 방식은 싱글톤이지만, 싱글톤 방식만 지원하는 것은 아니다. 요청할 때 마다 새 로운 객체를 생성해서 반환하는 기능도 제공
- `싱글톤 방식의 주의점`
  - 싱글톤 패턴이든 싱글톤 컨테이너를 사용하든, 객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에 `싱글톤 객체는 무상태로 설계해야함`
- 무상태 방식을 만들기 위한 방법
  - `클라이언트가 값을 변경할 수 있는 필드가 있으면 안됨`
  - 가급적 읽기만 가능해야함
  - 필드 대신에 자바에서 공유되지 않는 지역변수, 파라미터를 사용

#### @Configuration과 싱글톤
- 스프링 컨테이너는 싱글톤 레지스트리이므로 따라서 스프링 빈이 싱글톤이 되도록 보장
- 스프링은 클래스의 `바이트 코드를 조작하는 라이브러리를 사용하여 스프링 빈이 여러 개 생성되어도 하나만 만듦`
- @Configuration를 사용하고, @Bean만 사용해야 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장
- @Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않음


## 컴포넌트 스캔

#### 컴포넌트 스캔과 의존 관계 자동 주입
- 자바 코드의 @Bean이나 XML의 <bean> 등을 통해서 설정 정보에 직 접 등록할 스프링 빈을 나열하면 생산성이 떨어지므로 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 `컴포넌트 스캔`이라는 기능을 제공
- 스프링 빈들의 의존관계도 자동으로 주입하는 `@Autowired` 라는 기능도 제공
- 컴포넌트 스캔
  - 컴포넌트 스캔은 이름 그대로 @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
  - @Configuration 이 컴포넌트 스캔의 대상이 된 이유도 @Configuration 소스코드를 열어보면 @Component 애노테이션이 붙어있기 때문
  - 컴포넌트 스캔을 쓰게 되면 사용하는 빈이 자동으로 등록이 되는데 의존 관계를 수동으로 설정할 수 없어서 자동 의존 관계를 사용
  - @ComponentScan은 @Component가 붙은 모든 클래스를 스프링 빈으로 등록할 때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용
  - @Component("지정할 이름")을 통해서 빈 이름을 직접 지정할 수 있음
- 컴포넌트 스캔 속의 의존 관계 자동 주입
  - 생성자에 @Autowired 를 지정하면, 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입
  - getBean()과 동일한 역할
- 컴포넌트 스캔 탐색 위치
  - basePackages: 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색
  ```java
  @ComponentScan(
    basePackages = "hello.core",
  }
  ```
  - basePackageClasses: 지정한 클래스의 패키지를 탐색 시작 위치로 지정
  - 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치
  - 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상 단에 두는 것이 권장
- 컴포넌트 스캔 대상: @Component: 컴포넌트 스캔에서 사용하는 기본 설정
  - @Controlller: 스프링 MVC 컨트롤러에서 사용, 스프링 MVC 컨트롤러로 인식
  - @Service: 스프링 비즈니스 로직에서 사용
  - @Repository: 스프링 데이터 접근 계층에서 사용, 스프링 데이터 접근 계층으로 인식하고 데이터 계층의 예외를 스프링 예외로 변환
  - @Configuration: 스프링 설정 정보에서 사용, 스프링 설정 정보로 인식하고 스프링 빈이 싱글톤을 유지하도록 추가 처리
- 필터: @ComponentScan()의 설정안에서 필터링 가능
  - includeFilters: 컴포넌트 스캔 대상을 추가로 지정, @Component 면 충분하기 때문에, includeFilters 를 사용할 일은 거의 없음
  - excludeFilters: 컴포넌트 스캔에서 제외할 대상을 지정
- 필터 옵션
  - ANNOTATION: 기본값, 애노테이션을 인식해서 동작
  - ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해서 동작
  - ASPECTJ: AspectJ 패턴 사용
  - REGEX: 정규 표현식
  - CUSTOM: TypeFilter 이라는 인터페이스를 구현해서 처리
- 중복 등록과 충돌
  - 자동 빈 등록 vs 자동 빈 등록: 빈의 이름 지정을 같게 한 경우 주로 발생, ConflictingBeanDefinitionException 예외
  - 수동 빈 등록 vs 자동 빈 등록: 스프링에서는 수동 빈 등록이 우선권을 갖으나 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생
    - 프로퍼티에서 spring.main.allow-bean-definition-overriding 을 통해서 수동/자동 오버라이딩 설정이 가능


## 의존관계 자동 주입

#### 의존관계 주입 방법
- 생성자 주입
  - 생성자를 통해서 의존 관계를 주입 받는 방법
  - 컴포넌트가 스프링 빈에 등록 될 때 생성자가 호출되는데 그때 스프링 컨테이너에서 필요한 의존관계들을 주입
  - 생성자 호출시점에 딱 1번만 호출되는 것이 보장
  - `불변 의존고관계와 필수 의존관계`에 사용
  - 가장 권장되는 의존관계 주입 방법
  - 생성자가 단 1개라면 스프링 빈에 대해서 @Autowired를 생략 가능
  ```java
  @Component
  public class OrderServiceImpl implements OrderService {
      private final MemberRepository memberRepository;
      private final DiscountPolicy discountPolicy;

      @Autowired
      public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy; 
      }
  }
  ```

- 수정자 주입
  - setter라 불리는 필드의 값을 변경하는 수정자 메서드를 통해서 의존관계를 주입하는 방법
  - `선택, 변경 가능성이 있는 의존관계`에 특수하게 사용
  - 자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법
  ```java
   @Component
    public class OrderServiceImpl implements OrderService {
        private MemberRepository memberRepository;
        private DiscountPolicy discountPolicy;

        @Autowired
        public void setMemberRepository(MemberRepository memberRepository) {
          this.memberRepository = memberRepository; 
        }
        
        @Autowired
        public void setDiscountPolicy(DiscountPolicy discountPolicy) {
          this.discountPolicy = discountPolicy; 
        }
    }
  ```

- 필드 주입
  - 필드에 어노테이션을 통해서 의존관계를 주입하는 방법
  - 코드가 간결해서 많은 개발자들을 유혹하지만 외부에서 변경이 불가능해서 테스트 하기 힘들다는 치명적인 단점이 존재
  - DI 프레임워크가 없으면 아무것도 할 수 없는 코드가 되어 애플리케이션의 실제 코드와 관계 없는 테스트 코드를 만들 수 없음
  - 권장되지 않은 방법
  > 참고: 순수한 자바 테스트 코드는 @Autowired가 동작하지 않아서 @SpringBootTest 처럼 스프링 컨테이너를 테스트에 통합한 경우에만 가능

- 일반 메서드 주입
  - 일반 메서드를 통해서 주입 받는 방법
  - 일반적으로 사용되지 않는 방법
- 의존 관계 주입 주의 사항
  - `의존관계 자동 주입은 스프링 컨테이너가 관리하는 스프링 빈이어야 동작`하므로 스프링 빈이 아닌 클래스에서는 @Autowired 코드를 적용해도 아무 기능도 동작하지 않음

#### 옵션 처리
- 옵션 처리
  - 주입할 스프링 빈이 없어도 동작해야 할 때 사용
  - @Autowired만 사용하면 required 옵션의 기본값이 true로 되어 있어서 자동 주입 대상이 없으면 오류가 발생하는 것을 방지하기 위해 옵션 처리
- 옵션 처리
  - Autowired(required=false) : 자동 주입할 대상이 없으면 메서드 자체가 호출 안되게 만듦
  - org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null이 입력
  - Optional<> : 자동 주입할 대상이 없으면 Optional.empty가 입력, 자바의 기능

#### 생성자 주입을 선택해야하는 이유
- 불변
  - 대부분의 경우 불변한 의존관계가 이상적임
  - 대부분의 의존관계 주입은 한번 일어나면 애플리케이션 종료시점까지 의존관계를 변경할 일이 없음
  - 수정자 주입을 사용하면, setXxx 메서드를 public으로 열어두어야하므로 누군가 실수로 변경할 수 도 있고, 변경하면 안되는 메서드를 열어두는 것은 좋은 설계 방법이 아님
- 누락
  - 생성자 주입을 사용하면 주입 데이터를 누락 했을 때 컴파일 오류가 발생하므로 IDE에서 바로 어떤 값을 필수로 주입해야 하는지 알 수 있음
- final
  - 생성자 주입을 사용하면 필드에 final 키워드를 사용할 수 있어서 `생성자에서 혹시라도 값이 설정 되지 않는 오류를 컴파일 시점에 막아줌`
  - 생성자이 아닌 방법들은 final 키워드를 사용할 수 없음

#### 롬복과 생성자 의존관계 주입
- 롬복
  - 대부분이 다 불변이고, 그래서 다음과 같이 생성자에 final 키워드를 사용 -> 생성자를 만들기 귄찮아짐
  - 필드 주입처럼 좀 편리하게 사용하는 방법으로 `롬복`을 이용 가능
  - 롬복 라이브러리가 제공하는 `@RequiredArgsConstructor` 기능을 사용하면 final이 붙은 필드를 모아서 생성자를 자동으로 만들어줌

#### 조회 값이 2개 이상인 경우 해결 방법
- 문제: 타입으로 조회하면 선택된 빈이 2개 이상일 때 문제가 발생하는데, 클래스의 하위 타입이 여러 개인 상황에서 하위 타입으로 지정하여 DIP를 위배하지 않으면서 문제 해결하는 것은 어려움
- 해결 방법
  - @Autowired의 필드 명 매칭
    - 타입이 동일한 빈이 복수 개인 경우 타입 매칭에 실패하지만 `파라미터 이름으로 빈 이름을 추가적으로 매칭하는 기능`
  - @Qualifier
    - 주입 시 추가적인으로 @Qualifier 는 추가 구분자를 붙여주는 방법
    - 빈 등록시 @Qualifier를 붙여줘야하고 주입시에 @Qualifier를 붙여주고 등록한 이름을 적어줘야함\
    - @Qualifier끼리 매
    - @Qualifier 를 찾는 용도로만 사용하는게 명확한 방법
    ```java
    @Component
    @Qualifier("fixDiscountPolicy")
    public class FixDiscountPolicy implements DiscountPolicy {}

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
      this.memberRepository = memberRepository; this.discountPolicy = discountPolicy;
    }
    ```
  - @Primary
    - @Primary는 우선순위(기본값)를 정하는 방법
    - @Qualifier를 적용하여 함께 `자주 사용하는 방법`(@Qualifier 가 @Primary보다 우선권이 높음)
    - 주요 사례: 코드에서 특별한 기능 으로 가끔 사용하는 서브 데이터베이스의 커넥션을 획득하는 스프링 빈이 있다고 생각해보자. 메인 데이터 베이스의 커넥션을 획득하는 스프링 빈은 @Primary 를 적용해서 조회하는 곳에서 @Qualifier 지정 없이 편리하게 조회하고, 서브 데이터베이스 커넥션 빈을 획득할 때는 @Qualifier 를 지정해서 명시적으로 획 득 하는 방식
-  어노테이션 직접 만들어서 Qualifer 사용하기
  - @Qualifier("mainDiscountPolicy") 이렇게 문자를 적으면 컴파일시 타입 체크가 안됨
  ```java
  @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE}) @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @Qualifier("mainDiscountPolicy")
  public @interface MainDiscountPolicy {
  }
  ```
  ```java
  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) { 
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy; 
  }
  ```

#### 자동, 수동 등록의 올바른 실무 운영 기준
- `편리한 자동 기능을 기본으로 사용`이 권장
  - 스프링 빈을 하나 등록할 때 @Component 만 넣어주면 끝나는 일을 @Configuration 설정 정보에 가서 @Bean 을 적고, 객체를 생성하고, 주입할 대상을 일일이 적어주는 과정은 상당히 번거로움
  - 업무 로직 빈인 웹을 지원하는 컨트롤러, 핵심 비즈니스 로직이 있는 서비스, 데이터 계층의 로직을 처리하는 리포지토리 등에 적극 사용이 권장
- `수동 등록을 사용하면 좋은 경우`
  - `가술 지원 빈`은 기술적인 문제나 공통 관심사(AOP)를 처리할 때 주로 사용되는데, 데이터베이스 연결이나 공통 로그 처리처럼 업무 로직을 지원하기 위한 기술은 수동 빈 등록을 사용해서 명확하게 들어내는 것이 좋음
  - 비즈니스 로직 중에서 다형성을 적극 활용할 때는 고민을 하고 사용
  - 수동 빈으로 등록하거나 또는 자동으로 하면 특정 패키지에 같이 묶어두는게 좋음

## 빈 생명주기 콜백

#### 빈 생명주기 
- 빈 생명 주기: 스프링에서 객체의 초기화 작업과 종료 작업을 처리할 때 사용하는 라이프 사이클
  - `객체 생성 -> 의존관계 주입`의 라이플 사이클을 가지고 자세히 보면 `스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존 관계 주입 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료`
  - 의존관계 주입이 다 끝난 다음에야 필요한 데이터를 사용할 수 있는 준비가 완료되므로 초기화 작업은 `의존관계 주입이 모두 완료되고 난 다음에 호출해야함`
  - 초기화 콜백: 빈이 생성되고 빈의 의존관계 주입이 완료된 후 호출
  - 호출 소멸 전 콜백: 빈이 소멸되기 직전에 호출
- 빈 생명 주기 사용법
  - 생성자 안에서 무거운 초기화 작업을 함께 하는 것 보다는 객체를 생성하는 부분과 초기화 하는 부분 을 명확하게 나누는 것이 유지보수 관점에서 좋음
  - 의존관계 주입이 완료되면 스프링 빈에게 콜백 메서드를 통해서 초기화 콜백 호출

#### 빈 생명주기 콜백을 지원 방식
- 인터페이스(InitializingBean, DisposableBean)
  - 외부 라이브러리에 적용할 수 없어서 거의 사용하지 않는 방법
  - InitializingBean 은 afterPropertiesSet() 메서드로 초기화를 지원
  - DisposableBean 은 destroy() 메서드로 소멸을 지원
  ```java
  public class NetworkClient implements InitializingBean, DisposableBean {
      
      private String url;
      
      public NetworkClient() {
        System.out.println("생성자 호출, url = " + url); 
      }
        
      public void setUrl(String url) { t
          his.url = url;
      }
      
      public void connect() {
          System.out.println("connect: " + url); 
      }
      
      public void call(String message) {
          System.out.println("call: " + url + " message = " + message);
      }

      
      public void disConnect() {
          System.out.println("close + " + url); 
      }

      @Override
      public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
      }

      @Override
      public void destroy() throws Exception {
            disConnect();
      }
  }
  ```
- 설정 정보에 초기화 메서드, 종료 메서드 지정
  - @Bean(initMethod = "함수 이름", destroyMethod = "함수 이름") 처럼 초기화, 소멸 메서드를 지정 가능
  - 스프링 빈이 스프링 코드에 의존하지 않아서 외부 라이브러리에도 초기화, 종료 메서드를 적용 가능
  - 이 추론 기능은 close , shutdown 라는 이름의 메서드를 자동으로 호출하므로 배포할 때 주의
- @PostConstruct, @PreDestory 애노테이션
  - `가장 권장되는 방법`
  - javax.annotation에 존재하는 자바 표준으로 스프링에 의존적이지 않은 자바 표준
  - 매우 편리
  - 외부 라이브러리를 초기화, 종료해야하면 @Bean의 기능을 사용해야함
  ```java
  public class NetworkClient {

      private String url;
      
      public NetworkClient() {
        System.out.println("생성자 호출, url = " + url); 
      }

      public void setUrl(String url) { this.url = url;}

      public void connect() {
        System.out.println("connect: " + url); }

      public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
      }
      
      public void disConnect() {
        System.out.println("close + " + url); 
      }

      @PostConstruct
      public void init() {
        System.out.println("NetworkClient.init"); 
        connect();
        call("초기화 연결 메시지");
      }

      @PreDestroy
      public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
      }
  }
  ```
  ```java
  @Configuration
  static class LifeCycleConfig {
    @Bean
    public NetworkClient networkClient() {
       NetworkClient networkClient = new NetworkClient(); 
       networkClient.setUrl("http://hello-spring.dev"); 
       return networkClient;
    }
  }
  ```
## 프로토 타입 스코프

#### 빈 스코프
- 스코프는 `빈이 존재할 수 있는 범위`를 의미
- 스프링 빈이 기본적으로 싱글톤 스코프로 생성되어 스프링 컨테이너의 시작과 함께 생성되어서 스프링 컨테이너가 종료될 때 까지 유지
- `싱글톤 스코프`: 기본 스코프, `스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프`
- 프로토타입 스코프: 스프링 컨테이너는 `프로토타입 빈의 생성과 의존관계 주입까지만 관여하고` 더는 관리하지 않는 매우 짧은 범위의 스코프
- 웹 관련 스코프
  - request: 웹 요청이 들어오고 나갈때 까지 유지되는 스코프
  - session: 웹 세션이 생성되고 종료될 때 까지 유지되는 스코프
  - application: 웹의 서블릿 컨텍스와 같은 범위로 유지되는 스코프
- 빈 지정 등록 방법
```java
@Scope("prototype")
@Component
public class HelloBean {}
```
또는 
```java
@Scope("request")
@Component
public class HelloBean {}
```



#### 프로토 타입 스코프
- 프로토 타입 스코프를 사용하는 경우
  - 매번 사용할 때 마다 의존관계 주입이 완료된 새로운 객체가 필요하 면 사용
- 싱글톤 스코프의 빈과 프로토타입 스코프의 빈
  - 싱글톤 스코프의 빈을 조회하면 스프링 컨테이너는 항상 같은 인스턴스의 스프링 빈을 반환
  - 프로토타입 스코프의 빈을 조회하면 스프링 컨테이너는 생성 및 의존관계 주입까지만 수행하고 항상 새로운 인스턴스를 생성해서 반환
- 프로토타입 스코프의 특징
  - 스프링 컨테이너에 요청할 때마다 새로 생성
  - 프로토타입 빈을 관리할 책임은 프로토타입 빈을 받은 클라이언트가 가짐
  - @PreDestory 같은 종료 메서드가 호출되지 않음
- 프로토타입 스코프의 빈이 싱글톤 스코프의 빈 안에서 사용될 때 문제
  - 스프링 컨테이너에 프토토타입 스코프의 빈을 요청하면 항상 새로운 객체 인스턴스를 생성해서 반환하지만 싱글톤 빈과 함께 사용할 때는 의도한 대로 잘 동작하지 않으므로 주의
  - 싱글톤 빈의 내부에 가지고 있는 프로토타입 빈은 이미 과거에 주입이 끝난 빈이기 때문에, `싱글톤 빈을 요청해도 프로토타입 빈은 새로 생성되지 않음`, 즉 싱글톤 빈과 함께 계속 유지됨
- 프로토타입 스코프의 빈이 싱글톤 스코프의 빈 안에서 사용될 때 문제 해결 방법
  - 싱글톤 빈이 프로토타입을 사용할 때마다 스프링 컨테이너에 새로 요청하게 변경
- `ObjectProvider`
  - 지정한 빈을 컨테이너에서 대신 찾아주는 DL(Dependency Lookup) 서비스를 제공하는 객체
  - prototypeBeanProvider.getObject() 을 통해서 항상 새로운 프로토타입 빈이 생성
  - ObjectFactory의 확장
  - 스프링에 의존
  - DL이 필요한 경우는 언제든지 사용
  - 권장되는 방법
- JSR-330 Provider
  - `javax.inject.Provider` 라는 JSR-330 자바 표준을 사용하는 방법
  - provider.get() 을 통해서 항상 새로운 프로토타입 빈이 생성
  - 스프링에 의존적이지 않음
  - DL이 필요한 경우는 언제든지 사용

#### 웹 스코프
- `웹 스코프`: 웹 환경에서만 동작하는 스코프
- 웹 스코프 종류
  - request: `HTTP 요청 하나가 들어오고 나갈 때 까지 유지되는 스코프`, 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성되고 관리
  - session: `HTTP Session과 동일한 생명주기를 가지는 스코프`
  - application: 서블릿 컨텍스트( ServletContext )와 동일한 생명주기를 가지는 스코프
  - websocket: 웹 소켓과 동일한 생명주기를 가지는 스코프
- 웹 스코프 사용 시 문제
  - 스프링 애플리케이션을 실행하는 시점에 싱글톤 빈은 생성해서 주입이 가능하지만, request 스코프 빈은 실제 요청이 와야 생성으므로 따로 호출하는 시점까지 `request scope 빈의 생성을 지연 처리가 필요`
- 문제 해결 방법
  - `Provider`을 통해서 호출하는 시점까지 지연 처리
  - `proxyMode`를 통해서 가짜 `프록시 클래스`를 만들어두고 HTTP request와 상관 없이 가짜 프록시 클래스를 미리 주입하고 요청하면 진짜 빈을 찾아서 요청하고 위임
