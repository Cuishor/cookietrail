package source.actor;

public enum ActorType {
	PLAYER("C:\\Users\\alex_\\Documents\\CookieTrail\\src\\resource\\monster.png"),
	COLLECTABLE("C:\\Users\\alex_\\Documents\\CookieTrail\\src\\resource\\cherry.png");
	
	protected String aspect;

	/**
	 * @param aspect
	 */
	ActorType(String aspect) {
		this.aspect = aspect;
	}

	public String getAspect() {
		return aspect;
	}
	
}
