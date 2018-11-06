package pers.kim.decolartor;

import org.junit.Test;

public class AvatarTest {
	@Test
	public void testAvatar() {
		Intelligentar human=new Hurman();
		Intelligentar avatar=new Avatar(human);
		avatar.walk();
	}
}
