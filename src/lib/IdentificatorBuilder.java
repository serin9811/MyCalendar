package lib;

import java.util.UUID;

public class IdentificatorBuilder {
	
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
