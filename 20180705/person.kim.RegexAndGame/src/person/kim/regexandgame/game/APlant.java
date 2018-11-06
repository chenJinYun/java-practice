package person.kim.regexandgame.game;

public class APlant extends Plant{

	@Override
	public void action() {
		System.out.println("不能動");
	}

	@Override
	public void attacks() {
		System.out.println("只能一次發出一枚炮彈");
	}

	@Override
	public void appearance() {
		System.out.println("頭大身小");
	}

}
