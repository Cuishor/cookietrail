package source.actor;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cherry extends Component {

	public Cherry() {
		type = ActorType.COLLECTABLE;
		try {
			image = ImageIO.read(new File(".\\src\\resource\\cherry.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
