package pers.kim.decolartor;

public class Avatar extends Intelligentar {
	private Intelligentar interage;

	public Avatar(Intelligentar human) {
		// TODO Auto-generated constructor stub
		super();
		this.interage = human;
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		interage.walk();
		System.out.println("avatar run");

	}

}
