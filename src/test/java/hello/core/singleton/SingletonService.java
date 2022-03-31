package hello.core.singleton;

public class SingletonService {
    // 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 싱글톤(1개만 생성)으로 관리한다.
    // 지금까지 우리가 학습한 스프링 빈이 바로 싱글톤으로 관리되는 빈이다.
    // static 설정하면 class레벨에 올라가기때문에 딱 하나만 생성된다.
    // java가 뜰때 static영역에 오른쪽 참조값을 생성해서 instance에 넣어둔다.

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() { }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
